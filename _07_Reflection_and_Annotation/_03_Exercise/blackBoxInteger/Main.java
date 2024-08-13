package Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

    private static BlackBoxInt myObject;

    public static <myObject> void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scan = new Scanner(System.in);
        Class<BlackBoxInt> reflection = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = reflection.getDeclaredConstructor();
        constructor.setAccessible(true);
        myObject = (BlackBoxInt) constructor.newInstance();
        Field field = reflection.getDeclaredField("innerValue");
        field.setAccessible(true);

        while (true) {
            String command = scan.nextLine();
            if (command.equals("END")) {
                break;
            }
            String[] info = command.split("_");
            switch (info[0]) {
                case "add" -> {
                    manipulateValue(reflection, "add", Integer.parseInt(info[1]), field);
                }
                case "subtract" -> {
                    manipulateValue(reflection, "subtract", Integer.parseInt(info[1]), field);
                }
                case "divide" -> {
                    manipulateValue(reflection, "divide", Integer.parseInt(info[1]), field);
                }
                case "multiply" -> {
                    manipulateValue(reflection, "multiply", Integer.parseInt(info[1]), field);
                }
                case "leftShift" -> {
                    manipulateValue(reflection, "leftShift", Integer.parseInt(info[1]), field);
                }
                case "rightShift" -> {
                    manipulateValue(reflection, "rightShift", Integer.parseInt(info[1]), field);
                }
            }
        }

    }

    private static void manipulateValue(Class<BlackBoxInt> reflection, String name, int value, Field field) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method method = reflection.getDeclaredMethod(name, int.class);
        method.setAccessible(true);
        method.invoke(myObject, value);
        System.out.println(field.get(myObject));
    }
}
