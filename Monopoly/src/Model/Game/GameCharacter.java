/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Game;

import java.io.Serializable;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author nacho
 */

public class GameCharacter implements Serializable  {
    //Atributos
    EnumCharacter character;
    ImageIcon appereance;
    
    //Metodos
    public GameCharacter(EnumCharacter character,ImageIcon appereance){
        this.character = character;
        this.appereance = appereance;
    }

    public EnumCharacter getCharacter() {
        return character;
    }

    public Icon getAppereance() {
        return appereance;
    }
    
}

