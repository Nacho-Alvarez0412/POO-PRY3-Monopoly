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
public class SellRequestPackage extends Package {
    public String property;
    public String seller;
    public String buyer;
    public String message;
    public int price;
    public boolean edification;
    public boolean accepted;
    public boolean waiting;
    
    public SellRequestPackage(String property,String seller,String buyer, boolean edification,int price) {
        super("SellRequest");
        this.property = property;
        this.seller = seller;
        this.buyer = buyer;
        this.edification = edification;
        waiting = true;
        this.price = price;
    }
    
     public void setMessage(String message) {
        this.message = message;
    }
    
}
