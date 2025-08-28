package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class VictoryPanel extends AbstractLevel {

    private BufferedImage victoryIm;
    private JLabel imageLabel;

    private static final int[][] DUMMY_MAP = {
            {EMPTY}
    };

    public VictoryPanel(JFrame frame) {
        super(frame, 0, 0, DUMMY_MAP);
        this.setPreferredSize(new Dimension(Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT));
        this.setLayout(new BorderLayout());
        try{
            victoryIm = ImageIO.read(getClass().getResource("/images/victory.png"));
        }catch (Exception e){
        victoryIm = null;
        }
        imageLabel = new JLabel(new ImageIcon(victoryIm), SwingConstants.CENTER);
        add(imageLabel, BorderLayout.CENTER);
    }
    @Override
    public AbstractLevel createNewLevel() {
        return null;
    }
}
