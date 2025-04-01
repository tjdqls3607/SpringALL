package com.mycom.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

// client -> server 로 전송하는 parameter 처리
// servlet, jsp <= request.getParameter("name")
// Spring 은 넘어오는 파라미터를 최대한 대응하는 메소드의 파라미터에 자동화 시동
@Controller
public class ParamController {
	
	@GetMapping("/param1")
	public void m1(HttpServletRequest request) {
		System.out.println(request.getParameter("bookId"));
		System.out.println(request.getParameter("bookName"));
	}
	
	@GetMapping("/param2")
	public void m2(String bookId) {	// String bookId
		System.out.println(bookId);
	}
	
	@GetMapping("/param3")
	public void m3(int bookId, String bookName) {	// int bookId
		System.out.println(bookId);
		System.out.println(bookName);
	}
	
	// 500오류 : Optional int parameter 'book' is present but cannot be translated into a null value due to being declared as a primitive type.
	// 1. 이름으로 매칭되지 않으면 null 로 처리
	// 2. 메소드의 파라미터 타입이 원시 타입이면 int <-- null 을 넣지 못한다 위 오류가 발생
	@GetMapping("/param4")
	public void m4(int book) {	// IlligalStateException
		System.out.println(book);
	}
	
	@GetMapping("/param5")
	public void m5(Integer book) {	//null
		System.out.println(book);
	}

	@GetMapping("/param6")
	public void m6(Integer bookId) {	//123
		System.out.println(bookId);
	}
	
	@GetMapping("/param7")
	public void m7(String bookname) {	//null
		System.out.println(bookname);
	}
	
	// @RequestParam
	// required 속성 (true 가 default)
	@GetMapping("/param8")
	public void m8(@RequestParam String seq) {	//123, warn ( bad request 400 )
		System.out.println(seq);
	}
	
	@GetMapping("/param9")
	public void m9(@RequestParam(required = false) String seq) {	//123, null
		System.out.println(seq);
	}
	
	@GetMapping("/param10")
	public void m10(@RequestParam(name = "seq2") String seq) {	//123, null
		System.out.println(seq);
	}

}
