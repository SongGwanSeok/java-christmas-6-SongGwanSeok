package christmas.model.promotion;

import christmas.model.order.UserOrder;
import java.util.Arrays;

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
            return "없음";
        }
        String benefitDetails = discounts.makeBenefitDetails(userOrder);
        if (present != null) {
            benefitDetails += present.makeEventPriceToString();
        }

        return benefitDetails;
    }

    public int calculateBenefitCost(UserOrder userOrder) {
        int sumDiscount = calculateTotalDiscountCost(userOrder);

        if (present != null) {
            sumDiscount += present.calculatePrice();
        }

        return sumDiscount;
    }

    public static Integer calculateTotalDiscountCost(UserOrder userOrder) {
        return Arrays.stream(Discount.values())
                .map(discount -> discount.calculate(userOrder))
                .reduce(0, Integer::sum);
    }

}
