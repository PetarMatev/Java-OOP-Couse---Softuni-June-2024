package christmasPastryShop.entities.cocktails.interfaces;

public abstract class BaseCocktail implements Cocktail {

    private String name;
    private int size;
    private double price;
    private String brand;

    protected BaseCocktail(String name, int size, double price, String brand) {
        this.name = name;
        this.size = size;
        this.price = price;
        this.brand = brand;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String getBrand() {
        return null;
    }

    @Override
    public String toString() {
        return "BaseCocktail{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", price=" + price +
                ", brand='" + brand + '\'' +
                '}';
    }
}
