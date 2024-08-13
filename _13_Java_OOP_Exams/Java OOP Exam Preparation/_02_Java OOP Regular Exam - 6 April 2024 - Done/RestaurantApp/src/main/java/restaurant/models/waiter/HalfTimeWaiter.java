package restaurant.models.waiter;

public class HalfTimeWaiter extends BaseWaiter {

    private static final int EFFICIENCY = 4;

    public HalfTimeWaiter(String name) {
        super(name, EFFICIENCY);
    }

    @Override
    public void work() {

        int currentEfficiency = getEfficiency();
        int updatedEfficiency = currentEfficiency - 2;

        if (updatedEfficiency < 0) {
            setEfficiency(0);
        } else {
            setEfficiency(updatedEfficiency);
        }
    }
}
