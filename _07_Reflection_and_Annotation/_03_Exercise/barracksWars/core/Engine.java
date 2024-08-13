package Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.core;

import Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.core.commands.CommandInterpreterImpl;
import Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.interfaces.Executable;
import Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.interfaces.Repository;
import Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.interfaces.Runnable;
import Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {
    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];

                CommandInterpreterImpl commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);
                Executable executable = (Executable) commandInterpreter.interpretCommand(data, commandName);
                String result = executable.execute();

                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException | ClassNotFoundException |
                     NoSuchMethodException | InvocationTargetException | IllegalAccessException |
                     InstantiationException | ExecutionControl.NotImplementedException e) {
                e.printStackTrace();
            }
        }
    }


}
