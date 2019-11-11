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
public class DicesPackage extends Package{
    public int value;
    public DicesPackage(int value) {
        super("DicesRoll");
        this.value = value;
    }
    
}
