import Containers.MasterList;
import FoodTracking.*;
import GuiPages.UI_Handler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main
{

    public static void main(String[] args)
    {
        UI_Handler ui_handler = new UI_Handler();
        System.out.println(MasterList.getFoodList());
        ArrayList<Nutrient> n = new ArrayList<>();
        Nutrient nutrient = new Nutrient("Fat", 10);
        n.add(nutrient);
        Food food = new Food.Builder()
                .name("Pizza")
                .date(12, 12, 2024)
                .servingInfo(10, new Cups(), "Cups", 10)
                .nutrients(n)
                .build();
        MasterList.addFood(food);
        /*
        double d = 100;
        Fl_Oz fu = new Fl_Oz();
        String s = "Fl Oz";
        int i = 10;
        System.out.println(d + " " + fu.toString() + " " + s + " " + i);
        ServingInfo test = new ServingInfo(d, fu, s, i);
        if(test.servingUnit instanceof Fl_Oz_Unit)
            System.out.println("pass");
        test = new Fl_Oz_ToCupsFilter(test).getConversion();
        System.out.println(test.getServingSize() + " " + test.servingUnit.toString() + " " + test.unitName
        + " " + test.getServingsRemaining());
        if(test.servingUnit instanceof Fl_Oz_Unit)
            System.out.println("fail");
        if(test.servingUnit instanceof CupsUnit)
            System.out.println("pass");
        if(test.servingUnit instanceof GramsUnit)
            System.out.println("fail");
        test = new CupsToFl_Oz_Filter(test).getConversion();
        System.out.println(test.getServingSize() + " " + test.servingUnit.toString() + " " + test.unitName
                + " " + test.getServingsRemaining());

        Calendar c = Calendar.getInstance();
        GregorianCalendar c2 = new GregorianCalendar(2025, Calendar.NOVEMBER, 10);
        */
    }
}
