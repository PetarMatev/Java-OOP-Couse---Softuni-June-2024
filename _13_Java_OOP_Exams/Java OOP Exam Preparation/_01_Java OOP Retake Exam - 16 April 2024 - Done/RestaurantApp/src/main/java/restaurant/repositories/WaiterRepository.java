package restaurant.repositories;

import restaurant.models.waiter.Waiter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class WaiterRepository implements Repository<Waiter> {

    private Collection<Waiter> waiters;

    public WaiterRepository() {
        this.waiters = new ArrayList<>();
    }

    @Override
    public Collection<Waiter> getCollection() {
        return this.waiters;
    }

    @Override
    public void add(Waiter entity) {
        this.waiters.add(entity);

    }

    @Override
    public boolean remove(Waiter entity) {
        return this.waiters.remove(entity);
    }

    @Override
    public Waiter byName(String name) {
        return getCollection().stream().filter(waiter -> waiter.getName().equals(name)).findFirst().orElse(null);
    }
}
