package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private JFrame frame;


    public GamePanel(JFrame frame){
        this.frame = frame;
        this.setFocusable(true);
        this.setDoubleBuffered(true);



    }


    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);


    }

}
