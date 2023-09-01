package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        //MemberService memberService = new MemberServiceImpl(memberRepository);
        MemberService memberService = appConfig.memberService();    // memberServiceImpl
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member="+member.getName());
        System.out.println("find member = "+findMember.getName());

    }
}
