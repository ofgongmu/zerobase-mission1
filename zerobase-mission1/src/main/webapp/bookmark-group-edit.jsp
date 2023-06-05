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
<title>위치 히스토리 목록</title>
<style>
	body {
		font-family: sans-serif;
	}
	div {
		margin-top: 20px;
		margin-bottom: 20px;
	}
	input {
		border: solid 1px #000000;
	}
	table {
		width: 100%;
		background-color: green;
		font-color: white;
		border-collapse: collapse;
	}
	th, td {
		border: 1px solid #FFFFFF;
		padding: 10px
	}
	
	th {
		background-color: #24af7f;
		color: white;
		width: 20%;
	}
	tbody tr:nth-child(2n) {
		background-color: #FFFFFF;
	}
	tbody tr:nth-child(2n+1) {
		background-color: #e2e2e2;
	}
	
</style>
</head>
<body>
	<h1>와이파이 정보 구하기</h1>
	<div id="menu">
		<a href="home.jsp">홈</a>
		<span> | </span>
		<a href="history.jsp">위치 히스토리 목록</a>
		<span> | </span>
		<a href="load-wifi.jsp">OPEN API 와이파이 정보 가져오기</a>
		<span> | </span>
		<a href="bookmark-list.jsp">북마크 보기</a>
		<span> | </span>
		<a href="bookmark-group.jsp">북마크 그룹 관리</a>
	</div>
	
	<div style="font-size: 12px">
	
	<% 
			GroupDAO gDao = new GroupDAO(); 
			GroupDTO gDto = gDao.detail(Integer.parseInt(request.getParameter("id"))); 
	%>
		<form action="bookmark-group-edit-submit.jsp" method="get"> 
		<table>
			
				<input type ="hidden" id="id" name="id" value=<%=Integer.parseInt(request.getParameter("id")) %>>
			
				<tr>
					<th>북마크 이름</th>
					<td><input type="text" id="name" name="name" value="<%=gDto.getGroupName()%>"></td>
				</tr>
				<tr>
					<th>순서</th>
					<td><input type="number" id="order" name="order" value="<%=gDto.getOrder()%>"></td>
				</tr>
			
				<tr>
					<td colspan="2">
						<center>
							<a href="bookmark-group.jsp">돌아가기</a>
							<button type="submit">수정</button>
						</center>
					</td>
				</tr>
			
				
		</table>
		</form>
			
		
	</div>
</body>
</html>