package Java_OOP_June_2024._05_Polymorphism._03_Exercise._04_Calculator;

import java.util.ArrayList;
import java.util.List;

public class DivideOperation implements Operation {
    private List<Integer> operands;
    private int result;

    public DivideOperation() {
        this.operands = new ArrayList<>();
    }

    @Override
    public void addOperand(int operand) {
        this.operands.add(operand);

        if (isCompleted()) {
            this.result = this.operands.get(0) / this.operands.get(1);
        }
    }

    @Override
    public int getResult() {
        return this.result;
    }

    @Override
    public boolean isCompleted() {
        return this.operands.size() == 2;
    }
}
