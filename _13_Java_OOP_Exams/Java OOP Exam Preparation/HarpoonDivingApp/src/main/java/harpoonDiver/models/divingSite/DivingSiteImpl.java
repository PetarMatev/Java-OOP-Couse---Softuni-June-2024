package harpoonDiver.models.divingSite;

import java.util.ArrayList;
import java.util.Collection;

public class DivingSiteImpl implements DivingSite {

    private String name;
    private Collection<String> seaCreatures;

    protected DivingSiteImpl(String name) {
        this.name = name;
        this.seaCreatures = new ArrayList<>();
    }

    @Override
    public Collection<String> getSeaCreatures() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
