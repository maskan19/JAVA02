<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet File Upload / Download 연습</title>
</head>
<body>
	<h1>File Upload 연습</h1>
	<hr>
	<!-- 파일을 서버로 전송하기 위해 form의 method는 post
		enctype="multipart/form-data"가 설정되어있어야한다. -->
	<form method="post" enctype="multipart/form-data"
		action="<%=request.getContextPath()%>/fileUploadServlet.do">
		ID : <input name="memId" type = "text"><br><br>
		Upload File1 : <input type="file" name="file1" multiple><br><br> <!-- 여러개의 파일을 선택할 수 있음 -->
		Upload File2 : <input type="file" name="file2" ><br><br>
		Upload File3 : <input type="file" name="file3" multiple><br><br>
		<input type="submit" value="파일 전송">
	</form>
	<hr>
	<a href="<%=request.getContextPath()%>/uploadFilesServlet.do">
		업로드된 전체 파일 목록 보기
	</a>
</body>
</html>