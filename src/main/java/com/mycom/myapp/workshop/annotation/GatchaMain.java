package com.mycom.myapp.workshop.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class GatchaMain {

    public static void main(String[] args) {
        // 스프링 컨텍스트 초기화
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GachaMachine.class);
        
        // GatchMachine 빈 가져오기
        GachaMachine gatchMachine = context.getBean(GachaMachine.class);
        System.out.println("오늘의 포켓몬은 뭘까요?");

        // 2초 동안 " . " 출력
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(".");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // 랜덤 결과 출력
        System.out.println("결과: " + gatchMachine.draw());

        // 컨텍스트 종료
        context.close();
    }
}
