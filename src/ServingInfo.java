public class ServingInfo {
    private double servingSize;
    private String unitName;

    public ServingInfo(double servingSize, String unitName) {
        this.servingSize = servingSize;
        this.unitName = unitName;
    }

    public double getServingSize() {
        return servingSize;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setServingSize(double servingSize) {
        this.servingSize = servingSize;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}

