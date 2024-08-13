package Java_OOP_June_2024._04_Interfaces_and_Abstraction._03_Exercise._05_Telephony;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> phoneNumbers = Arrays.stream(getList(scan)).toList();
        List<String> sites = Arrays.stream(getList(scan)).toList();
        Smartphone smartphone = new Smartphone(phoneNumbers, sites);
        makeCalls(smartphone);
        browseWebsites(smartphone);
    }

    private static void browseWebsites(Smartphone smartphone) {
        System.out.println(smartphone.browse());
    }

    private static void makeCalls(Smartphone smartphone) {
        System.out.println(smartphone.call());
    }

    private static String[] getList(Scanner scan) {
        return scan.nextLine().split("\\s+");
    }
}
