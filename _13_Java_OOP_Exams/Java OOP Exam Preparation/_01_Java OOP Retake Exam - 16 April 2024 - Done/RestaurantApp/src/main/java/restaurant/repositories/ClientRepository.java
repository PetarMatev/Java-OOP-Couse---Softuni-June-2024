package restaurant.repositories;

import restaurant.models.client.Client;

import java.util.ArrayList;
import java.util.Collection;

public class ClientRepository implements Repository<Client> {

    private Collection<Client> clients;

    public ClientRepository() {
        this.clients = new ArrayList<>();
    }

    @Override
    public Collection<Client> getCollection() {
        return this.clients;
    }

    @Override
    public void add(Client entity) {
        this.clients.add(entity);

    }

    @Override
    public boolean remove(Client entity) {
        return this.clients.remove(entity);
    }

    @Override
    public Client byName(String name) {
        return this.clients.stream().filter(w -> w.getName().equals(name)).findFirst().orElse(null);
    }
}
