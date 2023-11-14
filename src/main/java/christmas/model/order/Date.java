package christmas.model.order;

public class Date {

    public static final String DATE_RULE = "^(3[0-1]|2\\d|1\\d|[1-9])$";
    public static final String WRONG_DATE_ERROR = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    public static final int WEEK = 7;
    public static final int FRIDAY = 1;
    public static final int SATURDAY = 2;
    public static final int SUNDAY = 3;
    public static final int CHRISTMAS_DATE = 25;

    private final int day;

    public Date(String input) {
        validate(input);
        this.day = Integer.parseInt(input);
    }

    public int getDay() {
        return day;
    }

    public Boolean isBeforeChristmas() {
        return this.day <= CHRISTMAS_DATE;
    }

    public Boolean isWeekend() {
        return findWeek() == FRIDAY || findWeek() == SATURDAY;
    }

    public Boolean isStar() {
        return findWeek() == SUNDAY || day == CHRISTMAS_DATE;
    }

    private int findWeek() {
        return day % WEEK;
    }

    private void validate(String day) {
        isEmpty(day);
        isInRange(day);
    }

    private void isEmpty(String day) {
        if (day.isEmpty()) {
            throw new IllegalArgumentException(WRONG_DATE_ERROR);
        }
    }

    private void isInRange(String day) {
        if (!day.matches(DATE_RULE)) {
            throw new IllegalArgumentException(WRONG_DATE_ERROR);
        }
    }
}
