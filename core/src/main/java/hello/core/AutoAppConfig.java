package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(                          // @Component가 붙은 메소드들을 찾아서 자동으로 스프링 빈 등록
        basePackages = "hello.core.member",      // scan 범위 지정,
        basePackageClasses = AutoAppConfig.class,
        //AppConfig제외하기 위한 세팅
       excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
