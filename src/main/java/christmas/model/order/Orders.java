package christmas.model.order;

import static christmas.model.order.MenuType.isEqualType;
import static christmas.util.StringUtils.splitByDelimiter;

import christmas.validation.OrdersValidation;
import java.util.List;

public class Orders {

    public static final String COMMA = ",";
    public static final int MAX_TOTAL_QUANTITY = 20;

    private final List<Order> orders;

    public Orders(String ordersInput) throws IllegalArgumentException {
        List<Order> orders = makeOrders(ordersInput);
        OrdersValidation.validate(orders);
        this.orders = List.copyOf(orders);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        orders.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    public int calculateTotalCost() {
        return orders.stream()
                .map(Order::calculateOrderPrice)
                .reduce(0, Integer::sum);
    }

    public int findMenuTypeCount(MenuType targetType) {
        return orders.stream().filter(order -> isEqualType(order.getMenuType(), targetType))
                .map(Order::getQuantity)
                .reduce(0, Integer::sum);
    }

    private List<Order> makeOrders(String ordersInput) {
        List<String> strings = splitByDelimiter(ordersInput, COMMA);
        return strings.stream()
                .map(Order::new)
                .toList();
    }
}
