package christmas.view;

import christmas.util.StringUtils;

public class OrderOutputView {

    private static final String WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String MONTH = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MESSAGE = "<주문 메뉴>";
    private static final String TOTAL_COST_MESSAGE = "<할인 전 총주문 금액>";

    public static void printErrorMsg(String error) {
        System.out.println(error);
    }

    public static void printWelcome() {
        System.out.println(WELCOME_MESSAGE);
    }

    public static void printDate(int date) {
        System.out.printf(MONTH, date);
        System.out.println();
        System.out.println();
    }

    public static void printOrders(String orders) {
        System.out.println(ORDER_MESSAGE);
        System.out.println(orders);
    }

    public static void printTotalCost(int totalCost) {
        System.out.println(TOTAL_COST_MESSAGE);
        System.out.println(StringUtils.changeKrCurrentFormat(totalCost));
        System.out.println();
    }

}
