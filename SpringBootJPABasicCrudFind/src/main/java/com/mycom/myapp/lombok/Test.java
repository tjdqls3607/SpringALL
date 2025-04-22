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
