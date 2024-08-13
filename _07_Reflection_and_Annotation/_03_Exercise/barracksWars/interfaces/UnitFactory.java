package Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.interfaces;

import jdk.jshell.spi.ExecutionControl;

public interface UnitFactory {

    Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException, ClassNotFoundException;
}