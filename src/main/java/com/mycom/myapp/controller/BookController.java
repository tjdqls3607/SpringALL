package com.mycom.myapp.controller;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.mycom.myapp.dto.BookDto;
import com.mycom.myapp.service.BookService;
// Controller 는 항상 front 와 back 연결
// url mapping 은 front 와 약속
@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    
    // 목록 : /books/list,   get,  X,       list.jsp
    @GetMapping(value="/list")
    public String listBook(Model model) {
        List<BookDto> bookList = bookService.listBook();
        model.addAttribute("bookList", bookList);
        return "list";
    }
    
    // 상세 : /books/detail, get,  bookId,  detailForm.jsp
    
    // 등록 : /books/insert, post, BookDto, insertResult.jsp
    @PostMapping(value="/insert")
    public String insertBook(BookDto bookDto) {
        System.out.println(bookDto);
        int ret = bookService.insertBook(bookDto);
        System.out.println(ret);
        return "insertResult";
    }
    
    // 수정 : /books/update, post, BookDto, updateResult.jsp
    
    // 삭제 : /books/delete, get,  bookId,  deleteResult.jsp
    
    // insertForm.jsp 에 대한 요청도 BookController 를 통해서 이동
    // 등록 화면 : /books/insertForm, get, X, insertForm.jsp
    @GetMapping(value="/insertForm")
    public String insertForm() {
        return "insertForm";
    }
}