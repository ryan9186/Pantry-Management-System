package GuiPages;

import FoodTracking.*;

import javax.swing.*;
import java.awt.*;

public class EditFoodPrompt extends JPanel
{
    Food foodObject;
    JTextField foodName;
    JTextField foodExpiry;
    JLabel servingsRemaining;
    JLabel servingsUnit;
    JScrollPane nutrientPanel;

    JButton updateFoodButton;
    JButton convertUnitButton;
    JButton decrementServingsButton;

    public EditFoodPrompt(Food foodObject)
    {
        this.foodObject = foodObject;

        initComponents();
    }

    public void initComponents()
    {
        setLayout(null);
        setSize(800, 800);
        setBorder(BorderFactory.createLineBorder(Color.black, 2));
        foodName = new JTextField("FoodTracking.Food Name");
        foodName.setSize(300, 20);
        foodName.setLocation(250, 100);
        add(foodName);

        foodExpiry = new JTextField("Expiry Date");
        foodExpiry.setSize(300, 20);
        foodExpiry.setLocation(250, 150);
        add(foodExpiry);

        servingsRemaining = new JLabel("Servings Remaining");
        servingsRemaining.setSize(300, 20);
        servingsRemaining.setLocation(300, 250);
        add(servingsRemaining);

        servingsUnit = new JLabel("Serving Units");
        servingsUnit.setSize(300, 20);
        servingsUnit.setLocation(300, 300);
        add(servingsUnit);

        decrementServingsButton = new JButton("-");
        decrementServingsButton.setSize(50, 50);
        decrementServingsButton.setLocation(700, 250);
        add(decrementServingsButton);

        updateFoodButton = new JButton("Update");
        updateFoodButton.setSize(150, 20);
        updateFoodButton.setLocation(200, 725);
        add(updateFoodButton);

        convertUnitButton = new JButton("Convert");
        convertUnitButton.setSize(150, 20);
        convertUnitButton.setLocation(450, 725);
        add(convertUnitButton);

        JPanel testPanel = new JPanel();
        testPanel.setLayout(new GridLayout(100, 1));
        testPanel.setSize(50, 400);
        testPanel.setLocation(300, 550);
        testPanel.setVisible(true);
        for(int i = 0; i < foodObject.getNutrients().size(); i++)
        {
            JLabel test = new JLabel(foodObject.getNutrients().get(i).getName());
            JTextField testField = new JTextField(foodObject.getNutrients().get(i).getAmount() + "");

            testPanel.add(test);
            testPanel.add(testField);
        }
        nutrientPanel = new JScrollPane();
        nutrientPanel.setSize(400, 300);
        nutrientPanel.setLocation(200, 400);
        nutrientPanel.setViewportView(testPanel);
        add(nutrientPanel);

    }
}
