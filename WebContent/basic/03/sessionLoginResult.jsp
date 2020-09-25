<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	로그인 성공시
		ㅁㅁ님 반갑습니다.
		로그아웃
	로그인 실패시
		alert("로그인 실패")
		이전 페이지로 이동
 -->
<%
request.setCharacterEncoding("utf-8");

String id = (String) session.getAttribute("id");

if(id == null){
	%>
	<script type="text/javascript">
		alert("로그인 실패");
		history.go(-1);
	</script>
	<%
} else {
	%>
	<h3><%=id %>님 반갑습니다.</h3>
	<a href="<%=request.getContextPath()%>/SessionLogoutTest.do">로그아웃</a>
	<%
}
%>
</body>
</html>