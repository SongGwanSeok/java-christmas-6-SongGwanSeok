package christmas.model.promotion;

import christmas.model.order.Orders;
import christmas.model.order.UserOrder;

public class Promotion {

    private final Present present;
    private Benefit benefit;
    private Badge badge;

    public Promotion(Present present, UserOrder userOrder) {
        this.present = present;
        this.benefit = new Benefit(present, userOrder);
        setBadge();
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

    private void setBadge() {
        badge = Badge.getBadge(benefit.calculateCost());
    }

}
