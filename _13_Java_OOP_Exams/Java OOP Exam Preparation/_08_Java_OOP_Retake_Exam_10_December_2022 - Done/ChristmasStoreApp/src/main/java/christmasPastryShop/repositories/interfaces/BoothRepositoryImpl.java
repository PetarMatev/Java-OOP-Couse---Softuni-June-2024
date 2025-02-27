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
    public Booth getByNumber(int number) {
        return this.models.stream().filter(m -> m.getBoothNumber() == number).findFirst().orElse(null);
    }

    @Override
    public Collection<Booth> getAll() {
        return this.models.stream().toList();
    }

    @Override
    public void add(Booth booth) {
        this.models.add(booth);
    }
}
