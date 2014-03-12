package com.example.bookexchange;

public class BookForSale extends Book {
	
	public String SaleId;
	public int Price;
	public String Seller;

	public BookForSale(String bookname, String isbn, String saleid, int price) {
		super(bookname, isbn);
		// TODO Auto-generated constructor stub
		SaleId = saleid;
		Price = price;
	}
	
	public void setSaleId(String saleid){
		SaleId = saleid;
	}
	
	public String getSaleId(){
		return SaleId;
	}
	
	public void setPrice(int price){
		Price = price;
	}
	
	public int getPrice(){
		return Price;
	}
	
	

}
