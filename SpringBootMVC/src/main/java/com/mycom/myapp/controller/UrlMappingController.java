package com.mycom.myapp.controller; 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//다양한 url mapping 을 다뤄본다.
@Controller
public class UrlMappingController {

	// get,post 등 request의 method 별 처리
	@RequestMapping("/m1")	// get,post,... 가능
	public void m1() {
		System.out.println("/m1");
	}
	
	@RequestMapping(value="/m2", method=RequestMethod.GET)	// get => @GetMapping
	public void m2() {
		System.out.println("/m2");
	}
	
	@RequestMapping(value="/m3", method=RequestMethod.POST)	// post => @PostMapping
	public void m3() {
		System.out.println("/m3");
	}
	
	@GetMapping(value="/m4")	//  get
	public void m4() {
		System.out.println("/m4");
	}
	
	@PostMapping(value="/m5")	//  post
	public void m5() {
		System.out.println("/m5");
	}
	
	// path variable
	// client 가 요청시 보내는 데이터는 기본적으로 parameter 사용
	// 대신 요청 url 의 일부에 포함시켜서 보낼 수도 있다. (REST API)
	
	// ../books?bookId=7 <= parameter
	// ../books/7 <= path variable
	@GetMapping(value="/books/{bookId}")
	public void m6(@PathVariable String bookId) {	// int<-->String
		System.out.println("/m6 " + bookId);
	}
	
	// 목록 페이징 limit, offset
	// /list/10/and/20
	@GetMapping(value="/list/{limit}/and/{offset}")
	public void m7(@PathVariable int limit, @PathVariable int offset) {
		System.out.println("/m7 " + limit + " and " + offset);
	}
	
	// 목록 페이징 limit, offset
	// /list/10/20
	@GetMapping(value="/list/{limit}/{offset}")
	public void m8(@PathVariable int limit, @PathVariable int offset) {
		System.out.println("/m8 " + limit + " and " + offset);
	}
	
	// 복수의 url mapping
	@PostMapping(value= {"/url1", "/url2"})	//  post
	public void m9() {
		System.out.println("/url1, /url2");
	}
	
	
	// sub domain
	// /sub1 X
	// /sub1/ OK
	// /sub1/abc OK
	@PostMapping(value="/sub1/*")	//  post
	public void m10() {
		System.out.println("/sub1");
	}
		
	// sub domain
	@PostMapping(value="/sub2/**")	//  post
	public void m11() {
		System.out.println("/sub2");
	}
	
	
	
	
	
	
	
	
}
