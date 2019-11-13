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
public class Card implements Serializable {
    EnumCardType type;
    
    Card(EnumCardType type){
        this.type = type;
    }

    public EnumCardType getType() {
        return type;
    }
}
