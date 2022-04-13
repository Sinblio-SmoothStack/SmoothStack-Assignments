public class Triangle implements Shape{
    private double base;
    private double height;

    public Triangle() {
        base = 0;
        height = 0;
    }

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    @Override
    public double calculateArea() {
        return 0;
    }

    @Override
    public void display() {

    }
}
