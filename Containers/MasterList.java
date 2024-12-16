package Containers;

import FoodTracking.*;

import java.util.ArrayList;

public final class MasterList
{
    private static ArrayList<Food> foodList = new ArrayList<>();
    private static ArrayList<Pantry> pantryList = new ArrayList<>();

    private MasterList()
    {

    }

    public static ArrayList<Food> getFoodList()
    {
        return foodList;
    }

    public static ArrayList<Pantry> getPantryList()
    {
        return pantryList;
    }

    public static void addFood (Food f)
    {
        foodList.add(f);
    }

    public static void addPantry (Pantry p)
    {
        pantryList.add(p);
    }

    public static void removeFood (Food f)
    {
        foodList.remove(f);
    }

    public static  void removePantry (Pantry p)
    {
        pantryList.remove(p);
    }

    public static Pantry getPantry (int i)
    {
        return pantryList.get(i);
    }
}
