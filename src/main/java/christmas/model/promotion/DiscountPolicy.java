package christmas.model.promotion;

import christmas.model.order.MenuType;
import christmas.model.order.UserOrder;

public class DiscountPolicy {

    public static final int ZERO_DISCOUNT = 0;
    public static final int THIS_YEAR = 2023;
    public static final int FIRST_DAY = 1;
    public static final int FIRST_DAY_DISCOUNT = 1000;
    public static final int STAR_DISCOUNT = 1000;
    public static final int PER_DAY_DISCOUNT = 100;
    public static final int DISCOUNT_STANDARD = 10000;

    public static int dDayDiscountPolicy(UserOrder userOrder) {
        int discount = ZERO_DISCOUNT;
        if (userOrder.checkBeforeChristmas()) {
            discount = FIRST_DAY_DISCOUNT + (userOrder.getDay() - FIRST_DAY) * PER_DAY_DISCOUNT;
        }
        return discount;
    }

    public static int weekdayDiscountPolicy(UserOrder userOrder) {
        int discount = ZERO_DISCOUNT;
        if (userOrder.isVisitWeekday()) {
            discount = userOrder.findMenuTypeCount(MenuType.DESSERT) * THIS_YEAR;
        }
        return discount;
    }

    public static int weekendDiscountPolicy(UserOrder userOrder) {
        int discount = ZERO_DISCOUNT;
        if (userOrder.isVisitWeekend()) {
            discount = userOrder.findMenuTypeCount(MenuType.MAIN) * THIS_YEAR;
        }
        return discount;
    }

    public static int specialDiscountPolicy(UserOrder userOrder) {
        int discount = ZERO_DISCOUNT;
        if (userOrder.isVisitStar()) {
            discount = STAR_DISCOUNT;
        }
        return discount;
    }
}
