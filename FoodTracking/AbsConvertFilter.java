package FoodTracking;

public abstract class AbsConvertFilter implements ServConvertFilterIF
{
    protected ServConvertFilterIF scf;
    protected ServingInfo servInfo;

    public AbsConvertFilter(ServConvertFilterIF scf)
    {
        this.scf = scf;
    }

    public AbsConvertFilter(ServingInfo servInfo)
    {
        this.servInfo = servInfo;
    }

}
