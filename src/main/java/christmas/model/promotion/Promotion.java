package christmas.model.promotion;

import christmas.model.order.Orders;
import christmas.model.order.UserOrder;

public class Promotion {

    private final Present present;
    private final Discounts discounts;
    private Badge badge;

    public Promotion(Present present, Discounts discounts) {
        this.present = present;
        this.discounts = discounts;
    }

    public Present present() {
        return present;
    }

    public String makeBenefitDetails(UserOrder userOrder) {
        if (discounts.isEmpty() && present == null) {
            return Present.NON_GIFT;
        }
        String benefitDetails = discounts.makeBenefitDetails(userOrder);
        if (present != null) {
            benefitDetails += present.makeEventPriceToString();
        }

        return benefitDetails;
    }

    public int calculateBenefitCost(UserOrder userOrder) {
        int sumDiscount = discounts.calculateTotalDiscountCost(userOrder);

        if (present != null) {
            sumDiscount += present.calculatePrice();
        }
        setBadge(sumDiscount);
        return sumDiscount;
    }

    public int calculateAfterDiscountCost(UserOrder userOrder) {
        Orders orders = userOrder.orders();
        return orders.calculateTotalCost() - discounts.calculateTotalDiscountCost(userOrder);
    }

    public Badge getBadge() {
        return badge;
    }

    private void setBadge(int sumDiscount) {
        badge = Badge.getBadge(sumDiscount);
    }

}
