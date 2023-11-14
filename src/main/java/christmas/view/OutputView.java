package christmas.view;

import christmas.model.promotion.Present;
import christmas.util.Utils;

public class OutputView {

    public static void printErrorMsg(String error) {
        System.out.println(error);
    }

    public static void printWelcome() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printDate(int date) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
    }

    public static void printOrders(String orders) {
        System.out.println("<주문 메뉴>");
        System.out.println(orders);
    }

    public static void printTotalCost(int totalCost) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(Utils.changeKrCurrentFormat(totalCost));
        System.out.println();
    }

    public static void printPresent(Present present) {
        System.out.println("<증정 메뉴>");
        System.out.println(present == null ? "없음" : present);
        System.out.println();
    }

}
