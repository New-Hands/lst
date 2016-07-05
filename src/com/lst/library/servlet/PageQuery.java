package com.lst.library.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lst.library.dao.DaoFactory;
import com.lst.library.vo.Book;
import com.lst.library.vo.Pager;

public class PageQuery extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2743163094999524190L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String path="/jsp/main.jsp";
		List<Book> bookList=null;
		int location;
		
		//接收上一页的第一本书的id
		int preId=0;
		if(req.getParameter("preId")!=null){
			
			preId=Integer.parseInt(req.getParameter("preId"));
			req.setAttribute("preId", preId);
		}
		
		//删除页面的第一本书的Id
		int firstId=0;
		if(req.getParameter("firstId")!=null){
			
			firstId=Integer.parseInt(req.getParameter("firstId"));
			location=DaoFactory.getBookDaoProxy().location(firstId);
		}
		
		if(req.getParameter("bookId")!=null){
			int bookId=Integer.parseInt(req.getParameter("bookId"));
		
		//获取所需的参数
		bookList=DaoFactory.getBookDaoProxy().pageQuery(bookId);
		int totalRecord=DaoFactory.getBookDaoProxy().getTotalRecord();
		
		location=DaoFactory.getBookDaoProxy().location(bookId+1);
		
		int totalPage;
		int currentPage = 0;
		
		if(totalRecord%15!=0){
			totalPage=totalRecord/15+1;
			currentPage=location%15+1;//这里不能够通过id来判断？那该通过什么来判断，，，，另用一个变量？？
		}else{
			totalPage=totalRecord/15;
		}
		//封装成result
		Pager<Book> page=new Pager<>(15,currentPage,totalRecord,totalPage, bookList);

		req.setAttribute("result", page);
		
		req.getRequestDispatcher(path).forward(req, resp);
		
		}else{
			
			req.setAttribute("info","缺少参数");
			req.getRequestDispatcher("error.jsp").forward(req, resp);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	

}
