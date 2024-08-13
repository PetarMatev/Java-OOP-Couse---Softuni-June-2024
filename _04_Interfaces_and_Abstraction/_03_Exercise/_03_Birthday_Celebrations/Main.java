package Java_OOP_June_2024._04_Interfaces_and_Abstraction._03_Exercise._03_Birthday_Celebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Birthable> currentList = new ArrayList<>();

        while (true) {
            String command = scan.nextLine();
            if (command.equals("End")) {
                break;
            }

            String[] info = command.split("\\s+");
            String obj = info[0];
            switch (obj) {
                case "Citizen":
                    String name = info[1];
                    int age = Integer.parseInt(info[2]);
                    String id = info[3];
                    String birthDate = info[4];
                    Birthable citizen = new Citizen(name, age, id, birthDate);
                    currentList.add(citizen);

                    break;
                case "Robot":
                    String model = info[1];
                    String robotID = info[2];
                    Identifiable robot = new Robot(robotID, model);
                    break;
                case "Pet":
                    String petName = info[1];
                    String petBirthDate = info[2];
                    Birthable pet = new Pet(petName, petBirthDate);
                    currentList.add(pet);
                    break;
            }

        }

        String specificYear = scan.nextLine();

        for (Birthable birthable : currentList) {
            String year = birthable.getBirthDate().split("/")[2];
            if (year.equals(specificYear)) {
                System.out.println(birthable.getBirthDate());
            }
        }


    }
}
