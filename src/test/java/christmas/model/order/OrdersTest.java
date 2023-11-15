package christmas.model.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("주문_내역")
class OrdersTest {

    @Test
    @DisplayName("생성_성공")
    void creatOrdersSuccess() {
        String input = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";
        Assertions.assertThatCode(() -> new Orders(input))
                .doesNotThrowAnyException();
    }


}