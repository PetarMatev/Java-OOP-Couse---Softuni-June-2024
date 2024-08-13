package restaurant.core;

import restaurant.models.client.Client;
import restaurant.models.client.ClientImpl;
import restaurant.models.orders.TakenOrdersImpl;
import restaurant.models.waiter.FullTimeWaiter;
import restaurant.models.waiter.HalfTimeWaiter;
import restaurant.models.waiter.Waiter;
import restaurant.models.working.WorkingImpl;
import restaurant.repositories.ClientRepository;
import restaurant.repositories.WaiterRepository;

import java.util.Collection;

import static restaurant.common.ConstantMessages.*;
import static restaurant.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private ClientRepository clientRepository;
    private WaiterRepository waiterRepository;
    private TakenOrdersImpl takenOrders;
    private WorkingImpl working;
    private int servedClientsCounter;

    public ControllerImpl() {
        this.clientRepository = new ClientRepository();
        this.waiterRepository = new WaiterRepository();
        this.takenOrders = new TakenOrdersImpl();
        this.working = new WorkingImpl();
        this.servedClientsCounter = 0;
    }

    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    public WaiterRepository getWaiterRepository() {
        return waiterRepository;
    }

    public TakenOrdersImpl getTakenOrders() {
        return takenOrders;
    }

    @Override
    public String addWaiter(String type, String waiterName) {
        Waiter waiter;
        switch (type) {
            case "FullTimeWaiter":
                waiter = new FullTimeWaiter(waiterName);
                break;
            case "HalfTimeWaiter":
                waiter = new HalfTimeWaiter(waiterName);
                break;
            default:
                throw new IllegalArgumentException(WAITER_INVALID_TYPE);
        }
        getWaiterRepository().add(waiter);
        return String.format(WAITER_ADDED, type, waiterName);
    }

    @Override
    public String addClient(String clientName, String... orders) {
        Client client = new ClientImpl(clientName);
        for (String order : orders) {
            client.getClientOrders().add(order);
        }
        clientRepository.add(client);
        return String.format(CLIENT_ADDED, clientName);
    }

    @Override
    public String removeWaiter(String waiterName) {
        Waiter waiter = getWaiterRepository().byName(waiterName);
        if (waiter == null) {
            throw new IllegalArgumentException(String.format(WAITER_DOES_NOT_EXIST, waiterName));
        }
        waiterRepository.remove(waiter);

        return String.format(WAITER_REMOVE, waiterName);
    }

    @Override
    public String removeClient(String clientName) {
        Client client = clientRepository.byName(clientName);
        if (client == null) {
            throw new IllegalArgumentException(String.format(CLIENT_DOES_NOT_EXIST, clientName));
        }
        clientRepository.remove(client);
        return String.format(CLIENT_REMOVE, clientName);
    }

    @Override
    public String startWorking(String clientName) {
        Collection<Waiter> listOfWaiters = this.waiterRepository.getCollection();
        if (listOfWaiters.isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_WAITERS);
        }
        Client client = clientRepository.byName(clientName);
        working.takingOrders(client, listOfWaiters);
        this.servedClientsCounter++;
        return String.format(ORDERS_SERVING, clientName);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_CLIENTS_COUNT, servedClientsCounter)).append(System.lineSeparator());
        sb.append(FINAL_WAITERS_STATISTICS).append(System.lineSeparator());
        for (Waiter waiter : waiterRepository.getCollection()) {
            sb.append(String.format(FINAL_WAITER_NAME, waiter.getName())).append(System.lineSeparator());
            sb.append(String.format(FINAL_WAITER_EFFICIENCY, waiter.getEfficiency())).append(System.lineSeparator());

            Collection<String> ords = waiter.takenOrders().getOrdersList();
            if (waiter.takenOrders().getOrdersList().isEmpty()) {
                sb.append(String.format(FINAL_WAITER_ORDERS, "None")).append(System.lineSeparator());
            } else {
                Collection<String> getOrders = waiter.takenOrders().getOrdersList();
                String result = String.join(FINAL_WAITER_ORDERS_DELIMITER, getOrders);
                sb.append(String.format(FINAL_WAITER_ORDERS, result)).append(System.lineSeparator());
            }
        }
        return sb.toString().trim();
    }
}
