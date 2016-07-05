package com.lst.library.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lst.library.dao.DaoFactory;
import com.lst.library.vo.Administer;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7121229311237411494L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String path="login.jsp";
		String user=req.getParameter("admin");
		String pwd=req.getParameter("pwd");
		
		List<String> info=new Vector<>();
		
		if(user==null||"".equals(user)){
			
			info.add("用户不能为空");

		}else{
			
			if(pwd==null||"".equals(pwd)){
				info.add("密码不能为空");
				
			}else{
				
				Administer admin=new Administer();
				
				admin.setAdmin(user);
				admin.setPwd(pwd);
				String res=DaoFactory.getAdminixterDao().query(admin);
			
				
				if("true".equals(res)){
					
					req.getSession().setAttribute("user", user);
					System.out.println("come in");
					path="/jsp/pagequery?bookId=0";

					
				}else{
	
					info.add(res);
					
					}
			}
				
		}
		
		req.setAttribute("info", info);
		req.getRequestDispatcher(path).forward(req, resp);
			
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
	
	
	

}
