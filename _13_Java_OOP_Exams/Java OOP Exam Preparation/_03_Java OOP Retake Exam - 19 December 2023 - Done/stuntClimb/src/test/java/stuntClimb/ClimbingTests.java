package stuntClimb;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClimbingTests {

    Climbing climbing;
    RockClimber rockClimber;

    @BeforeEach
    public void setUp() {
        climbing = new Climbing("Everest", 20);
        rockClimber = new RockClimber("Petar", 100);
    }

    @Test
    public void test_getting_the_name_of_the_rockClimber() {
        assertEquals("Petar", rockClimber.getName());
    }

    @Test
    public void test_getting_the_Strength_of_the_Rock_Climber() {
        assertEquals(100, rockClimber.getStrength());
    }

    @Test
    public void test_getting_the_Counter_of_climbers_of_this_mountain() {
        climbing.addRockClimber(rockClimber);
        assertEquals(1, climbing.getCount());
    }

    @Test
    public void test_getting_the_Name_of_the_mountain() {
        assertEquals("Everest", climbing.getName());
    }

    @Test
    public void test_getting_the_capacity_of_theMountain() {
        assertEquals(20, climbing.getCapacity());
    }

    @Test
    public void Successfully_constructing_our_Constructor() {
        climbing.addRockClimber(rockClimber);
        assertEquals(1, climbing.getCount());
    }

    @Test
    public void constructor_Throws_when_name_is_Null() {
        assertThrows(NullPointerException.class, () -> {
            Climbing everest = new Climbing(null, 2);
        });
    }

    @Test
    public void constructor_Throws_when_name_is_Empty() {
        assertThrows(NullPointerException.class, () -> {
            Climbing everest = new Climbing("", 2);
        });
    }

    @Test
    public void constructor_Throws_when_Capacity_isLess_than_Zero() {
        assertThrows(IllegalArgumentException.class, () -> {
            Climbing everest = new Climbing("Everest", -10);
        });
    }

    @Test
    public void testing_Boolean_Result_when_rockClimber_has_been_removed_Successfully() {
        climbing.addRockClimber(rockClimber);
        String rockClimberNameToBeRemoved = rockClimber.getName();
        assertTrue(climbing.removeRockClimber(rockClimberNameToBeRemoved));
    }

    @Test
    public void testingAddRockClimber_Should_Throw_When_Capacity_is_equal_Size_ofLIst() {
        assertThrows(IllegalArgumentException.class, () -> {
            Climbing K2 = new Climbing("K2", 1);
            RockClimber Petar = new RockClimber("Petar", 20);
            RockClimber Radina = new RockClimber("Radina", 30);
            K2.addRockClimber(Petar);
            K2.addRockClimber(Radina);
        });
    }

    @Test
    public void testingAddRockClimber_Should_Throw_When_TryAdd_already_Added_CLIMBER() {
        assertThrows(IllegalArgumentException.class, () -> {
            Climbing K2 = new Climbing("K2", 1);
            RockClimber Petar = new RockClimber("Petar", 20);
            K2.addRockClimber(Petar);
            K2.addRockClimber(Petar);
        });
    }
}
