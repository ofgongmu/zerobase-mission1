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
	<select name="북마크 그룹 이름">
		<option value="">북마크 그룹 이름 선택</option>
		<%%>
			<option value=""></option>
	</select>
	<button type="button">북마크 추가하기</button>
	<div style="font-size: 12px">
	<table>
				<% 
				DAO dao = new DAO();
				DTO dto = dao.detail(request.getParameter("no")); %> 
				<tr>
					<th>거리(km)</th>
					<td><%=dto.getDist()%></td>
				</tr>
				<tr>
					<th>관리번호</th>
					<td><%=dto.getManNum()%></td>
				</tr>
				<tr>
					<th>자치구</th>
					<td><%=dto.getLocGu()%></td>
				</tr>
				<tr>
					<th>와이파이명</th>
					<td><%=dto.getWifiName()%></td>
				</tr>
				<tr>
					<th>도로명주소</th>
					<td><%=dto.getLocAd()%></td>
				</tr>
				<tr>
					<th>상세주소</th>
					<td><%=dto.getLocAd2()%></td>
				</tr>
				<tr>
					<th>설치위치(층)</th>
					<td><%=dto.getLocFloor()%></td>
				</tr>
				<tr>
					<th>설치유형</th>
					<td><%=dto.getInstType()%></td>
				</tr>
				<tr>
					<th>설치기관</th>
					<td><%=dto.getInstAd()%></td>
				</tr>
				<tr>
					<th>서비스구분</th>
					<td><%=dto.getService()%></td>
				</tr>
				<tr>
					<th>망종류</th>
					<td><%=dto.getNetType()%></td>
				</tr>
				<tr>
					<th>설치년도</th>
					<td><%=dto.getInstYear()%></td>
				</tr>
				<tr>
					<th>실내외구분</th>
					<td><%=dto.getInOut()%></td>
				</tr>
				<tr>
					<th>WiFi접속환경</th>
					<td><%=dto.getEnvir()%></td>
				</tr>
				<tr>
					<th>X좌표</th>
					<td><%=dto.getCoorX()%></td>
				</tr>
				<tr>
					<th>Y좌표</th>
					<td><%=dto.getCoorY()%></td>
				</tr>
				<tr>
					<th>작업일자</th>
					<td><%=dto.getWorkDt()%></td>
				</tr>
			</table>
	</div>
</body>
</html>