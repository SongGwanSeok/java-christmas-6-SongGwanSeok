package christmas.controller;

import static christmas.model.order.Menu.CHAMPAGNE;
import static christmas.model.promotion.Present.PRESENT_STANDARD;
import static christmas.view.OutputView.printAfterDiscountCost;
import static christmas.view.OutputView.printBadge;
import static christmas.view.OutputView.printBenefitCost;
import static christmas.view.OutputView.printBenefitDetails;
import static christmas.view.OutputView.printPresent;

import christmas.model.order.Date;
import christmas.model.order.Orders;
import christmas.model.order.UserOrder;
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
        this.promotion = new Promotion(decidePresentByStandard(), userOrder);
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
