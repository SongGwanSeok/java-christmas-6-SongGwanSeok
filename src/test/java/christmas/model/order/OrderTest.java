package christmas.model.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("주문")
class OrderTest {

    @Test
    @DisplayName("생성_성공")
    void creatOrderSuccess() {
        String input = "티본스테이크-1";
        Assertions.assertThatCode(() -> new Order(input))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("생성_실패_잘못된_형식")
    @ValueSource(strings = {"티본스테이크,1", "티본스테이크 1개"})
    void creatOrderFailWrongFormat(String input) {
        Assertions.assertThatThrownBy(() -> new Order(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Order.WRONG_ORDER_ERROR);
    }

    @ParameterizedTest
    @DisplayName("생성_실패_메뉴판에_없는_메뉴_주문")
    @ValueSource(strings = {"탕후루-1", "치킨-10"})
    void creatOrderFailIsNotMenu(String input) {
        Assertions.assertThatThrownBy(() -> new Order(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Order.WRONG_ORDER_ERROR);
    }

    @ParameterizedTest
    @DisplayName("생성_실패_갯수_범위_오류")
    @ValueSource(strings = {"티본스테이크-0", "티본스테이크-3000000000"})
    void creatOrderFailWrongQuantity(String input) {
        Assertions.assertThatThrownBy(() -> new Order(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Order.WRONG_ORDER_ERROR);
    }
}