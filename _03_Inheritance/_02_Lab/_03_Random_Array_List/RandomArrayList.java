package Java_OOP_June_2024._03_Inheritance._02_Lab._03_Random_Array_List;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class RandomArrayList<T> extends ArrayList<T> {

    public T getRandomElement() {
        int index = ThreadLocalRandom.current()
                .nextInt(0, size());
        return remove(index);
    }


}
