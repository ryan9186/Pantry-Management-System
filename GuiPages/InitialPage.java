package GuiPages;

import javax.swing.*;
import java.awt.*;

public class InitialPage extends JPanel
{

    public UI_Handler uiHandler;
    JButton addEditFood;
    JButton viewPantries;
    JButton viewShoppingList;

    public InitialPage(UI_Handler uiHandler)
    {
        this.uiHandler = uiHandler;
        initComponents();
    }

    public void initComponents()
    {
        GridLayout gl = new GridLayout(3,1);
        gl.setHgap(50);
        gl.setVgap(50);
        this.setLayout(gl);
        addEditFood = new JButton("Add/Edit FoodTracking.Food");
        addEditFood.setSize(100, 100);
        viewPantries = new JButton("View Pantries");
        viewShoppingList = new JButton("View Shopping List");
        this.add(addEditFood);
        this.add(viewPantries);
        this.add(viewShoppingList);
        this.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
        this.setSize(600, 600);
        setVisible(true);

        addEditFood.addActionListener(e ->
        {
            uiHandler.loadPage(new AddEditFoodsPage(uiHandler));
        });
        viewPantries.addActionListener(e ->
        {
            uiHandler.loadPage(new PantrySelectionPage(uiHandler));
        });
        viewShoppingList.addActionListener(e ->
        {
            // view Shopping List logic here
        });
    }
}
