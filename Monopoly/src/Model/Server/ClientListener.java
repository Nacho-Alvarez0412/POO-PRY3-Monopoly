/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Server;

import Model.Game.Card;
import Model.Game.EnumCardType;
import Model.Game.Property;
import Model.Game.User;
import Model.Packages.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author nacho
 */
public class ClientListener extends Thread{
    //Atributos
    public Socket socket;
    public Server server;
    public int id;
    
    public ClientListener(Socket socket,Server server,int id){
        this.socket = socket;
        this.server = server;
        this.id = id;
    }
    
    @Override
    public void run(){
        while(true){
            try{
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Model.Packages.Package packet = (Model.Packages.Package) in.readObject();
                
                switch (packet.type){
                    
                    case "Chat":
                        ChatPackage messagePackage = (ChatPackage) packet;
                        String message = messagePackage.message;
                        message = server.findUser(id).name +": "+message;
                        messagePackage.message = message;
                        server.enviarPaquete(messagePackage);
                        break;
                        
                        
                    case "UserRequest":
                        UserRequestPackage userPackage = (UserRequestPackage) packet;
                        boolean authentication = server.authenticateUser(userPackage.user);
                        
                        if(authentication){
                            userPackage.user.id = this.id;
                            server.addUser(userPackage.user);
                            server.view.ServerLogTextArea.append("\nPlayer "+this.id+": "+userPackage.user.getName()+" Piece: "+userPackage.user.getCharacter().getCharacter()+", joined succesfully");
                            userPackage.setAcceptance(true);
                            server.enviarPaqueteA(userPackage,this.socket);
                        }
                        
                        else{
                            userPackage.setAcceptance(false);
                            server.enviarPaqueteA(userPackage,this.socket);
                        }
                        break;
                        
                    case "DicesRoll":
                        DicesPackage userRoll = (DicesPackage) packet;
                        if(server.gameState){
                            String Servermessage ="Server: " + server.findUser(id).name + " rolled a "+userRoll.value;
                            server.enviarPaquete(new ChatPackage(Servermessage));
                            server.findUser(id).roll = userRoll.value;
                            server.game.movePlayer(id);
                            User player = server.findUser(id);
                            Card property = server.game.board.get(player.index);                            
                            
                            server.enviarPaquete(new UserMovementPackage(player.index, id,property.getX(),property.getY()) );
                            
                            if(property.getType() == EnumCardType.Property){
                                Property terrain = (Property) property;
                                if(terrain.getOwner() != null){
                                    player.money -= terrain.getRentPrice();
                                    terrain.getOwner().money += terrain.getRentPrice();
                                    server.enviarPaqueteA(new RentSignalPackage(terrain.getRentPrice()), socket);
                                }
                            }
                            server.enviarPaqueteA(new UpdateUserPackage(player), socket);
                            server.enviarPaquete(new PropertiesUpdatePackage(server.game.properties));
                        }
                        else{
                            User player = server.findUser(id);
                            server.view.ServerLogTextArea.append("\n"+player.getName()+" rolled a "+userRoll.value);
                            player.roll = userRoll.value;
                            server.setOrder();
                        }
                        break;
                        
                    case "Turn":
                        server.game.setUserTurn(false);
                        break;
                        
                    case "InfoRequest":
                        UserInfoRequestPackage infoRequest = (UserInfoRequestPackage) packet;
                        if(infoRequest.userIndex >= server.players.size())
                            infoRequest.userIndex = 0;
                        
                        User user = server.players.get(infoRequest.userIndex);
                        if(user.id == this.id ){
                            infoRequest.userIndex++;
                            
                            if(infoRequest.userIndex >= server.players.size())
                            infoRequest.userIndex = 0;
                            
                            user = server.players.get(infoRequest.userIndex);
                        }
                        infoRequest.userIndex++;
                        infoRequest.user = user;
                        
                        server.enviarPaqueteA(packet, socket);
                        break;
                        
                    case "BuyRequest":
                        
                        BuyRequestPackage terrainRequest = (BuyRequestPackage) packet;
                        User player = server.findUser(id);
                        Property terrain = (Property) server.game.board.get(terrainRequest.boardIndex);
                        
                        if(terrain.getOwner() != null || terrain.getPrice() > player.money){
                            terrainRequest.accepetance = false;
                        }
                        else{
                            terrainRequest.accepetance = true;
                            player.money -= terrain.getPrice();
                            terrain.setOwner(player);
                            player.addTerrain(terrain);
                            
                        }
                        server.enviarPaqueteA(packet, socket);
                        server.enviarPaqueteA(new UpdateUserPackage(player), socket);
                        server.enviarPaquete(new PropertiesUpdatePackage(server.game.properties));
                        
                        break;
                        
                    case "SellRequest":
                        SellRequestPackage sellRequest = (SellRequestPackage) packet;
                        Property property = server.game.findProperty(sellRequest.property);
                        User seller = server.findUser(id);
                        User buyer = server.findUser(sellRequest.buyer);
                        
                        if(sellRequest.waiting == true){
                            if(sellRequest.edification){
                                if(property.getHouses()>0){
                                    seller.money += property.getBuildingPrice() * property.getHouses();
                                    property.setHouses(0);
                                }

                                if(property.isHotel()){
                                    seller.money += property.getBuildingPrice();
                                    property.setHotel(false);
                                }
                                sellRequest.accepted = true;
                            }

                            else if(sellRequest.buyer.equals("")){
                                seller.money += property.getPrice() - 20;
                                property.setOwner(null);
                                seller.removeProperty(property.getName());
                                sellRequest.accepted = true;

                            }

                            else{
                                sellRequest.setMessage(seller.name + " wants to sell " + property.getName() + " for $" + sellRequest.price);
                                server.enviarPaqueteA(packet, server.listeners.get(buyer.id-1).socket);
                            }
                        }
                        
                        else{
                            if(sellRequest.accepted){
                                seller.money += sellRequest.price;
                                buyer.money -= sellRequest.price;
                                property.setOwner(buyer);
                                buyer.addTerrain(property);
                                seller.removeProperty(property.getName());
                                server.enviarPaqueteA(new UpdateUserPackage(buyer), server.listeners.get(buyer.id-1).socket);
                            }
                        }
                        server.enviarPaqueteA(packet, socket);
                        server.enviarPaqueteA(new UpdateUserPackage(seller), socket);
                        server.enviarPaquete(new PropertiesUpdatePackage(server.game.properties));
       
                }
            } catch(IOException | ClassNotFoundException e) { 
                 System.out.println(e); 
            }
        }
    }
}
