/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Packages;

/**
 *
 * @author nacho
 */
public class BuyRequestPackage extends Package {
    public int boardIndex;
    public boolean accepetance;

    public BuyRequestPackage(int boardIndex) {
        super("BuyRequest");
        this.boardIndex = boardIndex;
    }
    
}
