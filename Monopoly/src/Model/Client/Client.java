/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Client;

import Model.Game.*;
import Model.Packages.DicesPackage;
import Model.Packages.UserRequestPackage;
import View.ClientView.ClientStartWindow;
import View.ClientView.RollDiceWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author nacho
 */
public class Client implements ActionListener {
    //Atributos
    public User user;
    public Socket socket;
    public GameController gameController;
    
    
    //Ventana ClientStart
    public ClientStartWindow startView;
    
    //Ventan tirar dados
    public RollDiceWindow diceView;
    
    //Metodos
    public Client() throws IOException{
      initWindows();
      connect("127.0.0.1", 5000);
      user = new User("",null);
    }
    
    public void connect(String address,int port) throws IOException{
        socket = new Socket(address,port);
        ServerListener listener = new ServerListener();
        listener.init(this,diceView);
        listener.start();
    }
    
    public void enviarPaquete(Model.Packages.Package packet) throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        out.writeObject(packet);
    }
    
    public void initWindows(){
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
        startView.ConfirmButton.addActionListener(this);
        
        diceView = new RollDiceWindow();
        
        diceView.DicesButton.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(startView.ConfirmButton)){
            if(user.getCharacter() == null)
                startView.ServerResponseLabel.setText("Select a piece in order to continue");
            else{
                startView.ConfirmButton.setEnabled(false);
                user.setName(startView.UsernameTextField.getText());
                UserRequestPackage packet = new UserRequestPackage(user);
                
                try {
                    enviarPaquete(packet);
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }   
            } 
        }
        
        else if (e.getSource().equals(startView.BattleshipButton)){
            ImageIcon appereance = new ImageIcon(getClass().getResource("/Images/battleship.png"));
            ImageIcon inGameappereance = new ImageIcon(getClass().getResource("/Images/InGameBattleship.png"));
            GameCharacter character = new GameCharacter(EnumCharacter.Battleship,appereance,inGameappereance );
            user.setCharacter(character);
        }
        
        else if (e.getSource().equals(startView.CarButton)){
            ImageIcon appereance = new ImageIcon(getClass().getResource("/Images/car.png"));
            ImageIcon inGameappereance = new ImageIcon(getClass().getResource("/Images/InGameCar.png"));
            GameCharacter character = new GameCharacter(EnumCharacter.Car,appereance,inGameappereance );
            user.setCharacter(character);
        }
        
        else if (e.getSource().equals(startView.CartButton)){
            ImageIcon appereance = new ImageIcon(getClass().getResource("/Images/cart.png"));
            ImageIcon inGameappereance = new ImageIcon(getClass().getResource("/Images/InGameCart.png"));
            GameCharacter character = new GameCharacter(EnumCharacter.Cart,appereance,inGameappereance );
            user.setCharacter(character);
        }
        
        else if (e.getSource().equals(startView.CatButton)){
            ImageIcon appereance = new ImageIcon(getClass().getResource("/Images/cat.png"));
            ImageIcon inGameappereance = new ImageIcon(getClass().getResource("/Images/InGameCat.png"));
            GameCharacter character = new GameCharacter(EnumCharacter.Cat,appereance,inGameappereance );
            user.setCharacter(character);
        }
        
        else if (e.getSource().equals(startView.DinosaurButton)){
            ImageIcon appereance = new ImageIcon(getClass().getResource("/Images/dinosaur.png"));
            ImageIcon inGameappereance = new ImageIcon(getClass().getResource("/Images/InGameDinosaur.png"));
            GameCharacter character = new GameCharacter(EnumCharacter.Dinosaur,appereance,inGameappereance );
            user.setCharacter(character);
        }
        
        else if (e.getSource().equals(startView.DogButton)){
            ImageIcon appereance = new ImageIcon(getClass().getResource("/Images/dog.png"));
            ImageIcon inGameappereance = new ImageIcon(getClass().getResource("/Images/InGameDog.png"));
            GameCharacter character = new GameCharacter(EnumCharacter.Dog,appereance,inGameappereance );
            user.setCharacter(character);
        }
        
        else if (e.getSource().equals(startView.DuckButton)){
            ImageIcon appereance = new ImageIcon(getClass().getResource("/Images/duck.png"));
            ImageIcon inGameappereance = new ImageIcon(getClass().getResource("/Images/InGameDuck.png"));
            GameCharacter character = new GameCharacter(EnumCharacter.Duck,appereance,inGameappereance );
            user.setCharacter(character);
        }
        
        else if (e.getSource().equals(startView.HatButton)){
            ImageIcon appereance = new ImageIcon(getClass().getResource("/Images/hat.png"));
            ImageIcon inGameappereance = new ImageIcon(getClass().getResource("/Images/InGameHat.png"));
            GameCharacter character = new GameCharacter(EnumCharacter.Hat,appereance,inGameappereance );
            user.setCharacter(character);
        }
        
        else if (e.getSource().equals(startView.IronButton)){
            ImageIcon appereance = new ImageIcon(getClass().getResource("/Images/iron.png"));
            ImageIcon inGameappereance = new ImageIcon(getClass().getResource("/Images/InGameIron.png"));
            GameCharacter character = new GameCharacter(EnumCharacter.Iron,appereance,inGameappereance );
            user.setCharacter(character);
        }
        
        else if (e.getSource().equals(startView.PenguinButton)){
            ImageIcon appereance = new ImageIcon(getClass().getResource("/Images/penguin.png"));
            ImageIcon inGameappereance = new ImageIcon(getClass().getResource("/Images/InGamePenguin.png"));
            GameCharacter character = new GameCharacter(EnumCharacter.Penguin,appereance,inGameappereance );
            user.setCharacter(character);
        }
        
        else if (e.getSource().equals(startView.ShoeButton)){
            ImageIcon appereance = new ImageIcon(getClass().getResource("/Images/shoe.png"));
            ImageIcon inGameappereance = new ImageIcon(getClass().getResource("/Images/InGameShoe.png"));
            GameCharacter character = new GameCharacter(EnumCharacter.Shoe,appereance,inGameappereance );
            user.setCharacter(character);
        }
        
        else if (e.getSource().equals(startView.ThimbleButton)){
            ImageIcon appereance = new ImageIcon(getClass().getResource("/Images/thimble.png"));
            ImageIcon inGameappereance = new ImageIcon(getClass().getResource("/Images/InGameThimble.png"));
            GameCharacter character = new GameCharacter(EnumCharacter.Thimble,appereance,inGameappereance );
            user.setCharacter(character);
        }
        
        else if (e.getSource().equals(diceView.DicesButton)){
            diceView.DicesButton.setEnabled(false);
            user.rollDices();
            diceView.Dice1Label.setIcon(user.dices.get(0).getFace());
            diceView.Dice2Label.setIcon(user.dices.get(1).getFace());

            int value = (user.dices.get(0).getValue()+user.dices.get(1).getValue());
            DicesPackage packet = new DicesPackage(value);
                
            try {
                enviarPaquete(packet);
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            startView.ServerResponseLabel.setText("Waiting for rest of the players");
        }
    }
}
