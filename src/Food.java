import java.util.Date;

public class Food {
    private String name;
    private ServingInfo servingInfo;
    private Date expiry;
    private Nutrient[] nutrients;

    public Food(String name, ServingInfo servingInfo, Date expiry, Nutrient[] nutrients){
        this.name = name;
        this.servingInfo = servingInfo;
        this.expiry = expiry;
        this.nutrients = nutrients;
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

    public Date getExpiry(){
        return expiry;
    }

    public void setExpiry(Date expiry){
        this.expiry = expiry;
    }

    public Nutrient[] getNutrients(){
        return this.nutrients;
    }

    public void setNutrients(Nutrient[] nutrients){
        this.nutrients = nutrients;
    }
}
