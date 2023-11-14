package christmas.model.promotion;

import christmas.model.order.UserOrder;
import java.util.List;

public class Discounts {

    private final List<Discount> discounts;

    public Discounts(List<Discount> discounts) {
        this.discounts = List.copyOf(discounts);
    }

    public Boolean isEmpty() {
        return discounts.isEmpty();
    }

    public String makeBenefitDetails(UserOrder data) {
        StringBuilder stringBuilder = new StringBuilder();
        discounts.forEach(discount -> stringBuilder.append(discount.makeString(data)));
        return stringBuilder.toString();
    }

    public int calculateTotalDiscountCost(UserOrder userOrder) {
        return discounts.stream()
                .map(discount -> discount.calculate(userOrder))
                .reduce(0, Integer::sum);
    }
}
