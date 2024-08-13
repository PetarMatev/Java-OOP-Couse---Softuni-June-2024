package Java_OOP_June_2024._02_Encapsulation._03_Exercise._04_Pizza_Calories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] pizzaInfo = scan.nextLine().split("\\s+");
        String pizzaName = pizzaInfo[1];
        int numberOfToppings = Integer.parseInt(pizzaInfo[2]);
        Pizza pizza = new Pizza(pizzaName, numberOfToppings);

        String[] doughInfo = scan.nextLine().split("\\s+");
        String flourType = doughInfo[1];
        String bakingTechnique = doughInfo[2];
        double weightInGrams = Double.parseDouble(doughInfo[3]);
        Dough dough = new Dough(flourType, bakingTechnique, weightInGrams);

        pizza.setDough(dough);

        String command = scan.nextLine();
        while (!command.equals("END")) {
            String[] toppingInfo = command.split("\\s+");
            String toppingType = toppingInfo[1];
            double weightGrams = Double.parseDouble(toppingInfo[2]);
            Topping topping = new Topping(toppingType, weightGrams);
            pizza.addTopping(topping);
            command = scan.nextLine();
        }


        System.out.println(pizza);
    }
}
