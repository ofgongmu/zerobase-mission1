
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
<style>
	body {
		font-family: sans-serif;
		text-align: center;
	}
</style>
	
</head>

<%
	data.JsonToJava j = new data.JsonToJava();
%>
<body>
	<h1><%=j.loadWifi()%>개의 WIFI 정보를 정상적으로 저장하였습니다.</h1>
	<a href="home.jsp">홈으로 가기</a>
</body>
</html>