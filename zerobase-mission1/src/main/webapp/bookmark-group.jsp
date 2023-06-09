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
		table-layout: fixed;
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
	<h1>북마크 관리</h1>
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
	<button type="button" onclick="location.href='bookmark-group-add.jsp'">북마크 그룹 이름 추가</button>
	<div style="font-size: 12px">
	
		<table>
			<thead>
				<tr>
					<th width="5%">ID</th>
					<th>북마크 이름</th>
					<th>순서</th>
					<th>등록일자</th>
					<th>수정일자</th>
					<th>비고</th>
				</tr>
			</thead>
						
		<%
				GroupDAO gDao = new GroupDAO();
				List<GroupDTO> groupList = gDao.showGroup();
				
				if (groupList.size() == 0) {
		%>
				<tbody>
					<tr>
						<td colspan="6" align="center">정보가 존재하지 않습니다.</td>
					</tr>
				</tbody>
		<% 
				} else {
		%>
					<tbody>
					
						<%
							for(GroupDTO gDto: groupList) { 
						%>
							<tr>
								<td><%=gDto.getGroupId()%></td>
								<td><%=gDto.getGroupName()%></td>
								<td><%=gDto.getOrder()%></td>
								<td><%=gDto.getAddDt()%></td>
								<td><%=gDto.getEditDt() == null ? "" : gDto.getEditDt()%></td>
								<td>
									<a href="bookmark-group-edit.jsp?id=<%=gDto.getGroupId()%>">수정</a>
									<a href="bookmark-group-delete.jsp?id=<%=gDto.getGroupId()%>">삭제</a>
								</td>
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