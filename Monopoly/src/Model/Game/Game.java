/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Game;

import Model.Packages.BankruptcyPackage;
import Model.Packages.PropertiesUpdatePackage;
import Model.Packages.TurnPackage;
import Model.Packages.UpdateUserPackage;
import Model.Packages.VictoryPackage;
import Model.Server.Server;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nacho
 */
public class Game extends Thread{
    ArrayList<User> players;
    int turn;
    Server server;
    boolean victory;
    public boolean userTurn;
    public ArrayList<Card> board;
    public ArrayList<Property> properties;
    public ArrayList<Wildcard> fortuneDeck;
    public ArrayList<Wildcard> communityChestDeck;

    public ArrayList<Property> getProperties() {
        return properties;
    }

    public ArrayList<User> getPlayers() {
        return players;
    }
    
    public User findUser(int id){
        for(User player : players){
            if(player.id == id)
                return player;
        }
        return null;
    }
    
    
    public Game(ArrayList<User> players,Server server){
        this.players = players;
        this.server = server;
        turn = 0;
        victory = false;
        BoardGenerator boardGenerator = new BoardGenerator();
        board = boardGenerator.board;
        properties = boardGenerator.properties;
        fortuneDeck = boardGenerator.fortune;
        communityChestDeck = boardGenerator.communityChest;
    }

    public void setPlayers(ArrayList<User> players) {
        this.players = players;
    }

    public void setUserTurn(boolean userTurn) {
        this.userTurn = userTurn;
    }
    
    void changeTurn(){
        turn++;
        
        if(turn >= players.size())
            turn = 0;
    }
    
    public void moveToService(int id){
        User player = players.get(id);
        int index = player.index;
        
        while(properties.get(index).color != Color.LIGHT_GRAY){
            index++;
        }
        player.roll = index - player.index;
    }
    
    public void movePlayer(int index){
        
        User user = findUser(index);
        
       while(user.roll != 0){
            user.index++;
            user.roll--;
            if(user.index>= board.size()){
                user.index = 0;
                user.money += 200;
                user.lap++;
            }
        }
       
    }

    public void run(){
        while(!victory){
            server.enviarPaquete(new TurnPackage(players.get(turn).name));
            userTurn = true;
            
            while(userTurn){
                if(checkUserState()){
                    User player = players.get(turn);
                    userTurn = false;
                    player.bankruptcy = true;
                    server.enviarPaquete(new BankruptcyPackage(player.name));
                    clearProperties(player);
                    server.enviarPaquete(new PropertiesUpdatePackage(properties));
                    players.remove(turn);
                }
                    
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            changeTurn();
            checkVictory();
        }
        server.enviarPaquete(new VictoryPackage(players.get(0).name));
        
    }

    public Property findProperty(String name) {
        for(Property property : properties){
            if(name.equals(property.getName()))
                return property;
        }
        return null;
    }

    public void moveToRailroad(int id) {
        User player = players.get(id);
        int index = player.index;
        
        while(properties.get(index).color != Color.BLACK){
            index++;
        }
        player.roll = index - player.index;
    }

    public void payPlayers(int cant, int id) {
        for(User player : server.players){
            if(player.id != id){
                player.money += cant;
                server.enviarPaqueteA(new UpdateUserPackage(player), server.listeners.get(player.id-1).socket);
            }
        }
    }

    public void collectMoney(int i, User player) {
        for(User clients : players){
            clients.money -= i;
            player.money+=i;
            server.enviarPaqueteA(new UpdateUserPackage(player), server.listeners.get(player.id-1).socket);
        }
    }

    private boolean checkUserState() {
        User player = players.get(turn);
        if(player.money<=0)
            return true;
        return false;
    }

    private void clearProperties(User player) {
        for(Property property : player.properties){
            property.owner = null;
            property.hotel = false;
            property.houses = 0;
        }
        player.properties.clear();
    }

    private void checkVictory() {
        
        if(players.size() == 1)
            victory = true;
    }
}
