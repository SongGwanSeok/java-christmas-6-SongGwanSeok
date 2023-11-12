package christmas.model;

import static christmas.model.MenuType.DRINK;
import static christmas.model.MenuType.isEqualType;
import static christmas.model.Order.WRONG_ORDER_ERROR;
import static christmas.util.Utils.splitByDelimiter;

import java.util.List;

public class Orders {

    public static final String COMMA = ",";

    private final List<Order> orders;

    public Orders(String ordersInput) {
        List<Order> orders = makeOrders(ordersInput);
        validate(orders);
        this.orders = List.copyOf(orders);
    }

    private static List<Order> makeOrders(String ordersInput) {
        List<String> strings = splitByDelimiter(ordersInput, COMMA);
        return strings.stream()
                .map(Order::new)
                .toList();
    }

    private void validate(List<Order> orders) {
        isDuplicate(orders);
        isSumBelowLimit(orders);
        isOnlyDrink(orders);
    }

    private void isDuplicate(List<Order> orders) {
        List<String> distinctMenuNames = getDistinctMenuNames(orders);

        if (orders.size() != distinctMenuNames.size()) {
            throw new IllegalArgumentException(WRONG_ORDER_ERROR);
        }
    }

    private void isSumBelowLimit(List<Order> orders) {
        if (getTotalQuantity(orders) > 20) {
            throw new IllegalArgumentException(WRONG_ORDER_ERROR);
        }
    }

    private void isOnlyDrink(List<Order> orders) {
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
