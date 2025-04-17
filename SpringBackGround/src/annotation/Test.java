package annotation;
import java.lang.annotation.Annotation;

import aboutaboutabout.Aboutjsb;
// Spring 입장 MyClass 가 사용한 annotation (미리 약속된) 을 파악 
public class Test {
    public static void main(String[] args) throws Exception{
        
        // AboutMe
//      Class<?> myClass = Class.forName("annotation.MyClass");
//      
//      Annotation[] annotations = myClass.getAnnotations();
//      // AboutMe annotation 의 속성값을 확인/처리
//      for (Annotation annotation : annotations) {
//          if( annotation instanceof AboutMe ) {
//              AboutMe aboutMe = (AboutMe) annotation;
//              // AboutMe annotation 대응 코드
//              System.out.println(aboutMe.love());
//              System.out.println(aboutMe.hate());
//          }
//      }
      
      
      // Aboutjsb
      Class<?> jsbClass = Class.forName("annotation.jsbClass");
      
      Annotation[] annotations = jsbClass.getAnnotations();
      for (Annotation annotation : annotations) {
    	  if (annotation instanceof Aboutjsb) {
    		  Aboutjsb aboutjsb = (Aboutjsb) annotation;
    		  System.out.println(aboutjsb.love());
    		  System.out.println(aboutjsb.hate());
    	  }
      }
        // Encrypt
//        User user = new User("홍길동", "1234");
//        System.out.println(user);
//        
//        // @Encrpyt 를 사용한 필드가 있으면 필드값을 암호화 변경
//        Field[] fileds = user.getClass().getDeclaredFields();
//        
//        for (Field field : fileds) {
//            if( field.isAnnotationPresent(Encrypt.class) ) {
//                field.setAccessible(true); // private 도 가능
//                field.set(user, field.get(user) + "5678");
//            }
//        }
//        
//        System.out.println(user);
    }
    
}
// 워크샆 : 조원이 annotation.MyClass 처럼 특정 annotation 을 사용하고, 속성값을 서로 다르게 준다
//         컴파일된 MyClass.class 을 교환