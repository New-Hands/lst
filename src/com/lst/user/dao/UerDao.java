package com.lst.user.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.lst.dbc.MysqlDatabaseConnection;
import com.lst.user.vo.User;


public class UerDao {
	
	
	private MysqlDatabaseConnection Db=null;
	
	public UerDao(MysqlDatabaseConnection db) {
		
		super();
		Db = db;
	}

	public String add(User user){
		

		String sql="insert into user(userId,passWord)values(?,?)";
		
		Connection con=null;
		PreparedStatement ps=null;

		try {

			String res=isExit(user);
			if(!(res.equals("true"))){

				con=Db.getConnection();
				ps=con.prepareStatement(sql);
				ps.setString(1, user.getUserName());
				ps.setString(2, user.getUserPwd());
				ps.executeUpdate();

				if(ps.getUpdateCount()==1){
					System.out.println("wangcehng ");
					return "true";

					}
				else
					return "添加失败";
			}else
				System.out.println("zhanghaocunzai");
			return "账号已经存在";


		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
		
		}

		return "false";

	}

	public String query(User user){


		String sql="select userId  from user where passWord = ? ";

		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;

		try {
			if(isExit(user).equals("true")){
				
				con=Db.getConnection();
				ps=con.prepareStatement(sql);
				ps.setString(1, user.getUserPwd());
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
			
		}

		return "false";

	}


	public String isExit(User user){

		String sql="select * from user where userId=?";

		Connection con=null;
		ResultSet rs=null;
		PreparedStatement ps=null;

		try {
			

			con=Db.getConnection();
			ps=con.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			rs=ps.executeQuery();

			if(rs.next()){
				System.out.println("找到");
				return "true";

			}else
				System.out.println("帐号不存在");
				return "帐号不存在";

		} catch (SQLException e) {

			e.printStackTrace();
		}finally{
			
		}

		return "false";

	}
	public static void main(String[] args) {

		


	}

}
