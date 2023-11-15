package christmas.model.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("방문_날짜")
class DateTest {

    @ParameterizedTest
    @DisplayName("크리스마스_이전_이거나_당일_인지_확인")
    @ValueSource(strings = {"13", "25", "31"})
    void isBeforeOrChristmas(String day) {
        boolean expect = true;
        if (Integer.parseInt(day) > 25) {
            expect = false;
        }
        Date date = new Date(day);
        Assertions.assertThat(date.isBeforeOrChristmas())
                .isEqualTo(expect);

    }

    @ParameterizedTest
    @DisplayName("주말인지_확인")
    @ValueSource(strings = {"1", "2", "8", "9", "15", "16", "22", "23", "29", "30"})
    void isWeekend(String day) {
        Date visitDate = new Date(day);
        Assertions.assertThat(visitDate.isWeekend())
                .isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("달력에_별표시_날짜인지_확인")
    @ValueSource(strings = {"3", "10", "17", "24", "25", "31"})
    void isStar(String day) {
        Date visitDate = new Date(day);
        Assertions.assertThat(visitDate.isStar())
                .isEqualTo(true);
    }
}