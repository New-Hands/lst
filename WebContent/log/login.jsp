<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>辛苦了，管理员</title>
<link rel=stylesheet type="text/css" href="http://localhost:8080/lst/css/adminlog.css"/>

</head>

<body>

<div class="top">
	<p id="wel">hello,administer</p>
</div>

<div class="content">

	<div>
	<center>
	<br>
	<%if(request.getAttribute("info")!=null){
	%>
		<%= request.getAttribute("info")%>
	<%
	}
	%>
	
	</center>
	<form action="/lst/log/LoginServlet" method="post" id="form">
	
		<table bordercolor="3" >
			<tr >
				<td><p>administer<p></td>
				<td><input type="text" name="admin"></td>
			</tr>
			<tr>
				<td ><p>password<p></td>
				<td ><input type="password" name="pwd" ></td>
			</tr>
			<tr>	
				<td><input id="log"  type="submit" value="登陆"><td>
			</tr>
		</table>
	</form>
	</div>
</div>
<div class="foot">
	<p class="footc">contact me: 1053611095</p>
	<p class="footc"><a href="http://www.cnblogs.com/lst601z815/">about me</a></p>
</div>
</body>
</html>