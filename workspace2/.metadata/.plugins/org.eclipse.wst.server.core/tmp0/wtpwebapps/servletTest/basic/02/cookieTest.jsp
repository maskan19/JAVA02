<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/cookieAddServlet.do">Cookie 정보 저장하기</a><br><br>

<a href="<%=request.getContextPath()%>/cookieReadServlet.do">저장된 Cookie 정보 읽어오기</a><br><br>

<a href="<%=request.getContextPath()%>/cookieDeleteServlet.do">저장된 Cookie 정보 삭제하기</a><br><br>

</body>
</html>