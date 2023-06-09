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
	}
	th, td {
		border: 1px solid #FFFFFF;
		padding: 10px
	}
	
	th {
		background-color: #24af7f;
		color: white;
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
	<h1>위치 히스토리 목록</h1>
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
					<th>ID</th>
					<th>X좌표</th>
					<th>Y좌표</th>
					<th>조회일자</th>
					<th>비고</th>
			</thead>
			<%
				HistoryDAO hDAO = new HistoryDAO();
				List<HistoryDTO> historyList = hDAO.showHistory();
			%>
			<tbody>
				<%
					for(HistoryDTO hDTO: historyList) {
				%>
					<tr>
						<td><%=hDTO.getHistoryId()%></td>
						<td><%=hDTO.getCoorX()%></td>
						<td><%=hDTO.getCoorY()%></td>
						<td><%=hDTO.getInquiryDt()%></td>
						<td align="center"><button type="button" onclick="<%hDAO.delete(hDTO.getHistoryId());%>; window.location.reload()">삭제</button></td>
					</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>