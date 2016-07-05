package com.lst.library.dao;

import com.lst.dbc.MysqlDatabaseConnection;
import com.lst.library.vo.Administer;

;

public class DaoFactory {
	
	
	public static AdministerDao getAdminixterDao(){
		
		MysqlDatabaseConnection db =new MysqlDatabaseConnection();
		return new AdministerDao(db);
		
	}
	
	public static BookDaoProxy getBookDaoProxy(){
		
		return new BookDaoProxy();
		
	}

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Administer admin=new Administer();
		admin.setAdmin("admin");
		admin.setPwd("123456");
		DaoFactory.getAdminixterDao().query(admin);

	}
	
	

}
