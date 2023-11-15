package christmas.validate;

import static christmas.model.order.MenuType.DRINK;
import static christmas.model.order.MenuType.isEqualType;
import static christmas.model.order.Order.WRONG_ORDER_ERROR;
import static christmas.model.order.Orders.MAX_TOTAL_QUANTITY;

import christmas.model.order.Order;
import java.util.List;

public class OrdersValidation {

    public static void validate(List<Order> orders) throws IllegalArgumentException {
        isDuplicate(orders);
        isSumBelowLimit(orders);
        isOnlyDrink(orders);
    }

    private static void isDuplicate(List<Order> orders) {
        List<String> distinctMenuNames = getDistinctMenuNames(orders);

        if (orders.size() != distinctMenuNames.size()) {
            throw new IllegalArgumentException(WRONG_ORDER_ERROR);
        }
    }

    private static void isSumBelowLimit(List<Order> orders) {
        if (getTotalQuantity(orders) > MAX_TOTAL_QUANTITY) {
            throw new IllegalArgumentException(WRONG_ORDER_ERROR);
        }
    }

    private static void isOnlyDrink(List<Order> orders) {
        if (checkAllDrink(orders)) {
            throw new IllegalArgumentException(WRONG_ORDER_ERROR);
        }
    }

    private static List<String> getDistinctMenuNames(List<Order> orders) {

        return orders.stream()
                .map(Order::getMenuName)
                .distinct()
                .toList();
    }

    private static Integer getTotalQuantity(List<Order> orders) {
        return orders.stream()
                .map(Order::getQuantity)
                .reduce(0, Integer::sum);
    }

    private static boolean checkAllDrink(List<Order> orders) {
        return orders.stream()
                .allMatch(order -> isEqualType(order.getMenuType(), DRINK));
    }
}
