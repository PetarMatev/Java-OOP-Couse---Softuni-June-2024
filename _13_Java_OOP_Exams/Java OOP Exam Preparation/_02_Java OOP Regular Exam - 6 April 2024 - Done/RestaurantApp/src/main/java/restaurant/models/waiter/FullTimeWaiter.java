package restaurant.models.waiter;

public class FullTimeWaiter extends BaseWaiter {

    private static final int EFFICIENCY = 8;

    public FullTimeWaiter(String name) {
        super(name, EFFICIENCY);
    }

    @Override
    public void work() {
        int currentEfficiency = getEfficiency();
        int updatedEfficiency = currentEfficiency - 1;

        if (updatedEfficiency < 0) {
            setEfficiency(0);
        } else {
            setEfficiency(updatedEfficiency);
        }

    }
}
