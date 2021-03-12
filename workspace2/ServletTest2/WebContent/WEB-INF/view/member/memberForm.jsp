<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 입력 폼</title>
<script type="text/javascript" src = "<%=request.getContextPath()%>/js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#memListBtn").on("click", function(){
		location.href="<%=request.getContextPath()%>/member/memberList.ddit";
	})
	var chkMemId = ""; //중복체크할 때의 ID가 저장될 변수
	$("#idcheck").on("click", function(){
		var memId = $("#mem_id").val(); //입력한 회원 ID읽어오기
		if(memId==""){
			alert("회원 ID를 입력하세요");
			$("#mem_id").focus();
			return;
		}
		$.ajax({
			"url" : "<%=request.getContextPath()%>/member/memberIdCheck.ddit",
			"method": "post",
			"data" : {"mem_id" : memId},
			"dataType" : "json",
			"success" : function(result){
				alert(result);
				if(result=="Success"){
					$("#idCheckResult").html("사용 가능 ID");
					chkMemId=memId;
				}else{
					$("#idCheckResult").html("중복된 ID");
					chkMemId="";
				}
			},
			"error" : function(xhr){
				alert("오류 : " + xhr.status);
			}
			
		})
		
	})
	
	//저장버튼 클릭: form이 submit될 때
	$("#memberForm").on('submit', function(){
		var memId=$("#mem_id").val();
		var idCheck = $("#idCheckResult").html().trim();
		if(chkMemId!=memId|| idChk =="사용 가능 ID"){
			alert("새로운 ID를 입력하세요");
			$("#mem_id").focus();
			return false;
		}
		return true;
	})
	
	
})



</script>
</head>
<body>
<h2>회원 정보 입력 폼</h2>
<form id = "memberForm" method="post" action="<%=request.getContextPath() %>/member/memberInsert.ddit">
	<table border="1">
		<tr>
		</tr>
		<tr>
			<td>회원ID</td>
			<td><input type="text" name="mem_id" id="mem_id"> 
				<input type="button" id="idcheck" value="중복확인"><br>
				<span id="idCheckResult"></span>
				</td>
		</tr>
		<tr>
			<td>회원이름</td>
			<td><input type="text" name="mem_name" id="mem_name"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="mem_pass" id="mem_tel"></td>
		</tr>
		<tr>
			<td>별명</td>
			<td><input type="text" name="mem_ali" id="mem_addr"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="file" name="mem_icon"
				id="mem_icon" accept="image/*" onchange="setThumbnail(event);" />
			</td>
		</tr>
		<tr>
			<td colspan="2">미리보기 : 
			<div class="image_container"></div>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="저장">
			<input type="reset" value="취소">
			<input type="button" id="memListBtn" value="회원목록">
			
			</td>
		</tr>
	</table>
	</form>
</body>
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