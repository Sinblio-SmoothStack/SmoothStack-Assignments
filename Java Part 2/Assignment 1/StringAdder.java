/*
 * Ben Schroeder
 *
 * When given an array of strings can return a double value being the summation of all values parsed from the strings
 */

public class StringAdder {
    String[] stringArray;

    public StringAdder() {
        this.stringArray = null;
    }

    public StringAdder(String[] stringArray) {
        this.stringArray = stringArray;
    }

    public void setStringArray(String[] stringArray) {
        this.stringArray = stringArray;
    }

    public String[] getStringArray() {
        return stringArray;
    }

    public double calculateSum() {
        double sum = 0;

        if (stringArray != null) {
            for (String s: stringArray) {
                sum += convertToDouble(s);
            }
        }

        return sum;
    }

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
