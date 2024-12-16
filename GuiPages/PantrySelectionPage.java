package GuiPages;

import Containers.MasterList;
import FoodTracking.Pantry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantrySelectionPage extends JPanel
{
    final int FRAME_WIDTH = 810;
    final int FRAME_HEIGHT = 810;

    UI_Handler uiHandler;
    JButton backButton;
    JButton addPantryButton;
    JButton[] pantryButtons;

    public PantrySelectionPage(UI_Handler uiHandler)
    {
        this.uiHandler = uiHandler;
        initComponents();
    }

    public void initComponents()
    {
        GridLayout gl = new GridLayout(3,3);
        gl.setHgap(25);
        gl.setVgap(25);
        setLayout(gl);
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

        JPanel nonSelection = new JPanel();
        GridLayout nonSelectionLayout = new GridLayout(2,1);
        gl.setHgap(25);
        gl.setVgap(25);
        nonSelection.setLayout(nonSelectionLayout);
        nonSelection.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        JButton backButton = new JButton("Back");
        nonSelection.add(backButton);
        backButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                uiHandler.loadPage(new InitialPage(uiHandler));
            }
        });
        JButton addPantryButton = new JButton("Add Pantry");
        addPantryButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JDialog jd = new JDialog();
                jd.setSize(400, 400);
                jd.setLocationRelativeTo(null);
                jd.setLayout(null);
                jd.setVisible(true);
                JPanel panel = new JPanel();
                panel.setLayout(new GridLayout(3, 1));
                {
                    JLabel addPantryLabel = new JLabel("Pantry Name");
                    panel.add(addPantryLabel);
                    JTextField addPantryTextField = new JTextField();
                    panel.add(addPantryTextField);
                    JButton addPantryButton = new JButton("Add Pantry");
                    panel.add(addPantryButton);
                    addPantryButton.addActionListener(new ActionListener()
                    {
                        @Override
                        public void actionPerformed(ActionEvent e)
                        {
                            Pantry newPantry = new Pantry(addPantryTextField.getText());
                            uiHandler.loadPage(new PantrySelectionPage(uiHandler));
                            jd.dispose();
                        }
                    });
                }
                jd.setContentPane(panel);
                jd.setVisible(true);
                panel.setVisible(true);
            }
        });
        nonSelection.add(addPantryButton);
        add(nonSelection);
        nonSelection.setVisible(true);
        for(int i = 0; i < MasterList.getPantryList().size(); i++)
        {
            JButton pantryButton = new JButton(MasterList.getPantry(i).getPantryName());
            pantryButton.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    // when pantry clicked
                    System.out.println(MasterList.getPantryList().size());
                }
            });
            add(pantryButton);
        }
    }
}
