package com.lst.library.vo;

import java.sql.Date;

public class Book {
	
	private int bookId;
	private String bookName;
	private String bookAuthor;
	private double bookPrice;
	private Object bookContext;
	private Date bookAddDate;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public Object getBookContext() {
		return bookContext;
	}
	public void setBookContext(Object bookContext) {
		this.bookContext = bookContext;
	}
	public Date getBookAddDate() {
		return bookAddDate;
	}
	public void setBookAddDate(Date bookAddDate) {
		this.bookAddDate = bookAddDate;
	}
	

}
