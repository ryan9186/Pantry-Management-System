package FoodTracking;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Food {
    private String name;
    private ServingInfo servingInfo;
    private GregorianCalendar expiry;
    private ArrayList<Nutrient> nutrients;

    public Food(String name, ServingInfo servingInfo, GregorianCalendar expiry, ArrayList<Nutrient> nutrients){
        this.name = name;
        this.servingInfo = servingInfo;
        this.expiry = expiry;
        this.nutrients = nutrients;
    }

    private Food(Builder builder)
    {
        name = builder.foodName;
        servingInfo = builder.servingInfo;
        expiry = builder.expiry;
        nutrients = builder.nutrients;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public ServingInfo getServingInfo() {
        return servingInfo;
    }

    public void setServingInfo(ServingInfo servingInfo){
        this.servingInfo = servingInfo;
    }

    public GregorianCalendar getExpiry(){
        return expiry;
    }

    public void setExpiry(GregorianCalendar expiry){
        this.expiry = expiry;
    }

    public ArrayList<Nutrient> getNutrients(){
        return this.nutrients;
    }

    public void setNutrients(ArrayList<Nutrient> nutrients){
        this.nutrients = nutrients;
    }

    public static class Builder
    {
        private String foodName;
        private ServingInfo servingInfo;
        private GregorianCalendar expiry;
        private ArrayList<Nutrient> nutrients;

        public Builder name(String foodName)
        {
            this.foodName = foodName;
            return this;
        }

        public Builder servingInfo(double servingSize, ServingUnitIF sui, String unitName, int servingsRemaining)
        {
            ServingInfo si = new ServingInfo(servingSize, sui, unitName, servingsRemaining);
            this.servingInfo = si;
            return this;
        }

        public Builder date(int day, int month, int year)
        {
            GregorianCalendar gc = new GregorianCalendar(day, month, year);
            this.expiry = gc;
            return this;
        }

        public Builder nutrients(ArrayList<Nutrient> nutrients)
        {
            this.nutrients = nutrients;
            return this;
        }

        public Food build()
        {
            return new Food(this);
        }
    }
}
