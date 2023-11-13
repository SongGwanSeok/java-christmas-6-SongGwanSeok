package christmas.model.order;

import christmas.util.Utils;
import java.util.List;

public class Order {

    public static final String HYPHEN = "-";
    public static final String WRONG_ORDER_ERROR = "[Error] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    private final Menu menu;
    private final int quantity;

    public Order(String input) {
        List<String> splitInput = Utils.splitByDelimiter(input, HYPHEN);
        validate(splitInput);
        String menuName = splitInput.get(0);
        String quantity = splitInput.get(1);

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
        isInMenu(splitInput.get(0));
        isInRange(splitInput.get(1));
    }

    private void isRightForm(List<String> splitInput) {
        if (splitInput.size() != 2) {
            throw new IllegalArgumentException(WRONG_ORDER_ERROR);
        }
    }

    private void isInMenu(String menu) {
        if (!Menu.isMenu(menu)) {
            throw new IllegalArgumentException(WRONG_ORDER_ERROR);
        }
    }

    private void isInRange(String quantity) {
        if (!quantity.matches("^[1-9]\\d{0,8}$")) {
            throw new IllegalArgumentException(WRONG_ORDER_ERROR);
        }
    }
}
