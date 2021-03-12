<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSON데이터 처리하기</title>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
$(function(){
	//문자열
	$("#strBtn").on("click", function(){
		$.ajax({
			"url" : "<%=request.getContextPath()%>/JSONServlet.do",
			"type" : "post",
			"data" : "choice=str",
			"success" : function(data){
				$("#result").empty();
				$("#result").append(data);
				$("#result").append("<hr color=#F5F2A0>");
				
			},
			"dataType" : "json"
		})
		
	})
	//배열
	$("#arrayBtn").on("click", function(){
		$.ajax({
			"url" : "<%=request.getContextPath()%>/JSONServlet.do",
			"type" : "post",
			"data" : "choice=array",
			"success" : function(data){
				$("#result").empty();
				$.each(data, function(i,v){
					$("#result").append(i + "번째 자료" + v + "<br>")
				})
				$("#result").append("<hr color=#90E0A1>");
				
			},
			"dataType" : "json"
		})
	})
	//객체
	$("#objBtn").on("click", function(){
		$.ajax({
			"url" : "<%=request.getContextPath()%>/JSONServlet.do",
			"type" : "post",
			"data" : "choice=obj",
			"success" : function(data){
				$("#result").empty();
				$.each(data, function(i,v){
					$("#result").append("필드명: " + i + " / 값: " + v + "<br>")
				})
				$("#result").append("ID: " + data.id + "<br>");
				$("#result").append("NAME: " + data.name + "<br>");
				$("#result").append("AGE: " + data.age + "<br>");
				$("#result").append("<hr color=#A5E0FA>");
			},
			"dataType" : "json"
		})
	})
	//리스트
	$("#listBtn").on("click", function(){
		$.ajax({
			"url" : "<%=request.getContextPath()%>/JSONServlet.do",
			"type" : "post",
			"data" : "choice=list",
			"success" : function(data){
				$("#result").empty();
				$.each(data, function(i,v){
					$("#result").append(i + "번째 리스트<br>");
					$("#result").append("ID: " + v.id + "<br>");
					$("#result").append("PASS: " + v.pass + "<br>");
					$("#result").append("AGE: " + v.age + "<br><br>");
				})
				$("#result").append("<hr color=#ADE0CB>");
				
			},
			"dataType" : "json"
		})
	})
	//Map객체
	$("#mapBtn").on("click", function(){
		$.ajax({
			"url" : "<%=request.getContextPath()%>/JSONServlet.do",
			"type" : "post",
			"data" : "choice=map",
			"success" : function(data){
				$("#result").empty();
				$.each(data, function(key, value){
					$("#result").append(key + " : " + value + "<br>")
				})
				$("#result").append("<hr color = 'red'>");
				
			},
			"dataType" : "json"
		})
	})
})

</script>
</head>
<body>
<form>
<input type="button" id="strBtn" value = "문자열">
<input type="button" id="arrayBtn" value = "배열">
<input type="button" id="objBtn" value = "객체">
<input type="button" id="listBtn" value = "리스트">
<input type="button" id="mapBtn" value = "Map객체">


</form>
<div id="result"></div>
</body>
</html>