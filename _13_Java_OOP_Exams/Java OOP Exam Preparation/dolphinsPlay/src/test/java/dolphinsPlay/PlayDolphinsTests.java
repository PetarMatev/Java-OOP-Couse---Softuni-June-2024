package dolphinsPlay;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayDolphinsTests {

    private Dolphin dolphin;
    private DolphinsPlay dolphinsPlay;

    @BeforeEach
    public void setUp() {
        dolphin = new Dolphin("Black", "Mario", 5);
        dolphinsPlay = new DolphinsPlay("VarnaPool", 2);
    }


    @Test
    public void testing_Constructor_of_DolphinsPlay_class() {
        assertEquals("VarnaPool", dolphinsPlay.getName());
        assertEquals(2, dolphinsPlay.getCapacity());
        assertEquals(0, dolphinsPlay.getDolphins().size());
    }


    @Test
    public void testing_capacity_Throws_when_less_Than_Zero() {
        assertThrows(IllegalArgumentException.class, () -> {
            DolphinsPlay newDolphinPlay = new DolphinsPlay("name", -10);
        });
    }

    @Test
    public void test_finding_All_Dolphines_By_Certain_Type() {
        DolphinsPlay dolphinsPlay1 = new DolphinsPlay("bla", 4);
        Dolphin dolphin1 = new Dolphin("White", "Ivan", 2);
        Dolphin dolphin2 = new Dolphin("White", "Penka", 2);
        Dolphin dolphin3 = new Dolphin("White", "Dragan", 2);
        dolphinsPlay1.addDolphin(dolphin);
        dolphinsPlay1.addDolphin(dolphin1);
        dolphinsPlay1.addDolphin(dolphin2);
        dolphinsPlay1.addDolphin(dolphin3);
        assertEquals(3, dolphinsPlay1.findAllDolphinsByType("White").size());
    }

    @Test
    public void test_gettingCount_of_added_Dolphins() {
        assertEquals(0, dolphinsPlay.getCount());
    }

    @Test
    public void test_adding_successfully_dolphine_toPlay() {
        dolphinsPlay.addDolphin(dolphin);
    }

    @Test
    public void test_adding_Null_for_dolphine_in_Dolphine_playThrows() {
        assertThrows(IllegalArgumentException.class, () -> {
            dolphinsPlay.addDolphin(null);
        });
    }

    @Test
    public void test_Adding_DolphinesThrows_When_Capacity_Reached() {
        assertThrows(IllegalArgumentException.class, () -> {
            Dolphin dolphin1 = new Dolphin("bla", "penka", 1);
            Dolphin dolphin2 = new Dolphin("aa", "genka", 1);
            dolphinsPlay.addDolphin(dolphin);
            dolphinsPlay.addDolphin(dolphin1);
            dolphinsPlay.addDolphin(dolphin2);
        });
    }

    @Test
    public void test_Adding_DolphinesThrows_When_Idential_Dolphines_Added() {
        assertThrows(IllegalArgumentException.class, () -> {
            dolphinsPlay.addDolphin(dolphin);
            dolphinsPlay.addDolphin(dolphin);
        });
    }


    @Test
    public void removeDolphin_from_list_of_dolphines() {
        dolphinsPlay.addDolphin(dolphin);
        String dolphineName = dolphin.getName();
        dolphinsPlay.removeDolphin(dolphineName);
    }

    @Test
    public void test_identification_of_Dolphine_with_max_energy() {
        Dolphin dolphineOne = new Dolphin("ivan", "penka", 100);
        Dolphin dolphineTwo = new Dolphin("draan", "Petkan", 1);
        dolphinsPlay.addDolphin(dolphineOne);
        dolphinsPlay.addDolphin(dolphineTwo);
        assertEquals("penka", dolphinsPlay.getTheDolphinWithTheMaxEnergy());
    }


    @Test
    public void testing_Constructor_Of_Dolphin_Class() {
        assertEquals("Black", dolphin.getType());
        assertEquals("Mario", dolphin.getName());
        assertEquals(5, dolphin.getEnergy());
    }
}
