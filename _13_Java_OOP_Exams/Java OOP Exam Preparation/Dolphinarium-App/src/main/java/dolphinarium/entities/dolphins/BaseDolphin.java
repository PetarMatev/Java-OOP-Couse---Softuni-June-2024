package dolphinarium.entities.dolphins;

import dolphinarium.entities.foods.Food;

import static dolphinarium.common.ExceptionMessages.DOLPHIN_NAME_NULL_OR_EMPTY;

public abstract class BaseDolphin implements Dolphin {

    private String name;
    private int energy;

    protected BaseDolphin(String name, int energy) {
        setName(name);
        setEnergy(energy);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(DOLPHIN_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setEnergy(int energy) {
        this.energy += energy;
        if (this.energy <= 0) {
            this.energy = 0;
        }
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getEnergy() {
        return this.energy;
    }

    @Override
    public abstract void jump();

    @Override
    public void eat(Food food) {
        // TODO double check this works correctly.
        setEnergy(food.getCalories());
    }
}
