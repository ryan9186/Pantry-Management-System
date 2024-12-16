package FoodTracking;

public class Nutrient {
    private String nutrientName;
    private double nutrientAmount;

    public Nutrient(String name, double amount){
        this.nutrientName = name;
        this.nutrientAmount = amount;
    }

    public String getName() {
        return nutrientName;
    }

    public void setName(String name){
        this.nutrientName = name;
    }

    public double getAmount(){
        return this.nutrientAmount;
    }

    public void setAmount(double amount){
        this.nutrientAmount = amount;
    }


}
