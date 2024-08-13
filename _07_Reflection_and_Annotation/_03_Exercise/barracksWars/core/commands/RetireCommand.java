package Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.core.commands;

import Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.interfaces.Repository;
import Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class RetireCommand extends Command {
    public RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ExecutionControl.NotImplementedException {
        String unitType = getData()[1];
        getRepository().removeUnit(unitType);
        return unitType + " retired!";
    }
}
