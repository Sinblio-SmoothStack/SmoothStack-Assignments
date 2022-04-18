package Demo_1_Tests;

import Demo_1.NoX;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class NoXTester {
    private List<String> l1;
    private List<String> l2;
    private List<String> l3;

    @BeforeEach
    public void setUp() {
        l1 = Arrays.asList("ax", "bb", "cx");
        l2 = Arrays.asList("xxax", "xbxbx", "xxcx");
        l3 = Arrays.asList("x");
    }

    @Test
    public void rightDigitTest() {
        NoX nx1 = new NoX(l1);
        NoX nx2 = new NoX(l2);
        NoX nx3 = new NoX(l3);

        assert (nx1.noX().equals(Arrays.asList("a", "bb", "c")));
        assert (nx2.noX().equals(Arrays.asList("a", "bb", "c")));
        assert (nx3.noX().equals(Arrays.asList("")));

    }
}

