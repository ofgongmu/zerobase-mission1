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
<title>와이파이 정보 구하기</title>
</head>
<body>
	<%
	
		
			String groupName = request.getParameter("groupName");
			String wifiName = request.getParameter("wifiName");
			
			BookmarkDAO bDAO = new BookmarkDAO();
			BookmarkDTO bDTO = new BookmarkDTO(groupName, wifiName);
			bDAO.add(bDTO);
		
				
			out.println("<script>");
			out.println("alert('북마크 정보를 추가하였습니다.')");
			out.println("location.href='bookmark-list.jsp'");
			out.println("</script>");
		 
	
		
	%>
	
		
		
		
	
</body>
</html>