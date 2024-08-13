package Java_OOP_June_2024._02_Encapsulation._03_Exercise._03_Shopping_Spree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (!name.trim().isEmpty() && !name.equals(" ")) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty");
        }

    }

    private void setMoney(double money) {
        if (money >= 0) {
            this.money = money;
        } else {
            throw new IllegalArgumentException("Money cannot be negative");
        }
    }

    public String getName() {
        return name;
    }

    public void buyProduct(Product product) {

        if (product.getCost() <= this.money) {
            products.add(product);
            this.money -= product.getCost();
        } else {
            throw new IllegalArgumentException(String.format("%s can't afford %s", getName(), product.getName()));
        }
    }

    @Override
    public String toString() {
        StringBuilder report = new StringBuilder();
        report.append(getName()).append(" - ");
        if (!products.isEmpty()) {
            report.append(products.toString().replaceAll("[\\[|\\]]", ""));
        } else {
            report.append("Nothing bought");
        }
        report.append(System.lineSeparator());
        return report.toString().trim();
    }
}
