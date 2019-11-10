/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Game;

import java.io.Serializable;

/**
 *
 * @author nacho
 */
public class User implements Serializable {
    //Atributos
    String name;
    GameCharacter character;
    
    
    //Metodos
    public User(String name,GameCharacter character){
        this.name = name;
        this.character = character;
    }

    public String getName() {
        return name;
    }

    public GameCharacter getCharacter() {
        return character;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCharacter(GameCharacter character) {
        this.character = character;
    }
}
