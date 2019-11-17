/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Packages;

import Model.Game.Wildcard;

/**
 *
 * @author nacho
 */
public class WildcardPackage extends Package {
    public Wildcard card;

    public WildcardPackage(Wildcard card) {
        super("Wildcard");
        this.card = card;
    }
    
}
