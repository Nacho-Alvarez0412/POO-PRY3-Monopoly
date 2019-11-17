/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Server;

import Model.Game.Card;
import Model.Game.EnumCardType;
import Model.Game.EnumSpecialType;
import Model.Game.Property;
import Model.Game.SpecialCard;
import Model.Game.User;
import Model.Game.Wildcard;
import Model.Packages.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Random;

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
                                if(terrain.getOwner() != null && terrain.getOwner() != player){
                                    player.money -= terrain.getRentPrice();
                                    terrain.getOwner().money += terrain.getRentPrice();
                                    server.enviarPaqueteA(new RentSignalPackage(terrain.getRentPrice()), socket);
                                }
                            }
                            
                            else if(property.getType() == EnumCardType.Special){
                                SpecialCard terrain = (SpecialCard) property;
                                executeTileAction(terrain,player);
                            
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
                        User playerC = server.findUser(id);
                        if(playerC.sentenceTime>0)
                            playerC.sentenceTime--;
                        if(playerC.sentenceTime == 0)
                            playerC.jail = false;
                        server.enviarPaqueteA(new UpdateUserPackage(playerC), socket);
                        server.game.setUserTurn(false);
                        break;
                        
                    case "WildcardUse":
                        User currentUser = server.findUser(id);
                        
                        if(currentUser.jail)
                            currentUser.jail = false;
                        else
                            currentUser.money+=50;
                        server.enviarPaqueteA(new UpdateUserPackage(currentUser), socket); 
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
                        User seller = server.findUser(sellRequest.seller);
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
                                sellRequest.waiting = false;
                                server.enviarPaqueteA(packet, socket);
                            }

                            else if(sellRequest.buyer.equals("")){
                                seller.money += property.getPrice() - 20;
                                property.setOwner(null);
                                seller.removeProperty(property.getName());
                                sellRequest.accepted = true;
                                sellRequest.waiting = false;
                                server.enviarPaqueteA(packet, socket);

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
                                seller.removeProperty(property.getName());
                                buyer.addTerrain(property);
                                property.setOwner(buyer);
                                server.enviarPaqueteA(new UpdateUserPackage(buyer), server.listeners.get(server.findUser(buyer.name).id-1).socket);
                                server.enviarPaqueteA(packet, server.listeners.get(server.findUser(seller.name).id-1).socket);
                            }
                        }
                        server.enviarPaqueteA(new UpdateUserPackage(seller), server.listeners.get(server.findUser(seller.name).id-1).socket);
                        server.enviarPaquete(new PropertiesUpdatePackage(server.game.properties));
                        break;
                        
                    case "BuildRequest":
                        BuildRequestPackage buildRequest = (BuildRequestPackage) packet;
                        Property propertyToConstruct = server.game.findProperty(buildRequest.name);
                        User owner = server.findUser(id);
                        
                        if(server.findUser(id).isMonopoly(propertyToConstruct.getColor())){
                            if(owner.money >= propertyToConstruct.getBuildingPrice()){
                                buildRequest.accepted = true;
                                if(propertyToConstruct.getHouses()<4)
                                    propertyToConstruct.addHouses();
                                else
                                    propertyToConstruct.setHotel(true);

                                owner.money -= propertyToConstruct.getBuildingPrice();
                            }
                            else
                                buildRequest.accepted = false;
                        }
                        else
                            buildRequest.accepted = false;
                        
                        server.enviarPaqueteA(packet, socket);
                        server.enviarPaqueteA(new UpdateUserPackage(server.findUser(id)), socket);
                        server.enviarPaquete(new PropertiesUpdatePackage(server.game.properties));
                        break;
                        
                    case "TradeRequest":
                        TradeRequestPackage tradeRequest = (TradeRequestPackage) packet;
                        User player1 = server.findUser(tradeRequest.player1);
                        User player2 = server.findUser(tradeRequest.player2);
                        Property property1 = server.game.findProperty(tradeRequest.property1);
                        Property property2 = server.game.findProperty(tradeRequest.property2);
                        
                        if(tradeRequest.waiting){
                            
                            tradeRequest.message = player1.name + " wants to trade "+ property1.getName()+ " for " + property2.getName();
                            server.enviarPaqueteA(packet, server.listeners.get(player2.id-1).socket);
                        }
                        else{
                            if(tradeRequest.accepted){
                                property1.setOwner(player2);
                                property2.setOwner(player1);
                                player1.removeProperty(property1.getName());
                                player2.removeProperty(property2.getName());
                                player1.addTerrain(property2);
                                player2.addTerrain(property1);
                                server.enviarPaquete(new PropertiesUpdatePackage(server.game.properties));
                                server.enviarPaqueteA(new UpdateUserPackage(player1),server.listeners.get(player1.id-1).socket);
                                server.enviarPaqueteA(new UpdateUserPackage(player2),server.listeners.get(player2.id-1).socket);
                            }
                            server.enviarPaqueteA(packet,server.listeners.get(player1.id-1).socket);
                        }
                        
                        break;
                        
                    case "MortgageCheck":
                        MortgagePackage mortgageRequest = (MortgagePackage) packet;
                        Property mortgagedProperty = server.game.findProperty(mortgageRequest.propertyName);
                        User MortgageOwner = server.findUser(id);
                        
                        if(mortgagedProperty.isMortgaged()){
                            MortgageOwner.money -= mortgagedProperty.getMortagePrice() +75;
                            mortgagedProperty.setMortgaged(false);
                        }
                        
                        else{
                            MortgageOwner.money += mortgagedProperty.getMortagePrice();
                            mortgagedProperty.setMortgaged(true);
                        }
                        server.enviarPaquete(new PropertiesUpdatePackage(server.game.properties));
                        server.enviarPaqueteA(new UpdateUserPackage(MortgageOwner),socket);
                        server.enviarPaqueteA(packet, socket);
                        
                        break;

                }
            } catch(IOException | ClassNotFoundException e) { 
                 System.out.println(e); 
            }
        }
    }

    private void executeTileAction(SpecialCard terrain,User player) {
        Random random = new Random();
        if(terrain.getId() == EnumSpecialType.Chance){
            
            Wildcard card = server.game.fortuneDeck.get(random.nextInt(16));
            server.enviarPaqueteA(new WildcardPackage(card),server.listeners.get(id-1).socket);
            executeWildcard(card,player);
        }
        
        else if(terrain.getId() == EnumSpecialType.CommunityChest){
            Wildcard card = server.game.communityChestDeck.get(random.nextInt(16));
            server.enviarPaqueteA(new WildcardPackage(card),server.listeners.get(id-1).socket);
            executeWildcard(card,player);
        }
        
        else if(terrain.getId() == EnumSpecialType.IncomeTax){
            player.money-=200;
            server.enviarPaqueteA(new InfoPackage("Income Tax for your properties. Pay $200"),server.listeners.get(id-1).socket);
        }
        
        else if(terrain.getId() == EnumSpecialType.LuxuryTax){
            player.money-=100;
            server.enviarPaqueteA(new InfoPackage("Income Tax for your luxuries. Pay $100"),server.listeners.get(id-1).socket);
        }
        
        else if(terrain.getId() == EnumSpecialType.ParkZone){
        
        }
        
        else if(terrain.getId() == EnumSpecialType.ToJail){
            player.jail = true;
            player.sentenceTime = 3;
            player.index = 10;
            server.enviarPaquete(new UserMovementPackage(player.index, id,terrain.getX(),terrain.getY()));
            server.enviarPaqueteA(new InfoPackage("Stop right there! Move to jail"),server.listeners.get(id-1).socket);
        }
        
    }
    
    private void executeWildcard(Wildcard card,User player) {
        Card property;
        if(card.isWildcardType()){
            switch (card.getId()){
                case 1: //Advance to Go
                    player.index = 0;
                    property = server.game.board.get(player.index);                            
                    server.enviarPaquete(new UserMovementPackage(player.index, id,property.getX(),property.getY()) );
                    break;
                    
                case 2: // Advance to Illinois Ave.
                    player.index = 24;
                    property = server.game.board.get(player.index);                            
                    server.enviarPaquete(new UserMovementPackage(player.index, id,property.getX(),property.getY()) );
                    break;
                    
                case 3: // Advance Carles Place
                    player.index = 11;
                    property = server.game.board.get(player.index);                            
                    server.enviarPaquete(new UserMovementPackage(player.index, id,property.getX(),property.getY()) );
                    break;
                    
                case 4: //Advance to nearest service
                    server.game.moveToService(id);
                    server.game.movePlayer(id);
                    property = server.game.board.get(player.index);
                    server.enviarPaquete(new UserMovementPackage(player.index, id,property.getX(),property.getY()) );
                    break;
                    
                case 5:  //Advance to nearest service
                    server.game.moveToRailroad(id);
                    server.game.movePlayer(id);
                    property = server.game.board.get(player.index);
                    server.enviarPaquete(new UserMovementPackage(player.index, id,property.getX(),property.getY()) );
                    break;
                case 6:
                    player.money += 50;
                    break;
                    
                case 7:
                    player.wildcard = true;
                    break;
                    
                case 8:
                    player.index -= 3;
                    property = server.game.board.get(player.index);                            
                    server.enviarPaquete(new UserMovementPackage(player.index, id,property.getX(),property.getY()) );
                    break;
                    
                case 9:
                    player.index = 10;
                    player.jail = true;
                    property = server.game.board.get(player.index);                            
                    server.enviarPaquete(new UserMovementPackage(player.index, id,property.getX(),property.getY()) );
                    break;
                    
                case 10:
                    player.Repair(25,100);
                    break;
                    
                case 11:
                    player.money -= 15;
                    break;
                    
                case 12:
                    player.index = 5;
                    property = server.game.board.get(player.index);                            
                    server.enviarPaquete(new UserMovementPackage(player.index, id,property.getX(),property.getY()) );
                    break;
                    
                case 13:
                    player.index = 39;
                    property = server.game.board.get(player.index);                            
                    server.enviarPaquete(new UserMovementPackage(player.index, id,property.getX(),property.getY()) );
                    break;
                    
                case 14:
                    player.money -= 50*server.players.size()-1;
                    server.game.payPlayers(50,player.id);
                    break;
                    
                case 15:
                    player.money += 150;
                    break;
                    
                case 16:
                    player.money += 100;
                    break;
            
            }
        }
        
        else{
            switch (card.getId()){
                case 1://Advance to go
                    player.index = 0;
                    property = server.game.board.get(player.index); 
                    player.money+=200;
                    server.enviarPaquete(new UserMovementPackage(player.index, id,property.getX(),property.getY()) );
                    break;
                    
                case 2:
                    player.money+=200;
                    break;
                case 3:
                    player.money-=50;
                    break;
                case 4:
                    player.money += 50;
                    break;
                case 5:
                    player.wildcard = true;
                    break;
                    
                case 6:
                    player.index = 10;
                    player.jail = true;
                    property = server.game.board.get(player.index);                            
                    server.enviarPaquete(new UserMovementPackage(player.index, id,property.getX(),property.getY()) );
                    break;
                case 7:
                    server.game.collectMoney(50,player);
                    break;
                case 8:
                    player.money+=100;
                    break;
                case 9:
                    player.money+=20;
                    break;  
                case 10:
                    server.game.collectMoney(10,player);
                    break;
                case 11:
                    player.money += 100;
                    break;
                case 12:
                    player.money -= 50;
                    break;
                case 13:
                    player.money -= 50;
                    break;
                case 14:
                    player.money += 15;
                    break;
                case 15:
                    player.Repair(40,115);
                    break;
                case 16:
                    player.money += 10;
                    break;
            
            }
        }
    }
}
