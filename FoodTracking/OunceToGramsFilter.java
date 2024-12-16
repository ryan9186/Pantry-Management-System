package FoodTracking;

public class OunceToGramsFilter extends AbsConvertFilter
{

    public OunceToGramsFilter(ServingInfo servInfo)
    {
        super(servInfo);
    }

    public OunceToGramsFilter(ServConvertFilterIF sfi)
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
        if(servInfo.servingUnit instanceof OunceUnit)
        {
            String newUnitName = "Cups";
            GramsUnit gu = new Grams();
            double newServingSize = (servInfo.getServingSize() / 28.3); // 28.3 grams in an ounce
            si = new ServingInfo(newServingSize, gu, newUnitName, servInfo.getServingsRemaining());
        }
        return si;
    }
}
