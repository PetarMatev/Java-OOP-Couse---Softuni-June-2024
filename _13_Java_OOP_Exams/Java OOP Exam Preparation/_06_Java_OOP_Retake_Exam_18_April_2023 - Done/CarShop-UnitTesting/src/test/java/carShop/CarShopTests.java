package carShop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class CarShopTests {


    CarShop audiShop;
    Car AudiA8;

    @BeforeEach
    public void setUp() {
        AudiA8 = new Car("A8", 300, 150000.00);
        audiShop = new CarShop();
    }

    @Test
    public void test_getModel_of_the_CAR() {
        assertEquals("A8", AudiA8.getModel());
    }

    @Test
    public void test_getPrice_of_the_CAR() {
        assertEquals(150000.00, AudiA8.getPrice());
    }

    @Test
    public void test_getHorsePower_of_the_CAR() {
        assertEquals(300, AudiA8.getHorsePower());
    }

    @Test
    public void test_GetCount_of_theList_ofCars_in_the_Shop() {
        Car AudiA6 = new Car("A6", 200, 30000.00);
        audiShop.add(AudiA8);
        audiShop.add(AudiA6);
        assertEquals(2, audiShop.getCount());
    }

    @Test
    public void test_adding_a_Car_Should_Throw__With_NullPointerException_When_car_is_NULL() {
        assertThrows(NullPointerException.class, () -> {
            audiShop.add(null);
        });
    }

    @Test
    public void test_REMOVING_A_CAR_FROM_THE_LIST_OF_CARS() {
        audiShop.add(AudiA8);
        assertTrue(audiShop.remove(AudiA8));
    }

    @Test
    public void test_getting_the_Most_LUXURIOUS_CAR_FROM_THE_LIST_OF_CARS() {
        Car AudiA6 = new Car("A6", 200, 30000.00);
        audiShop.add(AudiA8);
        audiShop.add(AudiA6);
        assertEquals(AudiA8, audiShop.getTheMostLuxuryCar());
    }

    @Test
    public void test_finding_all_the_Cars_by_specific_Model() {
        Car AudiA6 = new Car("A6", 200, 30000.00);
        Car AudiA6Sedan = new Car("A6", 150, 15000.00);
        Car AudiA6Coupe = new Car("A6", 110, 25000.00);
        audiShop.add(AudiA8);
        audiShop.add(AudiA6);
        audiShop.add(AudiA6Sedan);
        audiShop.add(AudiA6Coupe);
        Car[] expectedListOfCars = new Car[]{AudiA6, AudiA6Sedan, AudiA6Coupe};
        Collection<Car> expectedListModified = Collections.unmodifiableList(Arrays.asList(expectedListOfCars));

        assertEquals(3, audiShop.findAllCarByModel("A6").size());
        assertEquals(expectedListModified, audiShop.findAllCarByModel("A6"));
    }

    @Test
    public void test_Finding_ALL_Cars_with_HorsePower_More_Than_Given_HorsePower() {
        Car AudiA6 = new Car("A6", 200, 30000.00);
        Car AudiA6Sedan = new Car("A6", 150, 15000.00);
        Car AudiA6Coupe = new Car("A6", 110, 25000.00);
        audiShop.add(AudiA8);
        audiShop.add(AudiA6);
        audiShop.add(AudiA6Sedan);
        audiShop.add(AudiA6Coupe);

        Car[] expectedCarWithMOreThan190HorsePower = new Car[]{AudiA8, AudiA6};
        Collection<Car> ExpectedList = Collections.unmodifiableList(Arrays.asList(expectedCarWithMOreThan190HorsePower));

        assertEquals(ExpectedList, audiShop.findAllCarsWithMaxHorsePower(190));
    }


}

