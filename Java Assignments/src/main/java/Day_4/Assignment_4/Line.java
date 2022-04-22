package Day_4.Assignment_4;/*
Benjamin Schroeder

Line object created to experiment with Junit tests on
 */

import java.awt.Point;

public class Line {
    private Point p1;
    private Point p2;

    /**
     * Constructor based on 2 points to create a line segment
     *
     * @param p1 point 1
     * @param p2 point 2
     */
    public Line (Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * Calculates the slope of the line segment
     *
     * @return the slope of the line segment
     */
    public double getSlope() {
        return (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
    }

    /**
     * Calculates the distance of the two points that construct the line
     *
     * @return the distance of the two points
     */
    public double getDistance() {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(),2) + Math.pow(p1.getY() - p2.getY(), 2));
    }

    /**
     * Tells whether this line is parallel to a given line
     *
     * @param line the line to check if the current line is parallel to
     * @return a boolean value indicating whether the two lines are parallel
     */
    public boolean parallelTo(Line line) {
        return getSlope() == line.getSlope();
    }
}
