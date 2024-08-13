package Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.interfaces;

import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public interface Executable {

	String execute() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ExecutionControl.NotImplementedException, ClassNotFoundException;

}
