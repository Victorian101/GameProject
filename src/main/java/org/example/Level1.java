package org.example;

import javax.print.attribute.standard.OrientationRequested;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Level1 extends AbstractLevel{

    private static final int[][] MAP = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1},
            {1,1,1,1,0,0,0,3,0,0,0,1,1,1,1,1,1,1},
            {1,1,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1},
            {1,1,1,1,0,1,2,2,2,1,0,1,1,1,1,1,1,1},
            {1,1,1,1,0,1,2,2,2,1,0,1,1,1,1,1,1,1},
            {1,1,1,1,0,1,2,2,2,1,0,1,1,1,1,1,1,1},
            {1,1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,1,1},
            {1,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1},
            {1,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1},
            {1,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };






    public Level1(JFrame frame) {

        super(frame, 10, 7, MAP);
    }

    public AbstractLevel createNewLevel(){
        return new Level2(getFrame());
    }


    }
