package christmas.model.order;

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


}