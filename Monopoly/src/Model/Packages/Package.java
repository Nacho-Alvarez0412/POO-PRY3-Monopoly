/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Packages;

import java.io.Serializable;

/**
 *
 * @author nacho
 */
public abstract class Package implements Serializable {
    //Atributos
    public String type;
    
    //Metodos
    public Package(String type){
        this.type = type;
    }
}
