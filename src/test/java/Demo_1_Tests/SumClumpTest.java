package Demo_1_Tests;

import Demo_1.SumClump;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SumClumpTest {
    private int[] l1;
    private int[] l2;
    private int[] l3;

    @BeforeEach
    public void setUp() {
        l1 = new int[]{2, 4, 8};
        l2 = new int[]{1, 2, 4, 8, 1};
        l3 = new int[]{2, 4, 4, 8};
    }

    @Test
    public void rightDigitTest() {

        assert (SumClump.groupSumClump(0, l1, 10));
        assert (SumClump.groupSumClump(0, l2, 14));
        assert (!SumClump.groupSumClump(0, l3, 14));
    }
}
