package Java_OOP_June_2024._05_Polymorphism._02_Lab._02_Shapes;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
        calculateArea();
        calculatePerimeter();
    }

    public Double getHeight() {
        return height;
    }


    public Double getWidth() {
        return width;
    }


    @Override
    protected void calculatePerimeter() {
        super.setPerimeter(2 * getHeight() + 2 * getWidth());
    }

    @Override
    protected void calculateArea() {
        super.setArea(height * width);
    }
}
