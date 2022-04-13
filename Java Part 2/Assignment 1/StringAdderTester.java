/*
 * Ben Schroeder
 *
 * Tester for the string adder class
 */

public class StringAdderTester {
    public static void main (String[] args) {
        String[] strings1 = {"1.2", "2", "7"};
        String[] strings2 = {"5", "13", " 3.4", "three"};
        String[] strings3 = {};

        StringAdder adder = new StringAdder(strings1);
        assert(adder.calculateSum() == 10.2);

        adder.setStringArray(strings2);
        assert (adder.calculateSum() == 21.4);

        adder.setStringArray(strings3);
        assert (adder.calculateSum() == 0);
    }
}
