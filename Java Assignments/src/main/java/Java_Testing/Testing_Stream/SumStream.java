/*
Benjamin Schroeder

This class adapts a given piece of code inorder to make it testable using junit
 */

package Java_Testing.Testing_Stream;

import java.util.List;
import java.util.Optional;

public class SumStream {
    /*
    Inorder to fix the function to be testable in junit there must be a way of giving the function an input and returning
    the result. In addition, I removed the print command as the response can be printed by the class using the function
     */
    public static Optional<Integer> sum(List<Integer> numbers) {
        return numbers.stream().reduce((a, b) -> (a + b));
    }
}
