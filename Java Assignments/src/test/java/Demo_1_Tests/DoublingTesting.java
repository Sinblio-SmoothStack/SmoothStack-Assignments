package Demo_1_Tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Demo_1.Doubling;
import java.util.Arrays;
import java.util.List;

public class DoublingTesting {

    private List<Integer> l1;
    private List<Integer> l2;
    private List<Integer> l3;

    @BeforeEach
    public void setUp() {
        l1 = Arrays.asList(1, 2, 3);
        l2 = Arrays.asList(6, 8, 6, 8, -1);
        l3 = Arrays.asList();
    }

    @Test
    public void doublingTest() {
        Doubling d1 = new Doubling(l1);
        Doubling d2 = new Doubling(l2);
        Doubling d3 = new Doubling(l3);

        assert (d1.doubling().equals(Arrays.asList(2, 4, 6)));
        assert (d2.doubling().equals(Arrays.asList(12, 16, 12, 16, -2)));
        assert (d3.doubling().equals(Arrays.asList()));
    }
}
