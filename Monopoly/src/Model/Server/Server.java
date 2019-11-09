/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Packages.*;
import View.ServerView.ServerWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author nacho
 */
public class Server implements ActionListener {
    //Atributos
    public ArrayList<ClientListener> listeners;
    public ServerWindow view;
    
    public Server(){
        initWindow();
        listeners = new ArrayList<>();
        view.ServerLogJTextField.setText("Waiting for party size confirmation...");
        
    }
    
    public void addClient(ClientListener listener){
        listeners.add(listener);
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
    
    public void initWindow(){
        view = new ServerWindow();
        view.setVisible(true);
        view.ConfirmButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.ConfirmButton)){
            ConnectionController controller = new ConnectionController(this,(int)view.CantPlayersSpinBox.getValue());
            controller.start();
            view.ServerLogJTextField.setText("Waiting for players to join the party...");
        }
    }
}
