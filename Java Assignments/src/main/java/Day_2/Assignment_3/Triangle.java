package Day_2.Assignment_3;/*
 * Ben Schroeder
 *
 * A triangle object derived from the shape interface implementing its abstract methods
 */

public class Triangle implements Shape{
    /**
     * I chose to use primitives and initialize them to 0 over using the double object. While using the double object
     * would allow for me to set a null value and track whether a particular object has been given values, it would add
     * unneeded complexity. This is because values of zero will not cause any errors with the current methods.
     */
    private double base;
    private double height;

    /**
     * Default constructor
     */
    public Triangle() {
        base = 0;
        height = 0;
    }

    /**
     * Constructor with the ability to give a base and height of a triangle
     *
     * @param base The base of the triangle
     * @param height The height of a triangle
     */
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    /**
     * Getter for base
     *
     * @return The base of the triangle
     */
    public double getBase() {
        return base;
    }

    /**
     * Setter for the base
     *
     * @param base the new base of the triangle
     */
    public void setBase(double base) {
        this.base = base;
    }

    /**
     * Getter for height
     *
     * @return The height of the triangle
     */
    public double getHeight() {
        return height;
    }

    /**
     * Setter for the height
     *
     * @param height the new height of the triangle
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Calculates the area of the triangle
     *
     * @return the area of the triangle
     */
    @Override
    public double calculateArea() {
        return (base * height) / 2;
    }

    /**
     * Prints a description of the object to the console
     */
    @Override
    public void display() {
        System.out.printf("Triangle with a base of %s and a height of %s\n", base, height);
    }
}
