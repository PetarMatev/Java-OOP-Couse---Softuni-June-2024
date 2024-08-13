package harpoonDiver.repositories;

import harpoonDiver.models.diver.Diver;

import java.util.ArrayList;
import java.util.Collection;

public class DiverRepository implements Repository<Diver> {

    private Collection<Diver> divers;

    public DiverRepository() {
        this.divers = new ArrayList<>();
    }

    @Override
    public Collection<Diver> getCollection() {
        return null;
    }

    @Override
    public void add(Diver entity) {

    }

    @Override
    public boolean remove(Diver entity) {
        return false;
    }

    @Override
    public Diver byName(String name) {
        return null;
    }
}
