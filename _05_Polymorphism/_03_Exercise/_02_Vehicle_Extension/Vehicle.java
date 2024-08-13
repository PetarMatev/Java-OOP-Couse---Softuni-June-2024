package Java_OOP_June_2024._05_Polymorphism._03_Exercise._02_Vehicle_Extension;

public abstract class Vehicle {

    protected Double fuelQuantity;
    protected Double fuelConsumption;
    protected Double tankCapacity;
    protected String errorMessage;
    protected boolean checkForPassengers;

    public Vehicle(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
        this.errorMessage = null;
        this.checkForPassengers = true;
    }

    public Double getFuelQuantity() {
        return fuelQuantity;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public void amendFuel(Double reduction) {
        this.fuelQuantity = this.fuelQuantity - reduction;
    }

    public abstract String drive(Double distance);

    public void checkForErrorMessages() {
        if (errorMessage != null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public void refuel(Double liters) {
        if (liters <= 0) {
            errorMessage = "Fuel must be a positive number";
        } else if ((fuelQuantity + liters) > tankCapacity) {
            errorMessage = "Cannot fit fuel in tank";
        } else {
            fuelQuantity += liters;
            errorMessage = null;
        }
    }

    protected void checkForPassengers() {
    }
}
