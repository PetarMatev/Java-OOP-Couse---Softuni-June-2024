package restaurant.core;

import restaurant.models.client.Client;
import restaurant.models.client.ClientImpl;
import restaurant.models.waiter.FullTimeWaiter;
import restaurant.models.waiter.HalfTimeWaiter;
import restaurant.models.waiter.Waiter;
import restaurant.models.working.WorkingImpl;
import restaurant.repositories.ClientRepository;
import restaurant.repositories.WaiterRepository;

import java.util.List;

import static restaurant.common.ConstantMessages.*;
import static restaurant.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private ClientRepository clientRepository;
    private WaiterRepository waiterRepository;
    private WorkingImpl working;
    private int servedClients = 0;

    public ControllerImpl() {
        this.clientRepository = new ClientRepository();
        this.waiterRepository = new WaiterRepository();
        this.working = new WorkingImpl();
    }

    @Override
    public String addWaiter(String type, String waiterName) {
        Waiter waiter = switch (type) {
            case "FullTimeWaiter" -> new FullTimeWaiter(waiterName);
            case "HalfTimeWaiter" -> new HalfTimeWaiter(waiterName);
            default -> throw new IllegalArgumentException(WAITER_INVALID_TYPE);
        };
        waiterRepository.add(waiter);
        return String.format(WAITER_ADDED, type, waiterName);
    }

    @Override
    public String addClient(String clientName, String... orders) {
        Client client = new ClientImpl(clientName);
        client.getClientOrders().addAll(List.of(orders));
        clientRepository.add(client);
        return String.format(CLIENT_ADDED, clientName);
    }

    @Override
    public String removeWaiter(String waiterName) {
        Waiter waiter = waiterRepository.byName(waiterName);
        if (waiter == null) {
            throw new IllegalArgumentException(String.format(WAITER_DOES_NOT_EXIST, waiterName));
        }
        waiterRepository.remove(waiter);
        return WAITER_REMOVE.formatted(waiterName);
    }

    @Override
    public String removeClient(String clientName) {
        Client clientToBeRemoved = clientRepository.byName(clientName);
        if (clientToBeRemoved == null) {
            throw new IllegalArgumentException(String.format(CLIENT_DOES_NOT_EXIST, clientName));
        }
        clientRepository.remove(clientToBeRemoved);
        return CLIENT_REMOVE.formatted(clientName);
    }

    @Override
    public String startWorking(String clientName) {
        if (this.waiterRepository.getCollection().isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_WAITERS);
        }
        Client currentServedClient = clientRepository.byName(clientName);
        working.takingOrders(currentServedClient, this.waiterRepository.getCollection());
        servedClients++;
        return String.format(ORDERS_SERVING, clientName);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(FINAL_CLIENTS_COUNT, servedClients)).append((System.lineSeparator()));
        stringBuilder.append(String.format(FINAL_WAITERS_STATISTICS)).append(System.lineSeparator());
        this.waiterRepository.getCollection().forEach(waiter -> {
            stringBuilder.append(String.format(FINAL_WAITER_NAME, waiter.getName())).append(System.lineSeparator());
            stringBuilder.append(String.format(FINAL_WAITER_EFFICIENCY, waiter.getEfficiency())).append(System.lineSeparator());

            if (waiter.takenOrders().getOrdersList().isEmpty()) {
                stringBuilder.append(String.format(FINAL_WAITER_ORDERS, "None")).append(System.lineSeparator());
            } else {
                String takenOrders = String.join(FINAL_WAITER_ORDERS_DELIMITER, waiter.takenOrders().getOrdersList());
                stringBuilder.append(String.format(FINAL_WAITER_ORDERS, takenOrders)).append(System.lineSeparator());
            }

        });
        return stringBuilder.toString().trim();
    }
}
