package christmas.model.promotion;

import static christmas.model.order.Date.THIS_YEAR;

import christmas.model.order.Date;
import christmas.model.order.Orders;
import christmas.model.order.UserOrder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountPolicyTest {


    @Test
    @DisplayName("디데이_할인")
    void dDayCalculate() {
        Date visitDate = new Date("25");
        Orders orders = new Orders("타파스-1");
        UserOrder userOrder = new UserOrder(visitDate, orders);

        Assertions.assertThat(DiscountPolicy.dDayDiscountPolicy(userOrder))
                .isEqualTo(3400);
    }

    @Test
    @DisplayName("평일_할인")
    void weekdayCalculate() {
        Date visitDate = new Date("25");
        Orders orders = new Orders("초코케이크-1,아이스크림-2");
        UserOrder userOrder = new UserOrder(visitDate, orders);

        Assertions.assertThat(DiscountPolicy.weekdayDiscountPolicy(userOrder))
                .isEqualTo(THIS_YEAR * 3);
    }

    @Test
    @DisplayName("주말_할인")
    void weekendCalculate() {
        Date visitDate = new Date("23");
        Orders orders = new Orders("티본스테이크-2");
        UserOrder userOrder = new UserOrder(visitDate, orders);

        Assertions.assertThat(DiscountPolicy.weekendDiscountPolicy(userOrder))
                .isEqualTo(THIS_YEAR * 2);
    }

    @Test
    @DisplayName("특별_할인")
    void specialCalculate() {
        Date visitDate = new Date("25");
        Orders orders = new Orders("티본스테이크-2");
        UserOrder userOrder = new UserOrder(visitDate, orders);

        Assertions.assertThat(DiscountPolicy.specialDiscountPolicy(userOrder))
                .isEqualTo(1000);
    }

}