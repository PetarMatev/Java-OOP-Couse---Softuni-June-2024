package toyStore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ToyStoryTest {

    Toy toy;
    ToyStore toyStore;

    @BeforeEach
    public void setUp() {
        toy = new Toy("Samsung", "ID10");
        toyStore = new ToyStore();
    }

    @Test
    public void test_getting_Toy_manufacturer_and_toYID() {
        assertEquals("Samsung", toy.getManufacturer());
        assertEquals("ID10", toy.getToyId());
    }

    @Test
    public void testing_gettingList_of_Toys() {
        Map<String, Toy> toyMap = new HashMap<>();
        toyMap.put("A", null);
        toyMap.put("B", null);
        toyMap.put("C", null);
        toyMap.put("D", null);
        toyMap.put("E", null);
        toyMap.put("F", null);
        toyMap.put("G", null);
        assertEquals(toyMap, toyStore.getToyShelf());
        assertEquals(toyMap.size(), toyStore.getToyShelf().size());
    }

    @Test
    public void testGetToyShelfIsUnmodifiable() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            Toy bear = new Toy("bear", "jerry");
            toyStore.addToy("A", toy);
            toyStore.addToy("B", bear);
            toyStore.getToyShelf().clear();
        });
    }


    @Test
    public void test_addToy_Successfully() throws OperationNotSupportedException {
        String actual = toyStore.addToy("A", toy);
        String expected = "Toy:ID10 placed successfully!";
        Toy actualToy = toyStore.getToyShelf().get("A");
        assertEquals(toy, actualToy);
        assertEquals(expected, actual);
     }

    @Test
    public void test_addToy_Throws_when_trying_to_add_to_shelf_that_does_not_exist() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> {
            ToyStore newToyStore = new ToyStore();
            Toy newToy = new Toy("new", "ID_NEW");
            newToyStore.addToy("X", newToy);
        });
    }

    @Test
    public void test_addToy_Throws_when_shelf_is_different_from_null_which_means_is_not_empty() throws IllegalArgumentException, OperationNotSupportedException {
        ToyStore newToyStore = new ToyStore();
        Toy newToy = new Toy("new", "ID_NEW");
        newToyStore.addToy("G", newToy);
        assertThrows(IllegalArgumentException.class, () -> {
            Toy shinyBrightNewToy = new Toy("BG", "33");
            newToyStore.addToy("G", shinyBrightNewToy);
        });
    }

    @Test
    public void test_addToy_Throws_when_trying_to_add_a_toy_that_has_already_been_added() throws OperationNotSupportedException {
        assertThrows(OperationNotSupportedException.class, () -> {
            ToyStore newToyStore = new ToyStore();
            Toy newToy = new Toy("new", "ID_NEW");
            newToyStore.addToy("G", newToy);
            newToyStore.addToy("A", newToy);
        });
    }

    @Test
    public void test_addToy_AlreadyInShelf() throws OperationNotSupportedException, IllegalArgumentException {
        toyStore.addToy("G", toy);
        Exception exception = assertThrows(OperationNotSupportedException.class, () -> {
            toyStore.addToy("A", toy);
        });
        assertEquals("Toy is already in shelf!", exception.getMessage());
    }

    @Test
    public void test_remove_toy_Throws_when_shelf_does_not_Exist() {
        assertThrows(IllegalArgumentException.class, () -> {
            ToyStore newToyStore = new ToyStore();
            Toy newToy = new Toy("new", "ID_NEW");
            newToyStore.removeToy("X", newToy);
        });
    }

    @Test
    public void test_removeToy_Throws_if_the_selectedToy_to_be_removed_is_different_from_theToy_on_the_Shelf() {
        assertThrows(IllegalArgumentException.class, () -> {
            ToyStore newToyStore = new ToyStore();
            Toy newToy = new Toy("new", "ID_NEW");
            newToyStore.addToy("G", newToy);
            Toy newShinyTOy = new Toy("shiny", "ID");
            newToyStore.removeToy("G", newShinyTOy);
        });
    }

    @Test
    public void testRemoveToySuccessfully() throws OperationNotSupportedException {
        toyStore.addToy("A", toy);
        String actual = toyStore.removeToy("A", toy); // provide the message that needs to be compared.
        String expected = "Remove toy:ID10 successfully!";
        Toy actualToy = toyStore.getToyShelf().get("A");
        Assertions.assertNull(actualToy); // assert is now null.
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void test_removeToy_Throws_if_shelf_is_empty() {
        assertThrows(IllegalArgumentException.class, () -> {
            ToyStore newToyStore = new ToyStore();
            Toy newToy = new Toy("new", "ID_NEW");
            newToyStore.removeToy("A", newToy);
        });
    }
}