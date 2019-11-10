/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Server;

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
                        server.enviarPaquete(packet);
                        break;
                        
                        
                    case "UserRequest":
                        UserRequestPackage userPackage = (UserRequestPackage) packet;
                        boolean authentication = server.authenticateUser(userPackage.user);
                        
                        if(authentication){
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
                        
                }
            } catch(IOException | ClassNotFoundException e) { 
                 System.out.println(e); 
            }
        }
    }
}
