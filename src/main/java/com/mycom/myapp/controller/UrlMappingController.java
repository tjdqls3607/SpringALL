package com.mycom.myapp.controller; 

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//다양한 url mapping 을 다뤄본다.
@Controller
public class UrlMappingController {

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
}
