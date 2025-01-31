<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberList 페이지</title>
<script type="text/javascript">
window.onload = function(){
	var addBtn = document.getElementById("addBtn");
	
	addBtn.onclick = function(){
		location.href = "<%=request.getContextPath()%>/member/memberForm.ddit";
		
	}
}
</script>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<td colspan="4"><input type="button" id="addBtn" value="회원추가">
				</td>
			</tr>
			<tr>
				<th>ID</th>
				<th>이름</th>
				<th>아이콘</th>
				<th>별명</th>
			</tr>
		</thead>
		<tbody>
			<%
				//서블릿에서 보내온 데이터를 출력한다.
				List<MemberVO> memList = (List<MemberVO>) request.getAttribute("memList");
				if (memList == null || memList.size() == 0) {
			%>
			<tr>
				<td colspan="4">회원이 하나도 없습니다.</td>
			</tr>

			<%
				} else {
					for (MemberVO memvo : memList) {
			%>
			<tr>
				<td><a href="<%=request.getContextPath()%>/member/memberView.ddit?mem_id=<%=memvo.getMem_id()%>"><%=memvo.getMem_id()%></a></td>
				<td><%=memvo.getMem_name()%></td>
				<td><%=memvo.getMem_icon()%></td>
				<td><%=memvo.getMem_ali()%></td>
			</tr>


			<%
				}
			%>
			<%
				}
			%>
		</tbody>
	</table>

</body>
</html>