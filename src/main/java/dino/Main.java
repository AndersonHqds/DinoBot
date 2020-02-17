/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dino;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import javax.swing.JOptionPane;

/**
 *
 * @author mtuser
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AWTException, InterruptedException {
        Robot robot = new Robot(); 
        boolean gameStarted = false;
        final int R = 0, G = 1, B = 2;
        int x = 0;
        int y = 0;
        int color = 0;
        int[] colors = new int[3];
        
        Dino dino = new Dino();
        
        JOptionPane.showMessageDialog(null, "Coloque o mouse em cima do dinossauro já com a tela expandida");
        
        while(!gameStarted) {
            x = (int)MouseInfo.getPointerInfo().getLocation().x;
            y = (int)MouseInfo.getPointerInfo().getLocation().y;
            Color colorObj = robot.getPixelColor(x, y);
            colors[R] = colorObj.getRed();
            colors[G] = colorObj.getGreen();
            colors[B] = colorObj.getBlue();
            
            if(dino.matchWithDinoColor(colors[R], colors[G], colors[B])) {
                dino.start(x, y);
                gameStarted = true;
            }
            
            Thread.sleep(1000);
        }
        
        dino.loop(true);
       
    }
    
}
