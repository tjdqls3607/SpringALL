package com.mycom.myapp.calc.all;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Calculator 객체 필요
// CalcMain 의 Spring Context 를 통해서 HasaCalculator 객체를 생성 ( DI )
@Component
public class HasaCalculator {
	
	//Spring DI #3 constriuctor injection (spring 추천방식)
	Calculator calculator;	// interface 를 implements 한 객체가 DI
	
	public HasaCalculator (@Qualifier("aaa") Calculator calculator) {
		super();
		this.calculator = calculator;
	}
	
	
	public int add (int n1, int n2) {
		System.out.println("HasaCalculator add()");
		return calculator.add(n1, n2);
	}
}
