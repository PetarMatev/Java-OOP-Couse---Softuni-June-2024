package Java_OOP_June_2024._02_Encapsulation._03_Exercise._05_Football_Team_Generator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String playerName) {
        if (!players.removeIf(player -> player.getName().equals(playerName))) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", playerName, name));
        }
    }

    public double getRating() {
        return this.players.stream().map(Player::overallSkillLevel).mapToDouble(Double::doubleValue).average().orElse(0);
    }
}
