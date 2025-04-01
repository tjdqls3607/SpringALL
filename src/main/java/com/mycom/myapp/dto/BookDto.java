package com.mycom.myapp.dto;

public class BookDto {

	private String bookname;
	private int price;
	private String publisher;
	
	
	public String getBookName() {
		return bookname;
	}
	public void setBookName(String bookname) {
		this.bookname = bookname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String owner) {
		this.publisher = publisher;
	}
	
	public BookDto() {}
	public BookDto(String name, int price, String publisher) {
		super();
		this.bookname = name;
		this.price = price;
		this. publisher = publisher;
	}

	@Override
	public String toString() {
		return "BookDto [name=" + bookname + ", price=" + price + ", owner=" + publisher + "]";
	}
}
