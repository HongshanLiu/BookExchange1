package com.example.bookexchange;

public class Book {
	
	public String bookName;
	public String ISBN;
	
	public Book(String bookname,String isbn) {
		bookName = bookname;
		ISBN = isbn;
	}
	
	public void setName(String bookname){
		bookName = bookname;
	}
	
	public void setISBN(String isbn){
		ISBN = isbn;
	}
	
	public String getName(){
		return bookName;
	}
	
	public String getISBN(){
		return ISBN;
	}

}
