package FoodTracking;

public class CupsToFl_Oz_Filter extends AbsConvertFilter
{

    public CupsToFl_Oz_Filter (ServingInfo servInfo)
    {
        super(servInfo);
    }

    public CupsToFl_Oz_Filter(ServConvertFilterIF sfi)
    {
        super(sfi);
    }

    @Override
    public ServingInfo getConversion()
    {
        ServingInfo si = servInfo;
        if(scf != null)
        {
            si = scf.getConversion();
        }
        if(servInfo.servingUnit instanceof CupsUnit)
        {
            String newUnitName = "Fl Oz";
            Fl_Oz fo = new Fl_Oz();
            double newServingSize = (servInfo.getServingSize() * 8); // 8 fl oz in one cup
            si = new ServingInfo(newServingSize, fo, newUnitName, servInfo.getServingsRemaining());
        }
        return si;
    }
}
