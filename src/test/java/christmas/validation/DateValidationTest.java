package christmas.validation;

import christmas.model.order.Date;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("날짜_생성_예외")
class DateValidationTest {

    @Test
    @DisplayName("생성_성공")
    void createTestSuccess() {
        String input = "1";
        Assertions.assertThatCode(() -> DateValidation.validate(input))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("생성_실패_문자")
    void createTestFail1() {
        String input = "문자";
        Assertions.assertThatThrownBy(() -> DateValidation.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Date.WRONG_DATE_ERROR);
    }

    @ParameterizedTest
    @DisplayName("생성_실패_범위")
    @ValueSource(strings = {"0", "32"})
    void createTestFail2(String input) {
        Assertions.assertThatThrownBy(() -> DateValidation.validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Date.WRONG_DATE_ERROR);
    }

}