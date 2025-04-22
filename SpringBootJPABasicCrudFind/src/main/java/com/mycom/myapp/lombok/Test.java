package com.mycom.myapp.lombok;

public class Test {
	
	public static void main(String[] args) {
		// Builder 패턴 적용
		EmpDto2 empDto2 = EmpDto2.builder()
							.employeeId(1)
							.firstName("길동")
							.lastName("홍")
							.email("hon@gildong.com")
							.hireDate("2025-04-22")
							.departmentId("123")
							.build();
		
		System.out.println(empDto2);
		
	}
	
}

// Emp <-Entity, EmpDto 등 Emp 와 별개로 만들어야 하는가???
// Entity 와 별개의 Entity 를 표현하는 Dto 를 만드는게 일반적