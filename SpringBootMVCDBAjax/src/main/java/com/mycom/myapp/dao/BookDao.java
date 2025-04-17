package com.mycom.myapp.dao;

import java.util.List;

import com.mycom.myapp.dto.BookDto;

//book crud
public interface BookDao {
	
	List<BookDto> listBook();
	
	BookDto detailBook(int bookid);
	
	int insertBook(BookDto book);
	
	int updateBook(BookDto book);
	
	int deleteBook(int bookId);
	
	
}
