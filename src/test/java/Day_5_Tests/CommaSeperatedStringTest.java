package Day_5_Tests;

import Day_5.Basic_Lambdas.CommaSeperatedString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class CommaSeperatedStringTest {

    private List<Integer> l1;
    private List<Integer> l2;
    private List<Integer> l3;

    @BeforeEach
    public void setUp() {
        l1 = Arrays.asList(1, 2, 3);
        l2 = Arrays.asList(6, 8, 6, 8, -1);
        l3 = Arrays.asList(3,44);
    }

    @Test
    public void makeTest() {
        CommaSeperatedString c1 = new CommaSeperatedString(l1);
        CommaSeperatedString c2 = new CommaSeperatedString(l2);
        CommaSeperatedString c3 = new CommaSeperatedString(l3);

        assert (c1.make().equals("o1,e2,o3"));
        assert (c2.make().equals("e6,e8,e6,e8,o-1"));
        assert (c3.make().equals("o3,e44"));
    }
}
