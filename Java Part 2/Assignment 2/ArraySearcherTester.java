/*
 * Ben Schroeder
 *
 * Tester class for the ArraySearcher class allowing for easy value changing and testing
 */

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ArraySearcherTester {

    public static void main(String[] args) {
        final int ROWS = 10;
        final int COLS = 10;
        final int MAX_VALUE = 10;
        final int MIN_VALUE = 0;
        final int MAX_OCCURRENCES = 3;

        int[][] myArray = new int[ROWS][COLS];
        List<Point> knownMaximums = new ArrayList<>();

        //populates the array with random values between MIN_VALUE and MAX_VALUE - 1
        for (int i = 0; i < ROWS; i++)
            for (int j = 0; j < COLS; j++)
                myArray[i][j] = ThreadLocalRandom.current().nextInt(MIN_VALUE, MAX_VALUE);

        for (int i = 0; i < MAX_OCCURRENCES; i++) {
            boolean unique;

            do {
                unique = true;

                int row = ThreadLocalRandom.current().nextInt(0, ROWS);
                int col = ThreadLocalRandom.current().nextInt(0, COLS);
                Point newPoint = new Point(row, col);

                for (Point p: knownMaximums)
                    if (p.equals(newPoint))
                        unique = false;

                if (unique) {
                    knownMaximums.add(newPoint);
                    myArray[row][col] = MAX_VALUE;
                    System.out.printf("Maximum at (%d, %d)\n", row, col);
                }
            } while(!unique);
        }

        ArraySearcher searcher = new ArraySearcher(myArray);
        List<Point> foundMaximums = searcher.getMaxLocation();

        assert(foundMaximums.size() == knownMaximums.size());

        for (Point pfound: foundMaximums) {
            System.out.printf("Maximum found at (%s, %s)\n", pfound.getX(), pfound.getY());
            boolean exists = false;

            for (Point pknown: foundMaximums)
                if (pfound.equals(pknown))
                    exists = true;

            assert(exists);
        }

        for (Point pknown: foundMaximums) {
            boolean exists = false;

            for (Point pfound: foundMaximums)
                if (pknown.equals(pfound))
                    exists = true;

            assert(exists);
        }
    }
}
