package christmasPastryShop.repositories.interfaces;

import christmasPastryShop.entities.booths.interfaces.Booth;

import java.util.ArrayList;
import java.util.Collection;

public class BoothRepositoryImpl implements BoothRepository<Booth> {

    private Collection<Booth> models;

    public BoothRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Booth> getAll() {
        return null;
    }

    @Override
    public void add(Booth booth) {

    }

    @Override
    public Booth getByNumber(int number) {
        return null;
    }
}
