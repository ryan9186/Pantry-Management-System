package FoodTracking;

public class ServingInfo {
    public double servingSize;
    public ServingUnitIF servingUnit;
    public String unitName;
    public int servingsRemaining;

    public ServingInfo(double servingSize, ServingUnitIF sui, String unitName, int servingsRemaining) {
        this.servingSize = servingSize;
        this.unitName = unitName;
        this.servingUnit = sui;
        this.servingsRemaining = servingsRemaining;
    }

    public double getServingSize() {
        return servingSize;
    }

    public String getUnitName() {
        return unitName;
    }

    public int getServingsRemaining() { return servingsRemaining; }

    public void setServingSize(double servingSize) {
        this.servingSize = servingSize;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public void setServingsRemaining(int servingsRemaining) { this.servingsRemaining = servingsRemaining; }

    public void decrementServing() {this.servingsRemaining--;}
}

