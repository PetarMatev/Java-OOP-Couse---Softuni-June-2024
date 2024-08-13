package restaurant.models.working;

import restaurant.models.client.Client;
import restaurant.models.orders.TakenOrders;
import restaurant.models.waiter.Waiter;

import java.util.Collection;

public class WorkingImpl implements Working {

    @Override
    public void takingOrders(Client client, Collection<Waiter> waiters) {
        // Waiters cannot serve clients if their efficiency is equal to or below 0.
        //	They start working by taking orders from clients, one by one.
        //	If they take an order, they add it to their getOrders list and their efficiency is decreased.
        //	The taken order should then be removed from the getClientOrders list of the current client.
        //	Waiters cannot continue working if their efficiency drops to 0.
        //	If their efficiency drops to 0 they get tired and cannot take any more orders, and the next waiter starts working.

        Collection<String> orders = client.getClientOrders();

        for (Waiter waiter : waiters) {
            while (waiter.canWork() && orders.iterator().hasNext()) {
                waiter.work();
                String currentOrder = client.getClientOrders().iterator().next();
                waiter.takenOrders().getOrdersList().add(currentOrder);
                orders.remove(currentOrder);
            }
        }
    }
}
