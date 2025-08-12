package org.example;

import java.awt.*;

public class Rabbit {
    private int x = 460;
    private int y = 360;
    private int size = 40;
    private int speed = 8;

    public void paint (Graphics graphics){
        graphics.setColor(Color.darkGray);
        graphics.fillOval(this.x ,this.y, this.size, this.size);

    }

    public void moveUp(){ this.y -= this.speed; }
    public void moveDown(){ this.y+= this.speed; }
    public void moveRight(){ this.x+= this.speed; }
    public void moveLeft(){ this.x-= this.speed; }
}
