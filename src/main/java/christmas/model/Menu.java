package christmas.model;

import java.util.Objects;
import java.util.stream.Stream;

public enum Menu {
    MUSHROOM_SPOOF(MenuType.APPETIZER, "양송이수프", 6000),
    TAPAS(MenuType.APPETIZER, "타파스", 5500),
    CAESAR_SALAD(MenuType.APPETIZER, "시저샐러드", 8000),

    T_BORN_STEAK(MenuType.MAIN, "티본스테이크", 55000),
    BBQ_RIB(MenuType.MAIN, "바비큐립", 54000),
    SEAFOOD_PASTA(MenuType.MAIN, "해산물파스타", 35000),
    CHRISTMAS_PASTA(MenuType.MAIN, "크리스마스파스타", 25000),

    CHOCOLATE_CAKE(MenuType.DESSERT, "초코케이크", 15000),
    ICE_CREAM(MenuType.DESSERT, "아이스크림", 5000),

    ZERO_COKE(MenuType.DRINK, "제로콜라", 3000),
    RED_WINE(MenuType.DRINK, "레드와인", 60000),
    CHAMPAGNE(MenuType.DRINK, "샴페인", 25000),
    ;

    private final MenuType type;
    private final String name;
    private final int price;

    Menu(MenuType type, String name, int price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public MenuType getType() {
        return type;
    }

    public static Boolean isMenu(String menuName) {
        return Stream.of(Menu.values())
                .map(menu -> menu.name)
                .toList()
                .contains(menuName);
    }

    public static Menu findMenuByName(String name) {
        return Stream.of(Menu.values())
                .filter(menu -> Objects.equals(name, menu.name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(Order.WRONG_ORDER_ERROR));
    }
}
