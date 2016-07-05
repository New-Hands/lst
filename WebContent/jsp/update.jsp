<%@page import="com.lst.library.vo.Book"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>更新图书</title>
<link rel=stylesheet type="text/css" href="http://localhost:8080/lst/css/addbook.css"/>
</head>

<body>
<%
	if(request.getParameter("bookId")!=null){
	
	
%>

<div class="top">
	<p id="wel"><a href="pagequery?bookId=0">回到主界面</a></p>
</div>

<div class="content">
	<div>
	<form action="update?bookId=<%=request.getParameter("bookId")%>" method="post" id="form">
	
		<table bordercolor="3" >
	
			<tr >
				<td><p>书名<p></td>
				<td><input type="text" name="bookName" value="<%= request.getParameter("bookName")%>"></td>
			</tr>
			<tr>
				<td ><p>作者<p></td>
				<td ><input type="text" name="bookAuthor" value="<%= request.getParameter("bookAuthor")%>" ></td>
			</tr>
			<tr>
				<td ><p>价格<p></td>
				<td ><input type="text" name="bookPrice" value="<%= request.getParameter("bookPrice")%>" ></td>
			</tr>
			<tr>	
				<td><input id="log"  type="submit" value="更新"><td>
			</tr>
		</table>
	</form>
	
	</div>
</div>
<div class="foot">
	<p class="footc">contact me: 1053611095</p>
	<p class="footc"><a href="http://www.cnblogs.com/lst601z815/">about me</a></p>
</div>
<%
	}else{
%>
<div class="top">
	<p id="wel"><a href="pagequery?bookId=0">回到主界面</a></p>
</div>

<div class="content">
	<div>
	<form action="update" method="post" id="form">
	
		<table bordercolor="3" >
		
			<tr >
				<td><p>原书编号<p></td>
				<td><input type="text" name="bookId"></td>
			</tr>
	
			<tr >
				<td><p>书名<p></td>
				<td><input type="text" name="bookName" ></td>
			</tr>
			<tr>
				<td ><p>作者<p></td>
				<td ><input type="text" name="bookAuthor"  ></td>
			</tr>
			<tr>
				<td ><p>价格<p></td>
				<td ><input type="text" name="bookPrice"  ></td>
			</tr>
			<tr>	
				<td><input id="log"  type="submit" value="更新"><td>
			</tr>
		</table>
	</form>
	
	</div>
</div>
<div class="foot">
	<p class="footc">contact me: 1053611095</p>
	<p class="footc"><a href="http://www.cnblogs.com/lst601z815/">about me</a></p>
</div>
<%
	}
%>
</body>
</html>