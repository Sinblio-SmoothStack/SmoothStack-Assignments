package Day_2.Assignment_3;/*
 * Ben Schroeder
 *
 * Tester for shape, rectangle, circle, and triangle objects
 */

public class ShapeTester {
    public static void main(String[] args) {
        Circle circle1 = new Circle();

        assert(circle1.calculateArea() == 0);

        Shape circle2 = new Circle(2.5);

        circle1.display();
        circle2.display();

        circle1.setRadius(2.5);

        assert(circle1.calculateArea() == circle2.calculateArea());

        Shape rectangle = new Rectangle(2, 3);
        Shape triangle = new Triangle(2, 3);

        rectangle.display();
        triangle.display();

        assert(rectangle.calculateArea() == triangle.calculateArea() * 2);
    }
}
