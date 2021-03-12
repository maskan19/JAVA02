<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servlet File Upload / Download 연습</title>
</head>
<style>
.image_container img {
	width: auto;
	height: auto;
	max-width: 200px;
	max-height: 200px;
	object-fit: cover;
}
</style>


<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<body>
	<h1>File Upload 연습</h1>
	<hr>
	<form method="post" enctype="multipart/form-data"
		action="<%=request.getContextPath()%>/fileUploadServlet.do">
		<table border="1">
			<tr>
			</tr>
			<tr>
				<td>회원ID</td>
				<td><input type="text" name="mem_id" id="mem_id"> <input
					type="button" id="idcheck" value="중복확인"><br> <span
					id="idCheckResult"></span></td>
			</tr>
			<tr>
				<td>회원이름</td>
				<td><input type="text" name="mem_name" id="mem_name"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="mem_tel" id="mem_tel"></td>
			</tr>
			<tr>
				<td>아이콘</td>
				<td><input type="text" name="mem_pass" id="mem_pass"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="file" name="mem_icon"
					id="mem_icon" accept="image/*" onchange="setThumbnail(event);" />
				</td>
			</tr>
		</table>
	</form>
	미리보기 : 
	<div class="image_container"></div>
	<input type="submit" value="파일 전송">

	<script>
		function setThumbnail(event) {
			var reader = new FileReader();
			reader.onload = function(event) {
				var img = document.createElement("img");
				img.setAttribute("src", event.target.result);
				/* document.querySelector("div#image_container").removeChild(img); */
				$('.image_container').empty();
				document.querySelector(".image_container").appendChild(img);
			};
			reader.readAsDataURL(event.target.files[0]);
		}
	</script>




	<hr>
	<a href="<%=request.getContextPath()%>/uploadFilesServlet.do"> 업로드된
		전체 파일 목록 보기 </a>
</body>
</html>