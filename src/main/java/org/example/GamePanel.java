package org.example;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private JFrame frame;

    public JFrame getFrame() {
        return frame;
    }

    public GamePanel(Frame frame){
        this.frame = (JFrame) frame;
        this.setFocusable(true);
        this.setDoubleBuffered(true);



    }


    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);


    }

}
