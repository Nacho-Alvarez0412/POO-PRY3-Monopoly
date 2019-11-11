/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Game;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author nacho
 */
public class User implements Serializable {
    //Atributos
    public int id;
    public String name;
    public GameCharacter character;
    public ArrayList<Dice> dices;
    public int roll;
    public int money;
    
    
    //Metodos
    public User(String name,GameCharacter character){
        this.name = name;
        this.character = character;
        money = 1500;
        roll = 0;
        dices = new ArrayList();
        dices.add(new Dice());
        dices.add(new Dice());
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
    
    public void rollDices(){
        for(Dice dice : dices){
            dice.rollDice();
        }
    }
}
