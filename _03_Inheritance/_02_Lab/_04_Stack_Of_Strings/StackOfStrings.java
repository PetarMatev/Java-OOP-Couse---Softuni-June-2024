package Java_OOP_June_2024._03_Inheritance._02_Lab._04_Stack_Of_Strings;

import java.util.ArrayList;

public class StackOfStrings {

    // Composition
    private ArrayList<String> data;

    // delegation
    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    // delegation
    public void push(String item) {
        data.add(item);
    }

    // delegation
    public String pop() {
        return data.remove(data.size() - 1);
    }

    // delegation
    public String peek() {
        return data.get(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
