package FoodTracking;

public class Fl_Oz_ToCupsFilter extends AbsConvertFilter
{

    public Fl_Oz_ToCupsFilter(ServingInfo servInfo)
    {
        super(servInfo);
    }

    public Fl_Oz_ToCupsFilter(ServConvertFilterIF sfi)
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
        if(servInfo.servingUnit instanceof Fl_Oz_Unit)
        {
            String newUnitName = "Cups";
            CupsUnit cu = new Cups();
            double newServingSize = (servInfo.getServingSize() / 8); // 8 fl oz in one cup
            si = new ServingInfo(newServingSize, cu, newUnitName, servInfo.getServingsRemaining());
        }
        return si;
    }
}
