package com.lst.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlDatabaseConnection implements DatabaseConnection{
	
	private static final String URL="jdbc:mysql://localhost:3306/bookshop?useSSL=false&useUnicode=true&autoReconnect=true";
	private static final String DRIVER="org.gjt.mm.mysql.Driver";
	private static final String user="root";
	private static final String pass="lst601z815";
	
	private Connection con=null;

	static{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void close() {
		
		if(con!=null){
			try {
				con.close();
				System.out.println("关闭连接");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Connection getConnection(){
		
		try {
			this.con=DriverManager.getConnection(URL,user,pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;

	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MysqlDatabaseConnection con=new MysqlDatabaseConnection();
		con.getConnection();
		con.close();
		
	}
}
