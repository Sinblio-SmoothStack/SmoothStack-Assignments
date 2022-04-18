package Demo_1;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Doubling {
    private List<Integer> integerList;

    public Doubling(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public List<Integer> getMyArray() {
        return integerList;
    }

    public void setMyArray(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public List<Integer> doubling() {
        List<Integer> out = integerList.stream()
                .map((x) -> x * 2)
                .collect(toList());

        return out;
    }
}
