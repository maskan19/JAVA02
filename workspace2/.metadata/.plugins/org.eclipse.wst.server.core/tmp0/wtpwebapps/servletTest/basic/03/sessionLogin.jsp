<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 로그인 시작페이지</title>
</head>
<body>
	<a>
 <%
 	if (session.getAttribute("ID") != null && session.getAttribute("PASS") != null) {
 %> 
 <h2><%=session.getAttribute("ID")%>님 반갑습니다.</h2>
 <br><a href="<%=request.getContextPath()%>/sessionLogout.do">로그아웃</a>
 <%
 	} else {
 %>
		<form method="post" action="<%=request.getContextPath()%>/sessionLogin.do">
			<table border=1>
				<tr>
					<td>ID :</td>
					<td><input name="userid" type="text" placeholder="ID를 입력하세요"></td>
				</tr>
				<tr>
					<td>PASS :</td>
					<td><input name="userpass" type="password" placeholder="Password를 입력하세요"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align:center;"><input type="submit" value="Login"></td>
				</tr>
			</table>
<%
	}
%>
		</a>

</body>
</html>