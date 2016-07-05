package com.lst.library.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import com.lst.dbc.MysqlDatabaseConnection;
import com.lst.library.vo.Book;
public class BookDaoProxy {



	private BookDao bookDao=null;
	private MysqlDatabaseConnection db=null;
	private Connection con=null;
	
	public BookDaoProxy(){
		
		db=new MysqlDatabaseConnection();
		con=db.getConnection();
		
	}

	public List<Book> query(){
		
		List<Book> bookList=null;
		bookDao=new BookDao(con);
		bookList=bookDao.query();
		db.close();
		return bookList;

	}
	
	public boolean deleteSome(int []idArr){
		
		boolean flag=false;
		
		try {
			con.setAutoCommit(false);
			
			for(int i=0;i<idArr.length;i++){
				bookDao=new BookDao(con);
				flag=bookDao.delBook(idArr[i]);
			}
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			db.close();
			
		}
		
		return flag;
		
	}

 	public List<Book> pageQuery(int begain){
		

		List<Book> bookList=null;
		bookDao=new BookDao(con);
		bookList=bookDao.pageQuery(begain);
		db.close();
		return bookList;
		
	}
 	
 	
 	public boolean add(Book book){
 		boolean flag=false;
 		
 		try {
 			
 			bookDao=new BookDao(con);
 			flag=bookDao.addBook(book);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			db.close();
		}
 		
		return flag;
 		
 	}


 	public boolean update(Book book){
 		boolean flag=false;
 		try {
 			bookDao=new BookDao(con);
 			
 			flag=bookDao.updateBook(book);
 			
		} catch (Exception e) {
			
			
		}finally{
			db.close();
		}
 		
		return flag;
 		
 	}
 	
 	public List<Book> getByKey(String key){
 		
 		List<Book> bookList=new Vector<>();
 		try {
 			
 			BookDao da=new BookDao(con);
 			bookList=da.getByKey(key);
 				
			
		} catch (Exception e) {
			
		}finally{
			db.close();
		}
 		
		return bookList;
 		
 	}
 	
 	public int getTotalRecord(){
		
 		
 		int num=-1;
		bookDao=new BookDao(con);
		num=bookDao.getTotalRecord();
		db.close();
		return num;
		
	}
 	/**
 	 * 获取当前记录的位置
 	 */
 	public int location(int bookId){

 		int num = -1;
 		try {
 			
 			BookDao da=new BookDao(con);
 			num=da.location(bookId);
 				
			
		} catch (Exception e) {
			
		}finally{
			db.close();
		}
 		
		return num;
 		
 	}
 
 	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
