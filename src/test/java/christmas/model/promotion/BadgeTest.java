package christmas.model.promotion;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("뱃지")
class BadgeTest {

    @ParameterizedTest
    @DisplayName("혜택_금액에_따른_뱃지_생성_테스트")
    @ValueSource(ints = {0, 3000, 5000, 7000, 10000, 15000, 20000, 25000})
    void findBadgeByTotalDiscount(int totalDiscount) {
        Badge expectBadge = Badge.NON;
        if (totalDiscount >= 5000) {
            expectBadge = Badge.STAR;
        }
        if (totalDiscount >= 10000) {
            expectBadge = Badge.TREE;
        }
        if (totalDiscount >= 20000) {
            expectBadge = Badge.SANTA;
        }
        Assertions.assertThat(Badge.findBadgeByTotalDiscount(totalDiscount))
                .isEqualTo(expectBadge);
    }

}