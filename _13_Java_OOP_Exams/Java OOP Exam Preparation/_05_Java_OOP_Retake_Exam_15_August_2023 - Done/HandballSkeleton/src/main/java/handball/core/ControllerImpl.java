package handball.core;

import handball.entities.equipment.ElbowPad;
import handball.entities.equipment.Equipment;
import handball.entities.equipment.Kneepad;
import handball.entities.gameplay.Gameplay;
import handball.entities.gameplay.Indoor;
import handball.entities.gameplay.Outdoor;
import handball.entities.team.Bulgaria;
import handball.entities.team.Germany;
import handball.entities.team.Team;
import handball.repositories.EquipmentRepository;

import java.util.HashMap;
import java.util.Map;

import static handball.common.ConstantMessages.*;
import static handball.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private EquipmentRepository equipmentRepository;
    private Map<String, Gameplay> gamePlays;

    public ControllerImpl() {
        this.equipmentRepository = new EquipmentRepository();
        this.gamePlays = new HashMap<>();
    }

    @Override
    public String addGameplay(String gameplayType, String gameplayName) {
        Gameplay currentGamePlay = switch (gameplayType) {
            case "Outdoor" -> new Outdoor(gameplayName);
            case "Indoor" -> new Indoor(gameplayName);
            default -> throw new NullPointerException(INVALID_GAMEPLAY_TYPE);
        };

        this.gamePlays.put(gameplayName, currentGamePlay);
        return String.format(SUCCESSFULLY_ADDED_GAMEPLAY_TYPE, gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {
        Equipment equipment = switch (equipmentType) {
            case "Kneepad" -> new Kneepad();
            case "ElbowPad" -> new ElbowPad();
            default -> throw new IllegalArgumentException(INVALID_EQUIPMENT_TYPE);
        };
        this.equipmentRepository.add(equipment);
        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_TYPE, equipmentType);
    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {
        Equipment byTypeEquipment = equipmentRepository.findByType(equipmentType);
        if (byTypeEquipment == null) {
            throw new IllegalArgumentException(String.format(NO_EQUIPMENT_FOUND, equipmentType));
        }
        this.equipmentRepository.remove(byTypeEquipment);
        this.gamePlays.get(gameplayName).addEquipment(byTypeEquipment);
        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY, equipmentType, gameplayName);
    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
        Team currentTeam = switch (teamType) {
            case "Bulgaria" -> new Bulgaria(teamName, country, advantage);
            case "Germany" -> new Germany(teamName, country, advantage);
            default -> throw new IllegalArgumentException(INVALID_TEAM_TYPE);
        };

        Gameplay gameplay = gamePlays.get(gameplayName);
        String field = gameplay.getClass().getSimpleName();

        boolean successfulResult = false;

        if (field.equals("Outdoor") && teamType.equals("Bulgaria")) {
            successfulResult = true;

        } else if (field.equals("Indoor") && teamType.equals("Germany")) {
            successfulResult = true;
        }

        if (successfulResult) {
            this.gamePlays.get(gameplayName).addTeam(currentTeam);
            return String.format(SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
        } else {
            return GAMEPLAY_NOT_SUITABLE;
        }
    }

    @Override
    public String playInGameplay(String gameplayName) {
        Gameplay gameplay = this.gamePlays.get(gameplayName);
        gameplay.teamsInGameplay();
        return String.format(TEAMS_PLAYED, gameplay.getTeam().size());
    }

    @Override
    public String percentAdvantage(String gameplayName) {
        return String.format(ADVANTAGE_GAMEPLAY, gameplayName, this.gamePlays
                .get(gameplayName).getTeam().stream().mapToInt(Team::getAdvantage).sum());
    }

    @Override
    public String getStatistics() {
        StringBuilder outputResult = new StringBuilder();
        this.gamePlays.values().forEach(outputResult::append);
        return outputResult.toString().trim();
    }
}
