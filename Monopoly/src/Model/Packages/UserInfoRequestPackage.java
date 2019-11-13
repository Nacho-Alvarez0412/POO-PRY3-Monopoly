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
public class UserInfoRequestPackage extends Package {
    public int userIndex;
    public User user;
    
    public UserInfoRequestPackage(int index){
        super("InfoRequest");
        userIndex = index;
    }
    
}
