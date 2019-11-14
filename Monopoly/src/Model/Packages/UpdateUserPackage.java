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
public class UpdateUserPackage extends Package {
    public User user;
    public UpdateUserPackage(User user) {
        super("UserUpdate");
        this.user = user;
    }
    
}
