<%@page import="data.BookmarkDTO"%>
<%@page import="data.BookmarkDAO"%>
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
	

			<thead>
				<tr>
					<th width="5%">ID</th>
					<th>북마크 이름</th>
					<th>와이파이명</th>
					<th>등록일자</th>
					<th>비고</th>
				</tr>
			</thead>
			<% 
				BookmarkDAO bDao = new BookmarkDAO();
				List<BookmarkDTO> bookmarkList = bDao.showBookmark();
				if (bookmarkList.size() == 0) {
			%>
				<tbody>
					<tr>
						<td colspan="5" align="center">정보가 존재하지 않습니다.</td>
					</tr>
				</tbody>
		<% 
				} else {
		%>
					<tbody>
					
						<%
							for(BookmarkDTO bDto: bookmarkList) { 
						%>
							<tr>
								<td><%=bDto.getBookmarkId()%></td>
								<td><%=bDto.getGroupName()%></td>
								<td><%=bDto.getWifiName()%></td>
								<td><%=bDto.getAddDt()%></td>
								<td><a href="bookmark-delete.jsp?id=<%=bDto.getBookmarkId()%>">삭제</a></td>
							</tr>
						<%
							}
						%>
					</tbody>
				</table>
		<%
				}
		%>
	</div>
</body>
</html>