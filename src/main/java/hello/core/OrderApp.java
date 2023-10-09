package hello.core;

import hello.core.Order.Order;
import hello.core.Order.OrderService;
import hello.core.Order.OrderServiceImpl;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

/*        MemberService memberService = new MemberServiceImpl(null);
        OrderService orderService = new OrderServiceImpl(null,null);*/

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        Long membereId = 1L;
        Member member = new Member(membereId, "memberA", Grade.VIP);
        memberService.join(member);

//        Order order = orderService.createOrder(membereId, "itemA", 10000);

//        System.out.println("order = " + order);//order가 바로 toString으로 출력된다.
//        System.out.println("order.calculatePrice = " + order.calculatePrice());

    }
}
