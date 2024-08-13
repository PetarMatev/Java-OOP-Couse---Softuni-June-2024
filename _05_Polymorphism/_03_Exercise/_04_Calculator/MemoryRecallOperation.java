package Java_OOP_June_2024._05_Polymorphism._03_Exercise._04_Calculator;

public class MemoryRecallOperation implements Operation {
    private MemoryStorageOperation memoryStorage;

    public MemoryRecallOperation(MemoryStorageOperation memoryStorage) {
        this.memoryStorage = memoryStorage;
    }

    @Override
    public void addOperand(int operand) {
    }

    @Override
    public int getResult() {
        return this.memoryStorage.getResult();
    }

    @Override
    public boolean isCompleted() {
        return true;
    }
}
