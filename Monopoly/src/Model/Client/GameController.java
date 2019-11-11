/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Client;

import Model.Packages.ChatPackage;
import View.ClientView.GameView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nacho
 */
class GameController implements ActionListener {
    
    //Atributos
    GameView view;
    Client client;
    
    public GameController(Client client){
        this.client = client;
        view = new GameView();
        initWindow();
        view.setVisible(true);
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
    }
}
