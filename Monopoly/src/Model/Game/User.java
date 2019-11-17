/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Game;

import java.awt.Color;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JLabel;

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
    public ArrayList<Property> properties;
    public int roll;
    public int money;
    public int index;
    public JLabel inGameAppereance;
    int lap;
    public int sentenceTime;
    public boolean jail;
    public boolean wildcard;
    public boolean bankruptcy;
    
    
    //Metodos
    public User(String name,GameCharacter character){
        this.name = name;
        this.character = character;
        money = 1500;
        roll = 0;
        dices = new ArrayList();
        dices.add(new Dice());
        dices.add(new Dice());
        properties = new ArrayList<>();
        index = 0;
        jail = false;
        wildcard = false;
        bankruptcy = false;
    }
    
    public boolean isMonopoly(Color color){
        int cant = 0;
        
        if(color == Color.WHITE)
            cant = 2;
        if(color == Color.CYAN)
            cant = 3;
        if(color == Color.PINK)
            cant = 3;
        if(color == Color.ORANGE)
            cant = 3;
        if(color == Color.RED)
            cant = 3;
        if(color == Color.YELLOW)
            cant = 3;
        if(color == Color.GREEN)
            cant = 3;
        if(color == Color.BLUE)
            cant = 2;
        
        for(Property property : properties){
            if(property.color == color)
                cant--;
        }
        
        if(cant==0)
            return true;
        return false;
        
    }
    
    public void removeProperty(String name){
        Property delete = null;
        for(Property property : properties){
            if(property.name.equals(name)){
                delete = property;
                break;
            }
        }
        properties.remove(delete);
    }

    public void setInGameAppereance(JLabel inGameAppereance) {
        this.inGameAppereance = inGameAppereance;
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
        roll = dices.get(0).value + dices.get(1).value;
    }
    
    public boolean possesMonopoly(Color color,int cant){
        for(Property terrain : properties){
            if(terrain.color.equals(color))
                cant--;
            if(cant == 0)
                return true;
        }
        return false;
    }
    
    public boolean possesProperty(String name){
        for(Property terrain : properties){
            if(terrain.name.equals(name))
                return true;
        }
        return false;
    }

    public void addTerrain(Property terrain) {
        properties.add(terrain);
    }

    public void Repair(int house ,int hotel) {
        for( Property property : properties){
            money -= house*property.houses;
            
            if(property.isHotel())
                money -= hotel;
        }
    }
}
