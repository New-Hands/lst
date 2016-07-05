package com.lst.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.lst.dbc.MysqlDatabaseConnection;
import com.lst.library.vo.Book;
import com.lst.util.PacSearchKey;


public class BookDao {

	Connection con=null;
	public BookDao(Connection con) {
		
		this.con=con;
	}

	/**
	 * 
	 * @author lst
	 * @param begin 
	 * @return List<Book>
	 * 分页查询
	 */
	public List<Book> pageQuery(int begain){
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Book> bookList=new Vector<Book>();
		
		try {
			
			
			String sql=" select bookId,bookName,bookAuthor,bookPrice from book " +
					" where bookId>=? limit 15 ";
			
			ps=con.prepareStatement(sql);
			ps.setInt(1, begain);
			
			rs=ps.executeQuery();
			
			while(rs.next()){

				Book book=new Book();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookAuthor(rs.getString(3));
				book.setBookPrice(rs.getDouble(4));
				bookList.add(book);

				
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
		}
		
		
		return bookList;
		
	}
	
	public List<Book> query(){

		ResultSet rs=null;
		PreparedStatement ps=null;
		List<Book> bookList=new Vector<>();

		try {

			String sql="select bookId,bookName,bookAuthor,bookPrice from book ";
			ps=con.prepareStatement(sql);
			rs =ps.executeQuery();

			while(rs.next()){

				Book book=new Book();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setBookAuthor(rs.getString(3));
				book.setBookPrice(rs.getDouble(4));
				bookList.add(book);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally{

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


		}
		return bookList;

	}

	public List<Book> getOne(Book book){ 


		ResultSet rs=null;
		PreparedStatement ps=null;
		List<Book> bookList=new Vector<>();


		try {

			int count=0;

			boolean isId=false;
			boolean isName=false;
			boolean isAuthor=false;

			//StringBuilder的作用

			StringBuilder sql = new StringBuilder(" select bookId,bookName,bookAuthor,bookPrice from book where 1=1 ");

			if(book.getBookId()>=0){
				sql.append(" and bookId = ? ");
				isId=true;
			}
			if(!(book.getBookName().equals(""))){
				sql.append(" and bookName = ? ");
				isName=true;
			}
			if(!(book.getBookAuthor().equals("")))
			{
				sql.append(" and bookAuthor = ? ");
				isAuthor=true;
			}


			ps=con.prepareStatement(sql.toString());

			if(isId){
				ps.setInt(++count, book.getBookId());
			}
			if(isName){
				ps.setString(++count, book.getBookName());
			}
			if(isAuthor){
				ps.setString(++count, book.getBookAuthor());
			}


			rs=ps.executeQuery();

			while(rs.next()){

				Book abook=new Book();

				abook.setBookId(rs.getInt(1));
				abook.setBookName(rs.getString(2));
				abook.setBookAuthor(rs.getString(3));
				abook.setBookPrice(rs.getDouble(4));
				bookList.add(abook);

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

		}


		return bookList;

	}
	
	
	//添加基本的书籍信息
	public boolean addBook(Book book){


		boolean flag=false;
		PreparedStatement ps=null;

		try {

			String sql="insert into book "+
					"(bookName,bookAuthor,bookPrice)"+
					"values(?,?,?)";
			ps=con.prepareStatement(sql);

			ps.setString(1, book.getBookName());
			ps.setString(2,book.getBookAuthor());
			ps.setDouble(3, book.getBookPrice());


			ps.execute();

			flag=true;


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

		return flag;
	}

	public boolean delBook(int bookId){

		PreparedStatement ps=null;
		boolean flag=false;

		try {
			String sql=""+
					" delete from book"+
					" where bookId = ? ";//空格的问题
			ps=con.prepareStatement(sql);

			ps.setInt(1, bookId);

			ps.execute();
			flag=true;

		} catch (SQLException e) {

			flag=false;
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

		return flag;
	}
	
	
	public void getBookByPrice(){
		
		
	}

	/**
	 * 已编号为条件更新图书，默认编号不能更改
	 * @param book
	 * @return
	 */
	public boolean updateBook(Book book){

		PreparedStatement ps=null;
		boolean flag=false;

		try {


			String sql=""+
					" update book"+
					" set bookName=?,bookAuthor=?,bookPrice= ?"+
					" where booKId= ? ";

			ps=con.prepareStatement(sql);

			ps.setString(1, book.getBookName());
			ps.setString(2,book.getBookAuthor());
			ps.setDouble(3, book.getBookPrice());
			ps.setInt(4,book.getBookId());

			ps.execute();
			flag=true;

		} catch (SQLException e) {
			flag=false;
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

		return flag;
	}

	public List<Book> query(List<Map<String,Object>> prams){

		List<Book> bookList=new ArrayList<>();

		ResultSet rs=null;
		PreparedStatement ps=null;

		try {


			StringBuilder sql = new StringBuilder(" select * from book where 1=1 ");

			if(prams!=null&&prams.size()>0){

				for(int i=0;i<prams.size();i++)
				{	Map<String,Object> pram=prams.get(i);

				sql.append("and "+pram.get("name")+" "+pram.get("rea")+" "+pram.get("value")+"");
				}
			}
			ps=con.prepareStatement(sql.toString());
			rs= ps.executeQuery();

			while(rs.next()){

				Book abook=new Book();

				abook.setBookId(rs.getInt(1));
				abook.setBookName(rs.getString(2));
				abook.setBookAuthor(rs.getString(3));
				abook.setBookPrice(rs.getDouble(4));
				bookList.add(abook);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally{

			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return bookList;
	}


	public List<Book> getByKey(String key){
		

		ResultSet rs=null;
		PreparedStatement ps=null;
		List<Book> bookList=new Vector<>();

		String s = null;
		String []arr=PacSearchKey.packey(key);
		//String qPattern=" select bookId from book where 1=1 or bookName like ? or bookAuthor like ? or ?";
		
	
		
		String foot=" ) ";
		for(int i=0;i<arr.length;i++){
			
			
		}

		try {
			
			
			
			//这里可以使用正则表达式检查数字！！！！
		
			StringBuilder sql = new StringBuilder(" select bookId,bookName,bookAuthor,bookPrice from book where 1=1");
			//？？使用正则进行模糊
			//组装sql语句
			for(int i=0;i<arr.length;i++){
				String id=" and bookId in(select bookId from book where ";
				String tj="bookName like '%"+arr[i]+"%' or bookAuthor like '%"+arr[i]+"%' ";
				sql.append(id);
				sql.append(tj);
				if(arr[i].matches("^\\d+$")){
				sql.append(" or bookPrice ="+Double.parseDouble(arr[i])+"");
				}
				if(arr.length-1==i){
					
					for(int j=0;j<=i;j++){
					sql.append(foot);
					
					}
				}
				
			}
			s=sql.toString();
			ps=con.prepareStatement(sql.toString());

			rs=ps.executeQuery();

			while(rs.next()){

				Book abook=new Book();

				abook.setBookId(rs.getInt(1));
				abook.setBookName(rs.getString(2));
				abook.setBookAuthor(rs.getString(3));
				abook.setBookPrice(rs.getDouble(4));
				bookList.add(abook);

			}

			System.out.println(s);
		} catch (SQLException e) {
			System.out.println(s);

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

		}
		
		return bookList;

	}
	  
	/**
	 * 得到总的记录条数
	 */
	public int getTotalRecord(){
		
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		int num=-1;
		try {


			String sql="select count(bookId) from book ";

			ps=con.prepareStatement(sql);


			rs=ps.executeQuery();
			//非常重要的 迭代器相关
			rs.next();
			num=rs.getInt(1);
			

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
		}

		return num;
	}


	/**
	 * 
	 */
	public int location(int bookId){
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		int num=-1;
		try {


			String sql=" select count(bookId) from book where bookId <="+bookId+" ";

			ps=con.prepareStatement(sql);


			rs=ps.executeQuery();
			rs.next();
			num=rs.getInt(1);
			

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
		}

		return num;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	/*	MysqlDatabaseConnection db=new MysqlDatabaseConnection();
		BookDao da=new BookDao(db.getConnection());
		
		添加测试
		 * 
		Book book=new Book();		
		book.setBookName("test1");
		book.setBookAuthor("lst");
		book.setBookPrice(65);
		da.addBook(book);
		book.setBookId(2);
		
		List<Book> bookList=da.pageQuery(0);
		for(int i=0;i<bookList.size();i++){
			System.out.println(bookList.get(i).getBookName());
		}
		db.close();*/
		
		//测试了正则表达式
		/*String key="10";
		
		if(key.matches("\\d+$")){
			System.out.println(key);
		}*/

		MysqlDatabaseConnection db=new MysqlDatabaseConnection();
		BookDao da=new BookDao(db.getConnection());
		
		//测试模糊多条件搜索
		/*List<Book>bookList=da.getByKey("65");
		for(int i=0;i<bookList.size();i++){
			System.out.println(bookList.get(i).getBookName());
		}*/
		
		System.out.println(da.location(7));
		db.close();
	}

}
