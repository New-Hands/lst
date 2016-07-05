package com.lst.library.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckOut extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8113129570869824775L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpServletRequest res=(HttpServletRequest)req;
		HttpSession ses=res.getSession();
		
		ses.invalidate();
		
		resp.sendRedirect("/lst/log/login.jsp");
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
		
	}
	
	

}
