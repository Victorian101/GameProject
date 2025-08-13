package org.example;

import java.awt.*;

public class Rabbit {
//    private int x = 460;
//    private int y = 360;
//    private int size = 40;
//    private int speed = 8;

    private int row, col;
    private int tileSize;

    public Rabbit(int startRow, int startCol, int tileSize){
        this.row = startRow;
        this.col = startCol;
        this.tileSize = tileSize;
    }


    public void paint (Graphics graphics){
        graphics.setColor(Color.WHITE);
        graphics.fillOval(this.col * this.tileSize ,this.row * this.tileSize, this.tileSize, this.tileSize);

    }

    public void moveUp(){
        if(this.row > 0){
            this.row--;
        }
    }
    public void moveDown(int maxRow){
        if(this.row < maxRow){
            this.row++;
        }
    }
    public void moveRight(int maxCol){
        if(this.col < maxCol){
            this.col ++;
        }
    }
    public void moveLeft(){
        if(this.col > 0){
            this.col--;
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
