package magicGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MagicianTests {

    Magician magician;
    Magic magic;

    @BeforeEach
    public void setUp() {
        magician = new Magician("Petar", 100);
        magic = new Magic("Swap", 3);
    }

    @Test
    public void test_getting_the_name_of_the_magician() {
        assertEquals("Swap", magic.getName());
    }

    @Test
    public void test_getting_the_Bullets_of_the_magician() {
        assertEquals(3, magic.getBullets());
    }

    @Test
    public void test_getting_userName_of_Magician() {
        assertEquals("Petar", magician.getUsername());
    }


    @Test
    public void test_getting_health_of_Magician() {
        assertEquals(100, magician.getHealth());
    }

    @Test
    public void test_gettingUserNameThrows_whenNUll_orMissing() {
        assertThrows(NullPointerException.class, () -> {
            magician.addMagic(null);
            Magic newMagic = new Magic("", 1);
            magician.addMagic(newMagic);
        });
    }

    @Test
    public void test_creatingMagician_Throws_when_Health_is_set_to_less_than_zero() {
        assertThrows(IllegalArgumentException.class, () -> {
            Magician tryMagician = new Magician("Petar", -100);
        });
    }

    @Test
    public void removingMagicSUccessfully() {
        magician.addMagic(magic);
        assertTrue(magician.removeMagic(magic));
    }

    @Test
    public void test_takeDamage_Throws_when_HealthIs_Set_below_Zero() {
        assertThrows(IllegalArgumentException.class, () -> {
            Magician newMagician = new Magician("Ivan", -20);
        });
    }

    @Test
    public void test_takeDamage_Throws_when_Health_is_lessThan_Zero_OR_ZERO() {
        magician.takeDamage(300);
        assertEquals(0, magician.getHealth());
        Magician newMagiciain = new Magician("ABV", 1);
        newMagiciain.takeDamage(300);
        assertEquals(0, newMagiciain.getHealth());
    }

    @Test
    public void test_getting_specific_Magic_FroM_ListOF_magics() {
        Magic magicOne = new Magic("bla", 3);
        Magic magicTwo = new Magic("hello", 5);
        magician.addMagic(magicOne);
        magician.addMagic(magicTwo);

        assertEquals(magicOne, magician.getMagic("bla"));
    }

    @Test
    public void test_gettingList_Of_AllMagics() {
        Magic magicOne = new Magic("bla", 3);
        Magic magicTwo = new Magic("hello", 5);
        magician.addMagic(magicOne);
        magician.addMagic(magicTwo);

        List<Magic> expected = Collections.unmodifiableList(Arrays.asList(new Magic[]{magicOne, magicTwo}));

        assertEquals(expected, magician.getMagics());
    }

    @Test
    public void test_Getting_the_name_of_a_magic() {
        assertEquals("Petar", magician.getUsername());
        assertEquals(100, magician.getHealth());
    }

    @Test
    public void test_when_name_is_lessThan_1() {
        assertThrows(NullPointerException.class, () -> {
            Magician newMagician = new Magician("", 10);
        });
    }

    @Test
    public void test_taking_damage_when_Reduced_butSuccessful() {
        Magician reducedHealth = new Magician("Ivan", 100);
        reducedHealth.takeDamage(50);
        assertEquals(50, reducedHealth.getHealth());
    }


}
