package restaurant.models.waiter;

import restaurant.models.orders.TakenOrders;

public class HalfTimeWaiter extends BaseWaiter {

    private final static int EFFICIENCY = 4;

    public HalfTimeWaiter(String name) {
        super(name, EFFICIENCY);
    }


    @Override
    public TakenOrders takenOrders() {
        return super.getTakenOrders();
    }

    @Override
    public void work() {
        int currentEfficiency = getEfficiency() - 2;
        if (currentEfficiency < 0) {
            currentEfficiency = 0;
        }
        setEfficiency(currentEfficiency);
    }

}
