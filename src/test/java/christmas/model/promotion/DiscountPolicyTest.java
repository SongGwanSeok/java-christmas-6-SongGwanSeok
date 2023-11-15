package christmas.model.promotion;

import static christmas.model.promotion.DiscountPolicy.THIS_YEAR;

import christmas.model.order.Date;
import christmas.model.order.Orders;
import christmas.model.order.UserOrder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountPolicyTest {

    UserOrder constructUserOrder(String dateInput, String ordersInput) {
        Date visitDate = new Date(dateInput);
        Orders orders = new Orders(ordersInput);
        return new UserOrder(visitDate, orders);
    }

    @Test
    @DisplayName("디데이_할인")
    void dDayCalculate() {
        UserOrder userOrder = constructUserOrder("25", "타파스-1");

        Assertions.assertThat(DiscountPolicy.dDayDiscountPolicy(userOrder))
                .isEqualTo(3400);
    }

    @Test
    @DisplayName("평일_할인")
    void weekdayCalculate() {
        UserOrder userOrder = constructUserOrder("25", "초코케이크-1,아이스크림-2");

        Assertions.assertThat(DiscountPolicy.weekdayDiscountPolicy(userOrder))
                .isEqualTo(THIS_YEAR * 3);
    }

    @Test
    @DisplayName("주말_할인")
    void weekendCalculate() {
        UserOrder userOrder = constructUserOrder("23", "티본스테이크-2");

        Assertions.assertThat(DiscountPolicy.weekendDiscountPolicy(userOrder))
                .isEqualTo(THIS_YEAR * 2);
    }

    @Test
    @DisplayName("특별_할인")
    void specialCalculate() {
        UserOrder userOrder = constructUserOrder("25", "티본스테이크-2");

        Assertions.assertThat(DiscountPolicy.specialDiscountPolicy(userOrder))
                .isEqualTo(1000);
    }

}