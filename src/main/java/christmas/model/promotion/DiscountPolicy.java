package christmas.model.promotion;

import static christmas.model.order.Date.THIS_YEAR;

import christmas.model.order.MenuType;
import christmas.model.order.UserOrder;

public class DiscountPolicy {

    private static int discount = 0;

    public static int dDayDiscountPolicy(UserOrder userOrder) {
        if (userOrder.checkBeforeChristmas()) {
            discount = 1000 + (userOrder.getDay() - 1) * 100;
        }
        return discount;
    }

    public static int weekdayDiscountPolicy(UserOrder userOrder) {
        if (userOrder.isVisitWeekday()) {
            discount = userOrder.findMenuTypeCount(MenuType.DESSERT) * THIS_YEAR;
        }
        return discount;
    }

    public static int weekendDiscountPolicy(UserOrder userOrder) {
        if (userOrder.isVisitWeekend()) {
            discount = userOrder.findMenuTypeCount(MenuType.MAIN) * THIS_YEAR;
        }
        return discount;
    }

    public static int specialDiscountPolicy(UserOrder userOrder) {
        if (userOrder.isVisitStar()) {
            discount = 1000;
        }
        return discount;
    }
}
