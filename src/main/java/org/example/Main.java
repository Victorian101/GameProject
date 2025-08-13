package org.example;

import javax.swing.*;

public class Main {
    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = 800;
    public static final int HEIGHT_BUTTON = 50;
    public static final int WIDTH_BUTTON = 150;

    public static void main(String[] args) {
        JFrame window = new JFrame("Best game ever");
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setLayout(null);
        StartWindow startWindow = new StartWindow(window);
        window.add(startWindow);
        GamePanel gamePanel = new GamePanel(window);
        window.add(gamePanel);






        window.setVisible(true);


    }
}