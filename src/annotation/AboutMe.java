package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// interface 앞에 @ 붙혀서 annotation 만들수 있다
// 어디에 사용할 것인가? TYPE, METHOD... api 문서 확인
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface AboutMe {
	// 추상 메소드로 annotation 의 attribute 생성
	String love();
	String hate();
}


//@AboutMe