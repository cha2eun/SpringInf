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
// 의존관계 주입
public class AppConfig {
    // 중복제거하고 한곳만 바꿀 수 있도록 리팩터링
    // 추후 구현체가 바뀌어도 AppConfig의 여기만 바꾸면 됨
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        // 할인정책 변경적용
        return new RateDiscountPolicy();
    }

    // 생성자 주입
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }
}
