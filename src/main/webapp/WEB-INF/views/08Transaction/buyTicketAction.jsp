<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!--JSTL -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!--jquery와 부트스트랩 CDN 추가함 -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
	<h2>트랜잭션(Transaction)</h2>
	
	<h3>티켓 구매 결과 보기</h3>
	
	<ul>
		<li>고객아이디 : ${ticketInfo.customerId }</li>
		<li>티켓구매수 : ${ticketInfo.amount }</li>
	</ul>
	<p> 
		<a href="./buyTicketMain.do">
			티켓구매페이지 바로가기
		</a>
	</p>
</div>

</body>
</html>


















