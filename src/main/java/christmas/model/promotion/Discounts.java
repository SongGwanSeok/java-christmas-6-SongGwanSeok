package christmas.model.promotion;

import java.util.List;

public class Discounts {

    private final List<Discount> discounts;

    public Discounts(List<Discount> discounts) {
        this.discounts = List.copyOf(discounts);
    }
}
