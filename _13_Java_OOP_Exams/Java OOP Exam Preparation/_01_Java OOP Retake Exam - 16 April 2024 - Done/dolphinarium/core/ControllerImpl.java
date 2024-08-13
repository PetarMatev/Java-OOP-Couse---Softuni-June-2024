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
import java.util.Iterator;

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
        if (!poolType.equals("DeepWaterPool") && !poolType.equals("ShallowWaterPool")) {
            throw new NullPointerException(INVALID_POOL_TYPE);
        }


        if (pools.stream().anyMatch(pool -> pool.getName().equals(poolName))) {
            throw new NullPointerException(POOL_EXISTS);
        }

        Pool pool;
        switch (poolType) {
            case "DeepWaterPool":
                pool = new DeepWaterPool(poolName);
                pools.add(pool);
                break;
            case "ShallowWaterPool":
                pool = new ShallowWaterPool(poolName);
                pools.add(pool);
                break;
        }
        return String.format(SUCCESSFULLY_ADDED_POOL_TYPE, poolType, poolName);
    }

    @Override
    public String buyFood(String foodType) {

        if (!foodType.equals("Squid") && !foodType.equals("Herring") && !foodType.equals("Mackerel")) {
            throw new IllegalArgumentException(INVALID_FOOD_TYPE);
        }

        Food food;
        switch (foodType) {
            case "Squid":
                food = new Squid();
                foodRepository.add(food);
                break;
            case "Herring":
                food = new Herring();
                foodRepository.add(food);
                break;
            case "Mackerel":
                food = new Mackerel();
                foodRepository.add(food);
                break;
        }
        return String.format(SUCCESSFULLY_BOUGHT_FOOD_TYPE, foodType);
    }

    @Override
    public String addFoodToPool(String poolName, String foodType) {

        Food searchedFoodInRepository = foodRepository.findByType(foodType);
        if (searchedFoodInRepository == null) {
            throw new IllegalArgumentException(NO_FOOD_FOUND);
        }

        foodRepository.remove(searchedFoodInRepository);
        Pool searchedPool = pools.stream().filter(pool -> pool.getName().equals(poolName)).findFirst().orElse(null);
        searchedPool.addFood(searchedFoodInRepository);
        return String.format(SUCCESSFULLY_ADDED_FOOD_IN_POOL, foodType, poolName);
    }

    @Override
    public String addDolphin(String poolName, String dolphinType, String dolphinName, int energy) {

        if (!dolphinType.equals("BottleNoseDolphin") && !dolphinType.equals("SpottedDolphin") && !dolphinType.equals("SpinnerDolphin")) {
            throw new IllegalArgumentException(INVALID_DOLPHIN_TYPE);
        }

        Pool searchedPool = pools.stream().filter(pool -> pool.getName().equals(poolName)).findFirst().orElse(null);
        boolean searchedDolphine = searchedPool.getDolphins().stream().anyMatch(dolphin -> dolphin.getName().equals(dolphinName));

        if (searchedDolphine) {
            throw new IllegalArgumentException(DOLPHIN_EXISTS);
        }

        String typeOfSearchedPool = searchedPool.getClass().getSimpleName();
        Dolphin dolphin;
        switch (dolphinType) {
            case "SpinnerDolphin":
                if (typeOfSearchedPool.equals("ShallowWaterPool")) {
                    dolphin = new SpinnerDolphin(dolphinName, energy);
                    searchedPool.addDolphin(dolphin);
                    break;
                } else {
                    return POOL_NOT_SUITABLE;
                }
            case "BottleNoseDolphin":
                if (typeOfSearchedPool.equals("DeepWaterPool")) {
                    dolphin = new BottleNoseDolphin(dolphinName, energy);
                    searchedPool.addDolphin(dolphin);
                    break;
                } else {
                    return POOL_NOT_SUITABLE;
                }
            case "SpottedDolphin":
                if (typeOfSearchedPool.equals("DeepWaterPool") || typeOfSearchedPool.equals("ShallowWaterPool")) {
                    dolphin = new SpottedDolphin(dolphinName, energy);
                    searchedPool.addDolphin(dolphin);
                    break;
                } else {
                    return POOL_NOT_SUITABLE;
                }
        }
        return String.format(SUCCESSFULLY_ADDED_DOLPHIN_IN_POOL, dolphinType, dolphinName, poolName);
    }

    @Override
    public String feedDolphins(String poolName, String food) {
        Pool searchedPool = pools.stream().filter(pool -> pool.getName().equals(poolName)).findFirst().orElse(null);
        Food searchedFood = searchedPool.getFoods().stream().filter(searchedfood -> searchedfood.getClass().getSimpleName().equals(food)).findFirst().orElse(null);
        if (searchedFood == null) {
            throw new IllegalArgumentException(NO_FOOD_OF_TYPE_ADDED_TO_POOL);
        }
        searchedPool.getFoods().remove(searchedFood);
        searchedPool.getDolphins().stream().forEach(dolphine -> dolphine.eat(searchedFood));
        int fedDolphinsCount = searchedPool.getDolphins().size();
        return String.format(DOLPHINS_FED, fedDolphinsCount, poolName);
    }

    @Override
    public String playWithDolphins(String poolName) {
        int removedDolphins = 0;

        Pool searchedPool = pools.stream().filter(pool -> pool.getName().equals(poolName)).findFirst().orElse(null);
        int numberOfDolphins = searchedPool.getDolphins().size();
        if (numberOfDolphins == 0) {
            throw new IllegalArgumentException(NO_DOLPHINS);
        }

        Iterator<Dolphin> iterator = searchedPool.getDolphins().iterator();
        while (iterator.hasNext()) {
            Dolphin dolphin = iterator.next();
            dolphin.jump();
            if (dolphin.getEnergy() <= 0) {
                iterator.remove();
                removedDolphins++;
            }
        }
        return String.format(DOLPHINS_PLAY, poolName, removedDolphins);
    }

    @Override
    public String getStatistics() {

        StringBuilder stringBuilder = new StringBuilder();

        for (Pool pool : pools) {
            stringBuilder.append(String.format(DOLPHINS_FINAL, pool.getName())).append(System.lineSeparator());
            if (pool.getDolphins().size() == 0) {
                stringBuilder.append(NONE).append(System.lineSeparator());
            } else {
                Iterator<Dolphin> iterator = pool.getDolphins().iterator();

                while (iterator.hasNext()) {
                    Dolphin dolphin = iterator.next();
                    stringBuilder.append(dolphin.getName())
                            .append(" - ")
                            .append(dolphin.getEnergy());
                    if (iterator.hasNext()) {  // Check if this is not the last element
                        stringBuilder.append(DELIMITER);
                    }

                }
                stringBuilder.append(System.lineSeparator());
            }
        }
        return stringBuilder.toString();
    }
}
