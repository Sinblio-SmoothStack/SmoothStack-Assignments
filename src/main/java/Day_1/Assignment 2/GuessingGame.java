/*
 * Ben Schroeder
 *
 * This is a guessing game where a player is given a number of guesses. Within these guesses the player must guess
 * within a set range of a random number between a set maximum and minimum. The number of guesses, accepted range, and
 * minimum and maximum values for the random number are set as constants for easy adjustment.
 */

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class GuessingGame {

    // the minimum and maximum values possible for the game to generate
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 100;
    // the range in which a value will be accepted
    // (ie. if the value is  10 and 63 were to be the generated number the any guess from 53 to 73 would be accepted)
    private static final int ACCEPTABLE_ERROR = 10;
    // the number of guesses a player is allowed before they lose
    private static final int NUMBER_OF_GUESSES = 5;

    public static void main(String[] args) {
        // generates a random number between the minimum and maximum value
        int randomNumber = ThreadLocalRandom.current().nextInt(MIN_VALUE, MAX_VALUE + 1);
        System.out.println(randomNumber);

        // greeting message for the user outlining the rules
        System.out.printf("Welcome, I have generated a random number between %d and %d. you have %d attempts to guess a number within %d of that random number. Good Luck!!\n\n", MIN_VALUE, MAX_VALUE, NUMBER_OF_GUESSES,
                ACCEPTABLE_ERROR);

        Scanner in = new Scanner(System.in);

        int guess = 0;

        // Game Loop, starts at 1 for better numeration
        for (int i = 1; i <= NUMBER_OF_GUESSES; i++) {
            // prints the attempt number
            System.out.printf("Attempt %d of %d:\n", i, NUMBER_OF_GUESSES);

            boolean validInput = false;

            /*
            This loop serves to validate a players input

            First a player will be prompted for an input.
            Then, it will wait for and fetch an input
            Finally, it tries to parse the integer, there are 3 possible outcomes.

            -> The guess is an integer and within the valid range.
            The program continues on, exiting the loop.

            -> The guess is an integer, but is not within the valid range.
            The program prints a message stating the given value is not within the acceptable range. Then will loop
            and prompt the user for another value.

            -> The guess is not an integer.
            The program prints a different error message outlining that the input is not valid and must be an
            integer. Then it will loop and prompt the user for another value.
            */
            do {
                // the user is prompted for input
                System.out.printf("Please enter a guess between %d and %d : ", MIN_VALUE, MAX_VALUE);
                String input = in.next();


                try {
                    // attempts to parse an integer from the input
                    guess = Integer.parseInt(input);

                    // checks if the inputted value is within the valid range
                    if (MIN_VALUE <= guess && guess <= MAX_VALUE)
                    {
                        // sets validInput to true to exit the loop
                        validInput = true;
                    } else {
                        // otherwise, prints message for integer not within valid range
                        System.out.printf("%d is not between %d and %d!\n", guess, MIN_VALUE, MAX_VALUE);
                    }
                } catch (final NumberFormatException e)
                {
                    // catches a non-integer input and prints error message
                    System.out.printf("%s is not a valid input! Input must be an Integer.\n", input);
                }
            } while (!validInput);

            // checks if the value guessed is within the acceptable range
            if (Math.abs(randomNumber - guess) <= ACCEPTABLE_ERROR) {
                // breaks the game loop if guess is accepted
                break;
            } else {
                // prints a message stating that the guess was not within the acceptable range and starts next guess
                System.out.printf("Sorry! %d is not within %d of the random number.\n\n", guess, ACCEPTABLE_ERROR);
            }
        }

        // Determines which statement is correct to display to the player
        if (randomNumber == guess)
            // printed if the player guessed the exact value of the random number
            System.out.printf("Congratulations!! %d was the value of the random number!\n", guess);
        else if (Math.abs(randomNumber - guess) <= ACCEPTABLE_ERROR)
            // printed if the player guessed within the acceptable margin of the random number
            System.out.printf("Congratulations!! %d was was within %d of the random number %d!\n", guess,
                    ACCEPTABLE_ERROR, randomNumber);
        else
            // printed if the player failed to guess within range of the random number during the game
            System.out.printf("Sorry, The random number was %d. Better luck next time.\n", randomNumber);

    }
}
