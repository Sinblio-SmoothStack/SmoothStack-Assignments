package Demo_1_Tests;

import Demo_1.RightDigit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RightDigitTester {
    private List<Integer> l1;
    private List<Integer> l2;
    private List<Integer> l3;

    @BeforeEach
    public void setUp() {
        l1 = Arrays.asList(1, 22, 93);
        l2 = Arrays.asList(16, 8, 886, 8, 1);
        l3 = Arrays.asList(10, 0);
    }

    @Test
    public void rightDigitTest() {
        RightDigit r1 = new RightDigit(l1);
        RightDigit r2 = new RightDigit(l2);
        RightDigit r3 = new RightDigit(l3);

        assert (r1.rightDigit().equals(Arrays.asList(1, 2, 3)));
        assert (r2.rightDigit().equals(Arrays.asList(6, 8, 6, 8, 1)));
        assert (r3.rightDigit().equals(Arrays.asList(0, 0)));
    }
}
