/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Game;

import static Model.Game.EnumCardType.*;
import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author nacho
 */
public class Property extends Card implements Serializable{
    Color color;
    String name;
    int rent;
    int houses;
    boolean hotel;
    boolean mortgaged;
    int buildingPrice;
    int mortagePrice;
    int price;
    User owner;
    
    
    
    
    public Property(int x,int y,Color color,String name,int rent,int buildingPrice,int mortagePrice,int price ) {
        super(Property,x,y);
        this.color = color;
        this.name = name;
        this.rent = rent;
        houses = 0;
        hotel = false;
        mortgaged = false;
        owner = null;
        this.buildingPrice = buildingPrice;
        this.mortagePrice = mortagePrice;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
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
    
    public int getRentPrice(){
        int extra = 10*houses;
        if(hotel)
            extra += 150;
        return rent+extra;
    }

    public void setHouses(int houses) {
        this.houses = houses;
    }
    
    
}
