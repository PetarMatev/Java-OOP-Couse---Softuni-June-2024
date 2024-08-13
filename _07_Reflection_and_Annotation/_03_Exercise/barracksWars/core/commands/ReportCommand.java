package Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.core.commands;

import Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.interfaces.Repository;
import Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class ReportCommand extends Command {
    public ReportCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        return getRepository().getStatistics();
    }
}
