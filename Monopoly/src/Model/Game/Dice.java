/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Game;

import java.io.Serializable;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author nacho
 */
public class Dice implements Serializable{
    int value;
    ImageIcon face;
    
    public Dice(){
        value = 1;
        face = new ImageIcon(getClass().getResource("/Images/Red1.jpg"));
    }
    
    public void rollDice(){
        Random random = new Random();
        value = random.nextInt(6)+1;
        
        switch(value){
            
            case 1:
                face = new ImageIcon(getClass().getResource("/Images/Red1.jpg"));
                break;
            
            case 2:
                face = new ImageIcon(getClass().getResource("/Images/Red2.jpg"));
                break;
                
            case 3:
                face = new ImageIcon(getClass().getResource("/Images/Red3.jpg"));
                break;
                
            case 4:
                face = new ImageIcon(getClass().getResource("/Images/Red4.jpg"));
                break;
                
            case 5:
                face = new ImageIcon(getClass().getResource("/Images/Red5.jpg"));
                break;
                
            case 6:
                face = new ImageIcon(getClass().getResource("/Images/Red6.jpg"));
                break;
        }
    }

    public int getValue() {
        return value;
    }

    public ImageIcon getFace() {
        return face;
    }
    
    
}
