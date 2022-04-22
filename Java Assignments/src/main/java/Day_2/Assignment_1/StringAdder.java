package Day_2.Assignment_1;/*
 * Ben Schroeder
 *
 * When given an array of strings can return a double value being the summation of all values parsed from the strings
 */

public class StringAdder {
    String[] stringArray;

    /**
     * Default Constructor
     */
    public StringAdder() {
        this.stringArray = null;
    }

    /**
     * Constructor with ability to set string array on creation
     *
     * @param stringArray an array of strings with values to be summed
     */
    public StringAdder(String[] stringArray) {
        this.stringArray = stringArray;
    }

    /**
     * Setter for the string array
     *
     * @param stringArray the new string array
     */
    public void setStringArray(String[] stringArray) {
        this.stringArray = stringArray;
    }

    /**
     * Getter for the string array
     *
     * @return the string array
     */
    public String[] getStringArray() {
        return stringArray;
    }

    /**
     * Calculates the sum of all the strings stored in the array
     *
     * @return the sum of all values contained in the string array
     */
    public double calculateSum() {
        double sum = 0;

        if (stringArray != null) {
            for (String s: stringArray) {
                sum += convertToDouble(s);
            }
        }

        return sum;
    }

    /**
     * Function that attempts to parse a double from a string, but if it can't return 0 and prints a message to console.
     * This is static since it does not rely on any instance specific variable.
     *
     * @param toConvert the string to be parsed
     * @return the double value found or 0
     */
    private static double convertToDouble(String toConvert) {
        try {
            return Double.parseDouble(toConvert);
        } catch (final NumberFormatException e)
        {
            System.out.printf("%s could not be converted to a double. Using 0 instead.\n", toConvert);
            return 0;
        }
    }
}
