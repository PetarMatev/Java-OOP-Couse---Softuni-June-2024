package Java_OOP_June_2024._05_Polymorphism._03_Exercise._01_Vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    public Truck(Double fuelQuantity, Double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        increaseFuelConsumption();
    }

    private void increaseFuelConsumption() {
        super.fuelConsumption = super.fuelConsumption + 1.6;
    }

    @Override
    public String drive(Double distance) {
        double getMaxDistance = distance * super.fuelConsumption;
        if (super.fuelQuantity >= getMaxDistance) {
            super.fuelQuantity -= distance * super.fuelConsumption;
            DecimalFormat dm = new DecimalFormat("#.##");
            return String.format("Truck travelled %s km", dm.format(distance));
        }
        return "Truck needs refueling";
    }

    @Override
    public void refuel(Double liters) {
        super.fuelQuantity += liters * 0.95;
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", getFuelQuantity());
    }
}
