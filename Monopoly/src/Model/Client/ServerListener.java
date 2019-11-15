/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Client;

import Model.Game.User;
import Model.Packages.*;
import View.ClientView.RollDiceWindow;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
                Model.Packages.Package packet = (Model.Packages.Package) in.readObject();
                
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
                        client.gameController = new GameController(client,startPackage.properties,startPackage.players);
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
                        
                    case "UserMovement":
                        UserMovementPackage userMovement = (UserMovementPackage) packet;
                        User player = client.gameController.findUser(userMovement.id);
                        player.index = userMovement.userIndex;
                        client.gameController.paintPlayer(player,userMovement.x,userMovement.y);
                        break;
                        
                    case "UserUpdate":
                        UpdateUserPackage newUserInfo = (UpdateUserPackage) packet;
                        client.user = newUserInfo.user;
                        client.gameController.updateUserInfo();
                        break;
                        
                    case "PropertiesUpdate":
                        PropertiesUpdatePackage newPropertiesInfo = (PropertiesUpdatePackage) packet;
                        client.gameController.properties = newPropertiesInfo.properties;
                        break;
                    
                    case "BuyRequest":
                        BuyRequestPackage terrainRequest = (BuyRequestPackage) packet;
                         
                        if(terrainRequest.accepetance)
                            JOptionPane.showMessageDialog(client.gameController.view, "Your empire is growing! New terrain obtained");
                        
                        else
                            JOptionPane.showMessageDialog(client.gameController.view, "Trouble! This terrain already posses an owner or you're in financial danger!!");
                        
                        break;
                        
                    case "RentSignal":
                        RentSignalPackage rentPackage = (RentSignalPackage) packet;
                        JOptionPane.showMessageDialog(client.gameController.view, "Whoops! Seems you fell in an owned property. Pay $"+rentPackage.rent);
                        break;
                        
                    case "SellRequest":
                        SellRequestPackage request = (SellRequestPackage) packet;
                        
                        if(!request.waiting){
                        
                            if(request.accepted)
                                JOptionPane.showMessageDialog(client.gameController.sellView, "Your transaction has been processed successfully!");   

                            else
                                JOptionPane.showMessageDialog(client.gameController.sellView, "Your transaction has been declined... Better luck next time!"); 
                        }
                        
                        else{
                            client.gameController.request = request;
                            client.gameController.sellRequestView.MessageLabel.setText(request.message);
                            client.gameController.sellRequestView.setVisible(true);
                        }
                        break;
                        
                    case "BuildRequest":
                        BuildRequestPackage buildRequest = (BuildRequestPackage) packet;
                        
                        if(buildRequest.accepted)
                            JOptionPane.showMessageDialog(client.gameController.buildingView, "New building added to your property!");
                        else
                            JOptionPane.showMessageDialog(client.gameController.buildingView, "Whoops! Seems you dont have the requirements for building!");
                        
                        break;
                        
                    case "TradeRequest":
                        TradeRequestPackage tradeRequest = (TradeRequestPackage) packet;
                        
                        if(tradeRequest.waiting){
                            client.gameController.tradeRequestView.MessageLabel.setText(tradeRequest.message);
                            client.gameController.tradeRequestView.setVisible(true);
                            client.gameController.tradeRequest = tradeRequest;
                        }
                        
                        else{
                            if(tradeRequest.accepted)
                                JOptionPane.showMessageDialog(client.gameController.view, "Hurray! Both parties accepted to trade!");
                            else
                                JOptionPane.showMessageDialog(client.gameController.view, "Seems like your offer wasnt good enough!");
                        }
                        break;
                        
                    case "MortgageCheck":
                        MortgagePackage mortgagePackage = (MortgagePackage) packet;
                        
                        if(mortgagePackage.mortgage)
                            JOptionPane.showMessageDialog(client.gameController.view, "Your property has been mortgaged successfully");
                        else
                            JOptionPane.showMessageDialog(client.gameController.view, "Your property has been unmortgaged successfully");
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Model.Client.ServerListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Model.Client.ServerListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
