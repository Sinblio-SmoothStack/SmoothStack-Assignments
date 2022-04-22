package Day_2.Assignment_3;/*
 * Ben Schroeder
 *
 * A generic shape interface with abstract methods for area and printing a description of the shape
 */

public interface Shape {
    /**
     * Calculates the area of the shape
     *
     * @return the area of the shape
     */
    double calculateArea();

    /**
     * Prints a description of the object to the console
     */
    void display();
}
