package com.mycom.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.myapp.dto.BookDto;




@Controller
public class BookController {
	
	@GetMapping("/Bookmanager")
	public String bookManager(Model model) {
	    BookDto book = new BookDto("코딩이 재미땅!!!", 300000000, "유플러스");
	    model.addAttribute("bookDto", book);
	    return "Bookmanager";
	}

}
