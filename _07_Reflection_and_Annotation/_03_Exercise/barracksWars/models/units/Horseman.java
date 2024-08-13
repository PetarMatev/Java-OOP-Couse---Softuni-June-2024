package Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.models.units;

public class Horseman extends AbstractUnit {
    private static final int PIKEMAN_HEALTH = 50;
    private static final int PIKEMAN_DAMAGE = 10;

    public Horseman() {
        super(PIKEMAN_HEALTH, PIKEMAN_DAMAGE);
    }
}
