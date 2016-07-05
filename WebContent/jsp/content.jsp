<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>图书详情</title>
</head>
<body>

	<%
		if(request.getParameter("bookId")!=null){
		int bookId=Integer.parseInt(request.getParameter("bookId"));
		
		
	%>
	<%=bookId%>
	<%
		}else{
			
	%>		
	hello
	<% 	
		}
	%>
	
</body>
</html>