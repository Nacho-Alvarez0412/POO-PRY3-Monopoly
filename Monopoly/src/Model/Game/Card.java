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
public abstract class Card implements Serializable {
    EnumCardType type;
    int x;
    int y;
    
    Card(EnumCardType type,int x,int y){
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public EnumCardType getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
