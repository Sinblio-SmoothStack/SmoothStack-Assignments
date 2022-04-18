package Day_5_Tests;

import Day_5.Basic_Lambdas.StartsWith;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class StartsWithTest {
    private List<String> l1;
    private List<String> l2;
    private List<String> l3;

    @BeforeEach
    public void setUp() {
        l1 = Arrays.asList("ax", "bb", "cx");
        l2 = Arrays.asList("cat", "dog", "aaa", "apple", "axe", "short");
        l3 = Arrays.asList();
    }

    @Test
    public void startsWithTest() {
        assert (StartsWith.startsWith(l1, 'a', 2).equals(Arrays.asList("ax")));
        assert (StartsWith.startsWith(l2, 'a', 3).equals(Arrays.asList("aaa", "axe")));
        assert (StartsWith.startsWith(l3, 'a', 3).equals(Arrays.asList()));

    }
}
