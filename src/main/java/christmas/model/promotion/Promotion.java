package christmas.model.promotion;

import christmas.model.order.Orders;
import christmas.model.order.UserOrder;

public class Promotion {

    private final Present present;
    private final Benefit benefit;
    private final Badge badge;

    public Promotion(Present present, UserOrder userOrder) {
        this.present = present;
        this.benefit = new Benefit(present, userOrder);
        this.badge = Badge.getBadge(benefit.calculateCost());
    }

    public Present present() {
        return present;
    }

    public String getBenefitDetails() {
        if (benefit.isEmpty()) {
            return Benefit.NON_BENEFIT;
        }
        return benefit.toString();
    }

    public int calculateBenefitCost() {
        return benefit.calculateCost();
    }

    public int calculateAfterDiscountCost(UserOrder userOrder) {
        Orders orders = userOrder.orders();
        return orders.calculateTotalCost() - benefit.calculateCostWithoutPresent();
    }

    public Badge getBadge() {
        return badge;
    }

}
