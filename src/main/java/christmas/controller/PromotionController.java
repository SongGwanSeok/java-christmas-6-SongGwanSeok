package christmas.controller;

import static christmas.model.order.Menu.CHAMPAGNE;
import static christmas.model.promotion.DiscountPolicy.DISCOUNT_STANDARD;
import static christmas.model.promotion.DiscountPolicy.ZERO_DISCOUNT;
import static christmas.model.promotion.Present.PRESENT_STANDARD;
import static christmas.view.OutputView.printAfterDiscountCost;
import static christmas.view.OutputView.printBadge;
import static christmas.view.OutputView.printBenefitCost;
import static christmas.view.OutputView.printBenefitDetails;
import static christmas.view.OutputView.printPresent;

import christmas.model.order.Date;
import christmas.model.order.Orders;
import christmas.model.order.UserOrder;
import christmas.model.promotion.Badge;
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
        printPresent(promotion.present());
        printBenefitDetails(promotion.makeBenefitDetails(userOrder));
        printBenefitCost(promotion.calculateBenefitCost(userOrder));
        printAfterDiscountCost(promotion.calculateAfterDiscountCost(userOrder));
        printBadge(Badge.getBadge(promotion.calculateBenefitCost(userOrder)));
    }

    private void setPromotion() {
        this.promotion = new Promotion(getPresent(), getDiscounts());
    }

    private Present getPresent() {
        Present present = null;
        Orders orders = userOrder.orders();
        if (orders.calculateTotalCost() >= PRESENT_STANDARD) {
            present = new Present(CHAMPAGNE, 1);
        }
        return present;
    }

    private Discounts getDiscounts() {
        Orders orders = userOrder.orders();
        if (orders.calculateTotalCost() < DISCOUNT_STANDARD) {
            return new Discounts(Collections.emptyList());
        }
        return new Discounts(calculateDiscounts());
    }

    private List<Discount> calculateDiscounts() {
        return Arrays.stream(Discount.values())
                .filter(discount -> discount.calculate(userOrder) != ZERO_DISCOUNT)
                .toList();
    }

}
