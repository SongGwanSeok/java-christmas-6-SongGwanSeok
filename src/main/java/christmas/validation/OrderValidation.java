package christmas.validation;

import static christmas.model.order.Order.MENU_AND_QUANTITY_SIZE;
import static christmas.model.order.Order.MENU_INDEX;
import static christmas.model.order.Order.QUANTITY_INDEX;
import static christmas.model.order.Order.QUANTITY_RULE;
import static christmas.model.order.Order.WRONG_ORDER_ERROR;

import christmas.model.order.Menu;
import java.util.List;

public class OrderValidation {

    public static void validate(List<String> splitInput) throws IllegalArgumentException {
        isRightForm(splitInput);
        isInMenu(splitInput.get(MENU_INDEX));
        isInRange(splitInput.get(QUANTITY_INDEX));
    }

    private static void isRightForm(List<String> splitInput) {
        if (splitInput.size() != MENU_AND_QUANTITY_SIZE) {
            throw new IllegalArgumentException(WRONG_ORDER_ERROR);
        }
    }

    private static void isInMenu(String menu) {
        if (!Menu.isMenu(menu)) {
            throw new IllegalArgumentException(WRONG_ORDER_ERROR);
        }
    }

    private static void isInRange(String quantity) {
        if (!quantity.matches(QUANTITY_RULE)) {
            throw new IllegalArgumentException(WRONG_ORDER_ERROR);
        }
    }
}
