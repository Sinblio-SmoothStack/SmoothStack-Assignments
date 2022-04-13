public class Circle implements Shape{
    private double radius;

    public Circle() {
        radius = 0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public void display() {
        System.out.printf("Circle with a radius of %s", radius);
    }
}
