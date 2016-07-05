package com.lst.library.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lst.library.dao.DaoFactory;
import com.lst.library.vo.Book;

public class AddBook extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -476048834237437003L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Book book=new Book();
		if( req.getParameter("bookAuthor")!=null&&(req.getParameter("bookName"))!=null&&
				(req.getParameter("bookPrice"))!=null&&(!req.getParameter("bookAuthor").equals(""))&&
				(!req.getParameter("bookName").equals(""))&&
				(!req.getParameter("bookPrice").equals(""))){
			
			book.setBookAuthor(req.getParameter("bookAuthor"));
			book.setBookName(req.getParameter("bookName"));
			book.setBookPrice(Double.parseDouble(req.getParameter("bookPrice")));
			
			boolean flag=DaoFactory.getBookDaoProxy().add(book);
			System.out.print("dsf");
			
			req.setAttribute("flag", flag);
			req.getRequestDispatcher("addbook.jsp").forward(req, resp);
			
		}else{
			
			req.setAttribute("info", "参数错误");
			req.getRequestDispatcher("error.jsp").forward(req, resp);
			
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	
	
	

}
