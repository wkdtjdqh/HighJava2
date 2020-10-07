<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Servlet 요청 연습</h1>
	<hr>
	
	<h2>GET방식 요청1 ==> 링크 방식</h2>
	<a href="http://localhost/servletTest/WrapperTestServlet.do">GET 방식 요청1</a>
	<hr>
	<form action="http://localhost/servletTest/WrapperTestServlet.do">
		회원ID : <input type="text" name="mem_id"><br><br>
		회원이름 : <input type="text" name="mem_name"><br><br>
		패스워드 : <input type="password" name="mem_pass"><br><br>
		<input type="submit" value="전송"> 
		<input type="reset" value="취소">
	</form>
	
</body>
</html>