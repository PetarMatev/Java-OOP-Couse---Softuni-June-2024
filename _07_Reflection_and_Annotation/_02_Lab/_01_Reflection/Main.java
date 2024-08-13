package Java_OOP_June_2024._07_Reflection_and_Annotation._02_Lab._01_Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Reflection> reflection = Reflection.class;

        // This class type
        System.out.println(reflection);

        // Super class type
        Class<? super Reflection> superClass = reflection.getSuperclass();
        System.out.println(superClass);

        // All interfaces that are implemented by this class
        Class[] interfaces = reflection.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        // Instantiate object using reflection and print it too
        Object reflectionObject = reflection.getDeclaredConstructor().newInstance();
        System.out.println(reflectionObject);


    }
}
