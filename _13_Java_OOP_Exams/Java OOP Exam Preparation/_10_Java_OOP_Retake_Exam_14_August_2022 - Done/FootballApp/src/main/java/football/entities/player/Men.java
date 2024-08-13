package football.entities.player;

public class Men extends BasePlayer {

    private static final double KILOGRAMS = 85.50;
    // TODO -> I can only play on NaturalGrass!

    public Men(String name, String nationality, int strength) {
        super(name, nationality, KILOGRAMS, strength);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength() + 145);
    }
}
