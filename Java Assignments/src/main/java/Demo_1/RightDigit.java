package Demo_1;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class RightDigit {
    private List<Integer> integerList;

    public RightDigit(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public List<Integer> getMyArray() {
        return integerList;
    }

    public void setMyArray(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public List<Integer> rightDigit() {
        List<Integer> out = integerList.stream()
                .map((x) -> x % 10)
                .collect(toList());

        return out;
    }
}
