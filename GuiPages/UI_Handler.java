package GuiPages;

import javax.swing.*;

public class UI_Handler
{
    JFrame currentFrame;
    final int FRAME_WIDTH = 810;
    final int FRAME_HEIGHT = 810;

    public UI_Handler()
    {
        currentFrame = new JFrame();
        currentFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        currentFrame.setContentPane(new CustomAddFoodPrompt(this));
        currentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        currentFrame.setLocationRelativeTo(null);
        currentFrame.setVisible(true);
    }

    public void loadPage(JPanel nextPanel)
    {
        currentFrame.dispose();
        currentFrame = new JFrame();
        currentFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        currentFrame.setContentPane(nextPanel);
        currentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        currentFrame.setLocationRelativeTo(null);
        currentFrame.setVisible(true);
    }

}
