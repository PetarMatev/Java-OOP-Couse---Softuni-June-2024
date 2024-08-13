package christmasPastryShop.entities.delicacies.interfaces;

public abstract class BaseDelicacy implements Delicacy {

    private String name;
    private double portion;
    private double price;


    protected BaseDelicacy(String name, double portion, double price) {
        this.name = name;
        this.portion = portion;
        this.price = price;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public double getPortion() {
        return 0;
    }

    @Override
    public double getPrice() {
        return 0;
    }


    @Override
    public String toString() {
        return "BaseDelicacy{" +
                "name='" + name + '\'' +
                ", portion=" + portion +
                ", price=" + price +
                '}';
    }
}
