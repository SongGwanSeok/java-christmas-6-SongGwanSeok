package christmas.controller;

import static christmas.model.order.Menu.CHAMPAGNE;

import christmas.model.order.Date;
import christmas.model.order.Orders;
import christmas.model.order.UserOrder;
import christmas.model.promotion.Discount;
import christmas.model.promotion.Discounts;
import christmas.model.promotion.Present;
import christmas.model.promotion.Promotion;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PromotionController {

    private UserOrder userOrder;
    private Promotion promotion;

    public PromotionController(Date visitDate, Orders orders) {
        userOrder = new UserOrder(visitDate, orders);
        setPromotion();
    }

    public void printPromotion() {

    }

    private void setPromotion() {
        this.promotion = new Promotion(getPresent(), getDiscounts());
    }

    private Present getPresent() {
        Present present = null;
        Orders orders = userOrder.orders();
        if (orders.calculateTotalCost() >= 120000) {
            present = new Present(CHAMPAGNE, 1);
        }
        return present;
    }

    private Discounts getDiscounts() {
        Orders orders = userOrder.orders();
        if (orders.calculateTotalCost() < 10000) {
            return new Discounts(Collections.emptyList());
        }
        return new Discounts(calculateDiscounts());
    }

    private List<Discount> calculateDiscounts() {
        return Arrays.stream(Discount.values())
                .filter(discount -> discount.calculate(userOrder) != 0)
                .toList();
    }

}
