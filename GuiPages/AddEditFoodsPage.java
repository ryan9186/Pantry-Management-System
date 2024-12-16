package GuiPages;


import Containers.MasterList;
import FoodTracking.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddEditFoodsPage extends JPanel
{
    final int FRAME_WIDTH = 810;
    final int FRAME_HEIGHT = 810;

    public UI_Handler uiHandler;

    JCheckBox customSelectionCheckBox;    // selected for custom input food object creation
    JCheckBox searchSelectionCheckBox;    // selected for food object creation from API
    JButton addButton;                    // displays relevant food object creation prompt
    JButton editButton;                   // displays edit food prompt
    JButton discardButton;                // removes selected food object from system
    JButton addToShoppingListButton;      // adds selected food object to shopping list
    JTextArea foodInfo;                   // text area to display user's selected food object's information
    JList foodsInSys;                     // list to display food objects in system to user
    Food selectedFood = null;           // placeholder for user's selected food object

    JButton backButton;

    public AddEditFoodsPage(UI_Handler ui)
    {
        this.uiHandler = ui;
        initComponents();
    }

    public void initComponents()
    {
        setLayout(null);
        setBorder(BorderFactory.createLineBorder(Color.blue, 2));
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        customSelectionCheckBox = new JCheckBox("Custom");
        customSelectionCheckBox.setLocation(200, FRAME_HEIGHT / 10);
        customSelectionCheckBox.setSize(200, 20);
        add(customSelectionCheckBox);

        searchSelectionCheckBox = new JCheckBox("Search");
        searchSelectionCheckBox.setLocation(400, FRAME_HEIGHT / 10);
        searchSelectionCheckBox.setSize(200, 20);
        add(searchSelectionCheckBox);

        addButton = new JButton("Add FoodTracking.Food");
        addButton.setLocation(300, 150);
        addButton.setSize(100, 20);
        add(addButton);

        editButton = new JButton("Edit");
        editButton.setLocation(200, 700);
        editButton.setSize(100, 20);
        add(editButton);

        discardButton = new JButton("Discard");
        discardButton.setLocation(320, 700);
        discardButton.setSize(100, 20);
        add(discardButton);

        addToShoppingListButton = new JButton("+ Shopping List");
        addToShoppingListButton.setLocation(440, 700);
        addToShoppingListButton.setSize(100, 20);
        add(addToShoppingListButton);

        backButton = new JButton("Back");
        backButton.setLocation(50, 50);
        backButton.setSize(100, 20);
        add(backButton);

        foodInfo = new JTextArea();
        foodInfo.setLocation(100, 200);
        foodInfo.setSize(465, 400);
        foodInfo.setEditable(false);
        foodInfo.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        add(foodInfo);

        foodsInSys = new JList();
        foodsInSys.setLocation(600, FRAME_HEIGHT / 10);
        foodsInSys.setSize(180, 600);
        foodsInSys.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        foodsInSys.setListData(MasterList.getFoodList().toArray(new Food[0]));

        JScrollPane jsp = new JScrollPane(foodsInSys);
        jsp.setLocation(600, 100);
        jsp.setSize(180, 600);
        jsp.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        add(jsp);

        customSelectionCheckBox.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                searchSelectionCheckBox.setSelected(false);
            }
        });

        searchSelectionCheckBox.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                customSelectionCheckBox.setSelected(false);
            }
        });

        addButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

            }
        });

        editButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JDialog jd = new JDialog();
                jd.setSize(800, 800);
                jd.setLocationRelativeTo(null);
                jd.setLayout(null);
                jd.setVisible(true);
                JPanel panel = new EditFoodPrompt(selectedFood);
                jd.setContentPane(panel);
            }
        });

        discardButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

            }
        });

        addToShoppingListButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

            }
        });

        backButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                uiHandler.loadPage(new InitialPage(uiHandler));
            }
        });

        foodsInSys.addListSelectionListener(new ListSelectionListener()
        {
            public void valueChanged(ListSelectionEvent e)
            {
                selectedFood = (Food)foodsInSys.getSelectedValue();
                foodInfo.setText(selectedFood.getName());
            }
        });


    }
}
