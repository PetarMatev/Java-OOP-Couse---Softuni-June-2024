package _03_Shopping_Spree;

import Java_OOP_June_2024._02_Encapsulation._03_Exercise._03_Shopping_Spree.Person;
import Java_OOP_June_2024._02_Encapsulation._03_Exercise._03_Shopping_Spree.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Person> listOfPeople = new ArrayList<>();
        List<Product> listOfProducts = new ArrayList<>();
        String[] people = scan.nextLine().split(";");
        String[] products = scan.nextLine().split(";");

        for (int i = 0; i < people.length; i++) {
            String[] info = people[i].split("=");
            String name = info[0];
            int money = Integer.parseInt(info[1]);
            try {
                Person person = new Person(name, money);
                listOfPeople.add(person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        for (int i = 0; i < products.length; i++) {
            String[] productInfo = products[i].split("=");
            String productName = productInfo[0];
            int productCost = Integer.parseInt(productInfo[1]);
            try {
                Product product = new Product(productName, productCost);
                listOfProducts.add(product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String command = scan.nextLine();
        while (!command.equals("END")) {
            String currentPerson = command.split("\\s+")[0];
            String currentProduct = command.split("\\s+")[1];

            Person searchedPerson = listOfPeople.stream().filter(e -> e.getName().equals(currentPerson)).findFirst().orElse(null);
            Product searchedProduct = listOfProducts.stream().filter(p -> p.getName().equals(currentProduct)).findFirst().orElse(null);
            try {
                searchedPerson.buyProduct(searchedProduct);
                System.out.println(currentPerson + " bought " + currentProduct);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            command = scan.nextLine();
        }

        listOfPeople.forEach(e -> System.out.println(e));
    }
}
