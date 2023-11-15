package christmas.model.promotion;

import static org.mockito.Mockito.mock;

import christmas.model.order.Date;
import christmas.model.order.Orders;
import christmas.model.order.UserOrder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

@DisplayName("혜택 내역")
class BenefitTest {

    private Present present;
    private UserOrder userOrder;
    private Benefit benefit;

    @BeforeEach
    void before() {
        String visitDate = "26";
        String orders = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        int presentPrice = 25000;
        present = mock(Present.class);
        userOrder = new UserOrder(new Date(visitDate), new Orders(orders));
        Mockito.when(present.calculatePrice()).thenReturn(presentPrice);

        benefit = new Benefit(present, userOrder);
    }

    @Test
    @DisplayName("전체_혜택_가격_계산")
    void calculateCost() {
        int PresentCost = 25000;
        int weekdayDiscountCost = 4046;
        Assertions.assertThat(benefit.calculateCost())
                .isEqualTo(PresentCost + weekdayDiscountCost);
    }

    @Test
    @DisplayName("증정품을_제외한_혜택_가격_계산")
    void calculateCostWithoutPresent() {
        int weekdayDiscountCost = 4046;
        Assertions.assertThat(benefit.calculateCostWithoutPresent())
                .isEqualTo(weekdayDiscountCost);
    }
}