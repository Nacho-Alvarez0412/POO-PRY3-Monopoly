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
public class TradeRequestPackage extends Package {

    public final String player1;
    public final String player2;
    public final String property1;
    public final String property2;
    public String message;
    public boolean accepted;
    public boolean waiting;
    
    public TradeRequestPackage(String player1, String player2, String property1,String property2) {
        super("TradeRequest");
        this.player1 = player1;
        this.player2 = player2;
        this.property1 = property1;
        this.property2 = property2;
        this.waiting = true;
        
    }
    
}
