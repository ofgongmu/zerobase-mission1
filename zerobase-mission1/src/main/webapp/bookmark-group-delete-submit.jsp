<%@page import="data.GroupDTO"%>
<%@page import="data.GroupDAO"%>
<%@page import="data.DAO"%>
<%@page import="data.DTO"%>
<%@page import="data.HistoryDTO"%>
<%@page import="java.util.List"%>
<%@page import="data.HistoryDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>와이파이 정보 구하기</title>
</head>
<body>
	
	<% 
		out.println("<script>");
		out.println("alert('북마크 그룹 정보를 삭제하였습니다.')");
		out.println("location.href='bookmark-group.jsp'");
		out.println("</script>");
	%>
		
		
	
</body>
</html>