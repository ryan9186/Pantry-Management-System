package FoodTracking;

public class GramsToOunceFilter extends AbsConvertFilter
{

    public GramsToOunceFilter(ServingInfo servInfo)
    {
        super(servInfo);
    }

    public GramsToOunceFilter(ServConvertFilterIF sfi)
    {
        super(sfi);
    }

    @Override
    public ServingInfo getConversion()
    {
        ServingInfo si = null;
        if(scf != null)
        {
            si = scf.getConversion();
        }
        if(servInfo.servingUnit instanceof GramsUnit)
        {
            String newUnitName = "Cups";
            OunceUnit ou = new Ounces();
            double newServingSize = (servInfo.getServingSize() / 28.3); // 28.3 grams in an ounce
            si = new ServingInfo(newServingSize, ou, newUnitName, servInfo.getServingsRemaining());
        }
        return si;
    }
}
