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
public class VictoryPackage extends Package {
    public String winner;
    
    public VictoryPackage(String name) {
        super("VictorySignal");
        winner = name;
    }
    
}
