package christmas.model.promotion;

import static christmas.util.Utils.changeKrCurrentFormat;
import static christmas.util.Utils.makeNegative;

import christmas.model.order.Menu;

public class Present {

    public static final String NON_GIFT = "없음";
    public static final int PRESENT_STANDARD = 120000;

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
        return "증정 이벤트: " + makeNegative(changeKrCurrentFormat(calculatePrice()));
    }

    public int calculatePrice() {
        return menu.getPrice() * quantity;
    }
}
