package christmas.model.promotion;

import static christmas.util.StringUtils.changeKrCurrentFormat;
import static christmas.util.StringUtils.makeNegative;

import christmas.model.order.Orders;
import christmas.model.order.UserOrder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class Benefit {

    public static final String PRESENT_EVENT = "증정 이벤트";
    public static final String NON_BENEFIT = "없음\n";

    private final Map<String, Integer> details;

    public Benefit(Present present, UserOrder userOrder) {
        this.details = new HashMap<>();
        putDiscount(userOrder);
        putPresent(present);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        details.forEach((name, price) ->
                stringBuilder.append(name).append(": ")
                        .append(makeNegative(changeKrCurrentFormat(price)))
                        .append("\n")
        );
        return stringBuilder.toString();
    }

    public Boolean isEmpty() {
        return details.isEmpty();
    }

    public int calculateCost() {
        return details.values().stream()
                .reduce(0, Integer::sum);
    }

    public int calculateCostWithoutPresent() {
        return details.entrySet().stream()
                .filter(entry -> !Objects.equals(entry.getKey(), PRESENT_EVENT))
                .map(Entry::getValue)
                .reduce(0, Integer::sum);
    }

    private void putPresent(Present present) {
        if (present != null) {
            details.put(PRESENT_EVENT, present.calculatePrice());
        }
    }

    private void putDiscount(UserOrder userOrder) {
        Orders orders = userOrder.orders();
        if (orders.calculateTotalCost() < DiscountPolicy.DISCOUNT_STANDARD) {
            return;
        }
        for (Discount discount : Discount.values()) {
            int discountCost = discount.calculate(userOrder);
            if (discountCost == DiscountPolicy.ZERO_DISCOUNT) {
                continue;
            }
            details.put(discount.getName(), discountCost);
        }
    }

}
