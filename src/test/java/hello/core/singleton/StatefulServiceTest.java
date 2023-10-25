package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : a사용자 10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //ThreadB : b사용자 20000원 주문
        int userBPrice = statefulService2.order("userB", 20000);

        //ThreadA : a사용자 주문 금액 조회
//        int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice);
        //사용자 a가 주문하고 b사용자가 주문했다 그리고 a 사용자의 주문 금액을 확인하는데 2만원이 나온다
        //왜? ac.getBean(StatefulService.class); 들어가 보면 인스턴스는 둘다 같은 애를 사용한다.

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}