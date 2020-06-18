<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<div class="container">
	

	<h2>스프링 MVC시작하기</h2>
	<h3>resources 폴더 사용하기 </h3>
	<!--Spring MVC에서는 이와 같은 리소스를 사용하기위해
	별도로 resources폴더를 제공한다. 해당 폴더의 설정은
	servlet-context.xml에서 한다.  -->
	
	<!--기본 설정으로 이미지 사용하기  -->
	<img src="./resources/4.png" alt="dog" />
	
	<!--<resources 엘리먼트의 mapping 부분을 수정한 후 이미지 사용하기  -->
	<img src="./images/4.png" alt="puppy" />
	<!--리소스 사용을 위한 resources폴더의 기본 매핑명은 resources이지만
	엘리먼트 추가로 별칭을 변경하거나 추가할 수 있다.  -->
	
	
	
	
	<h3>첫번째 컨트롤러 만들기</h3>
	<!--Step1 : 효청명을 결정한다.  -->
	<ul>
		<li>
			<a href="./home/helloSpring" target="_blank">
			첫번째 컨트롤러 바로가기
			</a>
		</li>
	</ul>
	
	
	<!--  -->
	<h3>form값 차리하기</h3>
	<li>
		<a href="./form/servletRequest?id=kosmo&pw=1234" target="_blank">
		HttpServletRequest로 폼값받기
		</a>
	</li>
	
	
	<!--파라미터가 많다고 가정하고 파라미터들을 한꺼번에 저장하고 받아보자  -->
	<li>
		<a href="./form/requestParam.do?id=kosmo&pw=1234&name=홍길동&email=hong@gildong.com" target="_blank">
		@requestParam 어노테이션으로 폼값받기
		</a>
	</li>
	
	
	
	<li>
		<a href="./form/commandObjGet.do?id=kosmo&pw=1234&name=홍길동&email=hong@gildong.com" target="_blank">
		커맨드(Command)객체로 한번에 폼값받기
		</a>
	</li>
	
	
	
	<li>
		<a href="./form/gildong99/코스모" target="_blank">
		pathVariable 어노테이션으로 폼값받기
		</a>
	</li>
	
	
	<!--컨트롤러 : RequestMappingControllor.java  -->
	<h3>@RequestMapping 어노테이션 활용</h3>
	<li>
		<a href="./requestMapping/index.do" target="_blank">
		requestMapping 시작페이지 바로가기
		</a>
	</li>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</div>
</body>
</html>
