/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Game;

import Model.Packages.TurnPackage;
import Model.Server.Server;
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
    boolean userTurn;
    ArrayList<Card> board;
    ArrayList<Property> properties;
    ArrayList<Wildcard> fortuneDeck;
    ArrayList<Wildcard> communityChestDeck;

    public ArrayList<Property> getProperties() {
        return properties;
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
    
    void movePlayer(User user){
        while(user.roll != 0){
            user.index++;
            if(user.index>= board.size())
                user.index = 0;
        }
        
    }
    
    public void run(){
        while(!victory){
            server.enviarPaquete(new TurnPackage(players.get(turn).name));
            userTurn = true;
            
            while(userTurn){
                
                
                
                
                
                
                
                
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            changeTurn();
            
        }
        
    }
}
