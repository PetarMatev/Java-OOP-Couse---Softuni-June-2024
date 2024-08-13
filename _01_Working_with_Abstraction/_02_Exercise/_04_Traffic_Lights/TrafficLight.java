package Java_OOP_June_2024._01_Working_with_Abstraction._02_Exercise._04_Traffic_Lights;

public class TrafficLight {

    private Color color;

    public TrafficLight(Color color) {
        // new TrafficLight
        this.color = color;
    }

    // Chane Color of TrafficLight

    public void changeColor() {
        switch (this.color) {
            case RED:
                this.color = Color.GREEN;
                break;
            case GREEN:
                this.color = Color.YELLOW;
                break;
            case YELLOW:
                this.color = Color.RED;
                break;
        }
    }

    public String getColor() {
        return this.color.name();
    }
}
