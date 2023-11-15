package christmas.controller;

import static christmas.model.order.Menu.CHAMPAGNE;
import static christmas.model.promotion.Present.PRESENT_STANDARD;
import static christmas.view.PromotionOutputView.printAfterDiscountCost;
import static christmas.view.PromotionOutputView.printBadge;
import static christmas.view.PromotionOutputView.printBenefitCost;
import static christmas.view.PromotionOutputView.printBenefitDetails;
import static christmas.view.PromotionOutputView.printPresent;

import christmas.model.order.Date;
import christmas.model.order.Orders;
import christmas.model.order.UserOrder;
import christmas.model.promotion.Benefit;
import christmas.model.promotion.Present;
import christmas.model.promotion.Promotion;

public class PromotionController {

    private UserOrder userOrder;
    private Promotion promotion;

    public PromotionController(Date visitDate, Orders orders) {
        userOrder = new UserOrder(visitDate, orders);
        setPromotion();
    }

    public void printPromotion() {
        printPresent(promotion.present());
        printBenefitDetails(promotion.makeDetailsToString());
        printBenefitCost(promotion.calculateBenefitCost());
        printAfterDiscountCost(promotion.calculateAfterDiscountCost(userOrder));
        printBadge(promotion.getBadge());
    }

    private void setPromotion() {
        Present present = decidePresentByStandard();
        Benefit benefit = new Benefit(present, userOrder);
        this.promotion = new Promotion(present, benefit);
    }

    private Present decidePresentByStandard() {
        Present present = null;
        Orders orders = userOrder.orders();
        if (orders.calculateTotalCost() >= PRESENT_STANDARD) {
            present = new Present(CHAMPAGNE, 1);
        }
        return present;
    }

}
