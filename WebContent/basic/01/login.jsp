<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h2>로그인</h2>
	<hr>
	<form method="post" action="/servletTest/LoginCheckServlet.do">
		아이디 : <input type="text" name="userid"><br>
		비밀번호 : <input type="password" name="userpass"><br>
		<input type="submit" value="확인">
	</form>
</body>
</html>