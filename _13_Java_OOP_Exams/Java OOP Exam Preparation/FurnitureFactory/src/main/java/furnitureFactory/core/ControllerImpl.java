package furnitureFactory.core;

import furnitureFactory.entities.factories.AdvancedFactory;
import furnitureFactory.entities.factories.Factory;
import furnitureFactory.entities.factories.OrdinaryFactory;
import furnitureFactory.entities.wood.OakWood;
import furnitureFactory.entities.wood.Wood;
import furnitureFactory.entities.workshops.DeckingWorkshop;
import furnitureFactory.entities.workshops.TableWorkshop;
import furnitureFactory.entities.workshops.Workshop;
import furnitureFactory.repositories.WoodRepository;
import furnitureFactory.repositories.WoodRepositoryImpl;
import furnitureFactory.repositories.WorkshopRepository;
import furnitureFactory.repositories.WorkshopRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import static furnitureFactory.common.ConstantMessages.*;
import static furnitureFactory.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private WoodRepository woodRepository;
    private WorkshopRepository workshopRepository;
    private Collection<Factory> factories;

    public ControllerImpl() {
        this.woodRepository = new WoodRepositoryImpl();
        this.workshopRepository = new WorkshopRepositoryImpl();
        this.factories = new ArrayList<>();
    }

    @Override
    public String buildFactory(String factoryType, String factoryName) {
        Factory factory = switch (factoryType) {
            case "OrdinaryFactory" -> new OrdinaryFactory(factoryName);
            case "AdvancedFactory" -> new AdvancedFactory(factoryName);
            default -> throw new IllegalArgumentException(INVALID_FACTORY_TYPE);
        };

        Factory identicalNameFactory = this.factories.stream().filter(f -> f.getName().equals(factoryName)).findFirst().orElse(null);

        if (identicalNameFactory != null) {
            throw new NullPointerException(FACTORY_EXISTS);
        }
        this.factories.add(factory);
        return SUCCESSFULLY_BUILD_FACTORY_TYPE.formatted(factoryType, factoryName);
    }

    @Override
    public Factory getFactoryByName(String factoryName) {
        return this.factories.stream().filter(f -> f.getName().equals(factoryName)).findFirst().orElse(null);
    }

    @Override
    public String buildWorkshop(String workshopType, int woodCapacity) {
        Workshop workshop;
        switch (workshopType) {
            case "TableWorkshop":
                workshop = new TableWorkshop(woodCapacity);
                break;
            case "DeckingWorkshop":
                workshop = new DeckingWorkshop(woodCapacity);
                break;
            default:
                throw new IllegalArgumentException(INVALID_WORKSHOP_TYPE);
        }
        this.workshopRepository.add(workshop);
        return SUCCESSFULLY_BUILD_WORKSHOP_TYPE.formatted(workshopType);
    }

    @Override
    public String addWorkshopToFactory(String factoryName, String workshopType) {
        Workshop searchedWorkshop = this.workshopRepository.findByType(workshopType);
        if (searchedWorkshop == null) {
            throw new NullPointerException(NO_WORKSHOP_FOUND.formatted(workshopType));
        }

        Factory factory = this.getFactoryByName(factoryName);
        boolean withSameNameExist = factory.getWorkshops().stream()
                .anyMatch(workshop -> workshop.getClass().getSimpleName().equals(workshopType));
        if (withSameNameExist) {
            throw new IllegalArgumentException(WORKSHOP_EXISTS);
        }

        if (factory instanceof OrdinaryFactory && "TableWorkshop".equals(workshopType)) {
            factory.addWorkshop(searchedWorkshop);
            return SUCCESSFULLY_ADDED_WORKSHOP_IN_FACTORY.formatted(workshopType, factoryName);
        } else if (factory instanceof AdvancedFactory && "DeckingWorkshop".equals(workshopType)) {
            factory.addWorkshop(searchedWorkshop);
            return SUCCESSFULLY_ADDED_WORKSHOP_IN_FACTORY.formatted(workshopType, factoryName);
        } else {
            return NON_SUPPORTED_WORKSHOP;
        }
    }


    @Override
    public String buyWoodForFactory(String woodType) {
        Wood wood;
        if (!woodType.equals("OakWood")) {
            throw new IllegalArgumentException(INVALID_WOOD_TYPE);
        }
        wood = new OakWood();
        this.woodRepository.add(wood);
        return SUCCESSFULLY_BOUGHT_WOOD_FOR_FACTORY.formatted(woodType);
    }

    @Override
    public String addWoodToWorkshop(String factoryName, String workshopType, String woodType) {
        Wood wood = woodRepository.findByType(woodType);
        if (wood == null) {
            throw new NullPointerException(NO_WOOD_FOUND.formatted(woodType));
        }

        Factory factory = this.getFactoryByName(factoryName);
        Workshop workshop = factory.getWorkshops()
                .stream()
                .filter(w -> w.getClass().getSimpleName().equals(workshopType))
                .findFirst()
                .orElse(null);

        if (workshop == null) {
            throw new NullPointerException(NO_WORKSHOP_ADDED);
        }

        workshop.addWood(wood);
        this.woodRepository.remove(wood);
        return SUCCESSFULLY_ADDED_WOOD_IN_WORKSHOP.formatted(woodType, workshopType);
    }

    @Override
    public String produceFurniture(String factoryName) {
        Factory factory = this.getFactoryByName(factoryName);


        Collection<Workshop> workshops = factory.getWorkshops();
        if (workshops.isEmpty()) {
            throw new NullPointerException(THERE_ARE_NO_WORKSHOPS.formatted(factoryName));
        }

        int total = 0;

        Iterator<Workshop> iterator = workshops.iterator();

        while (iterator.hasNext()) {
            Workshop workshop = iterator.next();
            if (workshop.getWoodQuantity() >= workshop.getWoodQuantityReduceFactor()) {
                workshop.produce();
                total += 1;

                if (workshop.getWoodQuantity() <= 0) {
                    iterator.remove();
                    this.workshopRepository.remove(workshop);
                    factory.getRemovedWorkshops().add(workshop);
                    return WORKSHOP_STOPPED_WORKING.formatted(factoryName);
                }
            } else if (workshop.getWoodQuantity() > 0) {
                return INSUFFICIENT_WOOD.formatted(factoryName);
            }
        }
        if (total > 0) {
            return SUCCESSFUL_PRODUCTION.formatted(total, factoryName);
        }

        return FACTORY_DO_NOT_PRODUCED.formatted(factoryName);
    }

    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder();

        for (Factory factory : this.factories) {
            String factoryName = factory.getName();
            Collection<Workshop> workshops = factory.getWorkshops();

            reportBuilder.append("Production by ").append(factoryName).append(" factory:\n");

            if (workshops.isEmpty()) {
                reportBuilder.append("  No workshops were added to produce furniture.\n");
            } else {
                for (Workshop workshop : workshops) {
                    String workshopType = workshop.getClass().getSimpleName();
                    int producedCount = workshop.getProducedFurnitureCount();

                    reportBuilder.append("  ").append(workshopType).append(": ")
                            .append(producedCount).append(" furniture produced\n");
                }
            }
        }
        return reportBuilder.toString().trim();
    }
}
