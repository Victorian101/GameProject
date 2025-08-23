package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AbstractLevel extends GamePanel{
    public static final int EMPTY = 0;
    public static final int BLOCK = 1;
    public static final int CARROT = 2;
    public static final int GOAL = 3;
    public static final int TRAP = 4;
    public static final int TRAP_USED = 5;

    public static final int TILE_SIZE = 55;

    public boolean steppedOnTrap;

    private int cols;
    private int rows;

    private int carrotCount;
    private int totalCarrot;

    private int[][] map;
    private int[][] initialMap;
    private int startRow, startCol;
    private Rabbit rabbit;
    private boolean upLock, downLock, rightLock, leftLock;

    public AbstractLevel(JFrame frame,  int startRow, int startCol, int[][] map) {
        super(frame);
        this.map = map;
        this.rows = map.length;
        this.cols = map[0].length;
        this.startRow = startRow;
        this.startCol = startCol;
        this.steppedOnTrap = false;
        this.setBackground(new Color(144, 238, 144));
        this.setPreferredSize(new Dimension(cols * TILE_SIZE, rows * TILE_SIZE));
        this.setLayout(null);
        rabbit = new Rabbit( startRow, startCol, TILE_SIZE);
        setupKeyAdapter();
        carrotInMap();
        this.initialMap = copyMap(map);

    }



    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int tile = map[r][c];
                if (tile == BLOCK) {
                    graphics.setColor(Color.DARK_GRAY);
                    graphics.fillRect(c * TILE_SIZE, r * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                } else if (tile == CARROT) {
                    graphics.setColor(Color.ORANGE);
                    graphics.fillOval(c * TILE_SIZE + 5, r * TILE_SIZE + 5, TILE_SIZE - 10, TILE_SIZE - 10);
                } else if (tile == GOAL) {
                    graphics.setColor(Color.RED);
                    graphics.fillOval(c * TILE_SIZE + 4, r * TILE_SIZE + 4, TILE_SIZE - 8, TILE_SIZE - 8);
                    graphics.setColor(Color.BLACK);
                    graphics.fillOval(c * TILE_SIZE + 8, r * TILE_SIZE + 8, TILE_SIZE - 16, TILE_SIZE - 16);
                    graphics.setColor(Color.RED);
                    graphics.fillOval(c * TILE_SIZE + 12, r * TILE_SIZE + 12, TILE_SIZE - 24, TILE_SIZE - 24);
                }else if (tile == TRAP){
                    graphics.setColor(Color.YELLOW);
                    graphics.fillOval(c * TILE_SIZE + 12, r * TILE_SIZE + 12, TILE_SIZE - 24, TILE_SIZE - 24);
                }else if(tile == TRAP_USED){
                    graphics.setColor(Color.RED);
                    graphics.fillRect(c * TILE_SIZE + 12, r * TILE_SIZE + 12, TILE_SIZE - 24, TILE_SIZE - 24);
                }

                graphics.setColor(Color.BLACK);
                graphics.drawRect(c * TILE_SIZE, r * TILE_SIZE, TILE_SIZE, TILE_SIZE);

            }
            graphics.setColor(Color.ORANGE);
            graphics.fillOval(750, 30, 20, 20);
            graphics.setColor(Color.BLACK);
            graphics.drawString(this.carrotCount + "/" + this.totalCarrot, 790, 40);

            rabbit.paint(graphics);
        }
    }
    private void setupKeyAdapter() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> {
                        if (!upLock) {
                            tryMove(0,-1);
                            upLock = true;
                        }
                    }
                    case KeyEvent.VK_DOWN -> {
                        if (!downLock) {
                            tryMove(0, 1);
                            downLock = true;
                        }
                    }
                    case KeyEvent.VK_LEFT -> {
                        if (!leftLock) {
                            tryMove(-1, 0);
                            leftLock= true;
                        }
                    }
                    case KeyEvent.VK_RIGHT -> {
                        if (!rightLock) {
                            tryMove(1, 0);
                            rightLock = true;
                        }
                    }
                }
                repaint();
            }

            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> upLock = false;
                    case KeyEvent.VK_DOWN -> downLock = false;
                    case KeyEvent.VK_LEFT -> leftLock = false;
                    case KeyEvent.VK_RIGHT -> rightLock = false;
                }
            }

        });
    }

    public void carrotInMap(){
        this.totalCarrot = 0;
        for (int r = 0; r < this.rows; r++) {
            for (int c = 0; c < this.cols; c++) {
                if(this.map[r][c] == CARROT){
                    this.totalCarrot++;
                }
            }
        }
        this.carrotCount = 0;
    }

    public void tryMove(int mx, int my){
        int currentR = this.rabbit.getRow();
        int currentC = this.rabbit.getCol();
        int nextR = currentR + my;
        int nextC = currentC + mx;
        int tile = map[nextR][nextC];

            if(tile == BLOCK){
             return;
         }
        if(tile == GOAL && !allCollected()){
            return;
        }
        if(mx == 1){
            rabbit.moveRight(cols);
        }else if(mx == -1){
            rabbit.moveLeft();
        }else if(my == 1){
            rabbit.moveDown(rows);
        }else if(my == -1){
            rabbit.moveUp();
        }
        if(tile == CARROT){
            map[nextR][nextC] = EMPTY;
            this.carrotCount++;
        }
        if(tile == GOAL && allCollected()){
            nextLevel();
        }
        if(tile == TRAP){
            if(!steppedOnTrap){
                steppedOnTrap = true;
                map[nextR][nextC] = TRAP_USED;
            }else{
                restartLevel();
            }
        }
    }

    public boolean allCollected(){
        return this.carrotCount == this.totalCarrot;
    }

    public int[][] copyMap (int[][] map){
        int[][] copy = new int[map.length][];
        for (int i = 0; i < map.length; i++) {
            copy[i] = map[i].clone();
        }
        return copy;
    }

    public void restartLevel(){
        this.map = copyMap(initialMap);
        this.rabbit = new Rabbit(startRow , startCol, TILE_SIZE);
        this.carrotInMap();
        this.steppedOnTrap = false;
        revalidate();
        repaint();
        requestFocusInWindow();

    }


    public void nextLevel(){
        AbstractLevel next = createNewLevel();
        JFrame f = getFrame();
        if(next == null){
            return;
        }
        f.setContentPane(next);
        f.pack();
        next.requestFocusInWindow();

    }
    public AbstractLevel createNewLevel(){

        return null;
    }
}
