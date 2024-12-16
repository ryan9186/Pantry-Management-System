package GuiPages;

import FoodTracking.Food;
import FoodTracking.ServingUnitIF;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomAddFoodPrompt extends JPanel
{
    UI_Handler uiHandler;
    JButton backButton;

    JLabel foodNameLabel;
    JTextField foodNameField;

    JComboBox servingUnitCombo;
    JLabel servingAmountLabel;
    JTextField servingAmountField;

    JLabel expiryDateLabel;
    JTextField expiryDateDayField;
    JTextField expiryDateMonthField;
    JTextField expiryDateYearField;

    JButton addNutrientButton;
    JPanel nutrientsPanel;

    public CustomAddFoodPrompt(UI_Handler uiHandler)
    {
        this.uiHandler = uiHandler;
        initComponents();
    }

    private void initComponents()
    {
        setLayout(null);
        setSize(600, 600);
        setBorder(BorderFactory.createLineBorder(Color.black, 2));

        foodNameLabel = new JLabel("Food Name:");
        foodNameLabel.setSize(200, 20);
        foodNameLabel.setLocation(200, 50);
        add(foodNameLabel);

        foodNameField = new JTextField();
        foodNameField.setSize(200, 20);
        foodNameField.setLocation(400, 50);
        add(foodNameField);

        String[] s = {"Grams", "Ounces", "Fl Oz", "Cups"};
        servingUnitCombo = new JComboBox<>(s);
        servingUnitCombo.setSize(100, 20);
        servingUnitCombo.setLocation(200, 100);
        add(servingUnitCombo);

        servingAmountLabel = new JLabel("Serving Amount:");
        servingAmountLabel.setSize(100, 20);
        servingAmountLabel.setLocation(350, 100);
        add(servingAmountLabel);

        servingAmountField = new JTextField();
        servingAmountField.setSize(100, 20);
        servingAmountField.setLocation(500, 100);
        add(servingAmountField);

        expiryDateLabel = new JLabel("Expiry Date:");
        expiryDateLabel.setSize(100, 20);
        expiryDateLabel.setLocation(200, 300);
        add(expiryDateLabel);

        expiryDateDayField = new JTextField("Day");
        expiryDateDayField.setSize(40, 20);
        expiryDateDayField.setLocation(350, 300);
        add(expiryDateDayField);

        expiryDateMonthField = new JTextField("Month");
        expiryDateMonthField.setSize(40, 20);
        expiryDateMonthField.setLocation(450, 300);
        add(expiryDateMonthField);

        expiryDateYearField = new JTextField("Year");
        expiryDateYearField.setSize(40, 20);
        expiryDateYearField.setLocation(560, 300);
        add(expiryDateYearField);

        nutrientsPanel = new JPanel();
        nutrientsPanel.setVisible(true);
        nutrientsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        nutrientsPanel.setBackground(Color.WHITE);
        nutrientsPanel.setSize(400, 200);
        nutrientsPanel.setLocation(200, 400);
        nutrientsPanel.setLayout(new GridLayout(1, 2));
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(nutrientsPanel);
        scrollPane.setVisible(true);
        scrollPane.setSize(400, 200);
        scrollPane.setLocation(200, 400);
        add(scrollPane);

        addNutrientButton = new JButton("Add Nutrient");
        addNutrientButton.setSize(150, 20);
        addNutrientButton.setLocation(320, 350);
        add(addNutrientButton);
        addNutrientButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int componentsInNutrientsPanel = nutrientsPanel.getComponentCount();

                JTextField nutrientNameField = new JTextField("Nutrient Name");
                nutrientsPanel.add(nutrientNameField);
                nutrientNameField.setSize(95, 20);
                nutrientNameField.setLocation(50, (componentsInNutrientsPanel * 10) + 10);


                JTextField nutrientAmountField = new JTextField("Nutrient Amount");
                nutrientsPanel.add(nutrientAmountField);
                nutrientAmountField.setSize(95, 20);
                nutrientNameField.setLocation(150, ((componentsInNutrientsPanel - 1) * 10) + 10);

                System.out.println(componentsInNutrientsPanel);
                System.out.println(nutrientNameField.getX() + " " + nutrientNameField.getY());
                nutrientsPanel.setLayout(new GridLayout((componentsInNutrientsPanel / 2), 2));

                nutrientsPanel.updateUI();
            }
        });

        backButton = new JButton("Back");
        backButton.setSize(65, 20);
        backButton.setLocation(50, 50);
        add(backButton);
        backButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                uiHandler.loadPage(new InitialPage(uiHandler));
            }
        });
    }
}
