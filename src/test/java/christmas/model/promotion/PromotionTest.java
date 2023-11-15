package christmas.model.promotion;

import christmas.model.order.Orders;
import christmas.model.order.UserOrder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@DisplayName("프로모션")
class PromotionTest {

    private final int discountCost = 3023;
    private final int totalCost = 142000;
    private final String orders = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";

    private UserOrder userOrder;
    private Promotion promotion;

    @BeforeEach
    void before() {

        userOrder = Mockito.mock(UserOrder.class);
        Present present = Mockito.mock(Present.class);
        Benefit benefit = Mockito.mock(Benefit.class);
        promotion = new Promotion(present, benefit);

        Mockito.when(benefit.calculateCostWithoutPresent()).thenReturn(discountCost);
        Mockito.when(userOrder.orders()).thenReturn(new Orders(orders));
    }

    @Test
    @DisplayName("할인_적용_후_결제_금액_계산_테스트")
    void calculateAfterDiscountCost() {
        int expectCost = totalCost - discountCost;
        Assertions.assertThat(promotion.calculateAfterDiscountCost(userOrder))
                .isEqualTo(expectCost);
    }
}