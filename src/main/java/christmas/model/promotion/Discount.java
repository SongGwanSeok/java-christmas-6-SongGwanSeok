package christmas.model.promotion;

import static christmas.model.order.Date.THIS_YEAR;
import static christmas.util.Utils.changeKrCurrentFormat;

import christmas.model.order.MenuType;
import christmas.model.order.UserOrder;
import java.util.function.Function;

public enum Discount {
    DDAY_DISCOUNT("크리스마스 디데이 할인", Discount::dDayDiscountPolicy),
    WEEKDAY_DISCOUNT("평일 할인", Discount::weekdayDiscountPolicy),
    WEEKEND_DISCOUNT("주말 할인", Discount::weekendDiscountPolicy),
    SPECIAL_DISCOUNT("특별 할인", Discount::specialDiscountPolicy);

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

    private static int dDayDiscountPolicy(UserOrder userOrder) {
        int discount = 0;
        if (userOrder.checkBeforeChristmas()) {
            discount = 1000 + (userOrder.getDay() - 1) * 100;
        }
        return discount;
    }

    private static int weekdayDiscountPolicy(UserOrder userOrder) {
        int discount = 0;
        if (userOrder.isVisitWeekday()) {
            discount = userOrder.findMenuTypeCount(MenuType.DESSERT) * THIS_YEAR;
        }
        return discount;
    }

    private static int weekendDiscountPolicy(UserOrder userOrder) {
        int discount = 0;
        if (userOrder.isVisitWeekend()) {
            discount = userOrder.findMenuTypeCount(MenuType.MAIN) * THIS_YEAR;
        }
        return discount;
    }

    private static int specialDiscountPolicy(UserOrder userOrder) {
        int discount = 0;
        if (userOrder.isVisitStar()) {
            discount = 1000;
        }
        return discount;
    }

}
