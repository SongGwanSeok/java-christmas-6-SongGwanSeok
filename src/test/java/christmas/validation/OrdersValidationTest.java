package christmas.validation;

import static christmas.model.order.Orders.COMMA;
import static christmas.util.StringUtils.splitByDelimiter;

import christmas.model.order.Order;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("주문_목록_생성_예외")
class OrdersValidationTest {

    @ParameterizedTest
    @DisplayName("생성_실패_중복_메뉴")
    @ValueSource(strings = {"타파스-1,아이스트림-2,타파스-2", "타파스-1,시저샐러드-3,바비큐립-2,시저샐러드-1"})
    void creatOrdersFailDuplicated(String input) {
        List<String> strings = splitByDelimiter(input, COMMA);
        List<Order> orders = strings.stream()
                .map(Order::new)
                .toList();
        Assertions.assertThatThrownBy(() -> OrdersValidation.validate(orders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Order.WRONG_ORDER_ERROR);
    }

    @ParameterizedTest
    @DisplayName("생성_실패_형식_오류")
    @ValueSource(strings = {"티본스테이크,1,아이스크림,2", "티본스테이크-1-아이스크림-2"})
    void creatOrdersFailWrongFormat(String input) {
        List<String> strings = splitByDelimiter(input, COMMA);
        List<Order> orders = strings.stream()
                .map(Order::new)
                .toList();
        Assertions.assertThatThrownBy(() -> OrdersValidation.validate(orders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Order.WRONG_ORDER_ERROR);
    }

    @ParameterizedTest
    @DisplayName("생성_실패_20개_초과_메뉴_주문")
    @ValueSource(strings = {"타파스-10,아이스트림-20", "타파스-10,시저샐러드-10,바비큐립-1"})
    void creatOrdersFailOverQuantity(String input) {
        List<String> strings = splitByDelimiter(input, COMMA);
        List<Order> orders = strings.stream()
                .map(Order::new)
                .toList();
        Assertions.assertThatThrownBy(() -> OrdersValidation.validate(orders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Order.WRONG_ORDER_ERROR);
    }

    @ParameterizedTest
    @DisplayName("생성_실패_음료만_주문")
    @ValueSource(strings = {"제코콜라-10", "제로콜라-1,레드와인-3"})
    void creatOrdersFailOnlyDrink(String input) {
        List<String> strings = splitByDelimiter(input, COMMA);
        List<Order> orders = strings.stream()
                .map(Order::new)
                .toList();
        Assertions.assertThatThrownBy(() -> OrdersValidation.validate(orders))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Order.WRONG_ORDER_ERROR);
    }
}