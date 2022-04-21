/*
Ben Schroeder

A test class for lambda fibonacci method
 */

package Java_Testing_Tests.Testing_Lambda;

import Java_Testing.Testing_Lambda.Fibonacci;
import org.junit.jupiter.api.Test;

public class FibonacciTester {

    @Test
    public void testFibonacci() {
        assert (Fibonacci.nthTerm(-31) == 0);
        assert (Fibonacci.nthTerm(8) == 21);
        assert (Fibonacci.nthTerm(12) == Fibonacci.nthTerm(11) + Fibonacci.nthTerm(10));
    }

}
