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
        return this.sites.stream().toList();
    }

    @Override
    public void add(DivingSite entity) {
        this.sites.add(entity);
    }

    @Override
    public boolean remove(DivingSite entity) {
        return this.sites.remove(entity);
    }

    @Override
    public DivingSite byName(String name) {
        return this.sites.stream().filter(site -> site.getName().equals(name)).findFirst().orElse(null);
    }
}
