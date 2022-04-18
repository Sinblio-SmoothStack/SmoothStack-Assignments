/*
 * Ben Schroeder
 *
 * A Rectangle object derived from the shape interface implementing its abstract methods
 */

public class Rectangle implements Shape {
    /**
     * I chose to use primitives and initialize them to 0 over using the double object. While using the double object
     * would allow for me to set a null value and track whether a particular object has been given values, it would add
     * unneeded complexity. This is because values of zero will not cause any errors with the current methods.
     */
    private double length;
    private double width;

    /**
     * Default Constructor
     */
    public Rectangle() {
        length = 0;
        width = 0;
    }

    /**
     * Additional Constructor for entering length and width on creation
     *
     * @param length the length of the rectangle
     * @param width the width of the rectangle
     */
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /**
     * Getter for length
     *
     * @return the length of the rectangle
     */
    public double getLength() {
        return length;
    }

    /**
     * Setter for length
     *
     * @param length the new length of the rectangle
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Getter for width
     *
     * @return the width of the rectangle
     */
    public double getWidth() {
        return width;
    }

    /**
     * Setter for width
     *
     * @param width the new width of the rectangle
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Calculates the area of the rectangle
     *
     * @return the area of the rectangle
     */
    @Override
    public double calculateArea() {
        return length * width;
    }

    /**
     * Prints a description of the object to the console
     */
    @Override
    public void display() {
        System.out.printf("Rectangle with a length of %s and a width of %s\n", length, width);
    }
}
