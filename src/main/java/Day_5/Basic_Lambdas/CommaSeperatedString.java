/*
Benjamin Schroeder

Given a list of integers returns a comma seperated string based on the given integers
 */

package Day_5.Basic_Lambdas;

import java.util.List;
import java.util.stream.Collectors;

public class CommaSeperatedString {

    private List<Integer> input;

    public CommaSeperatedString(List<Integer> input) {
        this.input = input;
    }

    public List<Integer> getInput() {
        return input;
    }

    public void setInput(List<Integer> input) {
        this.input = input;
    }

    /**
     * makes a comma seperated string where a given integer has an e or o places before it representing whether its even
     * or odd respectively. The string is delimited by commas
     *
     * @return the created string
     */
    public String make() {
        return input.stream()
                .map((x) -> {
                    if (x % 2 == 0)
                        return "e" + x;
                    return "o" + x;
                })
                .collect(Collectors.joining(","));
    }

}
