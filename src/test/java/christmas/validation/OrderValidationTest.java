package christmas.validation;

import static christmas.model.order.Order.HYPHEN;

import christmas.model.order.Order;
import christmas.util.StringUtils;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class OrderValidationTest {

    @ParameterizedTest
    @DisplayName("생성_실패_잘못된_형식")
    @ValueSource(strings = {"티본스테이크,1", "티본스테이크 1개"})
    void creatOrderFailWrongFormat(String input) {
        List<String> splitInput = StringUtils.splitByDelimiter(input, HYPHEN);

        Assertions.assertThatThrownBy(() -> OrderValidation.validate(splitInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Order.WRONG_ORDER_ERROR);
    }

    @ParameterizedTest
    @DisplayName("생성_실패_메뉴판에_없는_메뉴_주문")
    @ValueSource(strings = {"탕후루-1", "치킨-10"})
    void creatOrderFailIsNotMenu(String input) {
        List<String> splitInput = StringUtils.splitByDelimiter(input, HYPHEN);

        Assertions.assertThatThrownBy(() -> OrderValidation.validate(splitInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Order.WRONG_ORDER_ERROR);
    }

    @ParameterizedTest
    @DisplayName("생성_실패_갯수_범위_오류")
    @ValueSource(strings = {"티본스테이크-0", "티본스테이크-3000000000"})
    void creatOrderFailWrongQuantity(String input) {
        List<String> splitInput = StringUtils.splitByDelimiter(input, HYPHEN);

        Assertions.assertThatThrownBy(() -> OrderValidation.validate(splitInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Order.WRONG_ORDER_ERROR);
    }

}