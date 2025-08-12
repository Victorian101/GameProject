package org.example;

import javax.swing.*;
import java.awt.*;

public class RulesWindow extends JPanel {
    public static final int RULE_WIDTH = 1000;
    public static final int RULE_HEIGHT = 800;
private JFrame frame;
public RulesWindow(JFrame frame){
    this.frame = frame;
    this.setLayout(null);
    this.setBounds(0, 0, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);

    JLabel label = new JLabel("Rules of THE game:");
    label.setFont(label.getFont().deriveFont(Font.BOLD,22f));
    label.setBounds(400,0,300,50);
    this.add(label);

    JTextArea area =new JTextArea("You need to catch all the carrot \n" +
            "Move your rabbit with the arrow: \n" +
            "Up, Down, Right, Left \n" +
            "Be carful from the traps \n" +
            "Good luck <3 ");
    area.setFont(area.getFont().deriveFont(16f));
    area.setEditable(false);
    area.setBackground(getBackground());
    area.setBounds(200,200,400,400);
    this.add(area);
    JButton backBut = new JButton("Back");
    backBut.setBounds(450, 600, Main.WIDTH_BUTTON, Main.HEIGHT_BUTTON);
    backBut.addActionListener(e ->{
        frame.setContentPane(new StartWindow(frame));
        frame.revalidate();
        frame.repaint();
    });
    this.add(backBut);
}



}
