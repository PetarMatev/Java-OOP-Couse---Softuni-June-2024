package Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars;

import Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.core.Engine;
import Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.core.factories.UnitFactoryImpl;
import Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.data.UnitRepository;
import Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.interfaces.Repository;
import Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.interfaces.Runnable;
import Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
