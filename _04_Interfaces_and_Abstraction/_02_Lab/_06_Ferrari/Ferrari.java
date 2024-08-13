package Java_OOP_June_2024._04_Interfaces_and_Abstraction._02_Lab._06_Ferrari;

public class Ferrari implements Car {

    private String driverName;
    private static final String MODEL = "488-Spider";

    public Ferrari(String driverName) {
        setDriverName(driverName);

    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String brakes() {
        return "Brakes!";
    }

    @Override
    public String gas() {
        return "brum-brum-brum-brrrrr";
    }

    @Override
    public String toString() {
        return MODEL + "/" +
                this.brakes() + "/" +
                this.gas() + "/" +
                this.getDriverName();
    }
}
