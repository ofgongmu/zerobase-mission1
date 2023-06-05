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
</head>
<body>
	<%
	
		GroupDAO gDao = new GroupDAO(); 
		
		
		if (request.getParameter("name") != null && request.getParameter("order") != null) {
			String groupName = request.getParameter("name");
			int order = Integer.parseInt(request.getParameter("order"));
								
			GroupDAO gDAO = new GroupDAO();
			GroupDTO gDTO = new GroupDTO(groupName, order);
			gDAO.add(gDTO);
		}
			
		out.println("<script>");
		out.println("alert('북마크 그룹 정보를 추가하였습니다.')");
		out.println("location.href='bookmark-group.jsp'");
		out.println("</script>");
	%>
	
		
		
		
	
</body>
</html>