package com.mycom.myapp.controller;

import org.springframework.stereotype.Controller;

import com.mycom.myapp.service.BookService;

// Controller 는 항상 front 와 back 연결
// url mapping 은 front 와 약속
@Controller
public class BookController {
	// 셍성자 주입
	private final BookService bookService;
	
	public BookController(BookService bookService) {	
		this.bookService = bookService;
	}
	
	// 목록: /books/list 		,get, x,		list.jsp
	
	// 상세: /books/detail 	,get, bookId,	detailForm.jsp		
	
	// 등록: /books/insert 	,post, BookDto,	insertResurt.jsp
	
	// 수정: /books/update 	,post, BookDto, updateResult.jsp
	
	// 삭제: /books/delete 	,get,  bookId,	deleteResult.jsp
	
	// insertForm.jsp 에 대한 요청도 BookController 를 통해서 이동
	// 등록 화면 : /books/insertForm, get, X, insertForm.jsp

}
