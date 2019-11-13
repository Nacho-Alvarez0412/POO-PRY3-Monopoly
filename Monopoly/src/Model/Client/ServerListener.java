/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Client;

import Model.Game.User;
import Model.Packages.ChatPackage;
import Model.Packages.Package;
import Model.Packages.StartSignalPackage;
import Model.Packages.TurnPackage;
import Model.Packages.UserInfoRequestPackage;
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
                        ChatPackage chatPackage = (ChatPackage) packet;
                        String message = chatPackage.message;
                        client.gameController.view.ChatTextArea.append(message+"\n");
                        break;
                        
                    case "DicesRoll":
                        client.diceView.DicesButton.setEnabled(true);
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
                            client.startView.ConfirmButton.setEnabled(true);
                            client.startView.ServerResponseLabel.setText("The chosen piece or name has already been selected");
                        }
                        break;
                      
                    case "StartSignal":
                        StartSignalPackage startPackage = (StartSignalPackage) packet;
                        client.startView.ServerResponseLabel.setText("Game is about to begin");
                        try {
                            sleep(2000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ServerListener.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        client.startView.setVisible(false);
                        client.startView.dispose();
                        client.gameController = new GameController(client,startPackage.properties);
                        break;
                        
                    case "Turn":
                        TurnPackage turnInfo = (TurnPackage) packet;
                        client.gameController.view.TurnLabel.setText(turnInfo.name);
                        
                        if(turnInfo.name.equals(client.user.name)){
                            client.gameController.view.RollButton.setEnabled(true);
                        }
                        break;
                        
                    case "InfoRequest":
                        UserInfoRequestPackage userInfo = (UserInfoRequestPackage) packet;
                        
                        User user = userInfo.user;
                        client.gameController.userIndex = userInfo.userIndex;
                        
                        client.gameController.view.PlayerXName.setText(user.name);
                        client.gameController.view.PlayerXMoney.setText("$ "+user.money);
                        client.gameController.view.PlayerXIconLabel.setIcon(user.character.getAppereance());
                        client.gameController.printXProperties(user.properties);
                        
                        
                        
                        
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
