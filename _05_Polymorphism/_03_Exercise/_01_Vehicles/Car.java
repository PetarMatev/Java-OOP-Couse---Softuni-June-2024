package Java_OOP_June_2024._05_Polymorphism._03_Exercise._01_Vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    public Car(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        increaseFuelConsumption();
    }

    private void increaseFuelConsumption() {
        super.fuelConsumption += 0.9;
    }

    @Override
    public String drive(Double distance) {
        double getMaxDistance = distance * super.fuelConsumption;
        if (super.fuelQuantity >= getMaxDistance) {
            super.fuelQuantity -= distance * super.fuelConsumption;
            DecimalFormat dm = new DecimalFormat("#.##");
            return String.format("Car travelled %s km", dm.format(distance));
        }
        return "Car needs refueling";
    }

    @Override
    public String toString() {
        return String.format("Car: %.2f", getFuelQuantity());
    }
}

