package Demo_1;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class NoX {
    private List<String> myList;

    public NoX(List<String> myList) {
        this.myList = myList;
    }

    public List<String> getMyList() {
        return myList;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public List<String> noX() {
        List<String> out = myList.stream()
                .map((s) -> s.replace("x", ""))
                .collect(toList());

        return out;
    }
}
