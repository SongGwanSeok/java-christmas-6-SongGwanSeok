package christmas.view;

import static christmas.util.StringUtils.changeKrCurrentFormat;
import static christmas.util.StringUtils.makeNegative;

import christmas.model.promotion.Badge;
import christmas.model.promotion.Present;

public class PromotionOutputView {

    private static final String PRESENT_MESSAGE = "<증정 메뉴>";
    private static final String BENEFIT_MESSAGE = "<혜택 내역>";
    private static final String BENEFIT_COST_MESSAGE = "<총혜택 금액>";
    private static final String PAYMENT_COST_MESSAGE = "<할인 후 예상 결제 금액>";
    private static final String BADGE_MESSAGE = "<12월 이벤트 배지>";

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
