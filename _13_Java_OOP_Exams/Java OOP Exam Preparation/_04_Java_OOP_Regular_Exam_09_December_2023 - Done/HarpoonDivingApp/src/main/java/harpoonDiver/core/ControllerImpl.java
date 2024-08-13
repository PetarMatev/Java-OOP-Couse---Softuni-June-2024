package harpoonDiver.core;

import harpoonDiver.models.diver.DeepWaterDiver;
import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.diver.OpenWaterDiver;
import harpoonDiver.models.diver.WreckDiver;
import harpoonDiver.models.diving.DivingImpl;
import harpoonDiver.models.divingSite.DivingSite;
import harpoonDiver.models.divingSite.DivingSiteImpl;
import harpoonDiver.repositories.DiverRepository;
import harpoonDiver.repositories.DivingSiteRepository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static harpoonDiver.common.ConstantMessages.*;
import static harpoonDiver.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private DiverRepository diverRepository;
    private DivingSiteRepository divingSiteRepository;
    private DivingImpl diving;
    private int divingSiteCounters;

    public ControllerImpl() {
        this.diverRepository = new DiverRepository();
        this.divingSiteRepository = new DivingSiteRepository();
        this.diving = new DivingImpl();
    }

    @Override
    public String addDiver(String kind, String diverName) {

        Diver diver;
        if (kind.equals("DeepWaterDiver")) {
            diver = new DeepWaterDiver(diverName);
        } else if (kind.equals("OpenWaterDiver")) {
            diver = new OpenWaterDiver(diverName);
        } else if (kind.equals("WreckDiver")) {
            diver = new WreckDiver(diverName);
        } else {
            throw new IllegalArgumentException(DIVER_INVALID_KIND);
        }
        diverRepository.add(diver);
        return String.format(DIVER_ADDED, kind, diverName);
    }

    @Override
    public String addDivingSite(String siteName, String... seaCreatures) {
        DivingSite divingSite = new DivingSiteImpl(siteName);
        divingSite.getSeaCreatures().addAll(List.of(seaCreatures));
        divingSiteRepository.add(divingSite);
        return String.format(DIVING_SITE_ADDED, siteName);
    }

    @Override
    public String removeDiver(String diverName) {
        if (!diverRepository.remove(diverRepository.byName(diverName))) {
            throw new IllegalArgumentException(String.format(DIVER_DOES_NOT_EXIST, diverName));
        }
        return String.format(DIVER_REMOVE, diverName);
    }

    @Override
    public String startDiving(String siteName) {
        divingSiteCounters++;
        List<Diver> divers = diverRepository.getCollection().stream().filter(diver -> diver.getOxygen() > 30).toList();
        if (divers.size() == 0) {
            throw new IllegalArgumentException(SITE_DIVERS_DOES_NOT_EXISTS);
        }
        DivingSite divingSite = divingSiteRepository.byName(siteName);
        diving.searching(divingSite, divers);
        long removed = divers.stream().filter(d -> d.getOxygen() == 0).count();
        List<Diver> diversList = divers.stream().toList();
        return String.format(SITE_DIVING, siteName, removed);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(FINAL_DIVING_SITES, divingSiteCounters)).append(System.lineSeparator());
        stringBuilder.append(FINAL_DIVERS_STATISTICS).append(System.lineSeparator());
        for (Diver diver : diverRepository.getCollection()) {
            stringBuilder.append(String.format(FINAL_DIVER_NAME, diver.getName())).append(System.lineSeparator());
            stringBuilder.append(String.format(FINAL_DIVER_OXYGEN, diver.getOxygen())).append(System.lineSeparator());

            long catchCounter = diver.getSeaCatch().getSeaCreatures().size();
            if (catchCounter == 0) {
                stringBuilder.append(String.format("Diver's catch: %s", "None")).append(System.lineSeparator());
            } else {
                Collection<String> seaCreaturesCaught = diver.getSeaCatch().getSeaCreatures().stream().toList();
                String catchOfDiver = String.join(FINAL_DIVER_CATCH_DELIMITER, seaCreaturesCaught);
                stringBuilder.append(String.format(FINAL_DIVER_CATCH, catchOfDiver)).append(System.lineSeparator());
            }
        }
        return stringBuilder.toString().trim();
    }
}
