package christmas.controller;

import christmas.model.order.Date;
import christmas.model.order.Orders;
import christmas.model.order.UserOrder;
import christmas.model.promotion.Discount;
import christmas.model.promotion.Present;
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

    }

    private void setDiscounts() {

    }

}
