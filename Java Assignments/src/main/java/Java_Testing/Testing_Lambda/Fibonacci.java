/*
Ben Schroeder

A function that when given n can return the nth number in the fibonacci sequence
 */

package Java_Testing.Testing_Lambda;

import java.util.stream.Stream;

public class Fibonacci {
    public static int nthTerm(int n) {
        int out = 0;

        if (n > 0) {
            out = Stream.iterate(new int[]{1, 1}, f -> new int[]{f[1], f[0] + f[1]})
                    .limit(n)
                    .reduce((a, b) -> b)
                    .get()[0];
        }

        return out;
    }
}
