/*
Ben Schroeder

A tester class written for the sum stream function
 */

package Java_Testing_Tests.Testing_Stream;

import Java_Testing.Testing_Stream.SumStream;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SumStreamTester {

    @Test
    public void testSum() {
        List<Integer> l1 = Arrays.asList();
        List<Integer> l2 = Arrays.asList(1, 2, 3);
        List<Integer> l3 = Arrays.asList(10, 10, 10, 10, 10);

        assert(SumStream.sum(l1).isEmpty());
        assert(SumStream.sum(l2).get() == 6);
        assert(SumStream.sum(l3).get() == 50);
    }
}
