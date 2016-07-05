package com.lst.util;


import com.lst.library.dao.DaoFactory;
import com.lst.library.vo.Book;

public class AddbookUtil {
	
	public static void add(int number){
		
		
		for(int i=0;i<number; i++ ){
			
			Book book=new Book();
			book.setBookName(GetRanDawta.getRanName(5));
			book.setBookAuthor(GetRanDawta.getRanName(4));
			book.setBookPrice(GetRanDawta.getDecimal(2, 1));
			
			DaoFactory.getBookDaoProxy().add(book);
		}
		
	}
	
	public static void main(String[] args) {
	
		
		add(50);
		
		
		
		

	}

}
