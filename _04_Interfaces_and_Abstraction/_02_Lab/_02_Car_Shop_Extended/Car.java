package Java_OOP_June_2024._04_Interfaces_and_Abstraction._02_Lab._02_Car_Shop_Extended;

import java.io.Serializable;

public interface Car extends Serializable {

    int TIRES = 4;

    String getModel();

    String getColor();

    Integer getHorsePower();

    String countryProduced();

}
