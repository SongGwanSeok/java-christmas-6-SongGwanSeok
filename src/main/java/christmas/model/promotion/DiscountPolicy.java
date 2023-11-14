package christmas.model.promotion;

import static christmas.model.order.Date.THIS_YEAR;

import christmas.model.order.MenuType;
import christmas.model.order.UserOrder;

public class DiscountPolicy {

    public static int dDayDiscountPolicy(UserOrder userOrder) {
        int discount = 0;
        if (userOrder.checkBeforeChristmas()) {
            discount = 1000 + (userOrder.getDay() - 1) * 100;
        }
        return discount;
    }

    public static int weekdayDiscountPolicy(UserOrder userOrder) {
        int discount = 0;
        if (userOrder.isVisitWeekday()) {
            discount = userOrder.findMenuTypeCount(MenuType.DESSERT) * THIS_YEAR;
        }
        return discount;
    }

    public static int weekendDiscountPolicy(UserOrder userOrder) {
        int discount = 0;
        if (userOrder.isVisitWeekend()) {
            discount = userOrder.findMenuTypeCount(MenuType.MAIN) * THIS_YEAR;
        }
        return discount;
    }

    public static int specialDiscountPolicy(UserOrder userOrder) {
        int discount = 0;
        if (userOrder.isVisitStar()) {
            discount = 1000;
        }
        return discount;
    }
}
