/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Game;

import static Model.Game.EnumCardType.*;

/**
 *
 * @author nacho
 */
public class Wildcard extends Card {
    int id;
    String  info;
    boolean wildcardType; // true = fortune -- false = communityChest
    
    public Wildcard(int id,String info,boolean type) {
        super(Wildcard);
        this.info = info;
        this.wildcardType = type;
    }

    public int getId() {
        return id;
    }

    public String getInfo() {
        return info;
    }

    public boolean isWildcardType() {
        return wildcardType;
    }
    
}
