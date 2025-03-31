package com.mycom.myapp.calc.hasa;

import org.springframework.stereotype.Component;

// Calculator 객체 필요
// CalcMain 의 Spring Context 를 통해서 HasaCalculator 객체를 생성 ( DI )
@Component
public class HasaCalculator {
	// Spring DI 를 사용하지 않는 경우
	Calculator calculator = new Calculator();
	
	public int add (int n1, int n2) {
		System.out.println("HasaCalculator add()");
		return calculator.add(n1, n2);
	}

}
