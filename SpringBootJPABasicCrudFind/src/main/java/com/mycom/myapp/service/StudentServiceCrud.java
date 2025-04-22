package com.mycom.myapp.service;

import java.util.List;
import java.util.Optional;

import com.mycom.myapp.entity.Student;

public interface StudentServiceCrud {
	List<Student> listStudent();
	Optional<Student> detailStudent(int id);
	
	Student insertStudent(Student student);	// jpa를 통해서 table 에 insert 하고 영속화 시킨 객체를 return
	Optional<Student> updateStudent(Student student);
	void deleteStudent(int id);	//delete 는 return 이 void
}
