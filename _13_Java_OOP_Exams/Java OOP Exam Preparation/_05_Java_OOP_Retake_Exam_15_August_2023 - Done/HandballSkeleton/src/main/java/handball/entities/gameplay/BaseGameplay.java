package handball.entities.gameplay;

import handball.entities.equipment.Equipment;
import handball.entities.team.Team;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static handball.common.ExceptionMessages.GAMEPLAY_NAME_NULL_OR_EMPTY;

public abstract class BaseGameplay implements Gameplay {

    private String name;
    private int capacity;
    private Collection<Equipment> equipments;
    private Collection<Team> teams;

    public BaseGameplay(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.equipments = new ArrayList<>();
        this.teams = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(GAMEPLAY_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int allProtection() {
        return equipments.stream().mapToInt(Equipment::getProtection).sum();
    }

    @Override
    public void addTeam(Team team) {
        teams.add(team);
    }

    @Override
    public void removeTeam(Team team) {
        teams.remove(team);
    }

    @Override
    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
    }

    @Override
    public void teamsInGameplay() {
        teams.forEach(Team::play);
    }

    @Override
    public Collection<Team> getTeam() {
        return this.teams.stream().toList();
    }

    @Override
    public Collection<Equipment> getEquipments() {
        return this.equipments.stream().toList();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s %s\nTeam: %s\nEquipment: %d, Protection: %d\n",
                this.name, this.getClass().getSimpleName(),
                this.teams.stream().map(Team::getName).collect(Collectors.joining(" ")),
                this.equipments.size(),
                allProtection());
    }
}
