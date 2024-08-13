package Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.interfaces;

import java.lang.reflect.InvocationTargetException;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException;
}
