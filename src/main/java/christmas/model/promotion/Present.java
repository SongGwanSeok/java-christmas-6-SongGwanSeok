package christmas.model.promotion;

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

}
