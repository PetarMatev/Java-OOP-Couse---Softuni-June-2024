package Java_OOP_June_2024._05_Polymorphism._03_Exercise._04_Calculator;

public class Extensions {

    // util class
    private Extensions() {

    }

    public static InputInterpreter buildInterpreter(CalculationEngine engine) {
        return new ExtendedInterpreter(engine);
    }
}
