package Java_OOP_June_2024._07_Reflection_and_Annotation._03_Exercise.barracksWars.models.units;

public class Gunner extends AbstractUnit {
    private static final int PIKEMAN_HEALTH = 20;
    private static final int PIKEMAN_DAMAGE = 20;

    public Gunner() {
        super(PIKEMAN_HEALTH, PIKEMAN_DAMAGE);
    }
}
