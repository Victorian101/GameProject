package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private JFrame frame;
    private Rabbit rabbit = new Rabbit();
//    private Level1 level1 = new Level1(frame);

    public GamePanel(JFrame frame){
        this.frame = frame;
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        this.setLayout(null);
        this.setBounds(0, 0, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);



//        this.setBackground(new Color(76, 122, 145));


        this.addKeyListener(new KeyAdapter(){
           @Override
           public void keyPressed (KeyEvent e){
               switch (e.getKeyCode()){
                   case KeyEvent.VK_LEFT -> rabbit.moveLeft();
                   case KeyEvent.VK_RIGHT -> rabbit.moveRight();
                   case KeyEvent.VK_UP -> rabbit.moveUp();
                   case KeyEvent.VK_DOWN -> rabbit.moveDown();
               }
               repaint();
           }
        });
    }


    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
//        rabbit.paint(graphics);
//        level1.paint(graphics);

    }

    public Rabbit getRabbit() {
        return rabbit;
    }
}
