/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Packages;

import Model.Game.User;

/**
 *
 * @author nacho
 */
public class UserRequestPackage extends Package {
    public User user;
    public boolean accepted;
    
    public UserRequestPackage(User user) {
        super("UserRequest");
        this.user = user;
    }
    
    public void setAcceptance(boolean state){
        this.accepted = state;
    }
    
}
