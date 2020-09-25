<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 연습</title>
</head>
<body>
<%
// JSP문서에서 세션은 'session'이라는 이름으로 이미 저장되어 있다.
%>
	<a href="<%=request.getContextPath()%>/SessionAddServlet.do">Session 정보 저장하기</a><br>
	<a href="<%=request.getContextPath()%>/SessionReadServlet.do">저장된 Session 정보 확인하기</a><br>
	<a href="<%=request.getContextPath()%>/SessionDeleteServlet.do">저장된 Session 정보 삭제하기</a><br>
</body>
</html>