package christmas.model.promotion;

import static christmas.util.Utils.changeKrCurrentFormat;

import christmas.model.order.Menu;

public class Present {

    private final Menu menu;
    private final int quantity;

    public Present(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return menu.getName() + " " + quantity + "개";
    }

    public String makeEventPriceToString() {
        return "증정 이벤트: " + changeKrCurrentFormat(calculatePrice()) + "\n";
    }

    public int calculatePrice() {
        return menu.getPrice() * quantity;
    }
}
