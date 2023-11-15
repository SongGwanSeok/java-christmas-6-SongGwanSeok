package christmas.model.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("주문_내역")
class OrdersTest {

    private Orders orders;

    @BeforeEach
    void before() {
        String input = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        orders = new Orders(input);
    }

    @Test
    @DisplayName("총_주문_금액_계산")
    void calculateTotalCost() {
        int expectTotalCost = 142000;
        Assertions.assertThat(orders.calculateTotalCost())
                .isEqualTo(expectTotalCost);
    }

    @Test
    @DisplayName("주문에서_주어진_메뉴_타입과_동일한_타입을_가지는_주문_갯수_찾기")
    void findMenuTypeCount() {
        int appetizerCount = 0;
        int mainCount = 2;
        int dessertCount = 2;
        int drinkCount = 1;
        Assertions.assertThat(orders.findMenuTypeCount(MenuType.APPETIZER))
                .isEqualTo(appetizerCount);
        Assertions.assertThat(orders.findMenuTypeCount(MenuType.MAIN))
                .isEqualTo(mainCount);
        Assertions.assertThat(orders.findMenuTypeCount(MenuType.DESSERT))
                .isEqualTo(dessertCount);
        Assertions.assertThat(orders.findMenuTypeCount(MenuType.DRINK))
                .isEqualTo(drinkCount);

    }

}