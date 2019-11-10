/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.ClientView;

/**
 *
 * @author nacho
 */
public class GameView extends javax.swing.JFrame {

    /**
     * Creates new form GameView
     */
    public GameView() {
        initComponents();
        setSize(1415,940);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoPanel = new javax.swing.JPanel();
        ButtonsPanel = new javax.swing.JPanel();
        NextPlayerButton = new javax.swing.JButton();
        BuildButton = new javax.swing.JButton();
        SellButton = new javax.swing.JButton();
        MortgageButton = new javax.swing.JButton();
        UnmortgageButton = new javax.swing.JButton();
        TradeButton = new javax.swing.JButton();
        BoardLabel = new javax.swing.JLabel();
        UserInfoPanel = new javax.swing.JPanel();
        UserIconLabel = new javax.swing.JLabel();
        UserName = new javax.swing.JLabel();
        UserMoneyLabel = new javax.swing.JLabel();
        PlayeXInfoPanel = new javax.swing.JPanel();
        PlayerXIconLabel = new javax.swing.JLabel();
        PlayerXName = new javax.swing.JLabel();
        PlayerXMoney = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        infoPanel.setBackground(new java.awt.Color(164, 208, 167));
        infoPanel.setLayout(null);

        ButtonsPanel.setBackground(new java.awt.Color(77, 158, 27));
        ButtonsPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonsPanel.setLayout(null);

        NextPlayerButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        NextPlayerButton.setText("NEXT PLAYER");
        ButtonsPanel.add(NextPlayerButton);
        NextPlayerButton.setBounds(10, 10, 170, 50);

        BuildButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        BuildButton.setText("BUILD");
        ButtonsPanel.add(BuildButton);
        BuildButton.setBounds(200, 10, 170, 50);

        SellButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        SellButton.setText("SELL");
        ButtonsPanel.add(SellButton);
        SellButton.setBounds(390, 10, 180, 50);

        MortgageButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        MortgageButton.setText("MORTGAGE");
        ButtonsPanel.add(MortgageButton);
        MortgageButton.setBounds(590, 10, 180, 50);

        UnmortgageButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        UnmortgageButton.setText("UNMORTGAGE");
        ButtonsPanel.add(UnmortgageButton);
        UnmortgageButton.setBounds(790, 10, 180, 50);

        TradeButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        TradeButton.setText("TRADE");
        ButtonsPanel.add(TradeButton);
        TradeButton.setBounds(1000, 10, 180, 50);

        infoPanel.add(ButtonsPanel);
        ButtonsPanel.setBounds(0, 830, 1400, 80);

        BoardLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MonopolyBoard.jpg"))); // NOI18N
        BoardLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infoPanel.add(BoardLabel);
        BoardLabel.setBounds(10, 10, 804, 810);

        UserInfoPanel.setBackground(new java.awt.Color(164, 208, 167));
        UserInfoPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        UserInfoPanel.setLayout(null);
        UserInfoPanel.add(UserIconLabel);
        UserIconLabel.setBounds(10, 10, 90, 70);

        UserName.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        UserName.setText("User");
        UserInfoPanel.add(UserName);
        UserName.setBounds(120, 10, 180, 30);

        UserMoneyLabel.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        UserMoneyLabel.setText("Money");
        UserInfoPanel.add(UserMoneyLabel);
        UserMoneyLabel.setBounds(330, 10, 180, 30);

        infoPanel.add(UserInfoPanel);
        UserInfoPanel.setBounds(830, 20, 560, 300);

        PlayeXInfoPanel.setBackground(new java.awt.Color(164, 208, 167));
        PlayeXInfoPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PlayeXInfoPanel.setLayout(null);
        PlayeXInfoPanel.add(PlayerXIconLabel);
        PlayerXIconLabel.setBounds(10, 10, 90, 70);

        PlayerXName.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PlayerXName.setText("PlayerX");
        PlayeXInfoPanel.add(PlayerXName);
        PlayerXName.setBounds(120, 10, 180, 30);

        PlayerXMoney.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PlayerXMoney.setText("Money");
        PlayeXInfoPanel.add(PlayerXMoney);
        PlayerXMoney.setBounds(330, 10, 180, 30);

        infoPanel.add(PlayeXInfoPanel);
        PlayeXInfoPanel.setBounds(830, 340, 560, 300);

        getContentPane().add(infoPanel);
        infoPanel.setBounds(0, 0, 1400, 900);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BoardLabel;
    private javax.swing.JButton BuildButton;
    private javax.swing.JPanel ButtonsPanel;
    private javax.swing.JButton MortgageButton;
    private javax.swing.JButton NextPlayerButton;
    private javax.swing.JPanel PlayeXInfoPanel;
    public javax.swing.JLabel PlayerXIconLabel;
    public javax.swing.JLabel PlayerXMoney;
    private javax.swing.JLabel PlayerXName;
    private javax.swing.JButton SellButton;
    private javax.swing.JButton TradeButton;
    private javax.swing.JButton UnmortgageButton;
    public javax.swing.JLabel UserIconLabel;
    private javax.swing.JPanel UserInfoPanel;
    public javax.swing.JLabel UserMoneyLabel;
    public javax.swing.JLabel UserName;
    private javax.swing.JPanel infoPanel;
    // End of variables declaration//GEN-END:variables
}