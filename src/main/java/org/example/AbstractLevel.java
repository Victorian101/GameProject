package org.example;

import javax.swing.*;
import java.awt.*;

public class AbstractLevel extends GamePanel{
    public static final int EMPTY = 0, BLOCK = 1, CARROT = 2, GOAL = 3;
    public static final int TILE_SIZE = 55;
//    public static final int COLS = 18;
//    public static final int ROW = 14;
    private int COLS, ROW ;



    private int carrotCount, totalCarrot;

    private int[][] map;
    private Rabbit rabbit;
    private boolean upLock, downLock, rightLock, leftLock;

    public AbstractLevel(JFrame frame, int[][] map, int startRow, int startCol) {
        super(frame);
        this.map = map;
        this.ROW = map.length;
        this.COLS = map[0].length;
        this.setBackground(new Color(144, 238, 144));
        this.setPreferredSize(new Dimension(COLS * TILE_SIZE, ROW * TILE_SIZE));
        this.setLayout(null);
        rabbit = new Rabbit( 12, 8, TILE_SIZE);
//        setupKeyAdapter();
        carrotInMap();

    }
    public void carrotInMap(){
        this.totalCarrot = 0;
        for (int r = 0; r < this.ROW; r++) {
            for (int c = 0; c < this.COLS; c++) {
                if(this.map[r][c] == CARROT){
                    this.totalCarrot++;
                }
            }
        }
        this.carrotCount = 0;
    }
}
