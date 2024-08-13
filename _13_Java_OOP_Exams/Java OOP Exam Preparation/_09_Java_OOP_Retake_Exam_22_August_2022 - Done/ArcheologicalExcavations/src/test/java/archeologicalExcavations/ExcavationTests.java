package archeologicalExcavations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExcavationTests {

    Archaeologist archaeologist;
    Excavation excavation;

    @BeforeEach
    public void setUp() {
        archaeologist = new Archaeologist("Petar", 100);
        excavation = new Excavation("Giza", 2);
    }

    @Test
    public void testGettingNameAndEnergyOfArcheologist() {
        assertEquals("Petar", archaeologist.getName());
        assertEquals(100, archaeologist.getEnergy());
    }


    @Test
    public void testDetailsOfExcavation() {
        excavation.addArchaeologist(archaeologist);
        Archaeologist secondarchaeologist = new Archaeologist("Ivan", 10);
        excavation.addArchaeologist(secondarchaeologist);
        assertEquals("Giza", excavation.getName());
        assertEquals(2, excavation.getCapacity());
        assertEquals(2, excavation.getCount());
    }

    @Test
    public void testingSettingNameThrowsWhenNullorMissing() {
        assertThrows(NullPointerException.class, () -> {
            Excavation newSite = new Excavation(null, 100);
        });
    }

    @Test
    public void testingSettingCapacityThrowsWhenCapacityIsLessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            Excavation newSite = new Excavation("Sofia", -100);
        });
    }

    @Test
    public void testingRemovingArchaeologistSuccessfully() {
        excavation.addArchaeologist(archaeologist);
        String archaeologistName = archaeologist.getName();
        assertTrue(excavation.removeArchaeologist(archaeologistName));
    }

    @Test
    public void testAddingArchaeologistThrowsWhenNoMoreCapacity() {
        assertThrows(IllegalArgumentException.class, () -> {
            excavation.addArchaeologist(archaeologist);
            Archaeologist secondArchaeologist = new Archaeologist("Dragan", 4);
            Archaeologist thirdArchaeologist = new Archaeologist("Nikolay", 10);
            excavation.addArchaeologist(secondArchaeologist);
            excavation.addArchaeologist(thirdArchaeologist);
        });
    }

    @Test
    public void testAddingArchaeologistThrowsWhenArchaeologistAlreadyExists() {
        assertThrows(IllegalArgumentException.class, () -> {
            excavation.addArchaeologist(archaeologist);
            excavation.addArchaeologist(archaeologist);
        });
    }
}
