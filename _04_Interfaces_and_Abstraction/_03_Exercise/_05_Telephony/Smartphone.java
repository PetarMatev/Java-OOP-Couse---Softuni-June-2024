package Java_OOP_June_2024._04_Interfaces_and_Abstraction._03_Exercise._05_Telephony;

import java.util.List;
import java.util.regex.Pattern;

public class Smartphone implements Browsable, Callable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile(".*\\d.*");

        for (String site : urls) {
            if (pattern.matcher(site).matches()) {
                stringBuilder.append("Invalid URL!").append(System.lineSeparator());
            } else {
                stringBuilder.append("Browsing: ").append(site).append("!").append(System.lineSeparator());
            }
        }
        return stringBuilder.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder stringBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("\\D");

        for (String number : numbers) {
            if (pattern.matcher(number).find()) {
                stringBuilder.append("Invalid number!").append(System.lineSeparator());
            } else {
                stringBuilder.append("Calling... ").append(number).append(System.lineSeparator());
            }
        }
        return stringBuilder.toString().trim();
    }
}
