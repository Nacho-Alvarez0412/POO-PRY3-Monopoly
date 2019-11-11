/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Client;

import Model.Packages.ChatPackage;
import Model.Packages.Package;
import Model.Packages.UserRequestPackage;
import View.ClientView.RollDiceWindow;
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
    RollDiceWindow view;
    
    public void init(Client client,RollDiceWindow view){
        this.client = client;
        this.view = view;
    }
    
    @Override
    public void run(){
        try{
            while(true){
                ObjectInputStream in = new ObjectInputStream(this.client.socket.getInputStream());
                Package packet = (Package) in.readObject();
                
                switch (packet.type){
                    
                    case "Chat":
                        ChatPackage chat = (ChatPackage) packet;
                        //Put on screen message
                        break;
                        
                    case "DicesRoll":
                        client.startView.ServerResponseLabel.setText("Reroll the dices");
                        client.diceView.setVisible(true);
                        break;
                        
                    case "UserRequest":
                        UserRequestPackage userPackage = (UserRequestPackage) packet;
                        
                        if(userPackage.accepted){
                            client.startView.ServerResponseLabel.setText("User joined succesfully");
                            view.setVisible(true);
                        }
                        
                        else{
                            client.startView.ConfirmButton.setEnabled(false);
                            client.startView.ServerResponseLabel.setText("The chosen piece or name has already been selected");
                        }
                        break;
                      
                    case "StartSignal":
                        client.startView.ServerResponseLabel.setText("Game is about to begin");
                        try {
                            sleep(2000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ServerListener.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        client.startView.setVisible(false);
                        client.startView.dispose();
                        client.gameController = new GameController(client);
                        break;

                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Model.Client.ServerListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Model.Client.ServerListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
