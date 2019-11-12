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
    
    public SpecialCard(EnumSpecialType id) {
        super(Special);
        this.id = id;
    }

    public EnumSpecialType getId() {
        return id;
    }
    
}
