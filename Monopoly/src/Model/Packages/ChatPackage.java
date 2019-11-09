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
public class ChatPackage extends Package {
    //Atributos
    public String message;
    
    //Metodos
    public ChatPackage(String message) {
        super("Chat");
        this.message = message;
    }
    
}
