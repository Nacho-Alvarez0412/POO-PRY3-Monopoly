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
public class MortgagePackage extends Package {
    public String propertyName;
    public boolean mortgage;
    
    public MortgagePackage(String propertyName,boolean mortgage) {
        super("MortgageCheck");
        this.propertyName = propertyName;
        this.mortgage = mortgage;
    }
    
}
