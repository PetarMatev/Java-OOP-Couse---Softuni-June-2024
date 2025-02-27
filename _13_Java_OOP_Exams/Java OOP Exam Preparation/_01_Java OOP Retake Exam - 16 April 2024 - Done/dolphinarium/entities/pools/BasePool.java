package dolphinarium.entities.pools;

import dolphinarium.entities.dolphins.Dolphin;
import dolphinarium.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;

import static dolphinarium.common.ExceptionMessages.*;

public abstract class BasePool implements Pool {

    private String name;
    private int capacity;
    private Collection<Food> foods;
    private Collection<Dolphin> dolphins;

    public BasePool(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.foods = new ArrayList<>();
        this.dolphins = new ArrayList<>();
    }

    public void setName(String name) {
        if (name.equals(null) || name.trim().isEmpty()) {
            throw new NullPointerException(POOL_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void addDolphin(Dolphin dolphin) {
        if (dolphins.size() >= getCapacity()) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        if (dolphin.getEnergy() <= 0) {
            throw new IllegalArgumentException(DOLPHIN_ENERGY_BELOW_OR_EQUAL_ZERO);
        }
        dolphins.add(dolphin);
    }

    @Override
    public void removeDolphin(Dolphin dolphin) {
        dolphins.remove(dolphin);
    }

    @Override
    public void addFood(Food food) {
        foods.add(food);
    }

    @Override
    public Collection<Dolphin> getDolphins() {
        return dolphins;
    }

    @Override
    public Collection<Food> getFoods() {
        return foods;
    }
}
