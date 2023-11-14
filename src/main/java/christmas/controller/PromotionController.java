package christmas.controller;

import static christmas.model.order.Menu.CHAMPAGNE;

import christmas.model.order.Date;
import christmas.model.order.Orders;
import christmas.model.order.UserOrder;
import christmas.model.promotion.Discount;
import christmas.model.promotion.Present;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PromotionController {

    private UserOrder userOrder;
    private Present present;
    private List<Discount> discounts;

    public PromotionController(Date visitDate, Orders orders) {
        userOrder = new UserOrder(visitDate, orders);
        setPresent();
        setDiscounts();
    }

    private void setPresent() {
        Orders orders = userOrder.orders();
        if (orders.calculateTotalCost() >= 120000) {
            present = new Present(CHAMPAGNE, 1);
        }

    }

    private void setDiscounts() {
        Orders orders = userOrder.orders();
        if (orders.calculateTotalCost() < 10000) {
            this.discounts = new ArrayList<>();
            return;
        }
        discounts = Arrays.stream(Discount.values())
                .filter(discount -> discount.calculate(userOrder) != 0)
                .toList();
    }

}
