package com.example.movie.api;

import com.example.movie.dto.DailyMovieDTO;
import com.example.movie.dto.MovieDTO;
import com.example.movie.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;


@Component
@RequiredArgsConstructor
@Slf4j
public class BoxOfficeApi {
    private MovieService ms;
    private String key = "813f6367ffa2a50e00c46b305d629d4b";
    private String dailyResponse;
    private JSONParser jsonParser;
    private Object obj;
    private JSONObject jsonObject;
    private JSONObject parse_boxOfficeResult;
    private JSONObject parse_movieInfoResult;

    @Autowired
    public BoxOfficeApi(MovieService ms) {
        this.ms = ms;
    }

    public void dailyBoxOffice() {

        dailyResponse = "";

        LocalDateTime time = LocalDateTime.now().minusDays(1); // 전날 박스오피스로 조회해야함.(최신) 당일 날짜로는 조회 불가능하기에.
        String targetDt = time.format(DateTimeFormatter.ofPattern("yyyMMdd"));

        String itemPerPage = "10"; //ROW 개수 (Default 가 10개임)

        /*** 아래 세가지 파라미터 안던져주면 오류 발생함. */
        String multiMovieYn = ""; //다양성영화(Y)/상업영화(N)/전체(default)
        String repNationCd = ""; //한국영화(K)/외국영화(F)/전체(default)
        String wideAreaCd = ""; //상영지역별 코드/전체(default)

        try {
            // KOBIS 오픈 API Rest Client를 통해 호출
            KobisOpenAPIRestService service = new KobisOpenAPIRestService(key);
            // 일별 박스오피스 API 서비스 호출 (boolean isJson, String targetDt, String itemPerPage,String multiMovieYn, String repNationCd, String wideAreaCd)
            dailyResponse = service.getDailyBoxOffice(true, targetDt, itemPerPage, multiMovieYn, repNationCd, wideAreaCd);

            jsonParser = new JSONParser(); //JSON Parser 객체 생성
            obj = jsonParser.parse(dailyResponse); //Parser 로 문자열 데이터를 객체로 변환
            jsonObject = (JSONObject) obj; //파싱한 obj 를 JSONObject 객체로 변환
            parse_boxOfficeResult = (JSONObject) jsonObject.get("boxOfficeResult"); // parsing 하기

            ObjectMapper objectMapper = new ObjectMapper();

            JSONArray parse_dailyBoxOfficeList = (JSONArray) parse_boxOfficeResult.get("dailyBoxOfficeList");   //boxOfficeResult -> dailyBoxOfficeList 꺼내기.
            for (int i = 0; i < parse_dailyBoxOfficeList.size(); i++) {
                JSONObject dailyBoxOffice = (JSONObject) parse_dailyBoxOfficeList.get(i);
                //JSON object -> Java Object 로 변환
                HashMap<String, Object> dailyResult = objectMapper.readValue(dailyBoxOffice.toString(), HashMap.class);

                // DTO 로 맞춰주기. (추후 Map -> DTO 로 변환 가능하도록 DTO 내에서 작업 필요할 것으로 보임.)
                DailyMovieDTO dailyMovieDTO = new DailyMovieDTO();
                dailyMovieDTO.setMovieCd(String.valueOf(dailyResult.get("movieCd")));
                dailyMovieDTO.setMovieNm(String.valueOf(dailyResult.get("movieNm")));
                dailyMovieDTO.setOpenDt(LocalDate.parse(dailyResult.get("openDt").toString()));
                dailyMovieDTO.setMovieRank(Integer.parseInt(String.valueOf(dailyResult.get("rank"))));
                dailyMovieDTO.setAudiAcc(Long.parseLong(String.valueOf(dailyResult.get("audiAcc"))));

                ms.insertDailyMovie(dailyMovieDTO); //DB 저장
            }
        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

    public void movieDetail() {

        String detailResponse;

        try {
            // KOBIS 오픈 API Rest Client를 통해 호출
            KobisOpenAPIRestService service = new KobisOpenAPIRestService(key);

            ArrayList<HashMap<String, Object>> map = ms.selectDailyMovieCode();
            for (int i = 0; i < map.size(); i++) {
                // 영화 상세정보 서비스 호출 (boolean isJson, String movieCd)
                detailResponse = service.getMovieInfo(true, map.get(i).get("movie_cd").toString());

                JSONParser jsonParser = new JSONParser(); //JSON Parser 객체 생성

                Object obj = jsonParser.parse(detailResponse); //Parser로 문자열 데이터를 객체로 변환

                JSONObject jsonObject = (JSONObject) obj; //파싱한 obj를 JSONObject 객체로 변환

                parse_movieInfoResult = (JSONObject) jsonObject.get("movieInfoResult"); // parsing하기
                JSONObject parse_movieInfoResultList = (JSONObject) parse_movieInfoResult.get("movieInfo"); // movieInfoResult -> movieInfo 꺼내오기.

                ObjectMapper objectMapper = new ObjectMapper();

                HashMap<String, Object> detailResult = objectMapper.readValue(parse_movieInfoResultList.toString(), HashMap.class);

                MovieDTO movieDTO = new MovieDTO();
                movieDTO.setMovieCd(String.valueOf(detailResult.get("movieCd")));
                movieDTO.setMovieNm(String.valueOf(detailResult.get("movieNm")));
                movieDTO.setMovieNmEn(String.valueOf(detailResult.get("movieNmEn")));
                movieDTO.setShowtime(Integer.parseInt(String.valueOf(detailResult.get("showTm"))));
                movieDTO.setOpenDt(LocalDate.of(Integer.parseInt(detailResult.get("openDt").toString().substring(0,4)), Integer.parseInt(detailResult.get("openDt").toString().substring(4,6)), Integer.parseInt(detailResult.get("openDt").toString().substring(6,8))));
                movieDTO.setTypeNm(String.valueOf(detailResult.get("typeNm")));

                ArrayList<HashMap<String, Object>> nations = (ArrayList<HashMap<String, Object>>) detailResult.get("nations");
                movieDTO.setNationNm(String.valueOf(nations.get(0).get("nationNm")));

                ArrayList<HashMap<String, Object>> genres = (ArrayList<HashMap<String, Object>>) detailResult.get("genres");
                String genreNm = "";
                for(int j = 0; j <genres.size(); j++) {
                    genreNm += genres.get(j).get("genreNm")+"/";
                }
                movieDTO.setGenreNm(genreNm);

                ArrayList<HashMap<String, Object>> directors = (ArrayList<HashMap<String, Object>>) detailResult.get("directors");

                movieDTO.setDirectorNm(String.valueOf(directors.get(0).get("peopleNm")));
                movieDTO.setDirectorNmEn(String.valueOf(directors.get(0).get("peopleNmEn")));

                ArrayList<HashMap<String, Object>> company = (ArrayList<HashMap<String, Object>>) detailResult.get("companys");
                movieDTO.setCompanyNm(String.valueOf(company.get(0).get("companyNm")));

                ArrayList<HashMap<String, Object>> audits = (ArrayList<HashMap<String, Object>>) detailResult.get("audits");
                movieDTO.setWatchGradeNm(String.valueOf(audits.get(0).get("watchGradeNm")));

                ArrayList<HashMap<String, Object>> actors = (ArrayList<HashMap<String, Object>>) detailResult.get("actors");
                String actors_name = "";
                String actors_name_en = "";
                for (int j = 0; j < actors.size(); j++) {
                    actors_name += actors.get(j).get("peopleNm") + "|";
                    actors_name_en += actors.get(j).get("peopleNmEn") + "|";
                }
                movieDTO.setActorNm(actors_name);
                movieDTO.setActorNmEn(actors_name_en);

                ms.insertMovieDetail(movieDTO); //DB저장
            }

        } catch (Exception e) {
            log.info(e.getMessage());
        }
    }

}
