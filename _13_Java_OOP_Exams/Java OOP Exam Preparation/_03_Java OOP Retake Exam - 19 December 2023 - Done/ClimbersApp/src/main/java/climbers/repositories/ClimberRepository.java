package climbers.repositories;

import climbers.models.climber.Climber;

import java.util.ArrayList;
import java.util.Collection;

public class ClimberRepository implements Repository<Climber> {

    private Collection<Climber> climbers;

    public ClimberRepository() {
        this.climbers = new ArrayList<>();
    }

    @Override
    public Collection<Climber> getCollection() {
        return this.climbers.stream().toList();
    }

    @Override
    public void add(Climber entity) {
        climbers.add(entity);
    }

    @Override
    public boolean remove(Climber entity) {
        return climbers.remove(entity);
    }

    @Override
    public Climber byName(String name) {
        return climbers
                .stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
