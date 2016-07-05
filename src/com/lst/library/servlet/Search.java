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

public class Search extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8885428939414722034L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if(req.getParameter("key")!=null){
			
			String path="/jsp/main.jsp";
			
			List<Book> bookList=DaoFactory.getBookDaoProxy().getByKey(req.getParameter("key"));
			
			
			//构造page对象
			
			int pageSize=15;
			int pageNum=1;
			Pager<Book> result=new Pager<Book>(pageNum,pageSize,bookList);
			
			req.setAttribute("result", result);
			
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
