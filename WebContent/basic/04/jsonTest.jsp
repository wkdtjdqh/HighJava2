<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$('button').on('click', function(){
			// 문자열 응답 데이터 처리
// 			$.ajax({
<%--  				url : "<%=request.getContextPath()%>/JSONTestServlet.do", --%>
// 				type : "post",
// 				success : function(data){
// 					$('#result').html("ajax 처리 데이터 : " + data);
// 				},
// 				dataType : "json"
// 			});
			
			// 배열 응답 데이터 처리
// 			$.ajax({
<%-- 				url : "<%=request.getContextPath()%>/JSONTestServlet.do", --%>
// 				type : "post",
// 				success : function(data){
// 					var str = "";
// 					$.each(data, function(i, v){
// 						str += i + "번째 자료 : " + v + "<br>";
// 					});
// 					$('#result').html(str);
// 				},
// 				dataType : "json"
// 			});
			
			// 객체 응답 데이터 처리
// 			$.ajax({
<%-- 				url : "<%=request.getContextPath()%>/JSONTestServlet.do", --%>
// 				type : "post",
// 				success : function(data){
// 					var str = "";
// 					str += "ID : " + data.id + "<br>";
// 					str += "NAME : " + data.name + "<br>";
					
// 					$('#result').html(str);
// 				},
// 				dataType : "json"
// 			});
			
			// 리스트 응답 데이터 처리
			$.ajax({
				url : "<%=request.getContextPath()%>/JSONTestServlet.do",
				type : "post",
				success : function(data){
					var str = "";
					$.each(data, function(i, v){
						str += i + "번째 자료<br>";
						str += "ID : " + v.id + "<br>";
						str += "NAME : " + v.name + "<hr>";
					});
					
					$('#result').html(str);
				},
				dataType : "json"
			});
		});
	});
</script>
</head>
<body>
	<button>JSON 데이터 가져오기</button>
	<hr>
	<h3>가져온 데이터</h3>
	<div id="result"></div>
</body>
</html>