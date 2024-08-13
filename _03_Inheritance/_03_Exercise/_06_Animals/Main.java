package Java_OOP_June_2024._03_Inheritance._03_Exercise._06_Animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;

public class Main {

    private static final List<Animal> listOfAnimals = new ArrayList<>();
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            executeFirstLin();
            String command = scan.nextLine();
            if (command.equals("Beast!")) {
                break;
            }

            String animalType = command;
            String[] info = secondInputCommand();
            String name = info[0];
            int age = Integer.parseInt(info[1]);
            String gender = info[2];

            createAnimal(animalType, name, age, gender);
        }

        iterateOverAnimals();
    }
    private static void executeFirstLin() {

    }

    private static void createAnimal(String animalType, String name, int age, String gender) {
        switch (animalType) {
            case "Dog":
                addAnimalToList(() -> new Dog(name, age, gender), listOfAnimals);
                break;
            case "Cat":
                addAnimalToList(() -> new Cat(name, age, gender), listOfAnimals);
                break;
            case "Frog":
                addAnimalToList(() -> new Frog(name, age, gender), listOfAnimals);
                break;
            case "Kitten":
                addAnimalToList(() -> new Kitten(name, age), listOfAnimals);
                break;
            case "Tomcat":
                addAnimalToList(() -> new Tomcat(name, age), listOfAnimals);
                break;
        }
    }

    private static String[] secondInputCommand() {
        String[] info = scan.nextLine().split("\\s+");
        return info;
    }

    private static void iterateOverAnimals() {
        for (Animal currentAnnimal : listOfAnimals) {
            System.out.println(currentAnnimal);
        }
    }

    private static void addAnimalToList(Supplier<Animal> animalSupplier, List<Animal> listOfAnimals) {
        try {
            Animal animal = animalSupplier.get();
            listOfAnimals.add(animal);
        } catch (Exception exception) {
            System.out.println(ExceptionMessages.INVALID_INPUT);
        }
    }
}
