/*
* Ben Schroeder
*
* This class consists of a function that can be used to create a pattern along with a main
* method utilizing the function inorder to print out 4 different patterns.
*/

public class PatternPrinter {

    // private variable needed so print pattern can print  the sequence while main can increase its length between runs
    private static StringBuffer dotSequence;

    public static void main(String[] args) {
        //constructs dotSequence
        dotSequence  = new StringBuffer(".........");

        // loop for the number of patterns to be printed, starts at one for ease of labeling
        for (int i = 1; i < 5; i++) {

            // labels the pattern that is printed
            System.out.printf("%d)\n", i);

            // case structure used to call the printPattern function with appropriate parameters for each loop through
            switch (i) {
                case 1 -> printPattern(4, 1, 1, 1);
                case 2 -> printPattern(4, 4, -1, 0);
                case 3 -> printPattern(4, 1, 2, 1, 5, -1);
                case 4 -> printPattern(4, 7, -2, 0, 2, 1);
            }

            // increments dot sequence following each run through
            dotSequence.append('.');
        }
    }

    /**
     * Prints a pattern of spaces and stars to the console based on a number of given parameters.
     *
     * @param lines the number of lines for the pattern to be printed on
     * @param stars the starting number of stars for the pattern
     * @param starChange the change in stars between lines (can be negative)
     * @param dotPlacement where the dot sequence will be placed (0 for the start, 1 for the end, any other number will
     *                     not print the sequence)
     * @param spaces the number of spaces desired in front of the printed stars
     * @param spacesChange the change in spaces between lines (can be negative)
     */
    private static void printPattern(int lines, int stars, int starChange, int dotPlacement, int spaces, int spacesChange) {

        if (dotPlacement == 0) {
            System.out.println(dotSequence);
        }


        for(int j = 0; j < lines; j ++) {
            // add spaces and stars equal to their current values
            String out = " ".repeat(spaces) + "*".repeat(stars);

            System.out.println(out);

            //Increments the spaces and stars value by their respective change parameters
            spaces += spacesChange;
            stars += starChange;
        }

        if (dotPlacement == 1) {
            System.out.println(dotSequence);
        }
    }

    /**
     * Prints a simplified pattern of stars to the console based on a number of given parameters.
     * This exists for ease of usage as it will call the original printPattern function with default values
     * within the spaces and spacesChange parameters inorder to not print any spaces.
     *
     * @param lines the number of lines for the pattern to be printed on
     * @param stars the starting number of stars for the pattern
     * @param starChange the change in stars between lines (can be negative)
     * @param dotPlacement where the dot sequence will be placed (0 for the start, 1 for the end, any other number will
     *                     not print the sequence)
    */
    private static void printPattern(int lines, int stars, int starChange, int dotPlacement) {
        printPattern(lines, stars, starChange, dotPlacement, 0, 0);
    }
}
