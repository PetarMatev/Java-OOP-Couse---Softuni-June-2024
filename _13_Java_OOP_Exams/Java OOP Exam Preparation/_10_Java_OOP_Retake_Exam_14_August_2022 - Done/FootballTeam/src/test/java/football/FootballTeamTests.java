package football;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class FootballTeamTests {

    Footballer footballer;
    FootballTeam footballTeam;

    @BeforeEach
    public void setUp() {
        footballer = new Footballer("Petar");
        footballTeam = new FootballTeam("Chelsea", 9);
    }

    @Test
    public void testGettingNameActivation() {
        assertEquals("Petar", footballer.getName());
        assertTrue(footballer.isActive());
    }

    @Test
    public void testGettingNameOfTeamAndVacantPosition() {
        assertEquals("Chelsea", footballTeam.getName());
        assertEquals(9, footballTeam.getVacantPositions());
        footballTeam.addFootballer(footballer);
        assertEquals(1, footballTeam.getCount());
    }

    @Test
    public void testSettingNameOfFootballTeamThrowsWithNull() {
        assertThrows(NullPointerException.class, () -> {
            FootballTeam testTeam = new FootballTeam(null, 8);
        });
    }

    @Test
    public void testSettingNameOfFootballTeamThrowsWithNegativeNumberOfVacantPosition() {
        assertThrows(IllegalArgumentException.class, () -> {
            FootballTeam testTeam = new FootballTeam("Chelsea", -8);
        });
    }

    @Test
    public void testAddingPlayerThrowsWhenNoMoreAvailablePositionsInTheTeam() {
        assertThrows(IllegalArgumentException.class, () -> {
            FootballTeam team = new FootballTeam("Levski", 1);
            team.addFootballer(footballer);
            Footballer newFootballer = new Footballer("Ivan");
            team.addFootballer(newFootballer);
        });
    }

    @Test
    public void testRemovingFootballerThrowsWhenFootballerIsNULL() {
        assertThrows(IllegalArgumentException.class, () -> {
            footballTeam.removeFootballer(null);
        });
    }

    @Test
    public void testingFootballerForSellThrowsWhenFootballerIsNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            footballTeam.footballerForSale(null);
        });
    }

    @Test
    public void testingFootballerForSellIsSuccessful() {
        footballTeam.addFootballer(footballer);
        String name = footballer.getName();
        footballer.setActive(false);
        assertEquals(footballer, footballTeam.footballerForSale(name));
        assertFalse(footballer.isActive());
    }

    @Test
    public void testingGettingStatistics() {
        footballTeam.addFootballer(footballer);
        Footballer secondFootballer = new Footballer("Ivan");
        footballTeam.addFootballer(secondFootballer);
        String expected = "The footballer Petar, Ivan is in the team Chelsea.";
        assertEquals(expected, footballTeam.getStatistics());
    }
}
