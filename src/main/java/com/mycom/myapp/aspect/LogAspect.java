package com.mycom.myapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// Logging 을 담당하는 Aspect
@Component	// 객체가 필요한 시점에 Spring 이 DI
@Aspect	//aspectj 라이브러리에 의해 AOP 로 동작 (<aop:aspectj-autoproxy></aop:aspectj-autoproxy> )
public class LogAspect {
	
	// logging 을 위한 객체 필요 
}
