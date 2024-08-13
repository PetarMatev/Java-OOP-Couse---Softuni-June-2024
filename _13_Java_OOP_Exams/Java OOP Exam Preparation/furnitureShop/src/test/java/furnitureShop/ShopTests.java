package furnitureShop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ShopTests {

    private Furniture furniture;
    private Shop shop;


    @BeforeEach
    public void setUp() {
        furniture = new Furniture("Door", "wood", 100);
        shop = new Shop("Ikea", 2);
    }

    @Test
    public void testConstructorOfFurnuture() {
        assertEquals("Door", furniture.getName());
        assertEquals("wood", furniture.getType());
        assertEquals(100, furniture.getPrice());
    }

    @Test
    public void testConstructorOfShop() {
        assertEquals("Ikea", shop.getType());
        assertEquals(2, shop.getCapacity());
    }

    @Test
    public void getFurnuturesReturnsUnmodifiedList() {
        shop.addFurniture(furniture);
        List<Furniture> furnitureList = shop.getFurnitures();
        assertThrows(UnsupportedOperationException.class, () -> {
            furnitureList.remove(0);
        });
    }

    @Test
    public void testGettingCountOfItems() {
        shop.addFurniture(furniture);
        assertEquals(1, shop.getCount());
    }

    @Test
    public void findAllFurnituresByType() {
        Furniture furniture1 = new Furniture("table", "metal", 1);
        Furniture furniture2 = new Furniture("window", "metal", 1);
        Furniture furniture3 = new Furniture("chair", "metal", 1);
        shop.addFurniture(furniture1);
        shop.addFurniture(furniture2);
        List<Furniture> expectedFurnitures = new ArrayList<>();
        expectedFurnitures.add(furniture1);
        expectedFurnitures.add(furniture2);
        assertEquals(expectedFurnitures, shop.findAllFurnitureByType("metal"));
    }

    @Test
    public void testingSettingUpCapacity() {

        //TODO
        assertThrows(IllegalArgumentException.class, () -> {
            shop.addFurniture(furniture);
            Furniture furniture1 = new Furniture("table", "metal", 1);
            shop.addFurniture(furniture1);
            Furniture furniture2 = new Furniture("window", "metal", 1);
            shop.addFurniture(furniture2);
            Furniture furniture3 = new Furniture("chair", "metal", 1);
            shop.addFurniture(furniture3);
        });
    }

    @Test
    public void test_Adding_nameThrowswhenFurniture_is_NULL() {

        assertThrows(IllegalArgumentException.class, () -> {
            Furniture furniture1 = null;
            shop.addFurniture(furniture1);
        });
    }

    @Test
    public void test_Adding_NAME_THROWS_When_NAME_EXISTST() {
        assertThrows(IllegalArgumentException.class, () -> {
            Furniture furniture1 = new Furniture("table", "metal", 1);
            shop.addFurniture(furniture1);
            shop.addFurniture(furniture1);

        });
    }

    @Test
    public void testing_REMOVING_FIRNUTURE() {
        shop.addFurniture(furniture);
        shop.removeFurniture("Door");
    }

    @Test
    public void testingGettingCheapstFurnuture() {
        Furniture furniture1 = new Furniture("table", "metal", 1);
        Furniture furniture2 = new Furniture("window", "metal", 100);
        shop.addFurniture(furniture1);
        shop.addFurniture(furniture2);
        assertEquals("table", shop.getCheapestFurniture());
    }

    @Test
    public void testingSettingUpCapacityWithNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            Shop testShop = new Shop("H&M", -100);
        });
    }


}