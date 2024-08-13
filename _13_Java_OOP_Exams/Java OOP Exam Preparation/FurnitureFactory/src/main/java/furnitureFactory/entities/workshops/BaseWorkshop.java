package furnitureFactory.entities.workshops;

import furnitureFactory.entities.wood.OakWood;
import furnitureFactory.entities.wood.Wood;

public abstract class BaseWorkshop implements Workshop {

    private int woodQuantity;
    private int producedFurnitureCount;
    private int woodQuantityReduceFactor;

    protected BaseWorkshop(int woodQuantity, int woodQuantityReduceFactor) {
        this.woodQuantity = Math.max(0, woodQuantity);
        this.producedFurnitureCount = 0;
        this.woodQuantityReduceFactor = woodQuantityReduceFactor;
    }

    @Override
    public void addWood(Wood wood) {
        int IncreaseQuantityByAmount = 200;
        if (wood instanceof OakWood) {
            this.woodQuantity += IncreaseQuantityByAmount;
        }
    }

    @Override
    public void produce() {
        this.woodQuantity -= this.woodQuantityReduceFactor;
        if (this.woodQuantity < 0) {
            this.woodQuantity = 0;
        }
        this.producedFurnitureCount += 1;
    }

    @Override
    public int getWoodQuantity() {
        return this.woodQuantity;
    }

    @Override
    public int getProducedFurnitureCount() {
        return this.producedFurnitureCount;
    }

    @Override
    public int getWoodQuantityReduceFactor() {
        return this.woodQuantityReduceFactor;
    }
}
