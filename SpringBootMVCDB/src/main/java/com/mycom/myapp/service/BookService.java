package com.mycom.myapp.service;

import java.util.List;

import com.mycom.myapp.dto.BookDto;

// service layer 는 실무에서는 가장 복잡한 코드가 존재 <- Business Logic
// 단순 crud 는 controller 와 repository layer 중간에서 단준 pass
public interface BookService {
	List<BookDto> listBook();
	
	BookDto detailBook(int bookid);
	
	int insertBook(BookDto book);
	
	int updateBook(BookDto book);
	
	int deleteBook(int bookId);
}
