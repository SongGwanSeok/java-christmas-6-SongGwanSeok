package christmas.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("메뉴판")
class MenuTest {

    @Test
    @DisplayName("메뉴판에_메뉴가_있는_경우")
    void isMenuTrue() {
        String menuName = "아이스크림";
        Assertions.assertThat(Menu.isMenu(menuName))
                .isEqualTo(true);
    }

    @Test
    @DisplayName("메뉴판에_메뉴가_없는_경우")
    void isMenuFalse() {
        String menuName = "탕후루";
        Assertions.assertThat(Menu.isMenu(menuName))
                .isEqualTo(false);
    }

    @Test
    @DisplayName("메뉴판에서_메뉴_찾기_성공")
    void findMenuByNameSuccess() {
        String menuName = "아이스크림";
        Assertions.assertThat(Menu.findMenuByName(menuName))
                .isEqualTo(Menu.ICE_CREAM);
    }

    @Test
    @DisplayName("메뉴판에서_메뉴_찾기_실패")
    void findMenuByNameFail() {
        String menuName = "탕후루";
        Assertions.assertThatThrownBy(() -> Menu.findMenuByName(menuName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Order.WRONG_ORDER_ERROR);
    }
}