package dolphinarium.core;

import dolphinarium.entities.dolphins.BottleNoseDolphin;
import dolphinarium.entities.dolphins.Dolphin;
import dolphinarium.entities.dolphins.SpinnerDolphin;
import dolphinarium.entities.dolphins.SpottedDolphin;
import dolphinarium.entities.foods.Food;
import dolphinarium.entities.foods.Herring;
import dolphinarium.entities.foods.Mackerel;
import dolphinarium.entities.foods.Squid;
import dolphinarium.entities.pools.DeepWaterPool;
import dolphinarium.entities.pools.Pool;
import dolphinarium.entities.pools.ShallowWaterPool;
import dolphinarium.repositories.FoodRepository;
import dolphinarium.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

import static dolphinarium.common.ConstantMessages.*;
import static dolphinarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private FoodRepository foodRepository;
    private Collection<Pool> pools;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.pools = new ArrayList<>();
    }

    @Override
    public String addPool(String poolType, String poolName) {
        Pool pool = pools.stream().filter(p -> p.getName().equals(poolName)).findFirst().orElse(null);
        if (pool != null) {
            throw new NullPointerException(POOL_EXISTS);
        }
        switch (poolType) {
            case "DeepWaterPool":
                pool = new DeepWaterPool(poolName);
                break;
            case "ShallowWaterPool":
                pool = new ShallowWaterPool(poolName);
                break;
            default:
                throw new NullPointerException(INVALID_POOL_TYPE);
        }
        pools.add(pool);
        return SUCCESSFULLY_ADDED_POOL_TYPE.formatted(poolType, poolName);
    }

    @Override
    public String buyFood(String foodType) {
        Food food = null;
        switch (foodType) {
            case "Squid":
                food = new Squid();
                break;
            case "Herring":
                food = new Herring();
                break;
            case "Mackerel":
                food = new Mackerel();
                break;
            default:
                throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }
        foodRepository.add(food);
        return SUCCESSFULLY_BOUGHT_FOOD_TYPE.formatted(foodType);
    }

    @Override
    public String addFoodToPool(String poolName, String foodType) {
        Food food = foodRepository.findByType(foodType);
        if (food == null) {
            throw new IllegalArgumentException(NO_FOOD_FOUND.formatted(foodType));
        }

        Pool pool = pools.stream().filter(p -> p.getName().equals(poolName)).findFirst().orElse(null);
        pool.addFood(food);
        foodRepository.remove(food);
        return SUCCESSFULLY_ADDED_FOOD_IN_POOL.formatted(foodType, poolName);
    }

    @Override
    public String addDolphin(String poolName, String dolphinType, String dolphinName, int energy) {
        Pool pool = pools.stream().filter(p -> p.getName().equals(poolName)).findFirst().orElse(null);
        Dolphin dolphin = pool.getDolphins().stream().filter(d -> d.getName().equals(dolphinName)).findFirst().orElse(null);
        if (dolphin != null) {
            throw new IllegalArgumentException(DOLPHIN_EXISTS);
        }
        switch (dolphinType) {
            case "BottleNoseDolphin":
                dolphin = new BottleNoseDolphin(dolphinName, energy);
                break;
            case "SpottedDolphin":
                dolphin = new SpottedDolphin(dolphinName, energy);
                break;
            case "SpinnerDolphin":
                dolphin = new SpinnerDolphin(dolphinName, energy);
                break;
            default:
                throw new IllegalArgumentException(INVALID_DOLPHIN_TYPE);
        }

        if (poolName.equals("DeepWaterPool")) {
            if (!dolphinType.equals("BottleNoseDolphin") && !dolphinType.equals("SpottedDolphin")) {
                return POOL_NOT_SUITABLE;
            }
        } else if (poolName.equals("ShallowWaterPool")) {
            if (!dolphinType.equals("SpinnerDolphin") && !dolphinType.equals("SpottedDolphin")) {
                return POOL_NOT_SUITABLE;
            }
        }

        pool.addDolphin(dolphin);
        return SUCCESSFULLY_ADDED_DOLPHIN_IN_POOL.formatted(dolphinType, dolphinName, poolName);
    }

    @Override
    public String feedDolphins(String poolName, String food) {
        Pool pool = pools.stream().filter(p -> p.getName().equals(poolName)).findFirst().orElse(null);
        Food searchedFood = pool.getFoods().stream().filter(f -> f.getClass().getSimpleName().equals(food)).findFirst().orElse(null);
        if (searchedFood == null) {
            throw new IllegalArgumentException(NO_FOOD_OF_TYPE_ADDED_TO_POOL);
        }
        int dolphineCounter = pool.getDolphins().size();
        pool.getDolphins().forEach(dolphin -> dolphin.eat(searchedFood));
        pool.getFoods().remove(searchedFood);
        return DOLPHINS_FED.formatted(dolphineCounter, poolName);
    }

    @Override
    public String playWithDolphins(String poolName) {
        Pool pool = pools.stream().filter(p -> p.getName().equals(poolName)).findFirst().orElse(null);
        if (pool.getDolphins().isEmpty()) {
            throw new IllegalArgumentException(NO_DOLPHINS);
        }

        pool.getDolphins().stream().forEach(dolphin -> dolphin.jump());
        long counter = pool.getDolphins().stream().filter(d -> d.getEnergy() <= 0).count();
        pool.getDolphins().removeIf(dolphin -> dolphin.getEnergy() <= 0);
        return DOLPHINS_PLAY.formatted(poolName, counter);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Pool pool : pools) {
            stringBuilder.append(DOLPHINS_FINAL.formatted(pool.getName())).append(System.lineSeparator());
            if (pool.getDolphins().size() == 0) {
                stringBuilder.append(NONE).append(System.lineSeparator());
            } else {
                StringBuilder listOfDolphins = new StringBuilder();
                Collection<Dolphin> dolphins = pool.getDolphins();
                int dolphinCount = dolphins.size();
                int currentIndex = 0;
                for (Dolphin currentDolphin : dolphins) {
                    listOfDolphins.append(String.format("%s - %d", currentDolphin.getName(), currentDolphin.getEnergy()));
                    if (currentIndex < dolphinCount - 1) {
                        listOfDolphins.append(DELIMITER);
                    }
                    currentIndex++;
                }
                stringBuilder.append(listOfDolphins).append(System.lineSeparator());
            }
        }
        return stringBuilder.toString().trim();
    }
}
