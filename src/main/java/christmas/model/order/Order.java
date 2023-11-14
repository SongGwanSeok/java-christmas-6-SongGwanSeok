package christmas.model.order;

import christmas.util.Utils;
import java.util.List;

public class Order {

    public static final String HYPHEN = "-";
    public static final int MENU_INDEX = 0;
    public static final int QUANTITY_INDEX = 1;
    public static final int MENU_AND_QUANTITY_SIZE = 2;
    public static final String WRONG_ORDER_ERROR = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
    public static final String QUANTITY_RULE = "^[1-9]\\d{0,8}$";

    private final Menu menu;
    private final int quantity;

    public Order(String input) {
        List<String> splitInput = Utils.splitByDelimiter(input, HYPHEN);
        validate(splitInput);
        String menuName = splitInput.get(MENU_INDEX);
        String quantity = splitInput.get(QUANTITY_INDEX);

        this.menu = Menu.findMenuByName(menuName);
        this.quantity = Integer.parseInt(quantity);
    }

    @Override
    public String toString() {
        return getMenuName() + " " + quantity + "개\n";
    }

    public int calculateOrderPrice() {
        return menu.getPrice() * quantity;
    }

    public String getMenuName() {
        return menu.getName();
    }

    public int getQuantity() {
        return quantity;
    }

    public MenuType getMenuType() {
        return menu.getType();
    }

    private void validate(List<String> splitInput) {
        isRightForm(splitInput);
        isInMenu(splitInput.get(MENU_INDEX));
        isInRange(splitInput.get(QUANTITY_INDEX));
    }

    private void isRightForm(List<String> splitInput) {
        if (splitInput.size() != MENU_AND_QUANTITY_SIZE) {
            throw new IllegalArgumentException(WRONG_ORDER_ERROR);
        }
    }

    private void isInMenu(String menu) {
        if (!Menu.isMenu(menu)) {
            throw new IllegalArgumentException(WRONG_ORDER_ERROR);
        }
    }

    private void isInRange(String quantity) {
        if (!quantity.matches(QUANTITY_RULE)) {
            throw new IllegalArgumentException(WRONG_ORDER_ERROR);
        }
    }
}
