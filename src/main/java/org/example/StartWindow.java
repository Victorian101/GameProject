package org.example;

import javax.swing.*;

import java.awt.*;




public class StartWindow extends JPanel {


    private JFrame frame;
    public StartWindow(JFrame frame){
        this.frame = frame;
        this.setBounds(0, 0, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
        this.setLayout(null);

        JLabel text = new JLabel("Catch the carrot");
        text.setFont(text.getFont().deriveFont(Font.BOLD, 22f));
        text.setBounds(400, 10, 200, 20);
        JButton button1 = new JButton("Start");
        button1.setBounds(450, 250, Main.WIDTH_BUTTON, Main.HEIGHT_BUTTON);
        JButton button2 = new JButton("Rules");
        button2.setBounds(450, 350, Main.WIDTH_BUTTON, Main.HEIGHT_BUTTON);
        JButton button3 = new JButton("Exit");
        button3.setBounds(450, 450, Main.WIDTH_BUTTON, Main.HEIGHT_BUTTON);
        this.add(text);
        this.add(button1);
        this.add(button2);
        this.add(button3);

        button1.addActionListener(e->{
            Level1 level1 = new Level1(frame);
            frame.setContentPane(level1);
            frame.revalidate();
            frame.repaint();
            level1.requestFocusInWindow();
            level1.requestFocus();
        });
        button2.addActionListener(e -> {
            frame.setContentPane(new RulesWindow(frame));
            frame.revalidate();
            frame.repaint();
        });


    }

}
