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
public class UserMovementPackage extends Package {
    public int userIndex;
    public int id;
    public int x;
    public int y;
    
    public UserMovementPackage(int index,int id,int x, int y) {
        super("UserMovement");
        userIndex = index;
        this.id = id;
        this.x = x;
        this.y = y;
    }
    
}
