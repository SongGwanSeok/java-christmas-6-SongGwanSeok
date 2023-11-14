package christmas.model.promotion;

import static christmas.util.Utils.changeKrCurrentFormat;

import christmas.model.order.UserOrder;
import java.util.function.Function;

public enum Discount {
    DDAY_DISCOUNT("크리스마스 디데이 할인", DiscountPolicy::dDayDiscountPolicy),
    WEEKDAY_DISCOUNT("평일 할인", DiscountPolicy::weekdayDiscountPolicy),
    WEEKEND_DISCOUNT("주말 할인", DiscountPolicy::weekendDiscountPolicy),
    SPECIAL_DISCOUNT("특별 할인", DiscountPolicy::specialDiscountPolicy);

    private final String name;
    private final Function<UserOrder, Integer> calculate;

    Discount(String name, Function<UserOrder, Integer> calculate) {
        this.name = name;
        this.calculate = calculate;
    }

    public String makeString(UserOrder userOrder) {
        return name + ": " + changeKrCurrentFormat(calculate(userOrder)) + "\n";
    }

    public int calculate(UserOrder data) {
        return calculate.apply(data);
    }

}
