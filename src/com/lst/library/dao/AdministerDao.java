package com.lst.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.lst.dbc.MysqlDatabaseConnection;
import com.lst.library.vo.Administer;

public class AdministerDao {
	
	
	private MysqlDatabaseConnection Db=new MysqlDatabaseConnection();

	
	public AdministerDao(MysqlDatabaseConnection db) {
		
		Db = db;
	}
	
	public AdministerDao(){
		
	}

	public boolean isExit(Administer admin){

		String sql="select * from administer where admin= ? ";

		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;

		try {
			
			con=Db.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, admin.getAdmin());
			rs=ps.executeQuery();

			if(rs.next()){
				System.out.println("找到");
				return true;

			}else
				
				System.out.println("帐号不存在");
				return false;

		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			Db.close();
			
		}

		return false;

	}
	
	
	public String query(Administer admin){


		String sql="select admin  from administer where pwd = ? and admin= ?";

		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;

		try {
			if(isExit(admin)){
				
				con=Db.getConnection();
				ps=con.prepareStatement(sql);
				ps.setString(1, admin.getPwd());
				ps.setString(2, admin.getAdmin());
				rs=ps.executeQuery();

				if(rs.next()){
					
					System.out.println("成功登陆");
					return "true";

				}else{

					System.out.println("密码错误");
					return "密码错误";
				}
			}
			else{
				
				System.out.println("帐号不存在");
				return "账号不存在";
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			Db.close();
			
		}

		return "false";

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		
		AdministerDao da=new AdministerDao();
		Administer admin=new Administer();
		
		admin.setAdmin("admin");
		admin.setPwd("123456");
		da.query(admin);
		
	
		

	}

}
