package christmas.model;

import christmas.util.Utils;
import java.util.List;

public class Order {

    public static final String HYPHEN = "-";
    public static final String WRONG_ORDER_ERROR = "[Error] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    private final Menu menu;
    private final int quantity;

    public Order(String input) {
        List<String> splitInput = Utils.splitByDelimiter(input, HYPHEN);
        String menuName = splitInput.get(0);
        String quantity = splitInput.get(1);
        validate(menuName, quantity);

        this.menu = Menu.findMenuByName(menuName);
        this.quantity = Integer.parseInt(quantity);
    }

    public String getMenuName() {
        return menu.name();
    }

    public int getQuantity() {
        return quantity;
    }

    public MenuType getMenuType() {
        return getMenuType();
    }

    private void validate(String menu, String quantity) {
        isInMenu(menu);
        isInRange(quantity);
    }

    private void isInMenu(String menu) {
        if (!Menu.isMenu(menu)) {
            throw new IllegalArgumentException(WRONG_ORDER_ERROR);
        }
    }

    private void isInRange(String quantity) {
        if (!quantity.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException(WRONG_ORDER_ERROR);
        }
    }
}
