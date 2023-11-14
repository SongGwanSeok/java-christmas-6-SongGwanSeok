package christmas.controller;

import static christmas.view.OutputView.printDate;
import static christmas.view.OutputView.printErrorMsg;
import static christmas.view.OutputView.printOrders;
import static christmas.view.OutputView.printTotalCost;
import static christmas.view.OutputView.printWelcome;

import christmas.model.order.Date;
import christmas.model.order.Orders;
import christmas.view.InputView;

public class OrderController {

    private PromotionController promotionController;
    private Date visitDate;
    private Orders orders;

    public void takeOrder() {
        printWelcome();
        setVisitDate();
        setOrders();
        printDate(visitDate.getDay());
        printOrders(orders.toString());
        printTotalCost(orders.calculateTotalCost());
        setPromotion();
    }

    private void setVisitDate() {
        try {
            visitDate = new Date(InputView.readDate());
        } catch (IllegalArgumentException e) {
            printErrorMsg(e.getMessage());
            setVisitDate();
        }
    }

    private void setOrders() {
        try {
            orders = new Orders(InputView.readOrders());
        } catch (IllegalArgumentException e) {
            printErrorMsg(e.getMessage());
            setOrders();
        }
    }

    private void setPromotion() {
        promotionController = new PromotionController(visitDate, orders);
    }

}
