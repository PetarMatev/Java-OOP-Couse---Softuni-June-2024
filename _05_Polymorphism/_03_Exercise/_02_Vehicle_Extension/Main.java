package Java_OOP_June_2024._05_Polymorphism._03_Exercise._02_Vehicle_Extension;

import java.util.Scanner;

public class Main {

    private static Vehicle car = null;
    private static Vehicle truck = null;
    private static Vehicle bus = null;
    private static String[] data = null;
    private final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        executeCommand();
        createCar();
        executeCommand();
        createTruck();
        executeCommand();
        createBus();

        applyVehicleCommand(Integer.parseInt(scan.nextLine()));

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }

    private static void createTruck() {
        truck = new Truck(Double.parseDouble(data[1]), Double.parseDouble(data[2]), Double.parseDouble(data[3]));
    }

    private static void createCar() {
        car = new Car(Double.parseDouble(data[1]), Double.parseDouble(data[2]), Double.parseDouble(data[3]));
    }

    private static void createBus() {
        bus = new Bus(Double.parseDouble(data[1]), Double.parseDouble(data[2]), Double.parseDouble(data[3]));
    }

    private static void executeCommand() {
        data = scan.nextLine().split("\\s+");
    }

    private static void applyVehicleCommand(int num) {
        for (int i = 0; i < num; i++) {
            executeCommand();
            switch (data[0]) {
                case "Drive" -> driveVehicle(data);
                case "Refuel" -> refuelVehicle(data);
                case "DriveEmpty" -> {
                    bus.checkForPassengers = false;
                    driveVehicle(data);
                    bus.checkForPassengers = true;
                }
            }
        }
    }

    private static void refuelVehicle(String[] command) {
        double refuelAmount = Double.parseDouble(command[2]);
        switch (command[1]) {
            case "Car" -> tryToRefuel(car, refuelAmount);
            case "Truck" -> tryToRefuel(truck, refuelAmount);
            case "Bus" -> tryToRefuel(bus, refuelAmount);
        }
    }

    private static void tryToRefuel(Vehicle vehicle, double refuelAmount) {
        try {
            vehicle.refuel(refuelAmount);
            vehicle.checkForErrorMessages();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void driveVehicle(String[] command) {
        switch (command[1]) {
            case "Car" -> System.out.println(car.drive(Double.parseDouble(command[2])));
            case "Truck" -> System.out.println(truck.drive(Double.parseDouble(command[2])));
            case "Bus" -> System.out.println(bus.drive(Double.parseDouble(command[2])));
        }

    }
}
