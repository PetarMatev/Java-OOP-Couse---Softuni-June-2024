package harpoonDiver.models.divingSite;

import java.util.ArrayList;
import java.util.Collection;

import static harpoonDiver.common.ExceptionMessages.SITE_NAME_NULL_OR_EMPTY;

public class DivingSiteImpl implements DivingSite {

    private String name;
    private Collection<String> seaCreatures;

    public DivingSiteImpl(String name) {
        setName(name);
        this.seaCreatures = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(SITE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getSeaCreatures() {
        return this.seaCreatures;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
