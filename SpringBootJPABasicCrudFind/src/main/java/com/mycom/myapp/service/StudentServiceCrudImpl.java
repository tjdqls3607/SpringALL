package com.mycom.myapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mycom.myapp.entity.Student;
import com.mycom.myapp.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceCrudImpl implements StudentServiceCrud{

	private final StudentRepository studentRepository;
	
	@Override
	public List<Student> listStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Optional<Student> detailStudent(int id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id);
	}

	@Override
	public Student insertStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
		// 추가적인 영속화된 student2 로 Business logic 처리 가능
		
	}

	@Override
	public Optional<Student> updateStudent(Student student) {
		// Student 타입으로 return 할 경우, Spring Data Jpa 에게 알아서 해.
		// id 가 없으면 ?? insert 된다.
		// id 가 있으면 ?? update 된다.
//		return studentRepository.save(student);
		
		// Optional<Student> 타입으로 return 할 경우, 직접 id 를 검사 후 진행 방식
		Optional<Student> exstingStudent = studentRepository.findById(student.getId());
		if (exstingStudent.isPresent()) {
			return Optional.of(studentRepository.save(student));
		}
		return Optional.empty();
	}

	@Override
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);		
	}
	

}
