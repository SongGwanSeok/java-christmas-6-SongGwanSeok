package christmas.view;

import static christmas.util.Utils.changeKrCurrentFormat;
import static christmas.util.Utils.makeNegative;

import christmas.model.promotion.Badge;
import christmas.model.promotion.Present;
import christmas.util.Utils;

public class OutputView {

    private static final String WELCOME_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String MONTH = "12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String ORDER_MESSAGE = "<주문 메뉴>";
    private static final String TOTAL_COST_MESSAGE = "<할인 전 총주문 금액>";
    private static final String PRESENT_MESSAGE = "<증정 메뉴>";
    private static final String BENEFIT_MESSAGE = "<혜택 내역>";
    private static final String BENEFIT_COST_MESSAGE = "<총혜택 금액>";
    private static final String PAYMENT_COST_MESSAGE = "<할인 후 예상 결제 금액>";
    private static final String BADGE_MESSAGE = "<12월 이벤트 배지>";

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
        System.out.println(Utils.changeKrCurrentFormat(totalCost));
        System.out.println();
    }

    public static void printPresent(Present present) {
        System.out.println(PRESENT_MESSAGE);
        System.out.println(present == null ? Present.NON_GIFT : present);
        System.out.println();
    }

    public static void printBenefitDetails(String benefitDetails) {
        System.out.println(BENEFIT_MESSAGE);
        System.out.print(benefitDetails);
        System.out.println();
    }

    public static void printBenefitCost(int benefitCost) {
        System.out.println(BENEFIT_COST_MESSAGE);
        String totalDiscountWithCurrent = changeKrCurrentFormat(benefitCost);
        if (benefitCost != 0) {
            totalDiscountWithCurrent = makeNegative(totalDiscountWithCurrent);
        }
        System.out.println(totalDiscountWithCurrent);
        System.out.println();
    }

    public static void printAfterDiscountCost(int afterDiscountCost) {
        System.out.println(PAYMENT_COST_MESSAGE);
        System.out.println(changeKrCurrentFormat(afterDiscountCost));
        System.out.println();
    }

    public static void printBadge(Badge badge) {
        System.out.println(BADGE_MESSAGE);
        System.out.println(badge);
    }

}
