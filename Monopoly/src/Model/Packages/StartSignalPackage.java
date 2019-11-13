/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Packages;

import Model.Game.Property;
import java.util.ArrayList;

/**
 *
 * @author nacho
 */
public class StartSignalPackage extends Package {
    public ArrayList<Property> properties;
    public StartSignalPackage(ArrayList<Property> properties) {
        super("StartSignal");
        this.properties = properties;
    }
    
}
