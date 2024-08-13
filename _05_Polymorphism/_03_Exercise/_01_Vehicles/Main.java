package Java_OOP_June_2024._05_Polymorphism._03_Exercise._01_Vehicles;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    private static Vehicle car = null;
    private static Vehicle truck = null;
    private static String[] data = null;
    private final static Scanner scan = new Scanner(System.in);
    private static final DecimalFormat dm = new DecimalFormat("#.##");

    public static void main(String[] args) {
        executeCommand();
        createCar();
        executeCommand();
        createTruck();

        applyVehicleCommand(Integer.parseInt(scan.nextLine()));

        System.out.println(car);
        System.out.println(truck);
    }

    private static void createTruck() {
        truck = new Truck(Double.parseDouble(data[1]), Double.parseDouble(data[2]));
    }

    private static void createCar() {
        car = new Car(Double.parseDouble(data[1]), Double.parseDouble(data[2]));
    }

    private static void executeCommand() {
        data = scan.nextLine().split("\\s+");
    }

    private static void applyVehicleCommand(int num) {
        for (int i = 0; i < num; i++) {
            executeCommand();
            if (data[0].equals("Drive")) {
                driveVehicle(data);
            } else {
                refuelVehicle(data);
            }
        }
    }

    private static void refuelVehicle(String[] command) {
        double refuelAmount = Double.parseDouble(command[2]);
        if (command[1].equals("Car")) {
            car.refuel(refuelAmount);
        } else {
            truck.refuel(refuelAmount);
        }
    }

    private static void driveVehicle(String[] command) {
        if (command[1].equals("Car")) {
            System.out.println(car.drive(Double.parseDouble(command[2])));
        } else {
            System.out.println(truck.drive(Double.parseDouble(command[2])));
        }
    }
}
