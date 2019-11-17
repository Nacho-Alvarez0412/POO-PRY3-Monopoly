/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Client;

import Model.Game.Property;
import Model.Game.User;
import Model.Packages.*;
import View.ClientView.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author nacho
 */
class GameController  implements ActionListener {
    
    //Atributos
    GameView view;
    Client client;
    int userIndex;
    ArrayList<Property> properties;
    ArrayList<User> players;
    
    //Ventanas Secundarias
    SellView sellView;
    SellRequestView sellRequestView;
    SellRequestPackage request;
    BuildingView buildingView;
    TradeRequestView tradeRequestView;
    TradeView tradeView;
    TradeRequestPackage tradeRequest;
    MortgageView mortgageView;
    
    public GameController(Client client, ArrayList<Property> properties,ArrayList<User> players){
        this.client = client;
        view = new GameView();
        view.setVisible(true);
        sellRequestView = new SellRequestView();
        buildingView = new BuildingView(new String[]{});
        userIndex = 0;
        this.properties = properties;
        this.players = players;
        updateProperties();
        this.request=null;
        this.tradeView = new TradeView(new String[]{}, new String[]{}, new String[]{});
        this.tradeRequestView = new TradeRequestView();
        this.mortgageView = new MortgageView();
        initWindow();
    }
    
    public User findUser(int id){
        for(User player : players){
            if(player.id == id)
                return player;
        }
        return null;
    }
    private void initSellWindow(){
        //Buttons Sell Windows
        sellView.SellEdificarionsButton.addActionListener(this);
        sellView.SellToBankButton.addActionListener(this);
        sellView.SellToPlayer.addActionListener(this);
    }
    
    private void initWindow() {
        //User Labels
        setIcons();
   
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
        view.TradeButton.addActionListener(this);
        view.BuyButton.addActionListener(this);
        view.WildcardButton.addActionListener(this);
        
        //Build Request buttons
        buildingView.BuildButton.addActionListener(this);
        
        //Sell Request buttons
        sellRequestView.AcceptButton.addActionListener(this);
        sellRequestView.DeclineButton.addActionListener(this);
        
        //TradeRequest buttons
        tradeView.jButton1.addActionListener(this);
        tradeRequestView.AcceptButton.addActionListener(this);
        tradeRequestView.DeclineButton.addActionListener(this);
        
        //MortgageWindow buttons
        mortgageView.MortgageButton.addActionListener(this);
        mortgageView.Unmortgage.addActionListener(this);
        
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
    
    private void getUserInfo() throws IOException{
        client.enviarPaquete(new UserInfoRequestPackage(userIndex));
    }
    
    
    private void setIcons() {
        for(User player : players){
            if(view.Player1IconLabel.getIcon() == null){
                view.Player1IconLabel.setIcon(player.character.getInGameCharacter());
                player.inGameAppereance = view.Player1IconLabel;
            }
            
            else if(view.Player2IconLabel.getIcon() == null){
                view.Player2IconLabel.setIcon(player.character.getInGameCharacter());
                player.inGameAppereance = view.Player2IconLabel;
            }
            
            else if(view.Player3IconLabel.getIcon() == null){
                view.Player3IconLabel.setIcon(player.character.getInGameCharacter());
                player.inGameAppereance = view.Player3IconLabel;
            }
            
            else if(view.Player4IconLabel.getIcon() == null){
                view.Player4IconLabel.setIcon(player.character.getInGameCharacter());
                player.inGameAppereance = view.Player4IconLabel;
            }
            
            else if(view.Player5IconLabel.getIcon() == null){
                view.Player5IconLabel.setIcon(player.character.getInGameCharacter());
                player.inGameAppereance = view.Player5IconLabel;
            }
            
            else if(view.Player6IconLabel.getIcon() == null){
                view.Player6IconLabel.setIcon(player.character.getInGameCharacter());
                player.inGameAppereance = view.Player6IconLabel;
            }
        }
    }

    private void updateProperties() {
        if(client.user.properties.isEmpty()){
            clearButtons();
        }
        for(Property terrain : client.user.properties){
            if(terrain.getName().equals( "Mediterranean Avenue")){
                view.MediterraneanButton.setOpaque(true);
                view.MediterraneanButton.setContentAreaFilled(true);
            }
                    
            if(terrain.getName().equals( "Baltic Avenue")){
                view.BalticButton.setOpaque(true);
                view.BalticButton.setContentAreaFilled(true);
            }
            
            if(terrain.getName().equals("Oriental Avenue")){
                    view.OrientalButton.setOpaque(true);
                    view.OrientalButton.setContentAreaFilled(true);
            }
            
           
            if(terrain.getName().equals("Vermont Avenue")){
                    view.VermontButton.setOpaque(true);
                    view.VermontButton.setContentAreaFilled(true);
            }
           
            
            if(terrain.getName().equals("Connecticut Avenue")){
                    view.ConnecticutButton.setOpaque(true);
                    view.ConnecticutButton.setContentAreaFilled(true);
            } 
           
            if(terrain.getName().equals("St. Charles Place")){
                view.CharlesButton.setOpaque(true);
                view.CharlesButton.setContentAreaFilled(true);
            }

           
            if(terrain.getName().equals("States Avenue")){
                view.StatesButton.setOpaque(true);
                view.StatesButton.setContentAreaFilled(true);
            } 
            
            
            if(terrain.getName().equals("Virginia Avenue")){
                    view.VirginiaButton.setOpaque(true);
                    view.VirginiaButton.setContentAreaFilled(true);
            }
            
            if(terrain.getName().equals("St. James Place")){
                    view.JamesButton.setOpaque(true);
                    view.JamesButton.setContentAreaFilled(true);
            }
            
                if(terrain.getName().equals("Tenessee Avenue")){
                    view.TenesseeButton.setOpaque(true);
                    view.TenesseeButton.setContentAreaFilled(true);
                }     
                
                if(terrain.getName().equals("New York Avenue")){
                    view.NewYorkButton.setOpaque(true);
                    view.NewYorkButton.setContentAreaFilled(true);
                } 
                
                if(terrain.getName().equals("Kentucky Avenue")){
                    view.KentuckyButton.setOpaque(true);
                    view.KentuckyButton.setContentAreaFilled(true);
                }
                
                if(terrain.getName().equals("Indiana Avenue")){
                    view.IndianaButton.setOpaque(true);
                    view.IndianaButton.setContentAreaFilled(true);
                }      
                
                if(terrain.getName().equals("Illinois Avenue")){
                    view.IllionisButton.setOpaque(true);
                    view.IllionisButton.setContentAreaFilled(true);
                }
               
                if(terrain.getName().equals("Atlantic Avenue")){
                    view.AtlanticButton.setOpaque(true);
                    view.AtlanticButton.setContentAreaFilled(true);
                }
                
                if(terrain.getName().equals("Ventor Avenue")){
                    view.VentnorButton.setOpaque(true);
                    view.VentnorButton.setContentAreaFilled(true);
                }  
                
                if(terrain.getName().equals("Marvin Gardens")){
                    view.MarvinButton.setOpaque(true);
                    view.MarvinButton.setContentAreaFilled(true);
                }      
                
                
                if(terrain.getName().equals("Pacific Avenue")){
                    view.PacificButton.setOpaque(true);
                    view.PacificButton.setContentAreaFilled(true);
                }
                
                if(terrain.getName().equals("North Carolina Avenue")){
                    view.NorthButton.setOpaque(true);
                    view.NorthButton.setContentAreaFilled(true);
                }      
                
                if(terrain.getName().equals("Pennsylvania Avenue")){
                    view.PennsylvaniaButton.setOpaque(true);
                    view.PennsylvaniaButton.setContentAreaFilled(true);
                }  
                
                if(terrain.getName().equals("Park Place")){
                    view.ParkButton.setOpaque(true);
                    view.ParkButton.setContentAreaFilled(true);
                }
                
                if(terrain.getName().equals("Boardwalk")){
                    view.BoardwalkButoon.setOpaque(true);
                    view.BoardwalkButoon.setContentAreaFilled(true);
                }
                
                if(terrain.getName().equals("Reading Railroad")){
                    view.ReadingTrainButton.setOpaque(true);
                    view.ReadingTrainButton.setContentAreaFilled(true);
                }     
               
                if(terrain.getName().equals("Pennsylvania Railroad")){
                    view.PennsylvaniaTrainButton.setOpaque(true);
                    view.PennsylvaniaTrainButton.setContentAreaFilled(true);
                }     
                
                if(terrain.getName().equals("B. & O. Railroad")){
                    view.BOTrainButton.setOpaque(true);
                    view.BOTrainButton.setContentAreaFilled(true);
                }
                
                if(terrain.getName().equals("Short Line")){
                    view.BOTrainButton.setOpaque(true);
                    view.BOTrainButton.setContentAreaFilled(true);
                }    
                
                if(terrain.getName().equals("Electric Company")){
                    view.ElectricButton.setOpaque(true);
                    view.ElectricButton.setContentAreaFilled(true);
                }     
                
               if(terrain.getName().equals("Water Works")){
                    view.WaterButton.setOpaque(true);
                    view.WaterButton.setContentAreaFilled(true);
               }
        }
    }

    void printXProperties(ArrayList<Property> properties) {
        clearXButtons();
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
    
    public Property searchProperty(String name){
        for(Property property : properties){
            if(name.equals(property.getName()))
                return property;
        }
        return null;
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
        
        else if (e.getSource().equals(view.RollButton)){
            view.EndTurnButton.setEnabled(true);
            
            
            client.user.rollDices();
            
            view.Dice1Label.setIcon(client.user.dices.get(0).getFace());
            view.Dice2Label.setIcon(client.user.dices.get(1).getFace());
            view.RollButton.setEnabled(false);
            DicesPackage packet = new DicesPackage(client.user.roll);
            packet.doubles = false;
            
            if(client.user.dices.get(0).getValue() == client.user.dices.get(1).getValue()){
                view.RollButton.setEnabled(true);
                packet.doubles = true;
            }
            
            
            try {
                client.enviarPaquete(packet);
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if (e.getSource().equals(view.WildcardButton)){
            if(client.user.jail || client.user.wildcard){
                try {
                    client.enviarPaquete(new WildCardUsePackage());
                } catch (IOException ex) {
                    Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
                JOptionPane.showMessageDialog(client.gameController.view, "You dont have jail free cards to sell!");
        }
        
        else if (e.getSource().equals(view.MortgageButton)){
            mortgageView.setPropertiesComboBox(getPropertyName());
            mortgageView.setVisible(true);
        }
        
        else if (e.getSource().equals(mortgageView.MortgageButton)){
            MortgagePackage packet = new MortgagePackage((String) mortgageView.PropertiesComboBox.getSelectedItem(),true);
            try {
                client.enviarPaquete(packet);
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if (e.getSource().equals(mortgageView.Unmortgage)){
            MortgagePackage packet = new MortgagePackage((String) mortgageView.PropertiesComboBox.getSelectedItem(),false);
            try {
                client.enviarPaquete(packet);
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if (e.getSource().equals(view.MortgageButton)){
            mortgageView.setPropertiesComboBox(getPropertyName());
            mortgageView.setVisible(true);
  
        }
        
        else if (e.getSource().equals(view.EndTurnButton)){
            view.EndTurnButton.setEnabled(false);
            view.RollButton.setEnabled(false);
            
            try {
                client.enviarPaquete(new TurnPackage(""));
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if (e.getSource().equals(view.NextPlayerButton)){
            try {
                getUserInfo();
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(e.getSource().equals(view.BuyButton)){
            try {
                client.enviarPaquete(new BuyRequestPackage(client.user.index));
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(e.getSource().equals(view.SellButton)){
            String[] propertiesName = getPropertyName();
            String[] playersNames = getPlayerName();
            sellView = new SellView(propertiesName,playersNames);
            initSellWindow();
            sellView.setVisible(true);
            
        }
        
        else if (e.getSource().equals(view.BuildButton)){
            String[] properties = getPropertyName();
            buildingView.PropertiesComboBox.setModel(new DefaultComboBoxModel<>(properties));
            buildingView.setVisible(true);
        }
        
        else if (e.getSource().equals(buildingView.BuildButton)){
            BuildRequestPackage packet = new BuildRequestPackage((String) buildingView.PropertiesComboBox.getSelectedItem());
            
            try {
                client.enviarPaquete(packet);
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if (e.getSource().equals(view.MediterraneanButton) || e.getSource().equals(view.MediterraneanXButton)){
            new PropertyView(searchProperty("Mediterranean Avenue")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.BalticButton) || e.getSource().equals(view.BalticXButton)){
            new PropertyView(searchProperty("Baltic Avenue")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.ReadingTrainButton) || e.getSource().equals(view.ReadingTrainXButton)){
            new RailroadView(searchProperty("Reading Railroad")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.OrientalButton) || e.getSource().equals(view.OrientalXButton)){
            new PropertyView(searchProperty("Oriental Avenue")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.VermontButton) || e.getSource().equals(view.VermontXButton)){
            new PropertyView(searchProperty("Vermont Avenue")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.ConnecticutButton) || e.getSource().equals(view.ConnecticutXButton)){
            new PropertyView(searchProperty("Connecticut Avenue")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.CharlesButton) || e.getSource().equals(view.CharlesXButton)){
            new PropertyView(searchProperty("St. Charles Place")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.StatesButton) || e.getSource().equals(view.StatesXButton)){
            new PropertyView(searchProperty("States Avenue")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.VirginiaButton) || e.getSource().equals(view.VirginiaXButton)){
            new PropertyView(searchProperty("Virginia Avenue")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.JamesButton) || e.getSource().equals(view.JamesXButton)){
            new PropertyView(searchProperty("St. James Place")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.TenesseeButton) || e.getSource().equals(view.TenesseeXButton)){
            new PropertyView(searchProperty("Tenessee Avenue")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.NewYorkButton) || e.getSource().equals(view.NewYorkXButton)){
            new PropertyView(searchProperty("New York Avenue")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.KentuckyButton) || e.getSource().equals(view.KentuckyXButton)){
            new PropertyView(searchProperty("Kentucky Avenue")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.IndianaButton) || e.getSource().equals(view.IndianaXButton)){
            new PropertyView(searchProperty("Indiana Avenue")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.IllionisButton) || e.getSource().equals(view.IllionisXButton)){
            new PropertyView(searchProperty("Illinois Avenue")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.AtlanticButton) || e.getSource().equals(view.AtlanticXButton)){
            new PropertyView(searchProperty("Atlantic Avenue")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.VentnorButton) || e.getSource().equals(view.VentnorXButton)){
            new PropertyView(searchProperty("Ventor Avenue")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.MarvinButton) || e.getSource().equals(view.MarvinXButton)){
            new PropertyView(searchProperty("Marvin Gardens")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.PacificButton) || e.getSource().equals(view.PacificXButton)){
            new PropertyView(searchProperty("Pacific Avenue")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.NorthButton) || e.getSource().equals(view.NorthXButton)){
            new PropertyView(searchProperty("North Carolina Avenue")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.PennsylvaniaButton) || e.getSource().equals(view.PennsylvaniaXButton)){
            new PropertyView(searchProperty("Pennsylvania Avenue")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.ParkButton) || e.getSource().equals(view.ParkXButton)){
            new PropertyView(searchProperty("Park Place")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.BoardwalkButoon) || e.getSource().equals(view.BoardwalkXButoon)){
            new PropertyView(searchProperty("Boardwalk")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.PennsylvaniaTrainButton) || e.getSource().equals(view.PennsylvaniaTrainXButton)){
            new RailroadView(searchProperty("Pennsylvania Railroad")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.BOTrainButton) || e.getSource().equals(view.BOTrainXButton)){
            new RailroadView(searchProperty("B. & O. Railroad")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.ShortTrainButton) || e.getSource().equals(view.ShortTrainXButton)){
            new RailroadView(searchProperty("Short Line")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.ElectricButton) || e.getSource().equals(view.ElectricXButton)){
            new ServiceView(searchProperty("Electric Company")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.WaterButton) || e.getSource().equals(view.WaterXButton)){
            new ServiceView(searchProperty("Water Works")).setVisible(true);
        }
        
        else if (e.getSource().equals(view.TradeButton)){
            tradeView.setPlayerPropertyComboBox(getPropertyName());
            tradeView.setPropertiesComboBox(getPropertiesNames());
            tradeView.setPlayersComboBox(getPlayerName());
            tradeView.setVisible(true);
        }
        
         else if (e.getSource().equals(tradeView.jButton1)){
            TradeRequestPackage request = new TradeRequestPackage(client.user.name, (String) tradeView.PlayersComboBox.getSelectedItem(), (String) tradeView.PlayerPropertyComboBox.getSelectedItem(), (String) tradeView.PropertiesComboBox.getSelectedItem());
            tradeView.setVisible(false);
            try {
                client.enviarPaquete(request);
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         
         else if (e.getSource().equals(tradeRequestView.AcceptButton)){
            tradeRequest.accepted = true;
            tradeRequest.waiting = false;
            
            try {
                client.enviarPaquete(tradeRequest);
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         
          else if (e.getSource().equals(tradeRequestView.DeclineButton)){
            tradeRequest.accepted = false;
            tradeRequest.waiting = false;
            
            try {
                client.enviarPaquete(tradeRequest);
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
         }
         
        
        
        else if(e.getSource().equals(sellRequestView.AcceptButton)){
            request.accepted = true;
            request.waiting = false;
            sellRequestView.setVisible(false);
            try {
                client.enviarPaquete(request);
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(e.getSource().equals(sellRequestView.DeclineButton)){
            request.accepted = false;
            request.waiting = false;
            sellRequestView.setVisible(false);
            try {
                client.enviarPaquete(request);
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(e.getSource().equals(sellView.SellEdificarionsButton)){
            String seller = client.user.name;
            String property = (String) sellView.PropertiesComboBox.getSelectedItem();
            SellRequestPackage request = new SellRequestPackage(property,seller,"",true,0);
            try {
                client.enviarPaquete(request);
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(e.getSource().equals(sellView.SellToBankButton)){
            String seller = client.user.name;
            String property = (String) sellView.PropertiesComboBox.getSelectedItem();
            SellRequestPackage request = new SellRequestPackage(property,seller,"",false,0);
            try {
                client.enviarPaquete(request);
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else if(e.getSource().equals(sellView.SellToPlayer)){
            String seller = client.user.name;
            String property = (String) sellView.PropertiesComboBox.getSelectedItem();
            String buyer = (String) sellView.PlayerComboBox.getSelectedItem();
            SellRequestPackage request = new SellRequestPackage(property,seller,buyer,false,(int) sellView.SellPriceSpinner.getValue());
            try {
                client.enviarPaquete(request);
            } catch (IOException ex) {
                Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     
        
    }

    void paintPlayer(User player,int x, int y) {
        player.inGameAppereance.setLocation(x,y);
    }

    void updateUserInfo() {
        view.UserMoneyLabel.setText(String.valueOf(client.user.money));
        clearButtons();
        updateProperties();
    }
    
    private String[] getPropertiesNames() {
        ArrayList<String> propertiesNames = new ArrayList<>();
        for(Property property : client.gameController.properties){
            propertiesNames.add(property.getName());
        }
        return propertiesNames.toArray(new String[0]);
    }

    private String[] getPropertyName() {
        ArrayList<String> propertiesNames = new ArrayList<>();
        for(Property property : client.user.properties){
            propertiesNames.add(property.getName());
        }
        return propertiesNames.toArray(new String[0]);
    }
    
    private String[] getPlayerName() {
        ArrayList<String> propertiesNames = new ArrayList<>();
        for(User user : players){
            if(!user.getName().equals(client.user.name))
                propertiesNames.add(user.getName());
        }
        return propertiesNames.toArray(new String[0]);
    }

    private void clearXButtons() {
        view.MediterraneanXButton.setOpaque(false);
        view.MediterraneanXButton.setContentAreaFilled(false);
        view.BalticXButton.setOpaque(false);
        view.BalticXButton.setContentAreaFilled(false);            
        view.OrientalXButton.setOpaque(false);
        view.OrientalXButton.setContentAreaFilled(false);

        view.VermontXButton.setOpaque(false);
        view.VermontXButton.setContentAreaFilled(false);

        view.ConnecticutXButton.setOpaque(false);
        view.ConnecticutXButton.setContentAreaFilled(false);

        view.CharlesXButton.setOpaque(false);
        view.CharlesXButton.setContentAreaFilled(false);

        view.StatesXButton.setOpaque(false);
        view.StatesXButton.setContentAreaFilled(false);

        view.VirginiaXButton.setOpaque(false);
        view.VirginiaXButton.setContentAreaFilled(false);

        view.JamesXButton.setOpaque(false);
        view.JamesXButton.setContentAreaFilled(false);

        view.TenesseeXButton.setOpaque(false);
        view.TenesseeXButton.setContentAreaFilled(false);

        view.NewYorkXButton.setOpaque(false);
        view.NewYorkXButton.setContentAreaFilled(false);

        view.KentuckyXButton.setOpaque(false);
        view.KentuckyXButton.setContentAreaFilled(false);

        view.IndianaXButton.setOpaque(false);
        view.IndianaXButton.setContentAreaFilled(false);

        view.IllionisXButton.setOpaque(false);
        view.IllionisXButton.setContentAreaFilled(false);

        view.AtlanticXButton.setOpaque(false);
        view.AtlanticXButton.setContentAreaFilled(false);

        view.VentnorXButton.setOpaque(false);
        view.VentnorXButton.setContentAreaFilled(false);

        view.MarvinXButton.setOpaque(false);
        view.MarvinXButton.setContentAreaFilled(false);

        view.PacificXButton.setOpaque(false);
        view.PacificXButton.setContentAreaFilled(false);

        view.NorthXButton.setOpaque(false);
        view.NorthXButton.setContentAreaFilled(false);

        view.PennsylvaniaXButton.setOpaque(false);
        view.PennsylvaniaXButton.setContentAreaFilled(false);

        view.ParkXButton.setOpaque(false);
        view.ParkXButton.setContentAreaFilled(false);

        view.BoardwalkXButoon.setOpaque(false);
        view.BoardwalkXButoon.setContentAreaFilled(false);

        view.ReadingTrainXButton.setOpaque(false);
        view.ReadingTrainXButton.setContentAreaFilled(false);

        view.PennsylvaniaTrainXButton.setOpaque(false);
        view.PennsylvaniaTrainXButton.setContentAreaFilled(false);

        view.BOTrainXButton.setOpaque(false);
        view.BOTrainXButton.setContentAreaFilled(false);

        view.ShortTrainXButton.setOpaque(false);
        view.ShortTrainXButton.setContentAreaFilled(false);

        view.ElectricXButton.setOpaque(false);
        view.ElectricXButton.setContentAreaFilled(false);
        view.WaterXButton.setOpaque(false);
        view.WaterXButton.setContentAreaFilled(false);
    }

    private void clearButtons() {
        view.MediterraneanButton.setOpaque(false);
        view.MediterraneanButton.setContentAreaFilled(false);
        view.BalticButton.setOpaque(false);
        view.BalticButton.setContentAreaFilled(false);            
        view.OrientalButton.setOpaque(false);
        view.OrientalButton.setContentAreaFilled(false);

        view.VermontButton.setOpaque(false);
        view.VermontButton.setContentAreaFilled(false);

        view.ConnecticutButton.setOpaque(false);
        view.ConnecticutButton.setContentAreaFilled(false);

        view.CharlesButton.setOpaque(false);
        view.CharlesButton.setContentAreaFilled(false);

        view.StatesButton.setOpaque(false);
        view.StatesButton.setContentAreaFilled(false);

        view.VirginiaButton.setOpaque(false);
        view.VirginiaButton.setContentAreaFilled(false);

        view.JamesButton.setOpaque(false);
        view.JamesButton.setContentAreaFilled(false);

        view.TenesseeButton.setOpaque(false);
        view.TenesseeButton.setContentAreaFilled(false);

        view.NewYorkButton.setOpaque(false);
        view.NewYorkButton.setContentAreaFilled(false);

        view.KentuckyButton.setOpaque(false);
        view.KentuckyButton.setContentAreaFilled(false);

        view.IndianaButton.setOpaque(false);
        view.IndianaButton.setContentAreaFilled(false);

        view.IllionisButton.setOpaque(false);
        view.IllionisButton.setContentAreaFilled(false);

        view.AtlanticButton.setOpaque(false);
        view.AtlanticButton.setContentAreaFilled(false);

        view.VentnorButton.setOpaque(false);
        view.VentnorButton.setContentAreaFilled(false);

        view.MarvinButton.setOpaque(false);
        view.MarvinButton.setContentAreaFilled(false);

        view.PacificButton.setOpaque(false);
        view.PacificButton.setContentAreaFilled(false);

        view.NorthButton.setOpaque(false);
        view.NorthButton.setContentAreaFilled(false);

        view.PennsylvaniaButton.setOpaque(false);
        view.PennsylvaniaButton.setContentAreaFilled(false);

        view.ParkButton.setOpaque(false);
        view.ParkButton.setContentAreaFilled(false);

        view.BoardwalkButoon.setOpaque(false);
        view.BoardwalkButoon.setContentAreaFilled(false);

        view.ReadingTrainButton.setOpaque(false);
        view.ReadingTrainButton.setContentAreaFilled(false);

        view.PennsylvaniaTrainButton.setOpaque(false);
        view.PennsylvaniaTrainButton.setContentAreaFilled(false);

        view.BOTrainButton.setOpaque(false);
        view.BOTrainButton.setContentAreaFilled(false);

        view.ShortTrainButton.setOpaque(false);
        view.ShortTrainButton.setContentAreaFilled(false);

        view.ElectricButton.setOpaque(false);
        view.ElectricButton.setContentAreaFilled(false);
        view.WaterButton.setOpaque(false);
        view.WaterButton.setContentAreaFilled(false);
    }
}
