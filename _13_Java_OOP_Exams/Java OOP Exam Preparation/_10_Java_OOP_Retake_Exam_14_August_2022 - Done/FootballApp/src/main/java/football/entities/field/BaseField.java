package football.entities.field;

import football.entities.player.Player;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static football.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static football.common.ExceptionMessages.FIELD_NAME_NULL_OR_EMPTY;

public abstract class BaseField implements Field {

    private String name;
    private int capacity;
    private SupplementRepositoryImpl supplements;
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.supplements = new SupplementRepositoryImpl();
        this.players = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FIELD_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int sumEnergy() {
        int total = 0;
        for (Supplement supplement : getSupplements()) {
            total += supplement.getEnergy();
        }
        return total;
    }

    @Override
    public void addPlayer(Player player) {
        if (this.capacity > getPlayers().size()) {
            this.players.add(player);
        } else {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
    }

    @Override
    public void removePlayer(Player player) {
        getPlayers().remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        getSupplements().add(supplement);
    }

    @Override
    public void drag() {
        getPlayers().forEach(Player::stimulation);
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):", this.name, getClass().getSimpleName())).append(System.lineSeparator());
        if (this.players.size() == 0) {
            sb.append("Player: none").append(System.lineSeparator());
        } else {
            String joinedPlayers = this.players.stream()
                    .map(Player::getName) // Assuming Player has a getName() method
                    .collect(Collectors.joining(" "));
            sb.append(String.format("Player: %s", joinedPlayers)).append(System.lineSeparator());
        }
        sb.append(String.format("Supplement: %d", this.supplements.getSupplements().size())).append(System.lineSeparator());
        sb.append(String.format("Energy: %d", this.sumEnergy())).append(System.lineSeparator());
        return sb.toString().trim();
    }

    @Override
    public Collection<Player> getPlayers() {
        return this.players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements.getSupplements();
    }

    @Override
    public String getName() {
        return this.name;
    }
}
