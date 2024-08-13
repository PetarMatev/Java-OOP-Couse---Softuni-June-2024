package Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.core.commands;

import Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.interfaces.CommandInterpreter;
import Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.interfaces.Executable;
import Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.interfaces.Repository;
import Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String UNITS_PACKAGE_NAME =
            "barracksWars.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;


    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand (String[] data, String commandName) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        String className = UNITS_PACKAGE_NAME +
                Character.toUpperCase(commandName.charAt(0)) +
                commandName.substring(1) +
                "Command";
        Class<Command> commandClazz = (Class<Command>) Class.forName(className);
        Constructor<Command> con = commandClazz.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
        return con.newInstance(data, repository, unitFactory);
    }
}
