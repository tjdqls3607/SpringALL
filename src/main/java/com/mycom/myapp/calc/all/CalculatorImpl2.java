package com.mycom.myapp.calc.all;

import org.springframework.stereotype.Component;

@Component("bbb")
public class CalculatorImpl2 implements Calculator {
	
    @Override
    public int add(int n1, int n2) {
    	
        System.out.println("CalculatorImpl2 add()");
        return n1 + n2;
    }
}