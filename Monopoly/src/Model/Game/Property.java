/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Game;

import static Model.Game.EnumCardType.*;
import java.awt.Color;

/**
 *
 * @author nacho
 */
public class Property extends Card {
    Color color;
    String name;
    int rent;
    int houses;
    boolean hotel;
    boolean mortgaged;
    int buildingPrice;
    int mortagePrice;
    int price;
    boolean owned;
    
    
    
    
    public Property(Color color,String name,int rent,int buildingPrice,int mortagePrice,int price ) {
        super(Property);
        this.color = color;
        this.name = name;
        this.rent = rent;
        houses = 0;
        hotel = false;
        mortgaged = false;
        owned = false;
        this.buildingPrice = buildingPrice;
        this.mortagePrice = mortagePrice;
        this.price = price;
    }

    public int getMortagePrice() {
        return mortagePrice;
    }

    public void setMortagePrice(int mortagePrice) {
        this.mortagePrice = mortagePrice;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public int getRent() {
        return rent;
    }

    public int getHouses() {
        return houses;
    }

    public boolean isHotel() {
        return hotel;
    }

    public boolean isMortgaged() {
        return mortgaged;
    }

    public int getBuildingPrice() {
        return buildingPrice;
    }

   

    public void addHouses() {
        if(houses<4)
            houses++;
    }

    public void setHotel(boolean hotel) {
        this.hotel = hotel;
    }

    public void setMortgaged(boolean mortgaged) {
        this.mortgaged = mortgaged;
    }
    
    
}
