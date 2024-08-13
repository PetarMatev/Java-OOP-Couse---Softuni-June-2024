package Java_OOP_June_2024._05_Polymorphism._03_Exercise._02_Vehicle_Extension;

import java.text.DecimalFormat;

public class Truck extends Vehicle {


    public Truck(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        increaseFuelConsumption();
    }

    private void increaseFuelConsumption() {
        super.fuelConsumption = super.fuelConsumption + 1.6;
    }

    @Override
    public String drive(Double distance) {
        if (super.fuelQuantity >= distance * super.fuelConsumption) {
            super.fuelQuantity -= distance * super.fuelConsumption;
            DecimalFormat dm = new DecimalFormat("#.##");
            return String.format("Truck travelled %s km", dm.format(distance));
        }
        return "Truck needs refueling";
    }

    @Override
    public void refuel(Double liters) {
        if (liters <= 0) {
            errorMessage = "Fuel must be a positive number";
        } else if ((fuelQuantity + liters * 0.95) > tankCapacity) {
            errorMessage = "Cannot fit fuel in tank";
        } else {
            super.fuelQuantity += liters * 0.95;
            errorMessage = null;
        }
    }

    @Override
    public String toString() {
        return String.format("Truck: %.2f", getFuelQuantity());
    }
}
