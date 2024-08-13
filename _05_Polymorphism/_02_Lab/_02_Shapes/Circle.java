package Java_OOP_June_2024._05_Polymorphism._02_Lab._02_Shapes;

public class Circle extends Shape {

    private final Double radius;

    public Circle(double radius) {
        this.radius = radius;
        calculateArea();
        calculatePerimeter();
    }

    public final Double getRadius() {
        return radius;

    }


    @Override
    protected void calculatePerimeter() {
        super.setPerimeter(2 * Math.PI * getRadius());
    }

    @Override
    protected void calculateArea() {
        super.setArea(Math.PI * Math.pow(getRadius(), 2));
    }
}
