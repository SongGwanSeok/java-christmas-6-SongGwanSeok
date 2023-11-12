package christmas.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("방문_날짜")
class DateTest {

    @Test
    @DisplayName("생성_성공")
    public void createTestSuccess() {
        String input = "1";
        Assertions.assertThatCode(() -> new Date(input))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("생성_실패_문자")
    public void createTestFail1() {
        String input = "문자";
        Assertions.assertThatThrownBy(() -> new Date(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Date.WRONG_DATE_ERROR);
    }

    @Test
    @DisplayName("생성_실패_범위")
    public void createTestFail2() {
        String input = "0";
        Assertions.assertThatThrownBy(() -> new Date(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Date.WRONG_DATE_ERROR);
    }
}