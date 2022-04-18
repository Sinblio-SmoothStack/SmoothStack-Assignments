package Day_5.Basic_Lambdas;

import java.util.List;
import java.util.stream.Collectors;

public class StartsWith {
    public static List<String> startsWith(List<String> input, char c, int length) {
        return input.stream()
                .filter(s -> s.length() == length)
                .filter(s -> s.charAt(0) == c)
                .collect(Collectors.toList());
    }
}
