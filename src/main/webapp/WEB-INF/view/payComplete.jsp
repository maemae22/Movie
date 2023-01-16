<%@ page import="com.example.movie.dto.TicketDTO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
    TicketDTO ticket = (TicketDTO) request.getAttribute("ticket");
    System.out.println(ticket.toString());
%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="css/showticket.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <link rel='stylesheet'
          href='//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css' />
    <script
            src='//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js'></script>
    <link rel="stylesheet"
          href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">
    <!-- MATERIAL DESIGN ICONIC FONT -->

</head>

<body>
<%@ include file="header.jsp" %>

<div>
    <div class="my-page-container">
        <div class="my-page-wrapper">
            <div class="my-page-header">예매 정보</div>
            <div class="complete-message"> 예매가 완료되었습니다.</div>
            <div class="poster"><img src="data:image/jpeg;base64,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"> </div>
            <div class="movie-reserve-list">
                <div class="movie-reserve">
                    <div class="movie-reserve-age">예매번호 103296-392873</div>
                    <div class="movie-reserve-title"><%=ticket.getMovieTitle() %></div>
                    <div class="movie-reserve-theater-wrapper">
                        <div><%=ticket.getSelectedTheater() %></div>
                        &nbsp;/&nbsp;
                        <div><%=ticket.getTheaterDetail()%> </div>
                        <div class="ticket-number"><%=ticket.getTicketNumber() %>장</div>
                    </div>
                    <div class="movie-reserve-seats"><%=ticket.getSelectedSeat() %></div>
                    <div class="movie-reserve-date-wrapper">
                        <div class="movie-reserve-date"><%=ticket.getMovieDate() %></div>
                        <div class="movie-reserve-runningTime"><%=ticket.getMovieStartTime() %></div>
                    </div>
                    <div class="movie"></div>

                    <div class="pay-information-wrapper">
                        <div class="pay-information-date-wrapper">
                            <div class="pay-information-date-title">결제한 날</div>
                            <div class="pay-information-date"><%=ticket.getPayDate() %></div>
                        </div>

                        <div class="pay-information-money-wrapper">
                            <div class="pay-information-money-title">결제한 비용</div>
                            <div class="pay-information-money"><%=ticket.getPayMoney() %>원</div>
                        </div>

                        <div class="barcode-wrapper">
                            <img src="images/barcode.png">
                        </div>

                        <form action="moveKakao.do" class="seatForm" method="POST">
                            <input type="hidden" class="title" name="movieTitle">
                            <input type="hidden" class="selectedTheater" name="selectedTheater">
                            <input type="hidden" class="reserveDate" name="movieDate">
                            <input type="hidden" class="runningTime" name="movieStartTime">
                            <input type="hidden" class="ticketNumber" name="ticketNumber">
                            <input type="hidden" class="selectedSeat" name="selectedSeat">
                            <input type="hidden" class="payMoney" name="payMoney">
                        </form>
                    </div>
                </div>

            </div>

        </div>

    </div>
    <div class="btn_group">
        <button class="main_btn" onclick="location.href='/main';">메인페이지</button>
        <button class="mypage_btn" onclick="location.href='/main';">상세페이지</button>
    </div>
</div>


<script src="js/seat.js"></script>


</body>

</html>