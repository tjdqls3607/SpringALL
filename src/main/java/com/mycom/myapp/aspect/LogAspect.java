package com.mycom.myapp.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

// Logging 을 담당하는 Aspect
@Component	// 객체가 필요한 시점에 Spring 이 DI
@Aspect	//aspectj 라이브러리에 의해 AOP 로 동작 (<aop:aspectj-autoproxy></aop:aspectj-autoproxy> )
public class LogAspect {
	
	// logging 을 위한 객체 필요 
	// trace > debug > info > warn > error 메소드들은 얼마나 더 자세한 혹은 얼마나 더 중요한 로그를 남기느냐 따라 선택
	// Spring Boot 의 현재 설정에 따라 로그 출력 결정 default 설정은 info
	// application.properties 에서 설정 가능
	private final Logger logger = LoggerFactory.getLogger(this.getClass());	//logback 구현체 (springboot default 구현체)
	
	// PointCut (Join Point (모든 메소드) 중 어떤 메소드에 끼어 들 것인가 표현)
	@Pointcut(value="execution(* com.mycom.myapp.aspect.*.*(..))")	// 리턴 패키지 클래스이름 파라미터
	private void logPointcut() {}	// 이름이logPointcut() 인 Pointcut 1개 생성
	
	// Advice 와 JoinPoint 에 의해 실제 로그 구현
	@Before("logPointcut()")
	public void brforeLog(JoinPoint joinpoint) {	//JoinPoint 실제 호출되는 메소드
//		System.out.println("[sysout : before]");
		logger.info("[Logger : before]");
		logger.info(joinpoint.getSignature().getName());
	}
	
	@After("logPointcut()")
	public void afterLog(JoinPoint joinpoint) {	//JoinPoint 실제 호출되는 메소드
//		System.out.println("[sysout : after]");
		logger.debug("[Logger : after]");
	}
}
