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
public class RentSignalPackage extends Package{
    
    public int rent;
    
    public RentSignalPackage(int rent) {
        super("RentSignal");
        this.rent = rent;
    }
    
    
}
