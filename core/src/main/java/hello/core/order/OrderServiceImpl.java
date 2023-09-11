package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    // 인터페이스에만 의존하도록 변경
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository   = memberRepository;
        this.discountPolicy     = discountPolicy;
    }
    // 근데 AppConfig에서 하는거랑, 여기서 하는거랑 뭐가 다르지??
    // 서비스코드들은 연결에 신경쓰지 않고, 구현체 교체가 필요할 경우는 config파일이 담당함
    // AppConfig는 구체클래스를 선택한다. 애플리케이션이 어떻게 동작해야할 지 전체 구성을 책임진다.

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member       = memberRepository.findById(memberId);
        int discountPrice   = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //test용
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}

