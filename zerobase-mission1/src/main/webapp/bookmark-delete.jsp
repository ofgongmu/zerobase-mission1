<%@page import="data.BookmarkDTO"%>
<%@page import="data.BookmarkDAO"%>
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
		<table>
			<% 
				BookmarkDAO bDao = new BookmarkDAO(); 
				BookmarkDTO bDto = bDao.detail(Integer.parseInt(request.getParameter("id"))); 
			%>
			
				<tr>
					<th>북마크 이름</th>
					<td><%=bDto.getGroupName()%></td>
				</tr>
				<tr>
					<th>와이파이명</th>
					<td><%=bDto.getWifiName()%></td>
				</tr>
				<tr>
					<th>등록일자</th>
					<td><%=bDto.getAddDt()%></td>
				</tr>
			
				<tr>
					<td colspan="2">
						<center>
							<a href="bookmark-group.jsp">돌아가기</a>
							<button type="button" onclick=<%bDao.delete(Integer.parseInt(request.getParameter("id")));%>"location.href='bookmark-delete-submit.jsp'">삭제</button>
						</center>
					</td>
				</tr>	
		</table>
	</div>
</body>
</html>