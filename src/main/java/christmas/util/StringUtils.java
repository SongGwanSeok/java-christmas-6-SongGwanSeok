package christmas.util;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class StringUtils {

    private static final String DECIMAL_FORMAT = "#,###";
    private static final String KR_CURRENT = "원";
    private static final String NEGATIVE_SIGN = "-";

    public static List<String> splitByDelimiter(String target, String delimiter) {
        return Arrays.stream(target.split(delimiter)).toList();
    }

    public static String changeKrCurrentFormat(int target) {
        DecimalFormat decFormat = new DecimalFormat(DECIMAL_FORMAT);

        return decFormat.format(target) + KR_CURRENT;
    }

    public static String makeNegative(String target) {
        return NEGATIVE_SIGN + target;
    }
}
