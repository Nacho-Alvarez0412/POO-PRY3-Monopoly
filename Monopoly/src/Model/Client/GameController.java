/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Client;

import Model.Game.Property;
import Model.Packages.ChatPackage;
import Model.Packages.DicesPackage;
import Model.Packages.TurnPackage;
import Model.Packages.UserInfoRequestPackage;
import View.ClientView.GameView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nacho
 */
class GameController  implements ActionListener {
    
    //Atributos
    GameView view;
    Client client;
    int userIndex;
    
    public GameController(Client client){
        this.client = client;
        view = new GameView();
        initWindow();
        view.setVisible(true);
        updateProperties();
        userIndex = 0;
    }
    
    private void initWindow() {
        //User Buttons
        view.MediterraneanButton.addActionListener(this);
        view.BalticButton.addActionListener(this);
        view.ReadingTrainButton.addActionListener(this);
        view.OrientalButton.addActionListener(this);
        view.VermontButton.addActionListener(this);
        view.ConnecticutButton.addActionListener(this);
        view.CharlesButton.addActionListener(this);
        view.ElectricButton.addActionListener(this);
        view.StatesButton.addActionListener(this);
        view.VirginiaButton.addActionListener(this);
        view.PennsylvaniaTrainButton.addActionListener(this);
        view.JamesButton.addActionListener(this);
        view.TenesseeButton.addActionListener(this);
        view.NewYorkButton.addActionListener(this);
        view.KentuckyButton.addActionListener(this);
        view.IndianaButton.addActionListener(this);
        view.IllionisButton.addActionListener(this);
        view.BOTrainButton.addActionListener(this);
        view.AtlanticButton.addActionListener(this);
        view.VentnorButton.addActionListener(this);
        view.WaterButton.addActionListener(this);
        view.MarvinButton.addActionListener(this);
        view.PacificButton.addActionListener(this);
        view.NorthButton.addActionListener(this);
        view.PennsylvaniaButton.addActionListener(this);
        view.ShortTrainButton.addActionListener(this);
        view.ParkButton.addActionListener(this);
        view.BoardwalkButoon.addActionListener(this);
        
        //Player X Buttons
        view.MediterraneanXButton.addActionListener(this);
        view.BalticXButton.addActionListener(this);
        view.ReadingTrainXButton.addActionListener(this);
        view.OrientalXButton.addActionListener(this);
        view.VermontXButton.addActionListener(this);
        view.ConnecticutXButton.addActionListener(this);
        view.CharlesXButton.addActionListener(this);
        view.ElectricXButton.addActionListener(this);
        view.StatesXButton.addActionListener(this);
        view.VirginiaXButton.addActionListener(this);
        view.PennsylvaniaTrainXButton.addActionListener(this);
        view.JamesXButton.addActionListener(this);
        view.TenesseeXButton.addActionListener(this);
        view.NewYorkXButton.addActionListener(this);
        view.KentuckyXButton.addActionListener(this);
        view.IndianaXButton.addActionListener(this);
        view.IllionisXButton.addActionListener(this);
        view.BOTrainXButton.addActionListener(this);
        view.AtlanticXButton.addActionListener(this);
        view.VentnorXButton.addActionListener(this);
        view.WaterXButton.addActionListener(this);
        view.MarvinXButton.addActionListener(this);
        view.PacificXButton.addActionListener(this);
        view.NorthXButton.addActionListener(this);
        view.PennsylvaniaXButton.addActionListener(this);
        view.ShortTrainXButton.addActionListener(this);
        view.ParkXButton.addActionListener(this);
        view.BoardwalkXButoon.addActionListener(this);
        
        //Dice Buttons
        view.RollButton.addActionListener(this);
        view.EndTurnButton.addActionListener(this);
        
        //Menu Buttons
        view.NextPlayerButton.addActionListener(this);
        view.BuildButton.addActionListener(this);
        view.SellButton.addActionListener(this);
        view.MortgageButton.addActionListener(this);
        view.UnmortgageButton.addActionListener(this);
        view.TradeButton.addActionListener(this);
        view.BuyButton.addActionListener(this);
        
        //Chat TextField
        view.ChatTextField.addActionListener(this);
        
        //Set User Stats
        setUserStats();
        
    }
    
    private void setUserStats() {
        view.UserIconLabel.setIcon(client.user.character.getAppereance());
        view.UserName.setText(client.user.getName());
        view.UserMoneyLabel.setText(client.user.money+" $");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(view.ChatTextField)){
            String msj = view.ChatTextField.getText();
            view.ChatTextField.setText("");

            ChatPackage chat = new ChatPackage(msj);
            try {
                client.enviarPaquete(chat);
            } catch (IOException ex) {
                Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (e.getSource().equals(view.RollButton)){
            view.EndTurnButton.setEnabled(true);
            view.RollButton.setEnabled(false);
            
            client.user.rollDices();
            
            view.Dice1Label.setIcon(client.user.dices.get(0).getFace());
            view.Dice2Label.setIcon(client.user.dices.get(1).getFace());
            
            try {
                client.enviarPaquete(new DicesPackage(client.user.roll));
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (e.getSource().equals(view.EndTurnButton)){
            view.EndTurnButton.setEnabled(false);
            view.RollButton.setEnabled(false);
            
            try {
                client.enviarPaquete(new TurnPackage(""));
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (e.getSource().equals(view.NextPlayerButton)){
            try {
                getUserInfo();
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void getUserInfo() throws IOException{
        client.enviarPaquete(new UserInfoRequestPackage(userIndex));
    }

    private void updateProperties() {
        for(Property terrain : client.user.properties){
            
            switch(terrain.getName()){
            
                case "Mediterranean Avenue":
                    view.MediterraneanButton.setOpaque(true);
                    view.MediterraneanButton.setContentAreaFilled(true);
                    break;
                    
                case "Baltic Avenue":
                    view.BalticButton.setOpaque(true);
                    view.BalticButton.setContentAreaFilled(true);
                    break;
                
                case "Oriental Avenue":
                    view.OrientalButton.setOpaque(true);
                    view.OrientalButton.setContentAreaFilled(true);
                    break;
                    
                case "Vermont Avenue":
                    view.VermontButton.setOpaque(true);
                    view.VermontButton.setContentAreaFilled(true);
                    break;
                    
                case "Connecticut Avenue":
                    view.ConnecticutButton.setOpaque(true);
                    view.ConnecticutButton.setContentAreaFilled(true);
                    break;
                    
                case "St. Charles Place":
                    view.CharlesButton.setOpaque(true);
                    view.CharlesButton.setContentAreaFilled(true);
                    break;
                    
                case "States Avenue":
                    view.StatesButton.setOpaque(true);
                    view.StatesButton.setContentAreaFilled(true);
                    break;
                
                case "Virginia Avenue":
                    view.VirginiaButton.setOpaque(true);
                    view.VirginiaButton.setContentAreaFilled(true);
                    break;
                  
                case "St. James Place":
                    view.JamesButton.setOpaque(true);
                    view.JamesButton.setContentAreaFilled(true);
                    break;
                    
                case "Tenessee Avenue":
                    view.TenesseeButton.setOpaque(true);
                    view.TenesseeButton.setContentAreaFilled(true);
                    break;
                    
                case "New York Avenue":
                    view.NewYorkButton.setOpaque(true);
                    view.NewYorkButton.setContentAreaFilled(true);
                    break;
                    
                case "Kentucky Avenue":
                    view.KentuckyButton.setOpaque(true);
                    view.KentuckyButton.setContentAreaFilled(true);
                    break;
                    
                case "Indiana Avenue":
                    view.IndianaButton.setOpaque(true);
                    view.IndianaButton.setContentAreaFilled(true);
                    break;
                    
                case "Illinois Avenue":
                    view.IllionisButton.setOpaque(true);
                    view.IllionisButton.setContentAreaFilled(true);
                    break;
                    
                case "Atlantic Avenue":
                    view.AtlanticButton.setOpaque(true);
                    view.AtlanticButton.setContentAreaFilled(true);
                    break;
                    
                case "Ventor Avenue":
                    view.VentnorButton.setOpaque(true);
                    view.VentnorButton.setContentAreaFilled(true);
                    break;
                    
                case "Marvin Gardens":
                    view.MarvinButton.setOpaque(true);
                    view.MarvinButton.setContentAreaFilled(true);
                    break;
                    
                case "Pacific Avenue":
                    view.PacificButton.setOpaque(true);
                    view.PacificButton.setContentAreaFilled(true);
                    break;
                    
                case "North Carolina Avenue":
                    view.NorthButton.setOpaque(true);
                    view.NorthButton.setContentAreaFilled(true);
                    break;
                    
                case "Pennsylvania Avenue":
                    view.PennsylvaniaButton.setOpaque(true);
                    view.PennsylvaniaButton.setContentAreaFilled(true);
                    break;
                    
                case "Park Place":
                    view.ParkButton.setOpaque(true);
                    view.ParkButton.setContentAreaFilled(true);
                    break;
                    
                case "Boardwalk":
                    view.BoardwalkButoon.setOpaque(true);
                    view.BoardwalkButoon.setContentAreaFilled(true);
                    break;
                    
                case "Reading Railroad":
                    view.ReadingTrainButton.setOpaque(true);
                    view.ReadingTrainButton.setContentAreaFilled(true);
                    break;
                    
                case "Pennsylvania Railroad":
                    view.PennsylvaniaTrainButton.setOpaque(true);
                    view.PennsylvaniaTrainButton.setContentAreaFilled(true);
                    break;
                    
                case "B. & O. Railroad":
                    view.BOTrainButton.setOpaque(true);
                    view.BOTrainButton.setContentAreaFilled(true);
                    break;
                    
                case "Short Line":
                    view.BOTrainButton.setOpaque(true);
                    view.BOTrainButton.setContentAreaFilled(true);
                    break;
                    
                case "Electric Company":
                    view.ElectricButton.setOpaque(true);
                    view.ElectricButton.setContentAreaFilled(true);
                    break;
                    
                case "Water Works":
                    view.WaterButton.setOpaque(true);
                    view.WaterButton.setContentAreaFilled(true);
                    break;
            }
        }
    }

    void printXProperties(ArrayList<Property> properties) {
        for(Property terrain : properties){
            
            switch(terrain.getName()){
            
                case "Mediterranean Avenue":
                    view.MediterraneanXButton.setOpaque(true);
                    view.MediterraneanXButton.setContentAreaFilled(true);
                    break;
                    
                case "Baltic Avenue":
                    view.BalticXButton.setOpaque(true);
                    view.BalticXButton.setContentAreaFilled(true);
                    break;
                
                case "Oriental Avenue":
                    view.OrientalXButton.setOpaque(true);
                    view.OrientalXButton.setContentAreaFilled(true);
                    break;
                    
                case "Vermont Avenue":
                    view.VermontXButton.setOpaque(true);
                    view.VermontXButton.setContentAreaFilled(true);
                    break;
                    
                case "Connecticut Avenue":
                    view.ConnecticutXButton.setOpaque(true);
                    view.ConnecticutXButton.setContentAreaFilled(true);
                    break;
                    
                case "St. Charles Place":
                    view.CharlesXButton.setOpaque(true);
                    view.CharlesXButton.setContentAreaFilled(true);
                    break;
                    
                case "States Avenue":
                    view.StatesXButton.setOpaque(true);
                    view.StatesXButton.setContentAreaFilled(true);
                    break;
                
                case "Virginia Avenue":
                    view.VirginiaXButton.setOpaque(true);
                    view.VirginiaXButton.setContentAreaFilled(true);
                    break;
                  
                case "St. James Place":
                    view.JamesXButton.setOpaque(true);
                    view.JamesXButton.setContentAreaFilled(true);
                    break;
                    
                case "Tenessee Avenue":
                    view.TenesseeXButton.setOpaque(true);
                    view.TenesseeXButton.setContentAreaFilled(true);
                    break;
                    
                case "New York Avenue":
                    view.NewYorkXButton.setOpaque(true);
                    view.NewYorkXButton.setContentAreaFilled(true);
                    break;
                    
                case "Kentucky Avenue":
                    view.KentuckyXButton.setOpaque(true);
                    view.KentuckyXButton.setContentAreaFilled(true);
                    break;
                    
                case "Indiana Avenue":
                    view.IndianaXButton.setOpaque(true);
                    view.IndianaXButton.setContentAreaFilled(true);
                    break;
                    
                case "Illinois Avenue":
                    view.IllionisXButton.setOpaque(true);
                    view.IllionisXButton.setContentAreaFilled(true);
                    break;
                    
                case "Atlantic Avenue":
                    view.AtlanticXButton.setOpaque(true);
                    view.AtlanticXButton.setContentAreaFilled(true);
                    break;
                    
                case "Ventor Avenue":
                    view.VentnorXButton.setOpaque(true);
                    view.VentnorXButton.setContentAreaFilled(true);
                    break;
                    
                case "Marvin Gardens":
                    view.MarvinXButton.setOpaque(true);
                    view.MarvinXButton.setContentAreaFilled(true);
                    break;
                    
                case "Pacific Avenue":
                    view.PacificXButton.setOpaque(true);
                    view.PacificXButton.setContentAreaFilled(true);
                    break;
                    
                case "North Carolina Avenue":
                    view.NorthXButton.setOpaque(true);
                    view.NorthXButton.setContentAreaFilled(true);
                    break;
                    
                case "Pennsylvania Avenue":
                    view.PennsylvaniaXButton.setOpaque(true);
                    view.PennsylvaniaXButton.setContentAreaFilled(true);
                    break;
                    
                case "Park Place":
                    view.ParkXButton.setOpaque(true);
                    view.ParkXButton.setContentAreaFilled(true);
                    break;
                    
                case "Boardwalk":
                    view.BoardwalkXButoon.setOpaque(true);
                    view.BoardwalkXButoon.setContentAreaFilled(true);
                    break;
                    
                case "Reading Railroad":
                    view.ReadingTrainXButton.setOpaque(true);
                    view.ReadingTrainXButton.setContentAreaFilled(true);
                    break;
                    
                case "Pennsylvania Railroad":
                    view.PennsylvaniaTrainXButton.setOpaque(true);
                    view.PennsylvaniaTrainXButton.setContentAreaFilled(true);
                    break;
                    
                case "B. & O. Railroad":
                    view.BOTrainXButton.setOpaque(true);
                    view.BOTrainXButton.setContentAreaFilled(true);
                    break;
                    
                case "Short Line":
                    view.BOTrainXButton.setOpaque(true);
                    view.BOTrainXButton.setContentAreaFilled(true);
                    break;
                    
                case "Electric Company":
                    view.ElectricXButton.setOpaque(true);
                    view.ElectricXButton.setContentAreaFilled(true);
                    break;
                    
                case "Water Works":
                    view.WaterXButton.setOpaque(true);
                    view.WaterXButton.setContentAreaFilled(true);
                    break;
            }
        }
    }
}
