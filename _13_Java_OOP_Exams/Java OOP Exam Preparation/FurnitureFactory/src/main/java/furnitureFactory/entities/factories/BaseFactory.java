package furnitureFactory.entities.factories;

import furnitureFactory.entities.workshops.Workshop;

import java.util.ArrayList;
import java.util.Collection;

import static furnitureFactory.common.ExceptionMessages.FACTORY_NAME_NULL_OR_EMPTY;

public abstract class BaseFactory implements Factory {

    private String name;
    private Collection<Workshop> workshops;
    private Collection<Workshop> removedWorkshops;

    protected BaseFactory(String name) {
        setName(name);
        this.workshops = new ArrayList<>();
        this.removedWorkshops = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FACTORY_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addWorkshop(Workshop workshop) {
        this.workshops.add(workshop);
    }

    @Override
    public Collection<Workshop> getWorkshops() {
        return this.workshops;
    }

    @Override
    public Collection<Workshop> getRemovedWorkshops() {
        return this.removedWorkshops;
    }

    protected void removeWorkshop(Workshop workshop) {
        if (this.workshops.remove(workshop)) {
            this.removedWorkshops.add(workshop);
        }
    }
}
