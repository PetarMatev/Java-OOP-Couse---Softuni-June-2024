package Java_OOP_June_2024._05_Polymorphism._03_Exercise._01_Vehicles;

public abstract class Vehicle {

    protected Double fuelQuantity;
    protected Double fuelConsumption;

    public Vehicle(Double fuelQuantity, Double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
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

    public  void refuel(Double liters) {
        fuelQuantity += liters;
    }
}
