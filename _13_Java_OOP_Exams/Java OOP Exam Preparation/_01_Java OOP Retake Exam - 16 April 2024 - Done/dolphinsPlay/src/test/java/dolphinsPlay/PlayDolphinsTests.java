package dolphinsPlay;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class PlayDolphinsTests {
    private static final String EXPECTED_NAME = "Jimmy";
    private static final int EXPECTED_CAPACITY = 100;
    private static List<Dolphin> EXPECTED_DOLPHINS = new ArrayList<>();
    private static final int EXPECTED_SIZE_OF_LIST = EXPECTED_DOLPHINS.size();


    private DolphinsPlay dolphinsPlay;

    @BeforeEach
    public void setUp() {
        this.dolphinsPlay = new DolphinsPlay(EXPECTED_NAME, EXPECTED_CAPACITY);
        EXPECTED_DOLPHINS = new ArrayList<>();
    }

    @Test
    public void constructor_Should_Create_Correct_Object() {
        String actualName = dolphinsPlay.getName();
        int actualCapacity = dolphinsPlay.getCapacity();
        List<Dolphin> actualDolphins = new ArrayList<>();

        Assertions.assertEquals(EXPECTED_NAME, actualName);
        Assertions.assertEquals(EXPECTED_CAPACITY, actualCapacity);
        Assertions.assertEquals(EXPECTED_DOLPHINS, actualDolphins);
    }

    @Test
    public void addDolphin_TEST_throws_when_NULL() {
        Dolphin dolphin = null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> dolphinsPlay.addDolphin(dolphin));
    }

    @Test
    public void addDolphin_TEST_throws_dolphinEXISTS() {
        Dolphin dolphin = Mockito.mock(Dolphin.class);
        Mockito.when(dolphin.getType()).thenReturn("Dummy");  // Mocking getType()
        Mockito.when(dolphin.getName()).thenReturn("Jimmy");  // Mocking getName()
        Mockito.when(dolphin.getEnergy()).thenReturn(100);    // Mocking getEnergy()

        dolphinsPlay.addDolphin(dolphin);

        Dolphin duplicateDolphin = Mockito.mock(Dolphin.class);
        Mockito.when(duplicateDolphin.getType()).thenReturn("Dummy");
        Mockito.when(duplicateDolphin.getName()).thenReturn("Jimmy");
        Mockito.when(duplicateDolphin.getEnergy()).thenReturn(80);

        Assertions.assertThrows(IllegalArgumentException.class, () ->
                        dolphinsPlay.addDolphin(duplicateDolphin),
                String.format("The dolphin %s already exist!", dolphin.getName()));
    }


    @Test
    public void getCapacity_TEST_Succssful_RESULT() {
        int actualCapacity = dolphinsPlay.getCapacity();
        Assertions.assertEquals(EXPECTED_CAPACITY, actualCapacity);
    }

    @Test
    public void getCapacity_TEST_Throws_Invalid_CAPACITY_when_CAPACITY_IS_LESS_THAN_ZERO() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> dolphinsPlay.setCapacity(-50));
    }


    @Test
    public void getCount_Test_SHOULD_RETURN_THE_SIZE_OF_THE_LIST_DOLPHINS() {
        int actualSize_Of_Dolphin_list = dolphinsPlay.getCount();
        Assertions.assertEquals(EXPECTED_SIZE_OF_LIST, actualSize_Of_Dolphin_list);
    }

    @Test
    public void getName_TEST() {
        String getActualName = dolphinsPlay.getName();
        Assertions.assertEquals(EXPECTED_NAME, getActualName);
    }

    @Test
    public void setName_TEST() {
        String actualName = "Jimmy";
        dolphinsPlay.setName(actualName);
        Assertions.assertEquals(EXPECTED_NAME, actualName);
    }
}
