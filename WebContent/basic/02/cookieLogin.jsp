<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<%
String cookie = "";	// 쿠키값이 저장될 변수
String check = "";	// 체크박스의 체크 상태를 나타낼 변수

Cookie[] ck = request.getCookies();
if(ck != null && ck.length > 0){
	for(Cookie c : ck){
		if(c.getName().equals("id")){
			// 원하는 쿠키값을 찾아 저장
			cookie = URLDecoder.decode(c.getValue(),"utf-8");
			check = "checked";
		}
	}
}
%>
	<h2>로그인</h2>
	<hr>
	<form action="/servletTest/CookieLoginServlet.do" method="post">
		<table>
			<tr><td>ID </td><td><input type="text" name="userid" value=<%=cookie %>></td><td><input type="checkbox" name="chkid" value="ok" <%=check %>>ID 기억하기</td></tr>
			<tr><td>PW </td><td colspan="2"><input type="password" name="userpass"></td></tr>
			<tr style="text-align: center;"><td colspan="3"><input type="submit" value="확인"> <input type="reset" value="취소"></td></tr>
		</table>
	</form>
</body>
</html>