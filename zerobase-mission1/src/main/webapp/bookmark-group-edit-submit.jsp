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
		GroupDTO gDto = gDao.detail(Integer.parseInt(request.getParameter("id"))); 
		
		if (request.getParameter("name") != null && request.getParameter("order") != null) {
			String groupName = request.getParameter("name");
			int order = Integer.parseInt(request.getParameter("order"));
			
			gDto.setGroupName(groupName);
			gDto.setOrder(order);
		}
		
		gDao.edit(gDto);
	
	
		out.println("<script>");
		out.println("alert('북마크 그룹 정보를 수정하였습니다.')");
		out.println("location.href='bookmark-group.jsp'");
		out.println("</script>");
		
		
	%>
</body>
</html>