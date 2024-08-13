package busyWaiters;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class RestaurantTests {

    private Restaurant restaurant;
    private FullTimeWaiter worker;

    @BeforeEach
    public void setUp() {
        restaurant = new Restaurant("BestRestaurant", 100);
        worker = new FullTimeWaiter("Petar", 3);
    }

    @Test
    public void constructor_TEST() {
        assertEquals(100, restaurant.getCapacity());
        assertEquals("BestRestaurant", restaurant.getName());
    }

    @Test
    public void constructor_TEST_Throws_With_InvalidName() {
        assertThrows(NullPointerException.class, () -> {
            Restaurant newRestaurant = new Restaurant(null, 10);
        });
    }

    @Test
    public void constructor_TEST_Throws_With_InvalidCapacity() {
        assertThrows(IllegalArgumentException.class, () -> {
            Restaurant newRestaurantTwo = new Restaurant("happy", -10);
        });
    }

    @Test
    public void addFullTimeWorker_SUCCESSFUL_ATTEMPT() {
        restaurant.addFullTimeWaiter(worker);
        assertEquals(1, restaurant.getCount());
    }

    @Test
    public void addFullTimeWorker_THROWS_WHEN_CAPACITY_IS_EQUAL_TO_ZERO() {
        assertThrows(IllegalArgumentException.class, () -> {
            Restaurant happyVarna = new Restaurant("Happy", 0);
            happyVarna.addFullTimeWaiter(worker);
        });
    }

    @Test
    public void addFullTimeWorker_THROWS_WHEN_CAPACITY_EQUALS_WAITERS_SIZE() {
        Restaurant happyBurgas = new Restaurant("HappyBurgas", 1);
        FullTimeWaiter secondWorker = new FullTimeWaiter("Bogdan", 10);
        assertThrows(IllegalArgumentException.class, () -> {
            happyBurgas.addFullTimeWaiter(worker);
            happyBurgas.addFullTimeWaiter(secondWorker);
        });
    }

    @Test
    public void addFullTimeWorker_THROWS_When_WAITER_ALREADY_EXISTS() {
        assertThrows(IllegalArgumentException.class, () -> {
            restaurant.addFullTimeWaiter(worker);
            restaurant.addFullTimeWaiter(worker);
        });
    }

    @Test
    public void removeFULLTIMEWORKER_TEST() {
        restaurant.addFullTimeWaiter(worker);
        assertTrue(restaurant.removeFullTimeWaiter("Petar"));
    }

    @Test
    public void testing_Getter_for_Efficiency_of_Worker() {
        assertEquals(3, worker.getEfficiency());
    }

    @Test
    public void testing_getting_the_name_of_the_worker() {
        assertEquals( "Petar", worker.getName());
    }

    @Test
    public void test_WaitersCollectionEmptyListOfArray() {
        Collection<FullTimeWaiter> waiters;
        waiters = new ArrayList<>();

        assertEquals(waiters, restaurant.getWaiters());

    }
}
