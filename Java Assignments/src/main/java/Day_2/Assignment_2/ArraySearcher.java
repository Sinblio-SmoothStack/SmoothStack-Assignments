package Day_2.Assignment_2;/*
 * Ben Schroeder
 *
 * An object that when given a 2d array is able to find the location of all occurrences of the maximum value within the array
 */

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class ArraySearcher {
    private int[][] toSearch;
    private List<Point> maxLocation = new ArrayList<>();

    /**
     * Default Constructor
     */
    public ArraySearcher() {
        toSearch = null;
    }

    /**
     * Constructor allowing for passing the array at creation
     *
     * @param toSearch the array to be searched for the max value
     */
    public ArraySearcher(int[][] toSearch) {
        this.toSearch = toSearch;
        findMax();
    }

    /**
     * Locates the maximum value, or values within the 2d array stored within to search
     */
    private void findMax() {
        maxLocation.clear();
        if (toSearch != null && toSearch.length != 0 && toSearch[0].length != 0) {
            int maxValue = toSearch[0][0];

            for (int i = 0; i < toSearch.length; i++) {
                for (int j = 0; j < toSearch[0].length; j++) {
                    if (toSearch[i][j] > maxValue) {
                        maxValue = toSearch[i][j];
                        maxLocation.clear();
                        maxLocation.add(new Point(i, j));
                    }else if (toSearch[i][j] == maxValue) {
                        maxLocation.add(new Point(i, j));
                    }
                }
            }
        }
    }

    /**
     * Getter fot the toSearch 2d array
     *
     * @return the 2d toSearch array
     */
    public int[][] getToSearch() {
        return toSearch;
    }

    /**
     * Setter for toSearch the 2d array calls findMax to update maxValues
     *
     * @param toSearch the new 2d array to find the max
     */
    public void setToSearch(int[][] toSearch) {
        this.toSearch = toSearch;
        findMax();
    }

    /**
     * Getter for the list of max locations. will return an empty arraylist if the 2d array is empty
     *
     * @return a list of points containing all occurrences of the maximum value
     */
    public List<Point> getMaxLocation() {
        return maxLocation;
    }
}
