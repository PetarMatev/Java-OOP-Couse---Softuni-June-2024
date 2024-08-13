package restaurant.models.waiter;

import restaurant.models.orders.TakenOrders;

//TODO
public class FullTimeWaiter extends BaseWaiter {

    private final static int EFFICIENCY = 8;

    public FullTimeWaiter(String name) {
        super(name, EFFICIENCY);
    }

    @Override
    public TakenOrders takenOrders() {
        return super.getTakenOrders();
    }

    @Override
    public void work() {
        int currentEfficiency = getEfficiency() - 1;
        if (currentEfficiency < 0) {
            currentEfficiency = 0;
        }
        setEfficiency(currentEfficiency);
    }
}
