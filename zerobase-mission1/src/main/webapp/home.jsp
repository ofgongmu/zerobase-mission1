<%@page import="data.HistoryDTO"%>
<%@page import="data.HistoryDAO"%>
<%@page import="java.util.List"%>
<%@page import="data.DTO"%>
<%@page import="data.DAO"%>
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
			padding: 10px;
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
	<div id="currentLoc">
		<form action="home.jsp" method="GET">
			<label for="LAT">LAT: </label><input type="text" id="LAT" name="LAT">
			<label for="LNT">, LNT: </label><input type="text" id="LNT" name="LNT">
			<button type="button" onclick="getLocation()">내 위치 가져오기</button>
			<button type="submit" onclick="home.jsp">근처 WIFI 정보 보기</button>
		</form>
	</div>
	<div style="font-size: 12px">
		<table>
			<thead>
				<tr>
					<th>거리(km)</th>
					<th>관리번호</th>
					<th>자치구</th>
					<th>와이파이명</th>
					<th>도로명주소</th>
					<th>상세주소</th>
					<th>설치위치(층)</th>
					<th>설치유형</th>
					<th>설치기관</th>
					<th>서비스구분</th>
					<th>망종류</th>
					<th>설치년도</th>
					<th>실내외구분</th>
					<th>WiFi접속환경</th>
					<th>X좌표</th>
					<th>Y좌표</th>
					<th>작업일자</th>
			</thead>
						
		<%
				DAO dao = new DAO();
			
				request.setCharacterEncoding("utf-8");
				
				if (request.getParameter("LAT") != null && request.getParameter("LNT") != null) {
					float curX = Float.parseFloat(request.getParameter("LAT"));
					float curY = Float.parseFloat(request.getParameter("LNT"));
					
					HistoryDAO hDAO = new HistoryDAO();
					HistoryDTO hDTO = new HistoryDTO(curX, curY);
					hDAO.update(hDTO);
					dao.updateDist(curX, curY);
					List<DTO> wifiList = dao.showNearWifi();
					
					%>
					<tbody>
					
							<%
								for(DTO dto: wifiList) { 
							%>
								<tr>
									<td><%=dto.getDist()%></td>
									<td><%=dto.getManNum()%></td>
									<td><%=dto.getLocGu()%></td>
									<td><a href="detail.jsp?no=<%=dto.getManNum()%>"><%=dto.getWifiName()%></a></td>
									<td><%=dto.getLocAd()%></td>
									<td><%=dto.getLocAd2()%></td>
									<td><%=dto.getLocFloor()%></td>
									<td><%=dto.getInstType()%></td>
									<td><%=dto.getInstAd()%></td>
									<td><%=dto.getService()%></td>
									<td><%=dto.getNetType()%></td>
									<td><%=dto.getInstYear()%></td>
									<td><%=dto.getInOut()%></td>
									<td><%=dto.getEnvir()%></td>
									<td><%=dto.getCoorX()%></td>
									<td><%=dto.getCoorY()%></td>
									<td><%=dto.getWorkDt()%></td>
								</tr>
							<%
								}
							%>
						</tbody>
					</table>
				
			<% } else { %>
			
				<tbody>
					<tr>
						<td colspan="18" align="center">위치정보를 입력한 후에 조회해주세요.</td>
					</tr>
				</tbody>
				</table>
			<% } %>
	</div>
	
	
	
	<script src="getLocation.js"></script>
</body>
</html>