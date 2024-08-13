package goldDigger.core;

import goldDigger.common.ConstantMessages;
import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static goldDigger.common.ConstantMessages.*;
import static goldDigger.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private DiscovererRepository discovererRepository;
    private SpotRepository spotRepository;
    private OperationImpl operation;
    private int totalInspectedSites;

    public ControllerImpl() {
        this.discovererRepository = new DiscovererRepository();
        this.spotRepository = new SpotRepository();
        this.operation = new OperationImpl();
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer = switch (kind) {
            case "Anthropologist" -> new Anthropologist(discovererName);
            case "Archaeologist" -> new Archaeologist(discovererName);
            case "Geologist" -> new Geologist(discovererName);
            default -> throw new IllegalArgumentException(DISCOVERER_INVALID_KIND);
        };
        this.discovererRepository.add(discoverer);
        return String.format(DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);
        Arrays.stream(exhibits).forEach(s -> spot.getExhibits().add(s));
        this.spotRepository.add(spot);
        return String.format(SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer searchedDiscoverer = this.discovererRepository.byName(discovererName);
        if (searchedDiscoverer == null) {
            throw new IllegalArgumentException(String.format(DISCOVERER_DOES_NOT_EXIST, discovererName));
        }
        this.discovererRepository.remove(searchedDiscoverer);
        return String.format(DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        Collection<Discoverer> filteredDiscoverers = this.discovererRepository
                .getCollection()
                .stream()
                .filter(discoverer -> discoverer.getEnergy() > 45)
                .collect(Collectors.toList());

        if (filteredDiscoverers.isEmpty()) {
            throw new IllegalArgumentException(SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }

        Spot searchedSpot = spotRepository.byName(spotName);
        operation.startOperation(searchedSpot, filteredDiscoverers);
        totalInspectedSites++;
        long excluded = discovererRepository.getCollection().stream().filter(d -> d.getEnergy() == 0).count();
        return String.format(INSPECT_SPOT, spotName, excluded);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(FINAL_SPOT_INSPECT, totalInspectedSites)).append(System.lineSeparator());
        sb.append(FINAL_DISCOVERER_INFO).append(System.lineSeparator());

        discovererRepository.getCollection().stream().forEach(discoverer -> {
                    sb.append(String.format(FINAL_DISCOVERER_NAME, discoverer.getName())).append(System.lineSeparator());
                    sb.append(String.format(FINAL_DISCOVERER_ENERGY, discoverer.getEnergy())).append(System.lineSeparator());
                    if (discoverer.getMuseum().getExhibits().isEmpty()) {
                        sb.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, "None")).append(System.lineSeparator());
                    } else {
                        String currentExhibits = String.join(ConstantMessages.FINAL_DISCOVERER_MUSEUM_EXHIBITS_DELIMITER, discoverer.getMuseum().getExhibits());
                        sb.append(String.format(FINAL_DISCOVERER_MUSEUM_EXHIBITS, currentExhibits)).append(System.lineSeparator());
                    }
                }
        );
        return sb.toString().trim();
    }
}
