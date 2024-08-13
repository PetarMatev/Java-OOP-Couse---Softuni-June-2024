package busyWaiters;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RestaurantTests {

    private FullTimeWaiter waiter;
    private Restaurant restaurant;

    @BeforeEach
    public void setUp() {
        waiter = new FullTimeWaiter("Ivan", 5);
        restaurant = new Restaurant("Happy", 2);
    }

    @Test
    public void test_Constructor_Of_Full_Time_Waiter() {
        assertEquals("Ivan", waiter.getName());
        assertEquals(5, waiter.getEfficiency());
    }

    @Test
    public void test_Setting_Name_With_Null_Which_Will_Throw() {
        assertThrows(NullPointerException.class, () -> {
            Restaurant testRestaurant = new Restaurant(null, 5);
        });
    }

    @Test
    public void test_Setting_Name_With_EmptyCell_Which_Will_Throw() {
        assertThrows(NullPointerException.class, () -> {
            Restaurant testRestaurant = new Restaurant("", 5);
        });
    }

    @Test
    public void test_Adding_Capacity_Which_Is_Less_Than_Zero_Which_Will_Throw() {
        assertThrows(IllegalArgumentException.class, () -> {
            Restaurant testRestaurant = new Restaurant("Happy", -100);
        });
    }


    @Test
    public void testing_Getting_Correct_Name_and_Size_of_list_of_Restaurants() {
        assertEquals("Happy", restaurant.getName());
        assertEquals(0, restaurant.getCount());
        assertEquals(2, restaurant.getCapacity());
        assertEquals(0, restaurant.getWaiters().size());
    }

    @Test
    public void testingRemovingWaiter() {
        restaurant.addFullTimeWaiter(waiter);
        String waiterName = waiter.getName();
        restaurant.removeFullTimeWaiter(waiterName);
    }

    @Test
    public void test_adding_Throws_When_no_Capacity() {
        assertThrows(IllegalArgumentException.class, () -> {
            FullTimeWaiter newwaiter = new FullTimeWaiter("ivan", 2);
            restaurant.addFullTimeWaiter(waiter);
            restaurant.addFullTimeWaiter(newwaiter);
            FullTimeWaiter testAddingThird = new FullTimeWaiter("Dragan", 5);
            restaurant.addFullTimeWaiter(testAddingThird);
        });
    }

    @Test
    public void test_adding_Throws_When_Waiter_Alraedy_Exists() {
        assertThrows(IllegalArgumentException.class, () -> {
            restaurant.addFullTimeWaiter(waiter);
            restaurant.addFullTimeWaiter(waiter);
        });
    }
}
