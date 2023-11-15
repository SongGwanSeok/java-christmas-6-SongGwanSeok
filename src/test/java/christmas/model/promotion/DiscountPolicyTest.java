package christmas.model.promotion;

import static christmas.model.promotion.DiscountPolicy.THIS_YEAR;
import static org.mockito.Mockito.mock;

import christmas.model.order.MenuType;
import christmas.model.order.UserOrder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@DisplayName("할인_정책")
@RunWith(MockitoJUnitRunner.class)
class DiscountPolicyTest {

    UserOrder userOrder;

    @BeforeEach
    void before() {
        userOrder = mock(UserOrder.class);
    }

    @Test
    @DisplayName("디데이_할인")
    void dDayCalculate() {
        int christmasDay = 25;
        int expectDiscount = 3400;
        Mockito.when(userOrder.checkBeforeChristmas()).thenReturn(true);
        Mockito.when(userOrder.getDay()).thenReturn(christmasDay);

        Assertions.assertThat(DiscountPolicy.dDayDiscountPolicy(userOrder))
                .isEqualTo(expectDiscount);
    }

    @Test
    @DisplayName("평일_할인")
    void weekdayCalculate() {
        int dessertCount = 3;
        Mockito.when(userOrder.isVisitWeekday()).thenReturn(true);
        Mockito.when(userOrder.findMenuTypeCount(MenuType.DESSERT)).thenReturn(dessertCount);

        Assertions.assertThat(DiscountPolicy.weekdayDiscountPolicy(userOrder))
                .isEqualTo(THIS_YEAR * dessertCount);
    }

    @Test
    @DisplayName("주말_할인")
    void weekendCalculate() {
        int mainCount = 2;
        Mockito.when(userOrder.isVisitWeekend()).thenReturn(true);
        Mockito.when(userOrder.findMenuTypeCount(MenuType.MAIN)).thenReturn(mainCount);

        Assertions.assertThat(DiscountPolicy.weekendDiscountPolicy(userOrder))
                .isEqualTo(THIS_YEAR * mainCount);
    }

    @Test
    @DisplayName("특별_할인")
    void specialCalculate() {
        int expectDiscount = 1000;
        Mockito.when(userOrder.isVisitStar()).thenReturn(true);

        Assertions.assertThat(DiscountPolicy.specialDiscountPolicy(userOrder))
                .isEqualTo(expectDiscount);
    }

}