<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>        
<html>
<head>
	<title>��ü �Խñ�</title>
	
	<style type="text/css">
		#wrap {
			width: 800px;
			margin: 0 auto 0 auto;
		}

		#topForm{
			text-align :right;
		}

		#board, #pageForm, #searchForm{
			text-align :center;
		}
		
		#bList{
			text-align :center;
		}
	</style>
	
	<script type="text/javascript">
		function writeForm(){
			location.href="BoardWriteForm.bo";
		}
	</script>
	
</head>
<body>	

<div id="wrap">
	<br>
	<div id="topForm">
		<c:if test="${sessionScope.sessionID!=null}">
			<input type="button" value="�۾���" onclick="writeForm()">
		</c:if>	
	</div>
	<br>
	<div id="board">
		<table id="bList" width="800" border="3" bordercolor="lightgray">
			<tr heigh="30">
				<td>�۹�ȣ</td>
				<td>����</td>
				<td>�ۼ���</td>
				<td>�ۼ���</td>
				<td>��ȸ��</td>
			</tr>	
			<tr>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
			</tr>
		</table>
	</div>
	<br>
	<div id="pageForm">
		������ ��ȣ
	</div>
	<br>
	<div id="searchForm">
		<form>
			<select name="opt">
				<option value="0">����</option>
				<option value="1">����</option>
				<option value="2">����+����</option>
				<option value="3">�۾���</option>
			</select>
			<input type="text" size="20" name="condition"/>&nbsp;
			<input type="submit" value="�˻�"/>
		</form>	
	</div>
</div>	

</body>
</html>