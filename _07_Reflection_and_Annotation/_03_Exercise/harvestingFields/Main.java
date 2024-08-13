package Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.harvestingFields;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        Class<RichSoilLand> reflection = RichSoilLand.class;

        while (true) {
            String command = scan.nextLine();
            if (command.equals("HARVEST")) {
                break;
            }

            switch (command) {
                case "private" -> getPrivateDetails(reflection);
                case "protected" -> getProtectedDetails(reflection);
                case "public" -> getPublicDetails(reflection);
                case "all" -> getAllDetails(reflection);
            }
        }
    }


    private static void getPrivateDetails(Class<RichSoilLand> reflection) {
        Arrays.stream(reflection.getDeclaredFields()).filter(f -> Modifier.isPrivate(f.getModifiers()))
                .forEach(f -> System.out.println("private " + f.getType().getSimpleName() + " " + f.getName()));
    }

    private static void getProtectedDetails(Class<RichSoilLand> reflection) {
        Arrays.stream(reflection.getDeclaredFields()).filter(f -> Modifier.isProtected(f.getModifiers()))
                .forEach(f -> System.out.println("protected " + f.getType().getSimpleName() + " " + f.getName()));
    }

    private static void getPublicDetails(Class<RichSoilLand> reflection) {
        Arrays.stream(reflection.getDeclaredFields()).filter(f -> Modifier.isPublic(f.getModifiers()))
                .forEach(f -> System.out.println("public " + f.getType().getSimpleName() + " " + f.getName()));
    }

    private static void getAllDetails(Class<RichSoilLand> reflection) {
        Arrays.stream(reflection.getDeclaredFields())
                .filter(f -> Modifier.isPrivate(f.getModifiers())
                        || Modifier.isProtected(f.getModifiers())
                        || Modifier.isPublic(f.getModifiers()))
                .forEach(f -> System.out.println(
                        Modifier.toString(f.getModifiers()) + " " + f.getType().getSimpleName() + " " + f.getName()));
    }
}
