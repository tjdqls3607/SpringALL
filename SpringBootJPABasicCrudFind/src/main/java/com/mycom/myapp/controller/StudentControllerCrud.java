package com.mycom.myapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myapp.entity.Student;
import com.mycom.myapp.service.StudentServiceCrud;

import lombok.RequiredArgsConstructor;

// return type 이 Student (Entity) 인데, StudentDto 를 사용하는 게 바람직 하다. 단순화하기 위한 코드
@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentControllerCrud {
	
	private final StudentServiceCrud studentServiceCrud; 
	
	@GetMapping("/list")	//목록
	 public List<Student> listStudent() {
		return studentServiceCrud.listStudent();
	}
	
	@GetMapping("/detail/{id}")	//상세
	 public Optional<Student> detailStudent(@PathVariable("id") Integer id) {
		return studentServiceCrud.detailStudent(id);
	}
	
	@PostMapping("/insert")
	public Student insertStudent(Student student) {
		return studentServiceCrud.insertStudent(student);
	}
	
	@PostMapping("/update")
	public Optional<Student> updateStudent(Student student) {
		return studentServiceCrud.updateStudent(student);
	}
	
	@GetMapping("/delete/{id}")	//삭제
	 public void deleteStudent(@PathVariable("id") Integer id) {
		studentServiceCrud.deleteStudent(id);
	}
	
	@GetMapping("/count")
	public long countStudent() {
		return studentServiceCrud.countStudent();
	}
	
	@GetMapping("/page")
	public List<Student> listStudent(
			@RequestParam("pageNumber") Integer pageNumber,
			@RequestParam("pageSize") Integer pageSize){
		
		return studentServiceCrud.listStudent(pageNumber, pageSize);
	}
}
