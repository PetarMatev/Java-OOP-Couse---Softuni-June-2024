package vehicleShop.models.worker;

public class SecondShift extends BaseWorker {

    private static final int STRENGTH = 70;

    public SecondShift(String name) {
        super(name, STRENGTH);
    }

    @Override
    public void working() {
        int newStrength = getStrength() - 15;
        if (newStrength < 0) {
            newStrength = 0;
        }
        setStrength(newStrength);
    }
}
