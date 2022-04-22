package Day_2.Assignment_3;/*
 * Ben Schroeder
 *
 * A Circle object derived from the shape interface implementing its abstract methods
 */

public class Circle implements Shape{
    /**
     * I chose to use primitives and initialize them to 0 over using the double object. While using the double object
     * would allow for me to set a null value and track whether a particular object has been given values, it would add
     * unneeded complexity. This is because values of zero will not cause any errors with the current methods.
     */
    private double radius;

    /**
     * Default Constructor
     */
    public Circle() {
        radius = 0;
    }

    /**
     * Constructor for setting the radius upon creation
     *
     * @param radius the radius of the circle
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Getter for radius
     *
     * @return the radius of the circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Setter for radius
     *
     * @param radius the new radius of the circle
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Calculates the area of the circle
     *
     * @return the area of the circle
     */
    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * Prints a description of the object to the console
     */
    @Override
    public void display() {
        System.out.printf("Circle with a radius of %s\n", radius);
    }
}
