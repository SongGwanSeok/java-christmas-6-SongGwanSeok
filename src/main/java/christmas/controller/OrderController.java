package christmas.controller;

import christmas.model.Date;
import christmas.model.Orders;
import christmas.view.InputView;
import christmas.view.OutputView;

public class OrderController {

    private Date visitDate;
    private Orders orders;

    public void takeOrder() {
        OutputView.printWelcome();
        setVisitDate();
        setOrders();
        OutputView.printDate(visitDate.getDay());
        OutputView.printOrders(orders.toString());
    }

    private void setVisitDate() {
        visitDate = new Date(InputView.readDate());
    }

    private void setOrders() {
        orders = new Orders(InputView.readOrders());
    }

}
