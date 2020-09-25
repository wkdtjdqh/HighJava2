<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// 이 영역이 Java영역

// JSP문서에서 request는 HttpServletRequest객체의 참조값이 저장된 변수이다.
//			response는 HttpServletResponse객체의 참조값이 저장된 변수이다.
request.setCharacterEncoding("utf-8");

String userName = request.getParameter("username");
String tel = request.getParameter("tel");
String tel2 = (String)request.getAttribute("tel");

String name = "test";
String color = "pink";
	
out.println("이름 : " + name);
%>
<br>
<!-- JSP영역에서 만든 변수의 값이나 식의 결과를 바로 출력하기 -->
<div style="background:<%=color %>;">이름: <%=name %></div>
<div style="background:<%=color %>;">UN: <%=userName %></div>
<div style="background:<%=color %>;">전화: <%=tel %></div>
<div style="background:<%=color %>;">전화2: <%=tel2 %></div>
</body>
</html>