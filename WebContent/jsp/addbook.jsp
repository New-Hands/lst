<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>新书添加</title>
<link rel=stylesheet type="text/css" href="http://localhost:8080/lst/css/addbook.css"/>
</head>
<script type="text/javascript">

</script>
<body>

<div class="top">
	<p id="wel"><a href="pagequery?bookId=0">回到主界面</a></p>
</div>

<div class="content">
	<div>
	<form action="addbook" method="post" id="form">
	
		<table bordercolor="3" >
		<%
			if(request.getAttribute("flag")!=null){
				
		%>
		
			<tr >
				<td><p>添加成功<p></td>
			</tr>
		<%
			}
	
		%>
		
			<tr >
				<td><p>书名<p></td>
				<td><input type="text" name="bookName"></td>
			</tr>
			<tr>
				<td ><p>作者<p></td>
				<td ><input type="text" name="bookAuthor" ></td>
			</tr>
			<tr>
				<td ><p>价格<p></td>
				<td ><input type="text" name="bookPrice"></td>
			</tr>
			<tr>	
				<td><input id="log"  type="submit" value="添加"><td>
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