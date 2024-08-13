package scubaDive;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DivingTests {

    DeepWaterDiver diver;
    Diving blackSea;

    @BeforeEach
    public void setUp() {
        diver = new DeepWaterDiver("Petar", 35);
        blackSea = new Diving("BlackSea", 2);
    }

    @Test
    public void test_getting_The_name_of_the_Diver() {
        assertEquals("Petar", diver.getName());
    }

    @Test
    public void test_getting_the_OxygenLevel_of_the_Diver() {
        assertEquals(35, diver.getOxygen());
    }

    @Test
    public void testConstructor_should_Throw_when_name_is_NULL() {
        assertThrows(NullPointerException.class, () -> {
            Diving atlantic = new Diving(null, 50);
        });
    }

    @Test
    public void testConstructor_should_Throw_when_name_is_Empty() {
        assertThrows(NullPointerException.class, () -> {
            Diving atlantic = new Diving("", 50);
        });
    }

    @Test
    public void testConstructor_should_Throw_when_Capacity_IS_LESS_THAN_ZERO() {
        assertThrows(IllegalArgumentException.class, () -> {
            Diving atlantic = new Diving("Atlantic", -50);
        });
    }

    @Test
    public void test_removing_diver_from_theDivingSPot() {
        blackSea.addDeepWaterDiver(diver);
        String get_Name_To_Be_REMOVED = diver.getName();
        assertTrue(blackSea.removeDeepWaterDiver(get_Name_To_Be_REMOVED));
    }

    @Test
    public void test_trying_to_add_diver_to_diving_spot_but_throws_when_duplicates_attempted() {
        assertThrows(IllegalArgumentException.class, () -> {
            blackSea.addDeepWaterDiver(diver);
            blackSea.addDeepWaterDiver(diver);
        });
    }

    @Test
    public void test_trying_to_add_diver_to_diving_spot_but_throws_when_number_of_Divers_equals_capacity() {
        assertThrows(IllegalArgumentException.class, () -> {
            blackSea.addDeepWaterDiver(diver);
            DeepWaterDiver diverTwo = new DeepWaterDiver("Ivan", 30);
            blackSea.addDeepWaterDiver(diverTwo);
            DeepWaterDiver diverThree = new DeepWaterDiver("Petkan", 28);
            blackSea.addDeepWaterDiver(diverThree);
        });
    }
}
