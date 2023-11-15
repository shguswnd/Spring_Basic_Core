package hello.core;


import hello.core.Order.OrderService;
import hello.core.Order.OrderServiceImpl;
import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes =  Configuration.class)
)
public class AutoAppConfig {

    @Autowired MemberRepository memberRepository;
    @Autowired
    DiscountPolicy discountPolicy;


/*    @Bean
    OrderService orderService(){
        return new OrderServiceImpl(memberRepository, discountPolicy);
    }*/
/*    @Bean(name ="memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }*/


}
