package org.example;

import javax.print.attribute.standard.OrientationRequested;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Level1 extends GamePanel{

    public static final int BLOCK = 1;
    public static final int CARROT = 2;
    public static final int EMPTY = 0;

    public static final int TILE_SIZE = 55;
    public static final int COLS = 18; //Main.WINDOW_WIDTH / TILE_SIZE;
    public static final int ROW = 14 ;//Main.WINDOW_HEIGHT / TILE_SIZE;

    private int carrotCount = 0;
    private int totalCarrot;

    private int[][] map = {
            {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK},
            {BLOCK,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,CARROT,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,BLOCK},
            {BLOCK,EMPTY,BLOCK,BLOCK,BLOCK,EMPTY,BLOCK,BLOCK,BLOCK,EMPTY,BLOCK,BLOCK,BLOCK,EMPTY,BLOCK,BLOCK,EMPTY,BLOCK},
            {BLOCK,EMPTY,BLOCK,CARROT,BLOCK,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,BLOCK,EMPTY,EMPTY,BLOCK,EMPTY,BLOCK},
            {BLOCK,EMPTY,BLOCK,EMPTY,BLOCK,BLOCK,BLOCK,EMPTY,BLOCK,BLOCK,BLOCK,EMPTY,BLOCK,BLOCK,EMPTY,BLOCK,EMPTY,BLOCK},
            {BLOCK,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,BLOCK},
            {BLOCK,EMPTY,BLOCK,BLOCK,BLOCK,EMPTY,BLOCK,BLOCK,BLOCK,EMPTY,BLOCK,BLOCK,BLOCK,EMPTY,BLOCK,BLOCK,EMPTY,BLOCK},
            {BLOCK,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,CARROT,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,BLOCK},
            {BLOCK,EMPTY,BLOCK,EMPTY,BLOCK,BLOCK,EMPTY,BLOCK,BLOCK,BLOCK,EMPTY,BLOCK,BLOCK,EMPTY,BLOCK,EMPTY,BLOCK,BLOCK},
            {BLOCK,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,CARROT,BLOCK},
            {BLOCK,EMPTY,BLOCK,BLOCK,BLOCK,EMPTY,BLOCK,BLOCK,BLOCK,EMPTY,BLOCK,BLOCK,BLOCK,EMPTY,BLOCK,BLOCK,EMPTY,BLOCK},
            {BLOCK,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,CARROT,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,EMPTY,BLOCK},
            {BLOCK,CARROT,EMPTY,BLOCK,BLOCK,EMPTY,BLOCK,BLOCK,BLOCK,EMPTY,BLOCK,BLOCK,BLOCK,EMPTY,BLOCK,BLOCK,CARROT,BLOCK},
            {BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK,BLOCK}
    };


    private Rabbit rabbit;

    private boolean upLock, downLock, rightLock, leftLock;


    public Level1(JFrame frame) {
        super(frame);
        this.setBackground(new Color(144, 238, 144));
        this.setPreferredSize(new Dimension(COLS * TILE_SIZE, ROW * TILE_SIZE));
        this.setLayout(null);
        rabbit = new Rabbit( 12, 8, TILE_SIZE);
        setupKeyAdapter();
        this.totalCarrot = 7;

    }
    private void setupKeyAdapter(){
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed (KeyEvent e) {
                int nextRow = rabbit.getRow();
                int nextCol = rabbit.getCol();

                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP -> {
                        if(!upLock) {
                            nextRow--;
                            if (isPossible(nextRow, nextCol)) {
                                rabbit.moveUp();
                                upLock = true;
                            }
                        }
                    }
                    case KeyEvent.VK_DOWN -> {
                        if(!downLock){
                            nextRow++;
                            if(isPossible(nextRow, nextCol)){
                                rabbit.moveDown(ROW);
                                downLock = true;
                            }

                        }
                    }
                    case KeyEvent.VK_LEFT -> {
                        if(!leftLock){
                            nextCol--;
                            if(isPossible(nextRow, nextCol)){
                                rabbit.moveLeft();
                                leftLock = true;
                            }
                        }
                    }
                    case KeyEvent.VK_RIGHT -> {
                        if(!rightLock){
                            nextCol ++;
                            if(isPossible(nextRow, nextCol)){
                                rabbit.moveRight(COLS);
                                rightLock = true;
                            }
                        }
                    }
                }
                repaint();
            }
            @Override
            public void keyReleased (KeyEvent e){
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP -> upLock = false;
                    case KeyEvent.VK_DOWN -> downLock = false;
                    case KeyEvent.VK_LEFT -> leftLock = false;
                    case KeyEvent.VK_RIGHT -> rightLock = false;
                }
            }
            public boolean isPossible ( int row, int col){
                return map[row][col] != BLOCK;
            }

        });



    }



    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COLS; c++) {
                int tile = map[r][c];
                if(tile == BLOCK){
                    graphics.setColor(Color.DARK_GRAY);
                    graphics.fillRect(c * TILE_SIZE , r * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                }else if(tile == CARROT){
                    graphics.setColor(Color.ORANGE);
                    graphics.fillOval(c * TILE_SIZE + 5 , r * TILE_SIZE + 5, TILE_SIZE - 10, TILE_SIZE - 10);
                }

                graphics.setColor(Color.BLACK);
                graphics.drawRect(c * TILE_SIZE, r * TILE_SIZE, TILE_SIZE, TILE_SIZE);

            }
            graphics.setColor(Color.ORANGE);
            graphics.fillOval(750 , 30, 20, 20);
            graphics.setColor(Color.BLACK);
            graphics.drawString(this.carrotCount + "/" + this.totalCarrot, 790, 40);
        }



//        for (int r = 0; r < ROW; r++) {
//            for (int c = 0; c < COLS; c++) {
//                graphics.setColor(new Color(0, 0, 0, 130));
//                graphics.drawRect(c * TILE_SIZE, r * TILE_SIZE, TILE_SIZE, TILE_SIZE);
//            }
//        }
        rabbit.paint(graphics);

    }

    public void colectCarrot (int r, int c){
        if(map[r][c] == CARROT){
            map[r][c] = EMPTY;
            carrotCount++;
        }
    }
    public boolean nextLevel(){
        return carrotCount == totalCarrot;
    }

    }
