package com.mycom.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.myapp.dto.BookDto;

//book crud
@Mapper
public interface BookDao {
	
	List<BookDto> listBook();
	
	BookDto detailBook(int bookid);
	
	int insertBook(BookDto book);
	
	int updateBook(BookDto book);
	
	int deleteBook(int bookId);
	
	
}
