<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>出错了</title>
</head>
<body>
<%
	if(request.getAttribute("info")!=null){
			String info=(String)request.getAttribute("info");
%>
<center>
<%= info%>
<hr>
<a href=" pagequery?bookId=0 ">回到主界面</a>

<%
	}else{
		
%>
	<p>出错了</p>
<%
	}
%>
</center>
</body>
</html>