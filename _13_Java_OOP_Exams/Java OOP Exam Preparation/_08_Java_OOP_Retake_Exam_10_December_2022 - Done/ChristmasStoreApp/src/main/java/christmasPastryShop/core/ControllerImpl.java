package christmasPastryShop.core;

import christmasPastryShop.core.interfaces.Controller;
import christmasPastryShop.entities.booths.interfaces.Booth;
import christmasPastryShop.entities.booths.interfaces.OpenBooth;
import christmasPastryShop.entities.booths.interfaces.PrivateBooth;
import christmasPastryShop.entities.cocktails.interfaces.Cocktail;
import christmasPastryShop.entities.cocktails.interfaces.Hibernation;
import christmasPastryShop.entities.cocktails.interfaces.MulledWine;
import christmasPastryShop.entities.delicacies.interfaces.Delicacy;
import christmasPastryShop.entities.delicacies.interfaces.Gingerbread;
import christmasPastryShop.entities.delicacies.interfaces.Stolen;
import christmasPastryShop.repositories.interfaces.BoothRepository;
import christmasPastryShop.repositories.interfaces.CocktailRepository;
import christmasPastryShop.repositories.interfaces.DelicacyRepository;

import java.util.Collection;
import java.util.stream.Collectors;

import static christmasPastryShop.common.ExceptionMessages.BOOTH_EXIST;
import static christmasPastryShop.common.ExceptionMessages.FOOD_OR_DRINK_EXIST;
import static christmasPastryShop.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private DelicacyRepository<Delicacy> delicacyRepository;
    private CocktailRepository<Cocktail> cocktailRepository;
    private BoothRepository<Booth> boothRepository;
    private double totalIncome = 0;

    public ControllerImpl(DelicacyRepository<Delicacy> delicacyRepository, CocktailRepository<Cocktail> cocktailRepository, BoothRepository<Booth> boothRepository) {
        this.delicacyRepository = delicacyRepository;
        this.cocktailRepository = cocktailRepository;
        this.boothRepository = boothRepository;
    }

    @Override
    public String addDelicacy(String type, String name, double price) {
        Delicacy delicacy = delicacyRepository.getByName(name);
        if (delicacy != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
        delicacy = switch (type) {
            case "Gingerbread" -> new Gingerbread(name, price);
            case "Stolen" -> new Stolen(name, price);
            default -> delicacy;
        };
        delicacyRepository.add(delicacy);
        return String.format(DELICACY_ADDED, name, type);
    }

    @Override
    public String addCocktail(String type, String name, int size, String brand) {
        Cocktail cocktail = cocktailRepository.getByName(name);
        if (cocktail != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }
        cocktail = switch (type) {
            case "Hibernation" -> new Hibernation(name, size, brand);
            case "MulledWine" -> new MulledWine(name, size, brand);
            default -> cocktail;
        };

        cocktailRepository.add(cocktail);
        return String.format(COCKTAIL_ADDED, name, brand);
    }

    @Override
    public String addBooth(String type, int boothNumber, int capacity) {
        Booth booth = boothRepository.getByNumber(boothNumber);
        if (booth != null) {
            throw new IllegalArgumentException(String.format(BOOTH_EXIST, boothNumber));
        }
        booth = switch (type) {
            case "OpenBooth" -> new OpenBooth(boothNumber, capacity);
            case "PrivateBooth" -> new PrivateBooth(boothNumber, capacity);
            default -> booth;
        };
        boothRepository.add(booth);
        return String.format(BOOTH_ADDED, boothNumber);
    }

    @Override
    public String reserveBooth(int numberOfPeople) {
        Collection<Booth> listOfAvailableBoots = boothRepository.getAll().stream().filter(b -> !b.isReserved()).collect(Collectors.toList());
        if (listOfAvailableBoots.size() == 0) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }

        Booth availableBoot = listOfAvailableBoots.stream().filter(booth -> booth.getCapacity() >= numberOfPeople).findFirst().orElse(null);

        if (availableBoot == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }

        availableBoot.reserve(numberOfPeople);
        return String.format(BOOTH_RESERVED, availableBoot.getBoothNumber(), numberOfPeople);
    }

    @Override
    public String leaveBooth(int boothNumber) {
        Booth booth = boothRepository.getByNumber(boothNumber);
        double curentIncome = booth.getBill();
        totalIncome += curentIncome;
        booth.clear();
        return String.format(BILL, boothNumber, curentIncome);
    }

    @Override
    public String getIncome() {
        return String.format(TOTAL_INCOME, this.totalIncome);
    }
}
