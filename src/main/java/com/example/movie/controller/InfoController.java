package com.example.movie.controller;

import com.example.movie.dto.InfoDTO;
import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class InfoController {
	private static Logger logger = LoggerFactory.getLogger(InfoController.class);
	
	
	@ResponseBody
	@RequestMapping(value = "crawling.do", method = {RequestMethod.GET, RequestMethod.POST}, produces="text/plain;charset=UTF-8")
	public String getCrawling() {
		Document doc;
		String gson = "";

		try {
			doc = Jsoup.connect("http://www.cgv.co.kr/movies/").get();
			/* Elements */
			Elements ranks = doc.select(".rank");
			/* logger.info("rank" + ranks); */

			Elements imgs = doc.select(".thumb-image > img");
			/* logger.info("imgs" + imgs); */

			Elements movieAges = doc.select(".ico-grade");
			/* logger.info("ico-grade" + movieAges); */

			Elements movieTitles = doc.select("div.box-contents strong.title");
			/* logger.info("titles" + movieTitles); */

			List<InfoDTO> list = new ArrayList<InfoDTO>();

			for(int i = 0; i < ranks.size(); i++) {

				String rank = ranks.get(i).text();
				String img = imgs.get(i).attr("src");
				String movieTitle = movieTitles.get(i).text();

				int index= i;
				InfoDTO infoDto = new InfoDTO(index, rank, img, movieTitle);

				list.add(infoDto);
			}
			gson = new Gson().toJson(list);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return gson;
	}
}

