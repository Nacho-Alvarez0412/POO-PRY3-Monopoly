/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Client;

import Model.Game.*;
import View.ClientView.ClientStartWindow;
import View.ServerView.ServerWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author nacho
 */
public class Client implements ActionListener {
    //Atributos
    public User user;
    public Socket socket;
    
    //Ventana ClientStart
    public ClientStartWindow startView;
    
    //Metodos
    public Client(String name,GameCharacter character){
        this.user = new User(name,character);
    }
    
    public void connect(String address,int port) throws IOException{
        socket = new Socket(address,port);
        
        ServerListener listener = new ServerListener();
        listener.init(this);
        listener.start();
    }
    
    public void enviarPaquete(Package packet) throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(packet);
    }
    
    public void initWindow(){
        startView = new ClientStartWindow();
        startView.setVisible(true);
        
        startView.BattleshipButton.addActionListener(this);
        startView.CarButton.addActionListener(this);
        startView.CartButton.addActionListener(this);
        startView.CatButton.addActionListener(this);
        startView.DinosaurButton.addActionListener(this);
        startView.DogButton.addActionListener(this);
        startView.DuckButton.addActionListener(this);
        startView.HatButton.addActionListener(this);
        startView.IronButton.addActionListener(this);
        startView.PenguinButton.addActionListener(this);
        startView.ShoeButton.addActionListener(this);
        startView.ThimbleButton.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
