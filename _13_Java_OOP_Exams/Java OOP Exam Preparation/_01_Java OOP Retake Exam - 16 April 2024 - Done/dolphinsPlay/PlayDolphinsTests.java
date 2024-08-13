package dolphinsPlay;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayDolphinsTests {

    private DolphinsPlay dolphinsPlay;
    private Dolphin dolphin;

    @BeforeEach
    public void setUp() {
        dolphinsPlay = new DolphinsPlay("Cancun", 3);
        dolphin = new Dolphin("SpottedDolphin", "Oum", 300);

        dolphinsPlay.addDolphin(dolphin);
    }

    @Test
    public void getCountShouldReturnOne() {
        int actualCount = dolphinsPlay.getCount();
        int expectedCount = 1;
        Assertions.assertEquals(expectedCount, actualCount);
    }

    @Test
    public void getDolphinsShouldReturnCorrectList() {
        Collection<Dolphin> expected = new ArrayList<>();
        expected.add(dolphin);

        Collection<Dolphin> actualD = dolphinsPlay.getDolphins();

        Assertions.assertEquals(expected, actualD);
    }

    @Test
    public void addDolphin() {

        int actualCount = dolphinsPlay.getCount();
        int expectedCount = 1;
        Assertions.assertEquals(expectedCount, actualCount);
    }


    @Test
    public void removeDolphin() {
        dolphinsPlay.removeDolphin(dolphin.getName());

        int actualCount = dolphinsPlay.getCount();
        int expectedCount = 0;
        Assertions.assertEquals(expectedCount, actualCount);
    }

    @Test
    public void addDolphinWithNullValue() {

        assertThrows(IllegalArgumentException.class, () -> {
            dolphinsPlay.addDolphin(null);
        });
    }

//    @Test(expected = IllegalArgumentException.class)
//    public void addDolphinWithNullValue() {
//
//        dolphinsPlay.addDolphin(null);
//    }


    @Test
    public void findDolphinWithMaxEnergy() {
        Dolphin dolphin2 = new Dolphin("SpottedDolphin", "Mike", 350);
        Dolphin dolphin3 = new Dolphin("SpottedDolphin", "Spike", 240);
        dolphinsPlay.addDolphin(dolphin2);
        dolphinsPlay.addDolphin(dolphin3);

        String expectedD = "Mike";
        String actualD = String.valueOf(dolphinsPlay.getTheDolphinWithTheMaxEnergy());

        Assertions.assertEquals(expectedD, actualD);
    }


    @Test
    public void testGetEnergy() {
        Dolphin dolphin = new Dolphin("SpottedDolphin", "Flipper", 100);
        Assertions.assertEquals(100, dolphin.getEnergy());
    }

    @Test
    public void findAllDolphinsByType() {
        DolphinsPlay pool = new DolphinsPlay("Caribi", 3);
        Dolphin dolphin2 = new Dolphin("Spotted", "Mike", 250);
        Dolphin dolphin3 = new Dolphin("BottleNose", "Spike", 240);
        Dolphin dolphin4 = new Dolphin("Spotted", "Henry", 220);

        pool.addDolphin(dolphin2);
        pool.addDolphin(dolphin3);
        pool.addDolphin(dolphin4);

        List<Dolphin> foundByType = pool.findAllDolphinsByType("Spotted");

        Assertions.assertEquals(2, foundByType.size());
    }

    @Test
    public void testGetCapacity() {

        Assertions.assertEquals(3, dolphinsPlay.getCapacity());
    }

    @Test
    public void getEnergy_ShouldReturnDolphinsEnergyValue() {

        Assertions.assertEquals(300, dolphin.getEnergy());
    }

    @Test
    public void getPoolName_ShouldReturnPoolName() {

        Assertions.assertEquals("Cancun", dolphinsPlay.getName());
    }

    @Test
    public void addMethod_ShouldThrowExceptionForInvalidCapacity() {
        DolphinsPlay play = new DolphinsPlay("Corals", 0);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            play.addDolphin(dolphin);
        });
    }

    @Test
    public void addMethod_ShouldThrowExceptionForExceededCapacity() {
        DolphinsPlay play = new DolphinsPlay("Corals", 1);
        Dolphin dolphin2 = new Dolphin("Spotted", "Mike" , 250);
        Dolphin dolphin3 = new Dolphin("BottleNose","Spike" , 240);

        play.addDolphin(dolphin2);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            play.addDolphin(dolphin3);
        });
    }

    @Test
    public void addMethod_ShouldThrowExceptionForExistingDolphin() {
        DolphinsPlay play = new DolphinsPlay("Corals", 3);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            play.addDolphin(dolphin);
            play.addDolphin(dolphin);
        });


    }

    @Test
    public void constructor_ShouldThrowArgumentExceptionForInvalidCapacity() {

        assertThrows(IllegalArgumentException.class, () -> {
            new DolphinsPlay("Ocean", -10);
        });
    }

}
