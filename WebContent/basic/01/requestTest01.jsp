<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h2>Request 연습 Form</h2>
<hr>
<!-- <form name="testForm" method="post" action="/servletTest/requestTest01.do" enctype="application/x-www-form-urlencoded"> -->
<form name="testForm" method="get" action="/servletTest/requestTest01.do" enctype="application/x-www-form-urlencoded">
	<table border="1">
		<tr><td>이름</td><td><input type="text" size="10" name="userName"></td></tr>
		<tr><td>직업</td>
		<td>
			<select name="job">
				<option value="무직">무직</option>
				<option value="회사원">회사원</option>
				<option value="전문직">전문직</option>
				<option value="학생">학생</option>
			</select>
		</td></tr>
		<tr><td>취미</td>
		<td>
			<input type="checkbox" name="hobby" value="여행">여행
			<input type="checkbox" name="hobby" value="게임">게임
			<input type="checkbox" name="hobby" value="배드민턴">배드민턴
			<input type="checkbox" name="hobby" value="바둑">바둑
			<input type="checkbox" name="hobby" value="장기">장기
		</td></tr>
		<tr><td colspan="2" style="text-align:center"><input type="submit" value="확인">&nbsp;&nbsp;
		<input type="reset" value="취소"></td></tr>
	</table>	
</form>
</body>
</html>