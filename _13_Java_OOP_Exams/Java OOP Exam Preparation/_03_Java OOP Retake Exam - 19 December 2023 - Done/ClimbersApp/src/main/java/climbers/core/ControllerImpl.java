package climbers.core;

import climbers.models.climber.Climber;
import climbers.models.climber.RockClimber;
import climbers.models.climber.WallClimber;
import climbers.models.climbing.ClimbingImpl;
import climbers.models.mountain.Mountain;
import climbers.models.mountain.MountainImpl;
import climbers.repositories.ClimberRepository;
import climbers.repositories.MountainRepository;

import java.util.Collection;
import java.util.List;

import static climbers.common.ConstantMessages.*;
import static climbers.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    ClimberRepository climbers;
    MountainRepository mountains;
    ClimbingImpl climbing;
    private int climbedMountains;

    public ControllerImpl() {
        this.climbers = new ClimberRepository();
        this.mountains = new MountainRepository();
        climbing = new ClimbingImpl();
        climbedMountains = 0;
    }

    @Override
    public String addClimber(String type, String climberName) {
        Climber climber = switch (type) {
            case "RockClimber" -> new RockClimber(climberName);
            case "WallClimber" -> new WallClimber(climberName);
            default -> throw new IllegalArgumentException(CLIMBER_INVALID_TYPE);
        };
        climbers.add(climber);
        return String.format(CLIMBER_ADDED, type, climberName);
    }

    @Override
    public String addMountain(String mountainName, String... peaks) {
        Mountain mountain = new MountainImpl(mountainName); // create the Mountain
        mountain.getPeaksList().addAll(List.of(peaks)); // add List.of(peaks)
        mountains.add(mountain); // add the mountain to the repository
        return String.format(MOUNTAIN_ADDED, mountainName);
    }

    @Override
    public String removeClimber(String climberName) {
        Climber climber = climbers.getCollection().stream().filter(c -> c.getName().equals(climberName)).findFirst().orElse(null);
        if (climber == null) {
            throw new IllegalArgumentException(String.format(CLIMBER_DOES_NOT_EXIST, climberName));
        }
        climbers.remove(climber);
        return String.format(CLIMBER_REMOVE, climberName);
    }

    @Override
    public String startClimbing(String mountainName) {
        Collection<Climber> listOfClimbers = this.climbers.getCollection();
        if (listOfClimbers.isEmpty()) {
            throw new IllegalArgumentException(THERE_ARE_NO_CLIMBERS);
        }
        Mountain mountain = mountains.byName(mountainName);
        climbing.conqueringPeaks(mountain, listOfClimbers);
        climbedMountains++;
        long removed = listOfClimbers.stream().filter(c -> c.getStrength() == 0).count();
        return String.format(PEAK_CLIMBING, mountainName, removed);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(FINAL_MOUNTAIN_COUNT, climbedMountains)).append(System.lineSeparator());
        stringBuilder.append(FINAL_CLIMBERS_STATISTICS).append(System.lineSeparator());
        for (Climber climber : climbers.getCollection()) {
            stringBuilder.append(String.format(FINAL_CLIMBER_NAME, climber.getName())).append(System.lineSeparator());
            stringBuilder.append(String.format(FINAL_CLIMBER_STRENGTH, climber.getStrength())).append(System.lineSeparator());
            List<String> peaks = climber.getRoster().getPeaks().stream().toList();
            String conqueredPeaks = String.join(FINAL_CLIMBER_FINDINGS_DELIMITER, peaks);
            stringBuilder.append(String.format(FINAL_CLIMBER_PEAKS, conqueredPeaks)).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
