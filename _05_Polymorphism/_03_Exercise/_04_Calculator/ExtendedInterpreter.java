package Java_OOP_June_2024._05_Polymorphism._03_Exercise._04_Calculator;

public class ExtendedInterpreter extends InputInterpreter {
    private MemoryStorageOperation memoryStorage;

    public ExtendedInterpreter(CalculationEngine engine) {
        super(engine);
        this.memoryStorage = new MemoryStorageOperation();
    }

    public Operation getOperation(String operation) {
        return switch (operation) {
            case "/" -> new DivideOperation();
            case "mr" -> new MemoryRecallOperation(memoryStorage);
            case "ms" -> this.memoryStorage;
            default -> super.getOperation(operation);
        };
    }
}
