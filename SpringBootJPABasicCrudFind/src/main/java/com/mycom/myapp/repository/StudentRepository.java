package com.mycom.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycom.myapp.entity.Student;

// repository 역할을 담당하는 구현 코드를 Spring Data Jpa 가 대신 생성, 수행
// extends JpaRepository 코드에 의해 대응되는 엔티티에 대한 기본 crud 및 기타 몇 가지 메소드가 자동 생성
public interface StudentRepository extends JpaRepository<Student, Integer>{
	
}
