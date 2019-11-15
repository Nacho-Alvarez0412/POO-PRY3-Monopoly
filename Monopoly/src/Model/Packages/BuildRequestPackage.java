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
public class BuildRequestPackage extends Package {
    public String name;
    public boolean accepted;
    
    public BuildRequestPackage(String name) {
        super("BuildRequest");
        this.name = name;
        accepted = false;
    }
    
    
}
