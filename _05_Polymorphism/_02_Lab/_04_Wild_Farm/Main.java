package Java_OOP_June_2024._05_Polymorphism._02_Lab._04_Wild_Farm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String info = scan.nextLine();

        List<Animal> animals = new ArrayList<>();


        while (!info.equals("End")) {

            Animal animal = createAnimal(info);
            Food food = createFood(scan);
            animal.makeSound();
            animal.eat(food);
            animals.add(animal);

            info = scan.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }

    public static Food createFood(Scanner scan) {
        String[] foodInfo = scan.nextLine().split("\\s+");
        String foodType = foodInfo[0];
        int quantity = Integer.parseInt(foodInfo[1]);

        Food food = null;

        if (foodType.equals("Vegetable")) {
            food = new Vegetable(quantity);
        } else {
            food = new Meat(quantity);
        }
        return food;
    }

    public static Animal createAnimal(String info) {
        String[] commandLine = info.split("\\s+");
        String animalType = commandLine[0];
        String animalName = commandLine[1];
        Double animalWeight = Double.parseDouble(commandLine[2]);
        String animalLivingRegion = commandLine[3];

        Animal animal = null;

        if (animalType.equals("Cat")) {
            String animalBreed = commandLine[4];
            animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, animalBreed);
        } else if (animalType.equals("Tiger")) {
            animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
        } else if (animalType.equals("Zebra")) {
            animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
        } else if (animalType.equals("Mouse")) {
            animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
        }
        return animal;
    }
}
