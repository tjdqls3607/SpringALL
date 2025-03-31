package com.mycom.myapp.calc.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class CalcMain {


	public static void main(String[] args) {
		
		// Spring DI를 통한 객체 생성
		// main() 에서 Spring Framework 의 환경
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CalcConfiguration.class); // 설정 java Configuration (annotation) 
		Calculator calculator = (Calculator)context.getBean("calculator");
		System.out.println(calculator.add(3,7));
		context.close();

	}

}
