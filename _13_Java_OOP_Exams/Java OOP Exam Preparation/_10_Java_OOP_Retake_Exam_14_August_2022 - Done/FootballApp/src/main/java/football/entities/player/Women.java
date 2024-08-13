package football.entities.player;

public class Women extends BasePlayer {

    private static final double KILOGRAMS = 60.00;
    // TODO -> I can only play on ArtificialTurf!

    public Women(String name, String nationality, int strength) {
        super(name, nationality, KILOGRAMS, strength);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength() + 115);
    }
}
