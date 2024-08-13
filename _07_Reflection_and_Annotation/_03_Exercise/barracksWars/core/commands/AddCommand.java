package Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.core.commands;

import Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.interfaces.Repository;
import Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.interfaces.Unit;
import Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class AddCommand extends Command {
    public AddCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }


    @Override
    public String execute() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ExecutionControl.NotImplementedException, ClassNotFoundException {
        String unitType = getData()[1];
        Unit unitToAdd = getUnitFactory().createUnit(unitType);
        this.getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
