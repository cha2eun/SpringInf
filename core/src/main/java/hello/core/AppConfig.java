package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 팩토리 메서드 방식 ! ! ! !
// 의존관계 주입
@Configuration
public class AppConfig {
    // Bean 어노테이션 등록하면 메소드명이 key, return값이 value로 bean등록됨
    // 중복제거하고 한곳만 바꿀 수 있도록 리팩터링
    // 추후 구현체가 바뀌어도 AppConfig의 여기만 바꾸면 됨
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        // 할인정책 변경적용
        return new RateDiscountPolicy();
    }

    // 생성자 주입
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
