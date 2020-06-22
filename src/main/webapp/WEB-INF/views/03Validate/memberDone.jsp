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
	<h2>VAlidator 인터페이스를 구현한 폼값 검증</h2>
	<h3>유효성 검증 성공 - 회원가입 완료</h3>
	
	
	<!--@ModelAttribute 어노테이션을 통해 커맨드객체의 이름을 mInfo로 
	변경했으므로 아래와 같이 출력한다.  -->
	<ul>
		<li>아이디 : ${mInfo.id }</li>
		<li>패스원드 : ${mInfo.pw }</li>
		<li>이름 : ${mInfo.name }</li>
	</ul>
</div>
</body>
</html>



















