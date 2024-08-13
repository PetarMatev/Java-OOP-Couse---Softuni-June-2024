package harpoonDiver.models.diver;

public class DeepWaterDiver extends BaseDiver {

    public static final int OXYGEN = 90;

    public DeepWaterDiver(String name) {
        super(name, OXYGEN);
    }
}
