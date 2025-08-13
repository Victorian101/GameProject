package org.example;

import javax.swing.*;
import java.awt.*;

public class Level1 extends GamePanel{

    public static final int TILE_SIZE = 55;
    public static final int COLS = Main.WINDOW_WIDTH / TILE_SIZE;
    public static final int ROW = Main.WINDOW_HEIGHT / TILE_SIZE;

    public Level1(JFrame frame) {
        super(frame);
        this.setBackground(new Color(144, 238, 144));

    }
    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COLS; c++) {
                graphics.setColor(new Color(0, 0, 0, 130));
                graphics.drawRect(c * TILE_SIZE, r * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }

        getRabbit().paint(graphics);

    }

    }
