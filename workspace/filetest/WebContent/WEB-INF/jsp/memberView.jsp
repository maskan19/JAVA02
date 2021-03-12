<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src = "<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	//회원 목록 버튼 클릭
	$("#memListBtn").on("click", function(){
		location.href="<%=request.getContextPath()%>/member/memberList.ddit";
	})

	//수정 버튼 클릭
	$("#updateBtn").on("click", function(){
		var memForm = document.getElementById("memberForm");
		memForm.action = "<%=request.getContextPath()%>/member/memberUpdateForm.ddit";
		memForm.submit(); //서버로 전송하게 하는 메서드
	})
	//삭제 버튼 클릭
	$("#delBtn").on("click", function(){
		var memForm = $("#memberForm").get(0);
		//jQuery. 위와 동일
		memForm.action ="<%=request.getContextPath()%>/member/memberDelete.ddit";
		memForm.submit();
	})
	
})
</script>
<title>Insert title here</title>
</head>
<body>
	<h2>회원 정보 상세 보기</h2>
	<%
		MemberVO memVo = (MemberVO) request.getAttribute("memberVo");
	%>
	
	
	
	<form id="memberForm" method="post">
	<!-- hidden -->
	<input type="hidden" name="mem_id" value="<%=memVo.getMem_id()%>">
	<table border="1">
		<tr>
		</tr>
		<tr>
			<td>회원ID</td>
			<td><%=memVo.getMem_id() %>
				</td>
		</tr>
		<tr>
			<td>회원이름</td>
			<td><%=memVo.getMem_name() %></td>
		</tr>
		<tr>
			<td>전화비번</td>
			<td><%=memVo.getMem_pass() %></td>
		</tr>
		<tr>
			<td>회원아이콘</td>
			<td><%=memVo.getMem_icon() %></td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="button" value="수정" id="updateBtn">
			<input type="button" value="삭제" id="delBtn">
			<input type="button" value="회원목록" id="memListBtn">
			
			</td>
		</tr>
	</table>
	</form>
</body>
</html>