package Java_OOP_June_2024._05_Polymorphism._03_Exercise._02_Vehicle_Extension;

import java.text.DecimalFormat;

public class Bus extends Vehicle {


    public Bus(Double fuelQuantity, Double fuelConsumption, Double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        increaseFuelConsumption();
    }

    @Override
    public void checkForPassengers() {
        super.checkForPassengers();
    }

    private void increaseFuelConsumption() {
        if (super.checkForPassengers) {
            super.fuelConsumption += 1.4;
        }
    }

    @Override
    public String drive(Double distance) {
        double getMaxDistance = distance * super.fuelConsumption;
        if (super.fuelQuantity >= getMaxDistance) {
            super.fuelQuantity -= distance * super.fuelConsumption;
            DecimalFormat dm = new DecimalFormat("#.##");
            return String.format("Bus travelled %s km", dm.format(distance));
        }
        return "Bus needs refueling";
    }

    @Override
    public String toString() {
        return String.format("Bus: %.2f", getFuelQuantity());
    }
}
