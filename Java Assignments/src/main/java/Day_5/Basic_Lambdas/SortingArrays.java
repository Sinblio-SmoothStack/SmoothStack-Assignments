/*
Benjamin Schroeder

A class to test various ways of sorting an array of words using lambda functions
 */

package Day_5.Basic_Lambdas;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class SortingArrays {

    String[] myArray;

    @BeforeEach
    void setUp () {
        myArray = new String[]{"Hello", "good", "evening", "there", "you", "should", "try", "lambdas", "they", "are"
                , "incredibly", "powerful", "even", "more", "than", "you", "may", "think"};
    }

    @Test
    void unsorted() {
        System.out.println("Unsorted Array:");

        for (String s: myArray)
            System.out.println(s);

        System.out.println();
    }

    @Test
    void length() {
        System.out.println("Sorted by length:");

        Arrays.stream(myArray)
                .sorted(Comparator.comparingInt(String::length))
                .forEach((a) -> System.out.println(a));

        System.out.println();
    }

    @Test
    void lengthReverse() {
        System.out.println("Sorted by reverse length:");

        Arrays.stream(myArray)
                .sorted((a, b) -> b.length() - a.length())
                .forEach((a) -> System.out.println(a));

        System.out.println();
    }

    @Test
    void alphabetically() {
        System.out.println("Sorted alphabetically by first char:");

        Arrays.stream(myArray)
                .sorted(Comparator.comparingInt(a -> a.toLowerCase().charAt(0)))
                .forEach((a) -> System.out.println(a));

        System.out.println();
    }

    @Test
    void eFirst() {
        System.out.println("Words that start with e first:");

        Arrays.stream(myArray)
                .sorted(Comparator.comparingInt(a -> {
                    if (a.toLowerCase().charAt(0) == 'e')
                        return 0;
                    return 1;
                }))
                .forEach((a) -> System.out.println(a));

        System.out.println();
    }

    @Test
    void eFirstStaticHelper() {
        System.out.println("Words that start with e first (now with static helper):");

        Arrays.sort(myArray, (a, b) -> eSort(a, b));

        for (String s: myArray)
            System.out.println(s);

        System.out.println();
    }

    @AfterEach
    void cleanUp() {
        myArray = null;
    }

    /**
     * Helper method for eFirstStaticHelper
     *
     * @param a String to compare 1
     * @param b string to compare 2
     * @return -1 if a goes first, 0 if maintain order, 1 if reverse order
     */
    private static int eSort(String a, String b) {
        if (a.toLowerCase().charAt(0) == 'e')
            if (b.toLowerCase().charAt(0) == 'e')
                return 0;
            else
                return -1;
        if (b.toLowerCase().charAt(0) == 'e')
            return 1;
        return 0;
    }
}
