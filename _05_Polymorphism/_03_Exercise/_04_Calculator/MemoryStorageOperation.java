package Java_OOP_June_2024._05_Polymorphism._03_Exercise._04_Calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class MemoryStorageOperation implements Operation {
    private Deque<Integer> memory;

    public MemoryStorageOperation() {
        this.memory = new ArrayDeque<>();
    }

    @Override
    public void addOperand(int operand) {
        memory.push(operand);
    }

    @Override
    public int getResult() {
        return memory.pop();
    }

    @Override
    public boolean isCompleted() {
        return false;
    }
}
