package christmas.validation;

import static christmas.model.order.Date.DATE_RULE;
import static christmas.model.order.Date.WRONG_DATE_ERROR;

public class DateValidation {

    public static void validate(String day) throws IllegalArgumentException {
        isEmpty(day);
        isInRange(day);
    }

    private static void isEmpty(String day) {
        if (day.isEmpty()) {
            throw new IllegalArgumentException(WRONG_DATE_ERROR);
        }
    }

    private static void isInRange(String day) {
        if (!day.matches(DATE_RULE)) {
            throw new IllegalArgumentException(WRONG_DATE_ERROR);
        }
    }
}
