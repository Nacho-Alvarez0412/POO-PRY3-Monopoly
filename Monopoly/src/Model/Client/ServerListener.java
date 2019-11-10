/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Client;

import Model.Packages.ChatPackage;
import Model.Packages.Package;
import Model.Packages.UserRequestPackage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nacho
 */
public class ServerListener extends Thread{
    Client client;
    
    public void init(Client client){
        this.client = client;
    }
    
    @Override
    public void run(){
        try{
            while(true){
                ObjectInputStream in = new ObjectInputStream(this.client.socket.getInputStream());
                Package packet = (Package) in.readObject();
                
                switch (packet.type){
                    
                    case "chat":
                        ChatPackage chat = (ChatPackage) packet;
                        //Put on screen message
                        break;
                        
                    case "UserRequest":
                        UserRequestPackage userPackage = (UserRequestPackage) packet;
                        
                        if(userPackage.accepted)
                            client.startView.ServerResponseLabel.setText("User joined succesfully");
                        
                        else
                            client.startView.ServerResponseLabel.setText("The chosen piece or name has already been selected");
                            
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Model.Client.ServerListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Model.Client.ServerListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
