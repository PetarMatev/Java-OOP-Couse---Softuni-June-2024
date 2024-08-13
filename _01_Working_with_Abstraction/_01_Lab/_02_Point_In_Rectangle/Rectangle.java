package Java_OOP_June_2024._01_Working_with_Abstraction._01_Lab._02_Point_In_Rectangle;

public class Rectangle {

    private final Point bottomLeft;
    private final Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Rectangle(int bottomLeftX, int bottomLeftY, int topRightX, int topRightY) {
        this.bottomLeft = new Point(bottomLeftX, bottomLeftY);
        this.topRight = new Point(topRightX, topRightY);
    }

    public boolean contains(Point point) {
        return point.getX() >= bottomLeft.getX() && point.getX() <= topRight.getX() &&
                point.getY() >= bottomLeft.getY() && point.getY() <= topRight.getY();
    }
}
