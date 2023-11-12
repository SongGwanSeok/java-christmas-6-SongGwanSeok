package christmas.util;

import java.util.Arrays;
import java.util.List;

public class Utils {

    public static List<String> splitByDelimiter(String target, String delimiter) {
        return Arrays.stream(target.split(delimiter)).toList();
    }
}
