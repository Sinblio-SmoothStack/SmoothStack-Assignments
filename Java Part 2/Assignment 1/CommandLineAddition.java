/*
 * Ben Schroeder
 *
 * This program takes any number of arguments from the command line then shows the result from adding them together
 */

public class CommandLineAddition {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments given, CommandLineAddition will add all arguments given to it.");
        } else {
            StringAdder adder = new StringAdder(args);
            double result = adder.calculateSum();
            System.out.println(result + " was the sum of given arguments");
        }
    }
}
