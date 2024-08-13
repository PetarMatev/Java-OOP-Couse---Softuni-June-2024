package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.delicacies.interfaces.Delicacy;

import java.util.ArrayList;
import java.util.Collection;

public class DelicacyRepositoryImpl implements DelicacyRepository<Delicacy> {

    private Collection<Delicacy> models;

    public DelicacyRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Delicacy> getAll() {
        return null;
    }

    @Override
    public void add(Delicacy delicacy) {

    }

    @Override
    public Delicacy getByName(String name) {
        return null;
    }
}
