package handball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeamTests {

    Team team;
    HandballPlayer handballPlayer;

    @BeforeEach
    public void setUp() {
        team = new Team("Levski", 2);
        handballPlayer = new HandballPlayer("Petar");
    }


    @Test
    public void getName_OfPlayer() {
        assertEquals("Petar", handballPlayer.getName());
    }

    @Test
    public void check_if_the_Player_is_Active() {
        assertTrue(handballPlayer.isActive());
    }

    @Test
    public void constructorThrows_when_name_is_NULL() {
        assertThrows(NullPointerException.class, () -> {
            Team team = new Team(null, 5);
        });
    }

    @Test
    public void constructorThrows_when_Position_IS_LESS_THAN_0() {
        assertThrows(IllegalArgumentException.class, () -> {
            Team team = new Team("CSKA", -1);
        });
    }

    @Test
    public void test_getting_size_of_list_of_players() {
        team.add(handballPlayer);
        assertEquals(1, team.getCount());
    }

    @Test
    public void addPlayersThrow_when_SizeOFList_Is_equal_to_position() {
        assertThrows(IllegalArgumentException.class, () -> {
            team.add(handballPlayer);
            HandballPlayer playerTwo = new HandballPlayer("Ivan");
            team.add(playerTwo);
            HandballPlayer playerThree = new HandballPlayer("Dragan");
            team.add(handballPlayer);
        });
    }

    @Test
    public void Test_removePlayerThrows_when_selectedPlayer_is_NULL() {
        assertThrows(IllegalArgumentException.class, () -> {
            team.remove(null);
        });
    }

    @Test
    public void removePlayer_TEST() {
        team.add(handballPlayer);
        String name = handballPlayer.getName();
        team.remove(name);
        assertEquals(0, team.getCount());
    }

    @Test
    public void testGettingCorrectStatistics() {
        team.add(handballPlayer);
        String expectedStatistics = "The player Petar is in the team Levski.";
        assertEquals(expectedStatistics, team.getStatistics());
    }

    @Test
    public void test_PlayerFor_AnotherTeam__is_NULL() {
        assertThrows(IllegalArgumentException.class, () -> {
            team.playerForAnotherTeam(null);
        });
    }

    @Test
    public void test_PlayerFor_AnotherTeam_SUCCEEDs() {
        team.add(handballPlayer);
        String name = handballPlayer.getName();
        assertEquals(handballPlayer, team.playerForAnotherTeam(name));
        assertFalse(handballPlayer.isActive()); // is required to use isActive test to make sure it gets passed through.
    }
}
