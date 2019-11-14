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
public class SpecialCard extends Card{
    EnumSpecialType id;
    
    public SpecialCard(int x,int y,EnumSpecialType id) {
        super(Special,x,y);
        this.id = id;
    }

    public EnumSpecialType getId() {
        return id;
    }
    
}
