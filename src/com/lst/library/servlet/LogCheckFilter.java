package com.lst.library.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class LogCheckFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest res=(HttpServletRequest)arg0;
		HttpSession ses=res.getSession();
		
		if(ses.getAttribute("user")!=null){
			arg2.doFilter(arg0, arg1);
			
		}else{
			arg0.setAttribute("info", "请先登陆");
			arg0.getRequestDispatcher("/log/login.jsp").forward(arg0, arg1);
		}


	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
