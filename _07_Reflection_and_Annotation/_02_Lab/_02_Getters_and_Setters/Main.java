package Java_OOP_June_2024._07_Reflection_and_Annotation._02_Lab._02_Getters_and_Setters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> reflection = Reflection.class;

        Method[] methods = reflection.getDeclaredMethods();

        Arrays.stream(methods)
                .filter(m -> !m.getName().equals("toString"))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(formatMethodInfo(m)));
    }

    public static String formatMethodInfo(Method m) {
        if (m.getName().startsWith("get")) {
            return m.getName() + " will return class " + m.getReturnType().getName();
        }
        return m.getName() + " and will set field of class " + m.getParameterTypes()[0].getName();
    }
}
