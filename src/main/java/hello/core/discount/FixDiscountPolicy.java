package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("FixDiscountPolicy") // 생성사 주입시 @Qualifier로 1:1 매칭하여 주입 표시  // @Primary를 메인으로 @Qualifier을 서브로 사용
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; //100원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
