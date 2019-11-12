/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Server;

import Model.Game.Game;
import Model.Game.User;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Packages.*;
import View.ServerView.ServerWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

/**
 *
 * @author nacho
 */
public class Server implements ActionListener {
    //Atributos
    public ArrayList<ClientListener> listeners;
    public ArrayList<User> players;
    public ServerWindow view;
    public Game game;
    public boolean gameState;
    
    public Server(){
        initWindow();
        listeners = new ArrayList<>();
        players = new ArrayList<>();
        gameState = false;
        view.ServerLogTextArea.setText("Waiting for party size confirmation...");
        
    }
    
    public void addClient(ClientListener listener){
        listeners.add(listener);
    }
    
    public void addUser(User user){
        players.add(user);
    }
    
    public void enviarPaquete(Model.Packages.Package packet){
        for(ClientListener listener : listeners){
            try{
                ObjectOutputStream out = new ObjectOutputStream(listener.socket.getOutputStream());
                out.writeObject(packet);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void enviarPaqueteA(Model.Packages.Package paq,Socket socket) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(paq);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void initWindow(){
        view = new ServerWindow();
        view.setVisible(true);
        view.ConfirmButton.addActionListener(this);
        view.StartGameButton.addActionListener(this);
    }
    
    public boolean authenticateUser(User user){
        for(User player : players){
            if(player.getCharacter().getCharacter() == user.getCharacter().getCharacter())
                return false;
            else if(player.getName().equals(user.getName()))
                return false;
        }
        
        return true;
    }
    
    public User findUser(int id){
        for(User player : players){
            if(player.id == id)
                return player;
        }
        return null;
    }
    
    public boolean areEquals(){
        for(User player1 : players){
            for(User player2 : players){
                if(player1.roll == player2.roll && player1.id != player2.id){
                    askReroll(player1.id,player2.id);
                    return true;
                }
            }
        }
        return false;
    }
    
    public void askReroll(int id1,int id2){
        DicesPackage packet = new DicesPackage(-1);
        enviarPaqueteA(packet, listeners.get(id1-1).socket);
        enviarPaqueteA(packet, listeners.get(id2-1).socket);
    }
    
    public void orderUsers(){
        for(int i = 0 ; i < players.size(); i++){
            User min = players.get(i);
            int minID = i;
            
            for(int j = i+1; j<players.size(); j++){
                if(players.get(j).roll>min.roll){
                    min = players.get(j);
                    minID = j;
                }
            }
            //Swapping
            
            User temp = players.get(i);
            players.set(i, min);
            players.set(minID, temp);
        }
    }
    
    public void printOrder(){
        int cont = 1;
        
        for(User player : players){
            view.ServerLogTextArea.append("\n"+cont+". "+player.getName());
            cont++;
        }
    }
    
    public void setOrder(){
        orderUsers();
        printOrder();
    }
    
    public void initGame(){
        game = new Game(players,this);
        game.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.ConfirmButton)){
            view.ConfirmButton.setEnabled(false);
            ConnectionController controller = new ConnectionController(this,(int)view.CantPlayersSpinBox.getValue());
            controller.start();
            view.ServerLogTextArea.setText("Waiting for players to join the party...");
        }
        
        else if (e.getSource().equals(view.StartGameButton)){
            
            if(!areEquals()){
                view.ServerLogTextArea.append("\nStarting game...");
                StartSignalPackage startSignal = new StartSignalPackage();
                enviarPaquete(startSignal);
                initGame();
                gameState = true;
            }
            else{
                view.ServerLogTextArea.append("\nPlayers no ready yet...");
            }
                
        }
    }
}
