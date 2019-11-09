/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Game;

import javax.swing.Icon;

/**
 *
 * @author nacho
 */

public class GameCharacter {
    //Atributos
    EnumCharacter character;
    Icon appereance;
    
    //Metodos
    public GameCharacter(EnumCharacter character,Icon appereance){
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

