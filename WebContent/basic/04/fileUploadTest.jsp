<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload / Download</title>
</head>
<body>
	<h2>File Upload 연습</h2>
	<form method="post" enctype="multipart/form-data" action="<%=request.getContextPath()%>/FileUploadServlet.do">
		파일1 : <input type="file" name="fileUpload1" multiple><br>
		파일2 : <input type="file" name="fileUpload2"><br>
		<input type="submit" value="파일 전송">
	</form>
	<hr>
	<a href="<%=request.getContextPath()%>/UploadFileListServlet.do">Upload된 전체 파일 보기</a>
</body>
</html>