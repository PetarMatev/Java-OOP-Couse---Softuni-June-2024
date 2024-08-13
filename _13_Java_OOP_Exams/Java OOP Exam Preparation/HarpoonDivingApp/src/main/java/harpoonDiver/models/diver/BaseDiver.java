package harpoonDiver.models.diver;

import harpoonDiver.models.seaCatch.BaseSeaCatch;
import harpoonDiver.models.seaCatch.SeaCatch;

public abstract class BaseDiver implements Diver {

    private String name;
    private double oxygen;
    private SeaCatch seaCatch;

    protected BaseDiver(String name, double oxygen) {
        this.name = name;
        this.oxygen = oxygen;
        this.seaCatch = new BaseSeaCatch();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getOxygen() {
        return 0;
    }

    @Override
    public boolean canDive() {
        return false;
    }

    @Override
    public SeaCatch getSeaCatch() {
        return null;
    }

    @Override
    public void shoot() {

    }
}
