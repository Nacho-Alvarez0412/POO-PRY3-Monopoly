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
    
    public ClientListener(Socket socket,Server server){
        this.socket = socket;
        this.server = server;
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
                        
                }
            } catch(IOException | ClassNotFoundException e) { 
                 System.out.println(e); 
            }
        }
    }
}
