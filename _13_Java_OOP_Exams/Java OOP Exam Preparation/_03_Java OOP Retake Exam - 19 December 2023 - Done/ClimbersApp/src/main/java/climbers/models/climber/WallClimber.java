package climbers.models.climber;

public class WallClimber extends BaseClimber {

    public WallClimber(String name) {
        super(name, 90);
    }

    @Override
    public void climb() {
        double strength = getStrength() - 30;
        if (strength < 0) {
            strength = 0;
        }
        setStrength(strength);
    }
}
