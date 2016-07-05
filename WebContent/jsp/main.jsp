<%@page import="com.lst.library.vo.Pager"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.*" import="com.lst.library.vo.Book"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>bookshop后台管理</title>
<link rel=stylesheet type="text/css" href="http://localhost:8080/lst/css/main.css" />
</head>

<%
// 获取请求的上下文
String context = request.getContextPath();

if(request.getAttribute("result")!=null);
	
@SuppressWarnings("unchecked") 
Pager<Book> pager=(Pager<Book>)request.getAttribute("result");
List<Book> bookList=pager.getDataList();
//使用数据之前一定要进行判断，空检查等
int  flagId=0;
int  fId=0;
int  lId=0;
int  preId=0; 

if(bookList!=null){
flagId=bookList.size();	
fId=bookList.get(flagId-1).getBookId();
flagId++;
lId=bookList.get(flagId-2).getBookId();//这样的写法 防止了id为负的情况;

//获取上一页的第一本图书的id
 
/* if(request.getAttribute("preId")!=null){
	preId=()request.getAttribute("preId");
} */
}

%>

<script type="text/javascript">
//当前第几页数据
var currentPage = ${result.currentPage};
	

//总页数
var totalPage = ${result.totalPage};

function submitForm(actionUrl){
var formElement = document.getElementById("stuForm");
formElement.action = actionUrl;
formElement.submit();
}

//第一页
function firstPage(){
if(currentPage == 1){
	alert("已经是第一页数据");
	return false;
	
}else{
	submitForm("<%=context %>/jsp/pagequery?bookId=0");
	return true;
}
}

//下一页
function nextPage(){
if(currentPage == totalPage){
	alert("已经是最后一页数据");
	return false;
}else{
	submitForm("<%=context%>/jsp/pagequery?preId="+(preId));
	return true;
}
}

//上一页
function previousPage(){
if(currentPage==1){
	alert("已经是第一页数据");
	return false;
}else{
	submitForm("<%=context %>/jsp/pagequery?bookId="+(preId));
	return true;
}
}

//尾页
function lastPage(){
if(currentPage== totalPage){
	alert("已经是最后一页数据");
	return false;
}else{
	submitForm("<%=context %>/jsp/pagequery?bookId="+(preId));
	return true;
}

}	
</script>

<body>
	<form action="<%=context %>/jsp/pagequery" id="stuForm" method="get"></form>
	
	<div class="top">
		
		<div id="search">
		<form action="../jsp/search" method="post">
			<label for="searchText">请输入想查询的书名</label><input type="text"
				id="search-text" name="key" /> 
				<input type="submit" id="submit" value="搜索" />
		</form>
		</div>
	
	</div>
<div class="bo">

	<div class="content">
		<form action="<%=application.getContextPath()%>/jsp/delsome?firstId=<%=fId%> " method="post" >
			<table>
				<tr>
				 	<td><p>选择</p></td>
				 	<td><p>书名</p></td>
				 	<td><p>作者</p></td>
				 	<td><p>价格</p></td>
				 	<td><p>详情</p></td>
				 	<td><p>操作</p></td>
				</tr>
	<%
			
				if(bookList!=null){
				for(int i=0;i<bookList.size();i++)
				{
					int bookId=bookList.get(i).getBookId();
	%>
			<tr>
				<td><input type="checkbox" name="bookId" value="<%=bookList.get(i).getBookId()%>"/></td>
				<td><%= bookList.get(i).getBookName()%></td>
				<td><%= bookList.get(i).getBookAuthor()%></td>
				<td><%= bookList.get(i).getBookPrice()%></td>
				<td><a href=" <%=application.getContextPath()%>/jsp/content.jsp?bookId=<%=bookList.get(i).getBookId() %> ">详情</a> </td>
				<td><a href=" <%=application.getContextPath()%>/jsp/update.jsp?bookId=<%=bookList.get(i).getBookId()%>&bookName=<%=bookList.get(i).getBookName()%>&bookAuthor=<%=bookList.get(i).getBookAuthor()%>&bookPrice=<%=bookList.get(i).getBookPrice()%>">更改</a></td>
			</tr>
	<%
		}
		
		}
	%>
			</table>
			<input id="del" type="submit" name="add" value="删除" >
		</form>	
	<center>
	<br> 共${result.totalRecord }条记录共${result.totalPage }页&nbsp;&nbsp;当前第${result.currentPage }页&nbsp;&nbsp;
		<ul class="page">
		<li><a href="<%=context %>/jsp/pagequery?bookId=0" onclick="">首页</a>&nbsp;&nbsp;</li>
		<li><a href="#" onclick="previousPage()">上一页</a>&nbsp;&nbsp; </li>
		<li><a href="<%=context%>/jsp/pagequery?preId=<%=preId %>&bookId=<%=lId %>" onclick="">下一页</a>&nbsp;&nbsp;</li>
		<li><a href="#" onblur="lastPage()">尾页</a></li>
		
		</ul>
	</center>
	</div>
	
	<div class="fun">
		<ul>
			<li>
				<a href=" <%=application.getContextPath()%>/jsp/addbook.jsp">添加图书</a>
			</li>
			<li> <a href=" <%=application.getContextPath()%>/jsp/update.jsp">更新图书</a></li>
			
			<li> <a href=" <%=application.getContextPath()%>/jsp/checkout">注销登陆</a></li>
		</ul>
	</div>
	
</div>

<div class="foot">
		
</div>
	
</body>
</html>