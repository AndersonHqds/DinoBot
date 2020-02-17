/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dino;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 *
 * @author mtuser
 */
public class Dino {
    final int DINO_COLOR_RED = 83;
    final int DINO_COLOR_GREEN = 83;
    final int DINO_COLOR_BLUE = 83;
    
    int enemyX, enemyY, dinoX, dinoY = 0;
    
    Robot robot;

    public Dino() throws AWTException {
        this.robot = new Robot();
    }
    
    public void start(int x, int y) {
        enemyX = x + 200;
        enemyY = y + 10;
        dinoX = x;
        dinoY = y;
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.mouseMove(x, y + 100);
    }
    
    public boolean hasEnemy() {
       Color screenColors = robot.getPixelColor(enemyX,enemyY);
       
       return (screenColors.getRed() != 255 && screenColors.getGreen() != 255 & screenColors.getBlue() != 255);
    }
    
    public boolean matchWithDinoColor(int r, int g, int b) {
       return (r == DINO_COLOR_RED && g == DINO_COLOR_GREEN && b == DINO_COLOR_BLUE);
    }
    
    public void jump() {
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);
    }
    
    public void loop(boolean running) {
        while(running) {
            if(this.hasEnemy()) {
                this.jump();
            }
        }
    }
}
