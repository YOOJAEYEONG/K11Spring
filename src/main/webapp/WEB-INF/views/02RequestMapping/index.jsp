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
	<h2>@RequestMapping 어노테이션</h2>
	
	<h3>GET방식으로 전송하기[검색폼]</h3>
	
	<script>
	function searchCheck(f){
		if(!f.searchWord.value){
			alert('검색어를 입력하세요');
			f.searchWord.focus();
			return false;
		}
	}
	</script>
	<form action="../requestMapping/getSearch.do" 
		method="get" name="searchFrm" onsubmit="return searchCheck(this)">
		
		<select name="searchColumn" >
			<option value="title">제목</option>
			<option value="name">작성자</option>
			<option value="content">내용</option>
		</select>
		
		<input type="text" name="searchWord" />
		<input type="submit" value="검색하기" />
	</form>
	
	
	
	
	
	<h3>POST방식으로 전송하기[로그인폼]</h3>
	
	<script>
	function loginCheck(f){
		
	}
	</script>
	<form action="../requestMapping/postLogin.do" 
		method="post" name="loginFrm" onsubmit="return loginCheck(this)">
		
		아이디: <input type="text" name="user_id" /> <br />
		비번: <input type="text" name="user_pw" /> <br />
		
		<input type="submit" value="로그인" />
	</form>

	
	<hr />
	
	
	<h3>@ModelAttribute 어노테이션 사용하여 커맨드객체 이름 변경하기</h3>
	<script>
		var stuCheck = function(){}
	</script>
	
	<%
	//로컬실행과 배포를 하는 경우와 같이 루트가 변경되는경우 수정하는 수고를 예방할 수 있다.
	String ctxPath = request.getContextPath(); 
	%>
	<form action="<%=ctxPath%>/requestMapping/modelAttribute" 
		method="post" name="studentFrm"
		onsubmit="return stuCheck();">
		<table class="table table-bordered" style="width: 400px;">
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="name" />
				</td>
			</tr>
			<tr>
				<td>나이</td>
				<td>
					<input type="text" name="age" />
				</td>
			</tr>
			<tr>
				<td>학년</td>
				<td>
					<select name="gradeNum" >
						<option value="1학년">1학년</option>
						<option value="2학년">2학년</option>
						<option value="3학년">3학년</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>학반</td>
				<td>
					<input type="radio" name="classNum"  value="1반"/>1반
					<input type="radio" name="classNum"  value="2반"/>2반
					<input type="radio" name="classNum"  value="3반"/>3반
				</td>
			</tr>
			<tr>
				<td colspan="2" class="text-center">
					<button type="submit">전송하기</button>
				</td>
			</tr>
		</table>
	</form>
	
	
	
</div>
</body>
</html>
































