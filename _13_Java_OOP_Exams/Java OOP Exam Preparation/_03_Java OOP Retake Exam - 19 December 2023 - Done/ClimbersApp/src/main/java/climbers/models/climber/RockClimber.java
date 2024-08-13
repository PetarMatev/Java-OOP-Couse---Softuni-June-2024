package climbers.models.climber;

public class RockClimber extends BaseClimber {
    public RockClimber(String name) {
        super(name, 120);
    }

    @Override
    public void climb() {
        double strength = getStrength() - 60;
        if (strength < 0) {
            strength = 0;
        }
        setStrength(strength);
    }
}
