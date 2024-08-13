package harpoonDiver.repositories;

import harpoonDiver.models.divingSite.DivingSite;

import java.util.ArrayList;
import java.util.Collection;

public class DivingSiteRepository implements Repository<DivingSite> {

    private Collection<DivingSite> sites;

    public DivingSiteRepository() {
        this.sites = new ArrayList<>();
    }

    @Override
    public Collection<DivingSite> getCollection() {
        return null;
    }

    @Override
    public void add(DivingSite entity) {

    }

    @Override
    public boolean remove(DivingSite entity) {
        return false;
    }

    @Override
    public DivingSite byName(String name) {
        return null;
    }
}
