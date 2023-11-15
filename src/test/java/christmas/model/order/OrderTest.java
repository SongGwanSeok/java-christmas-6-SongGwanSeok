package christmas.model.order;

import static christmas.model.order.Menu.T_BORN_STEAK;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("주문")
class OrderTest {

    @Test
    @DisplayName("생성_성공")
    void creatOrderSuccess() {
        String input = "티본스테이크-1";

        Assertions.assertThatCode(() -> new Order(input))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("주문_금액_계산")
    void calculateOrderPrice() {
        String input = "티본스테이크-2";
        Order order = new Order(input);

        Assertions.assertThat(order.calculateOrderPrice())
                .isEqualTo(T_BORN_STEAK.calculatePriceByQuantity(2));

    }


}