<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Servlet 요청 연습</h1>
	<hr>
	
	<h2>GET방식 요청1 ==> 링크 방식</h2>
	<a href="http://localhost/servletTest/ServletTest03.do">GET 방식 요청1</a>
	<hr>
	
	<h2>GET방식 요청2<br> ==> form의 submit방식<br> ==> form태그의 method속성을 생략하거나 'get'으로 설정한 경우</h2>
	<form action="http://localhost/servletTest/ServletTest03.do">
		<input type="submit" value="GET방식 요청2">
	</form>
	<hr>
	
	<h2>POST방식 요청<br> ==> form의 submit방식<br> ==> form의 method속성을 'post'로 설정한 경우</h2>
	<form action="http://localhost/servletTest/ServletTest03.do" method="post">
		<input type="submit" value="POST방식 요청">
	</form>
</body>
</html>