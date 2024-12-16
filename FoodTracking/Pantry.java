package FoodTracking;

import Containers.MasterList;

import java.util.ArrayList;

public class Pantry
{
    String pantryName;
    ArrayList<Food> foodsInPantry;

    public Pantry (String name)
    {
        pantryName = name;
        foodsInPantry = new ArrayList<Food>();
        MasterList.addPantry(this);
    }

    public String getPantryName()
    {
        return pantryName;
    }
}
