package org.example;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovementListener implements KeyListener {
    private GamePanel gamePanel;
    public MovementListener(GamePanel gamePanel){
        this.gamePanel = gamePanel;

    }
    public void keyTyped(KeyEvent e) {
//        System.out.println("Typed");
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT -> this.gamePanel.getRabbit().moveLeft();
            case KeyEvent.VK_RIGHT -> this.gamePanel.getRabbit().moveRight();
            case KeyEvent.VK_UP -> this.gamePanel.getRabbit().moveUp();
            case KeyEvent.VK_DOWN -> this.gamePanel.getRabbit().moveDown();
        }


    }

    public void keyReleased(KeyEvent e) {


    }
}
