package Demo_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class SumClump {
    public static boolean groupSumClump(int current, int[] input, int targetTotal) {
        if (current == targetTotal)
            return true;

        int start = 0;

        while (start < input.length && input[start] == 0) {
            start++;
        }

        if(start < input.length) {
            int end = start + 1;

            while (end < input.length && input[start] == input[end]) {
                end++;
            }

            int[] newInput = input.clone();
            int sum = 0;

            for(int i = start; i < end; i++) {
                sum += input[i];
                newInput[i] = 0;
            }

            System.out.printf("Current: %d Sum: %d\n", current, sum);

            return groupSumClump(current + sum, newInput, targetTotal) ||
                    groupSumClump(current, newInput, targetTotal);
        }

        return false;
    }
}
