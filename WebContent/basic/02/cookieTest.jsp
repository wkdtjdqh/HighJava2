<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie 연습</title>
<!-- 쿠키
	클라이언트에다가 정보를 저장함
	사이트와 관련된 정보를 항상 저장
	문자열만 저장할 수 있음
	해킹 위험에 노출되어있음
	시스템 운영에 도움되지만 민감한 데이터가 아닌 데이터를 주로 저장해서 사용
-->
<!-- 세션
	서버에다가 정보를 저장함 
	주로 로그인관련 정보를 저장할 때 사용
-->
</head>
<body>
<%
Cookie[] cookies = request.getCookies();
if(cookies != null){
	for(Cookie c : cookies){
		%>
		쿠키변수 : <%=c.getName() %><br>
		쿠키 값 : <%=URLEncoder.encode(c.getValue(), "utf-8")%><br>
		<%
	}
}
%>

	<a href="<%=request.getContextPath()%>/CookieAddServlet.do">Cookie 정보 저장하기</a><br>
	<a href="<%=request.getContextPath()%>/CookieReadServlet.do">저장된 Cookie 정보 확인하기</a><br>
	<a href="<%=request.getContextPath()%>/CookieDeleteServlet.do">저장된 Cookie 정보 삭제하기</a><br>
</body>
</html>