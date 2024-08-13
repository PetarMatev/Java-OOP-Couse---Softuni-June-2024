package Java_OOP_June_2024._02_Encapsulation._03_Exercise._04_Pizza_Calories;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (flourType.equals("Wholegrain") || flourType.equals("White")) {
            this.flourType = flourType;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (bakingTechnique.equals("Chewy") || bakingTechnique.equals("Crispy") || bakingTechnique.equals("Homemade")) {
            this.bakingTechnique = bakingTechnique;
        } else {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setWeight(double weight) {
        if (weight >= 1 && weight <= 200) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public double calculateCalories() {
        this.flourType = this.flourType.toUpperCase();
        double valueOfFlourType = DoughModifier.valueOf(this.flourType).getModifier();
        this.bakingTechnique = this.bakingTechnique.toUpperCase();
        double valueOfBakingTechnique = DoughModifier.valueOf(this.bakingTechnique).getModifier();

        return 2 * this.weight * valueOfFlourType * valueOfBakingTechnique;
    }
}
