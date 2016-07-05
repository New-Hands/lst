package com.lst.library.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lst.library.dao.DaoFactory;

public class DeleteSome extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3527521845970918131L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String []checkBoxArr= req.getParameterValues("bookId");
		boolean flag=false;
		int firstId=Integer.parseInt(req.getParameter("firstId"));		
		if(checkBoxArr!=null){
			int []idArr=new int[checkBoxArr.length];
			for(int i=0;i<checkBoxArr.length;i++){
				
				idArr[i]=Integer.parseInt(checkBoxArr[i]);
			}
			
			
			
			flag=DaoFactory.getBookDaoProxy().deleteSome(idArr);
			req.setAttribute("flag", flag);
			req.getRequestDispatcher("/jsp/pagequery?bookId="+firstId+"").forward(req, resp);
			System.out.println(firstId);
			
		}else{
			
			req.setAttribute("info","请先选择要删除的项");
			req.getRequestDispatcher("error.jsp").forward(req, resp);
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		this.doGet(req,resp);
	}
	
	

}
