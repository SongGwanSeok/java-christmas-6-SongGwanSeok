package christmas.view;

import static christmas.util.Utils.changeKrCurrentFormat;
import static christmas.util.Utils.makeNegative;

import christmas.model.promotion.Badge;
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

    public static void printBenefitDetails(String benefitDetails) {
        System.out.println("<혜택 내역>");
        System.out.println(benefitDetails);
    }

    public static void printBenefitCost(int benefitCost) {
        System.out.println("<총혜택 금액>");
        String totalDiscountWithCurrent = changeKrCurrentFormat(benefitCost);
        if (benefitCost != 0) {
            totalDiscountWithCurrent = makeNegative(totalDiscountWithCurrent);
        }
        System.out.println(totalDiscountWithCurrent);
        System.out.println();
    }

    public static void printAfterDiscountCost(int afterDiscountCost) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(changeKrCurrentFormat(afterDiscountCost));
        System.out.println();
    }

    public static void printBadge(Badge badge) {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }

}
