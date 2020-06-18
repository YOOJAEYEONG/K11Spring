<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
	<h2>form 데이터 받기</h2>
	<h3>@PathVariable 어노테이션으로 폼값 받기</h3>
	
	
	<ul>
		<li>이름:${memberId }</li>
		<li>아이디:${memberName }</li>
	
	</ul>
	
	
	
	<!--
	http://localhost:8081/k11spring/form/gildong99/코스모
	브라우저입장에서는 파라미터가 아닌 2뎁스안쪽의 경로이다.
	웹브라우저는 /로 구분되는 요청명을 디렉토리(경로)로 인식하므로
	현재 "./form/gildong/길동 과 같은 요청명은 ../를 경로에 추가하여 상위디렉토리로 이동해야한다.
	-->
	<div class="row mt-5" >
		<h3>이미지경로 확인</h3>
		<!-- 출력안됨 -->
		<img src="../images/4.png" alt="개" />
		<img src="../../images/4.png" alt="개" />
	</div>
	
	
	
	
</div>
</body>
</html>






















