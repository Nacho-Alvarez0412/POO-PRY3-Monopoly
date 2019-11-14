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
        ChatTextArea.setEditable(false);
        RollButton.setEnabled(false);
        EndTurnButton.setEnabled(false);
        
        //User Print Buttons
        MediterraneanButton.setOpaque(false);
        MediterraneanButton.setContentAreaFilled(false);
        BalticButton.setOpaque(false);
        BalticButton.setContentAreaFilled(false);
        OrientalButton.setOpaque(false);
        OrientalButton.setContentAreaFilled(false);
        VermontButton.setOpaque(false);
        VermontButton.setContentAreaFilled(false);
        ConnecticutButton.setOpaque(false);
        ConnecticutButton.setContentAreaFilled(false);
        CharlesButton.setOpaque(false);
        CharlesButton.setContentAreaFilled(false);
        StatesButton.setOpaque(false);
        StatesButton.setContentAreaFilled(false);
        VirginiaButton.setOpaque(false);
        VirginiaButton.setContentAreaFilled(false);
        JamesButton.setOpaque(false);
        JamesButton.setContentAreaFilled(false);
        TenesseeButton.setOpaque(false);
        TenesseeButton.setContentAreaFilled(false);
        NewYorkButton.setOpaque(false);
        NewYorkButton.setContentAreaFilled(false);
        KentuckyButton.setOpaque(false);
        KentuckyButton.setContentAreaFilled(false);
        IndianaButton.setOpaque(false);
        IndianaButton.setContentAreaFilled(false);
        IllionisButton.setOpaque(false);
        IllionisButton.setContentAreaFilled(false);
        AtlanticButton.setOpaque(false);
        AtlanticButton.setContentAreaFilled(false);
        VentnorButton.setOpaque(false);
        VentnorButton.setContentAreaFilled(false);
        MarvinButton.setOpaque(false);
        MarvinButton.setContentAreaFilled(false);
        PacificButton.setOpaque(false);
        PacificButton.setContentAreaFilled(false);
        NorthButton.setOpaque(false);
        NorthButton.setContentAreaFilled(false);
        PennsylvaniaButton.setOpaque(false);
        PennsylvaniaButton.setContentAreaFilled(false);
        ParkButton.setOpaque(false);
        ParkButton.setContentAreaFilled(false);
        BoardwalkButoon.setOpaque(false);
        BoardwalkButoon.setContentAreaFilled(false);
        ReadingTrainButton.setOpaque(false);
        ReadingTrainButton.setContentAreaFilled(false);
        PennsylvaniaTrainButton.setOpaque(false);
        PennsylvaniaTrainButton.setContentAreaFilled(false);
        BOTrainButton.setOpaque(false);
        BOTrainButton.setContentAreaFilled(false);
        ShortTrainButton.setOpaque(false);
        ShortTrainButton.setContentAreaFilled(false);
        ElectricButton.setOpaque(false);
        ElectricButton.setContentAreaFilled(false);
        WaterButton.setOpaque(false);
        WaterButton.setContentAreaFilled(false);
        
        
        //UserX print Buttons
        MediterraneanXButton.setOpaque(false);
        MediterraneanXButton.setContentAreaFilled(false);
        BalticXButton.setOpaque(false);
        BalticXButton.setContentAreaFilled(false);
        OrientalXButton.setOpaque(false);
        OrientalXButton.setContentAreaFilled(false);
        VermontXButton.setOpaque(false);
        VermontXButton.setContentAreaFilled(false);
        ConnecticutXButton.setOpaque(false);
        ConnecticutXButton.setContentAreaFilled(false);
        CharlesXButton.setOpaque(false);
        CharlesXButton.setContentAreaFilled(false);
        StatesXButton.setOpaque(false);
        StatesXButton.setContentAreaFilled(false);
        VirginiaXButton.setOpaque(false);
        VirginiaXButton.setContentAreaFilled(false);
        JamesXButton.setOpaque(false);
        JamesXButton.setContentAreaFilled(false);
        TenesseeXButton.setOpaque(false);
        TenesseeXButton.setContentAreaFilled(false);
        NewYorkXButton.setOpaque(false);
        NewYorkXButton.setContentAreaFilled(false);
        KentuckyXButton.setOpaque(false);
        KentuckyXButton.setContentAreaFilled(false);
        IndianaXButton.setOpaque(false);
        IndianaXButton.setContentAreaFilled(false);
        IllionisXButton.setOpaque(false);
        IllionisXButton.setContentAreaFilled(false);
        AtlanticXButton.setOpaque(false);
        AtlanticXButton.setContentAreaFilled(false);
        VentnorXButton.setOpaque(false);
        VentnorXButton.setContentAreaFilled(false);
        MarvinXButton.setOpaque(false);
        MarvinXButton.setContentAreaFilled(false);
        PacificXButton.setOpaque(false);
        PacificXButton.setContentAreaFilled(false);
        NorthXButton.setOpaque(false);
        NorthXButton.setContentAreaFilled(false);
        PennsylvaniaXButton.setOpaque(false);
        PennsylvaniaXButton.setContentAreaFilled(false);
        ParkXButton.setOpaque(false);
        ParkXButton.setContentAreaFilled(false);
        BoardwalkXButoon.setOpaque(false);
        BoardwalkXButoon.setContentAreaFilled(false);
        ReadingTrainXButton.setOpaque(false);
        ReadingTrainXButton.setContentAreaFilled(false);
        PennsylvaniaTrainXButton.setOpaque(false);
        PennsylvaniaTrainXButton.setContentAreaFilled(false);
        BOTrainXButton.setOpaque(false);
        BOTrainXButton.setContentAreaFilled(false);
        ShortTrainXButton.setOpaque(false);
        ShortTrainXButton.setContentAreaFilled(false);
        ElectricXButton.setOpaque(false);
        ElectricXButton.setContentAreaFilled(false);
        WaterXButton.setOpaque(false);
        WaterXButton.setContentAreaFilled(false);
        
        
        
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
        BuyButton = new javax.swing.JButton();
        Player1IconLabel = new javax.swing.JLabel();
        Player2IconLabel = new javax.swing.JLabel();
        Player3IconLabel = new javax.swing.JLabel();
        Player4IconLabel = new javax.swing.JLabel();
        Player5IconLabel = new javax.swing.JLabel();
        Player6IconLabel = new javax.swing.JLabel();
        BoardLabel = new javax.swing.JLabel();
        UserInfoPanel = new javax.swing.JPanel();
        UserIconLabel = new javax.swing.JLabel();
        UserName = new javax.swing.JLabel();
        UserMoneyLabel = new javax.swing.JLabel();
        BalticButton = new javax.swing.JButton();
        MediterraneanButton = new javax.swing.JButton();
        JamesButton = new javax.swing.JButton();
        NewYorkButton = new javax.swing.JButton();
        TenesseeButton = new javax.swing.JButton();
        OrientalButton = new javax.swing.JButton();
        VermontButton = new javax.swing.JButton();
        ConnecticutButton = new javax.swing.JButton();
        CharlesButton = new javax.swing.JButton();
        StatesButton = new javax.swing.JButton();
        VirginiaButton = new javax.swing.JButton();
        WaterButton = new javax.swing.JButton();
        ElectricButton = new javax.swing.JButton();
        ParkButton = new javax.swing.JButton();
        BoardwalkButoon = new javax.swing.JButton();
        KentuckyButton = new javax.swing.JButton();
        IndianaButton = new javax.swing.JButton();
        IllionisButton = new javax.swing.JButton();
        VentnorButton = new javax.swing.JButton();
        AtlanticButton = new javax.swing.JButton();
        MarvinButton = new javax.swing.JButton();
        PennsylvaniaButton = new javax.swing.JButton();
        NorthButton = new javax.swing.JButton();
        ShortTrainButton = new javax.swing.JButton();
        ReadingTrainButton = new javax.swing.JButton();
        PennsylvaniaTrainButton = new javax.swing.JButton();
        BOTrainButton = new javax.swing.JButton();
        PacificButton = new javax.swing.JButton();
        PlayeXInfoPanel = new javax.swing.JPanel();
        PlayerXIconLabel = new javax.swing.JLabel();
        PlayerXName = new javax.swing.JLabel();
        PlayerXMoney = new javax.swing.JLabel();
        ParkXButton = new javax.swing.JButton();
        KentuckyXButton = new javax.swing.JButton();
        IllionisXButton = new javax.swing.JButton();
        StatesXButton = new javax.swing.JButton();
        ElectricXButton = new javax.swing.JButton();
        JamesXButton = new javax.swing.JButton();
        VirginiaXButton = new javax.swing.JButton();
        VermontXButton = new javax.swing.JButton();
        CharlesXButton = new javax.swing.JButton();
        BalticXButton = new javax.swing.JButton();
        ReadingTrainXButton = new javax.swing.JButton();
        BoardwalkXButoon = new javax.swing.JButton();
        NewYorkXButton = new javax.swing.JButton();
        OrientalXButton = new javax.swing.JButton();
        BOTrainXButton = new javax.swing.JButton();
        AtlanticXButton = new javax.swing.JButton();
        IndianaXButton = new javax.swing.JButton();
        ShortTrainXButton = new javax.swing.JButton();
        MarvinXButton = new javax.swing.JButton();
        TenesseeXButton = new javax.swing.JButton();
        MediterraneanXButton = new javax.swing.JButton();
        ConnecticutXButton = new javax.swing.JButton();
        VentnorXButton = new javax.swing.JButton();
        PacificXButton = new javax.swing.JButton();
        PennsylvaniaTrainXButton = new javax.swing.JButton();
        NorthXButton = new javax.swing.JButton();
        WaterXButton = new javax.swing.JButton();
        PennsylvaniaXButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TurnLabel = new javax.swing.JLabel();
        RollButton = new javax.swing.JButton();
        EndTurnButton = new javax.swing.JButton();
        Dice2Label = new javax.swing.JLabel();
        Dice1Label = new javax.swing.JLabel();
        ChatTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        ChatTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        infoPanel.setBackground(new java.awt.Color(164, 208, 167));
        infoPanel.setLayout(null);

        ButtonsPanel.setBackground(new java.awt.Color(64, 119, 77));
        ButtonsPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ButtonsPanel.setLayout(null);

        NextPlayerButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        NextPlayerButton.setText("NEXT PLAYER");
        ButtonsPanel.add(NextPlayerButton);
        NextPlayerButton.setBounds(10, 10, 170, 50);

        BuildButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        BuildButton.setText("BUILD");
        BuildButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuildButtonActionPerformed(evt);
            }
        });
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
        TradeButton.setBounds(990, 10, 180, 50);

        BuyButton.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        BuyButton.setText("BUY");
        ButtonsPanel.add(BuyButton);
        BuyButton.setBounds(1200, 10, 180, 50);

        infoPanel.add(ButtonsPanel);
        ButtonsPanel.setBounds(0, 830, 1400, 80);
        infoPanel.add(Player1IconLabel);
        Player1IconLabel.setBounds(740, 750, 50, 50);
        infoPanel.add(Player2IconLabel);
        Player2IconLabel.setBounds(730, 740, 50, 50);
        infoPanel.add(Player3IconLabel);
        Player3IconLabel.setBounds(730, 740, 50, 50);
        infoPanel.add(Player4IconLabel);
        Player4IconLabel.setBounds(730, 740, 50, 50);
        infoPanel.add(Player5IconLabel);
        Player5IconLabel.setBounds(730, 740, 50, 50);
        infoPanel.add(Player6IconLabel);
        Player6IconLabel.setBounds(730, 740, 50, 50);

        BoardLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/MonopolyBoard.jpg"))); // NOI18N
        BoardLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        infoPanel.add(BoardLabel);
        BoardLabel.setBounds(10, 10, 804, 810);

        UserInfoPanel.setBackground(new java.awt.Color(164, 208, 167));
        UserInfoPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        UserInfoPanel.setLayout(null);
        UserInfoPanel.add(UserIconLabel);
        UserIconLabel.setBounds(10, 10, 110, 90);

        UserName.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        UserInfoPanel.add(UserName);
        UserName.setBounds(130, 10, 180, 30);

        UserMoneyLabel.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        UserMoneyLabel.setText("0 $");
        UserInfoPanel.add(UserMoneyLabel);
        UserMoneyLabel.setBounds(330, 10, 180, 30);

        BalticButton.setBackground(new java.awt.Color(153, 51, 0));
        BalticButton.setText("B2");
        BalticButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 51, 0), 2));
        UserInfoPanel.add(BalticButton);
        BalticButton.setBounds(80, 130, 50, 50);

        MediterraneanButton.setBackground(new java.awt.Color(153, 51, 0));
        MediterraneanButton.setText("B1");
        MediterraneanButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 51, 0), 2));
        UserInfoPanel.add(MediterraneanButton);
        MediterraneanButton.setBounds(20, 130, 50, 50);

        JamesButton.setBackground(new java.awt.Color(255, 153, 0));
        JamesButton.setText("O1");
        JamesButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));
        UserInfoPanel.add(JamesButton);
        JamesButton.setBounds(170, 190, 50, 50);

        NewYorkButton.setBackground(new java.awt.Color(255, 153, 0));
        NewYorkButton.setText("O3");
        NewYorkButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));
        UserInfoPanel.add(NewYorkButton);
        NewYorkButton.setBounds(290, 190, 50, 50);

        TenesseeButton.setBackground(new java.awt.Color(255, 153, 0));
        TenesseeButton.setText("O2");
        TenesseeButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));
        UserInfoPanel.add(TenesseeButton);
        TenesseeButton.setBounds(230, 190, 50, 50);

        OrientalButton.setBackground(new java.awt.Color(102, 255, 255));
        OrientalButton.setText("LB1");
        OrientalButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 255), 2));
        UserInfoPanel.add(OrientalButton);
        OrientalButton.setBounds(170, 70, 50, 50);

        VermontButton.setBackground(new java.awt.Color(102, 255, 255));
        VermontButton.setText("LB2");
        VermontButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 255), 2));
        UserInfoPanel.add(VermontButton);
        VermontButton.setBounds(230, 70, 50, 50);

        ConnecticutButton.setBackground(new java.awt.Color(102, 255, 255));
        ConnecticutButton.setText("LB3");
        ConnecticutButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 255), 2));
        UserInfoPanel.add(ConnecticutButton);
        ConnecticutButton.setBounds(290, 70, 50, 50);

        CharlesButton.setBackground(new java.awt.Color(255, 51, 204));
        CharlesButton.setText("P1");
        CharlesButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 204), 2));
        UserInfoPanel.add(CharlesButton);
        CharlesButton.setBounds(170, 130, 50, 50);

        StatesButton.setBackground(new java.awt.Color(255, 51, 204));
        StatesButton.setText("P2");
        StatesButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 204), 2));
        UserInfoPanel.add(StatesButton);
        StatesButton.setBounds(230, 130, 50, 50);

        VirginiaButton.setBackground(new java.awt.Color(255, 51, 204));
        VirginiaButton.setText("P3");
        VirginiaButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 204), 2));
        UserInfoPanel.add(VirginiaButton);
        VirginiaButton.setBounds(290, 130, 50, 50);

        WaterButton.setBackground(new java.awt.Color(204, 204, 204));
        WaterButton.setText("S2");
        WaterButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        UserInfoPanel.add(WaterButton);
        WaterButton.setBounds(80, 190, 50, 50);

        ElectricButton.setBackground(new java.awt.Color(204, 204, 204));
        ElectricButton.setText("S1");
        ElectricButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        UserInfoPanel.add(ElectricButton);
        ElectricButton.setBounds(20, 190, 50, 50);

        ParkButton.setBackground(new java.awt.Color(0, 0, 255));
        ParkButton.setText("A1");
        ParkButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));
        UserInfoPanel.add(ParkButton);
        ParkButton.setBounds(20, 250, 50, 50);

        BoardwalkButoon.setBackground(new java.awt.Color(0, 0, 255));
        BoardwalkButoon.setText("A2");
        BoardwalkButoon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));
        UserInfoPanel.add(BoardwalkButoon);
        BoardwalkButoon.setBounds(80, 250, 50, 50);

        KentuckyButton.setBackground(new java.awt.Color(255, 0, 0));
        KentuckyButton.setText("R1");
        KentuckyButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        UserInfoPanel.add(KentuckyButton);
        KentuckyButton.setBounds(380, 70, 50, 50);

        IndianaButton.setBackground(new java.awt.Color(255, 0, 0));
        IndianaButton.setText("R2");
        IndianaButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        UserInfoPanel.add(IndianaButton);
        IndianaButton.setBounds(440, 70, 50, 50);

        IllionisButton.setBackground(new java.awt.Color(255, 0, 0));
        IllionisButton.setText("R3");
        IllionisButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        UserInfoPanel.add(IllionisButton);
        IllionisButton.setBounds(500, 70, 50, 50);

        VentnorButton.setBackground(new java.awt.Color(255, 255, 51));
        VentnorButton.setText("Y2");
        VentnorButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 2));
        UserInfoPanel.add(VentnorButton);
        VentnorButton.setBounds(440, 130, 50, 50);

        AtlanticButton.setBackground(new java.awt.Color(255, 255, 51));
        AtlanticButton.setText("Y1");
        AtlanticButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 2));
        UserInfoPanel.add(AtlanticButton);
        AtlanticButton.setBounds(380, 130, 50, 50);

        MarvinButton.setBackground(new java.awt.Color(255, 255, 51));
        MarvinButton.setText("Y3");
        MarvinButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 2));
        UserInfoPanel.add(MarvinButton);
        MarvinButton.setBounds(500, 130, 50, 50);

        PennsylvaniaButton.setBackground(new java.awt.Color(0, 204, 0));
        PennsylvaniaButton.setText("G3");
        PennsylvaniaButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0), 2));
        UserInfoPanel.add(PennsylvaniaButton);
        PennsylvaniaButton.setBounds(500, 190, 50, 50);

        NorthButton.setBackground(new java.awt.Color(0, 204, 0));
        NorthButton.setText("G2");
        NorthButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0), 2));
        UserInfoPanel.add(NorthButton);
        NorthButton.setBounds(440, 190, 50, 50);

        ShortTrainButton.setBackground(new java.awt.Color(0, 0, 0));
        ShortTrainButton.setText("T4");
        ShortTrainButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        UserInfoPanel.add(ShortTrainButton);
        ShortTrainButton.setBounds(460, 250, 50, 50);

        ReadingTrainButton.setBackground(new java.awt.Color(0, 0, 0));
        ReadingTrainButton.setText("T1");
        ReadingTrainButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        UserInfoPanel.add(ReadingTrainButton);
        ReadingTrainButton.setBounds(280, 250, 50, 50);

        PennsylvaniaTrainButton.setBackground(new java.awt.Color(0, 0, 0));
        PennsylvaniaTrainButton.setText("T2");
        PennsylvaniaTrainButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        UserInfoPanel.add(PennsylvaniaTrainButton);
        PennsylvaniaTrainButton.setBounds(340, 250, 50, 50);

        BOTrainButton.setBackground(new java.awt.Color(0, 0, 0));
        BOTrainButton.setText("T3");
        BOTrainButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        UserInfoPanel.add(BOTrainButton);
        BOTrainButton.setBounds(400, 250, 50, 50);

        PacificButton.setBackground(new java.awt.Color(0, 204, 0));
        PacificButton.setText("G1");
        PacificButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0), 2));
        UserInfoPanel.add(PacificButton);
        PacificButton.setBounds(380, 190, 50, 50);

        infoPanel.add(UserInfoPanel);
        UserInfoPanel.setBounds(830, 20, 560, 310);

        PlayeXInfoPanel.setBackground(new java.awt.Color(164, 208, 167));
        PlayeXInfoPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PlayeXInfoPanel.setLayout(null);
        PlayeXInfoPanel.add(PlayerXIconLabel);
        PlayerXIconLabel.setBounds(10, 10, 110, 90);

        PlayerXName.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PlayerXName.setText("Player");
        PlayeXInfoPanel.add(PlayerXName);
        PlayerXName.setBounds(130, 10, 180, 30);

        PlayerXMoney.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        PlayerXMoney.setText("0 $");
        PlayeXInfoPanel.add(PlayerXMoney);
        PlayerXMoney.setBounds(330, 10, 180, 30);

        ParkXButton.setBackground(new java.awt.Color(0, 0, 255));
        ParkXButton.setText("A1");
        ParkXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));
        PlayeXInfoPanel.add(ParkXButton);
        ParkXButton.setBounds(20, 240, 50, 50);

        KentuckyXButton.setBackground(new java.awt.Color(255, 0, 0));
        KentuckyXButton.setText("R1");
        KentuckyXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        PlayeXInfoPanel.add(KentuckyXButton);
        KentuckyXButton.setBounds(380, 60, 50, 50);

        IllionisXButton.setBackground(new java.awt.Color(255, 0, 0));
        IllionisXButton.setText("R3");
        IllionisXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        PlayeXInfoPanel.add(IllionisXButton);
        IllionisXButton.setBounds(500, 60, 50, 50);

        StatesXButton.setBackground(new java.awt.Color(255, 51, 204));
        StatesXButton.setText("P2");
        StatesXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 204), 2));
        PlayeXInfoPanel.add(StatesXButton);
        StatesXButton.setBounds(230, 120, 50, 50);

        ElectricXButton.setBackground(new java.awt.Color(204, 204, 204));
        ElectricXButton.setText("S1");
        ElectricXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        PlayeXInfoPanel.add(ElectricXButton);
        ElectricXButton.setBounds(20, 180, 50, 50);

        JamesXButton.setBackground(new java.awt.Color(255, 153, 0));
        JamesXButton.setText("O1");
        JamesXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));
        PlayeXInfoPanel.add(JamesXButton);
        JamesXButton.setBounds(170, 180, 50, 50);

        VirginiaXButton.setBackground(new java.awt.Color(255, 51, 204));
        VirginiaXButton.setText("P3");
        VirginiaXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 204), 2));
        PlayeXInfoPanel.add(VirginiaXButton);
        VirginiaXButton.setBounds(290, 120, 50, 50);

        VermontXButton.setBackground(new java.awt.Color(102, 255, 255));
        VermontXButton.setText("LB2");
        VermontXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 255), 2));
        PlayeXInfoPanel.add(VermontXButton);
        VermontXButton.setBounds(230, 60, 50, 50);

        CharlesXButton.setBackground(new java.awt.Color(255, 51, 204));
        CharlesXButton.setText("P1");
        CharlesXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 51, 204), 2));
        PlayeXInfoPanel.add(CharlesXButton);
        CharlesXButton.setBounds(170, 120, 50, 50);

        BalticXButton.setBackground(new java.awt.Color(153, 51, 0));
        BalticXButton.setText("B2");
        BalticXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 51, 0), 2));
        PlayeXInfoPanel.add(BalticXButton);
        BalticXButton.setBounds(80, 120, 50, 50);

        ReadingTrainXButton.setBackground(new java.awt.Color(0, 0, 0));
        ReadingTrainXButton.setText("T1");
        ReadingTrainXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        PlayeXInfoPanel.add(ReadingTrainXButton);
        ReadingTrainXButton.setBounds(280, 240, 50, 50);

        BoardwalkXButoon.setBackground(new java.awt.Color(0, 0, 255));
        BoardwalkXButoon.setText("A2");
        BoardwalkXButoon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));
        PlayeXInfoPanel.add(BoardwalkXButoon);
        BoardwalkXButoon.setBounds(80, 240, 50, 50);

        NewYorkXButton.setBackground(new java.awt.Color(255, 153, 0));
        NewYorkXButton.setText("O3");
        NewYorkXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));
        PlayeXInfoPanel.add(NewYorkXButton);
        NewYorkXButton.setBounds(290, 180, 50, 50);

        OrientalXButton.setBackground(new java.awt.Color(102, 255, 255));
        OrientalXButton.setText("LB1");
        OrientalXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 255), 2));
        PlayeXInfoPanel.add(OrientalXButton);
        OrientalXButton.setBounds(170, 60, 50, 50);

        BOTrainXButton.setBackground(new java.awt.Color(0, 0, 0));
        BOTrainXButton.setText("T3");
        BOTrainXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        PlayeXInfoPanel.add(BOTrainXButton);
        BOTrainXButton.setBounds(400, 240, 50, 50);

        AtlanticXButton.setBackground(new java.awt.Color(255, 255, 51));
        AtlanticXButton.setText("Y1");
        AtlanticXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 2));
        PlayeXInfoPanel.add(AtlanticXButton);
        AtlanticXButton.setBounds(380, 120, 50, 50);

        IndianaXButton.setBackground(new java.awt.Color(255, 0, 0));
        IndianaXButton.setText("R2");
        IndianaXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        PlayeXInfoPanel.add(IndianaXButton);
        IndianaXButton.setBounds(440, 60, 50, 50);

        ShortTrainXButton.setBackground(new java.awt.Color(0, 0, 0));
        ShortTrainXButton.setText("T4");
        ShortTrainXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        PlayeXInfoPanel.add(ShortTrainXButton);
        ShortTrainXButton.setBounds(460, 240, 50, 50);

        MarvinXButton.setBackground(new java.awt.Color(255, 255, 51));
        MarvinXButton.setText("Y3");
        MarvinXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 2));
        PlayeXInfoPanel.add(MarvinXButton);
        MarvinXButton.setBounds(500, 120, 50, 50);

        TenesseeXButton.setBackground(new java.awt.Color(255, 153, 0));
        TenesseeXButton.setText("O2");
        TenesseeXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 0), 2));
        PlayeXInfoPanel.add(TenesseeXButton);
        TenesseeXButton.setBounds(230, 180, 50, 50);

        MediterraneanXButton.setBackground(new java.awt.Color(153, 51, 0));
        MediterraneanXButton.setText("B1");
        MediterraneanXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 51, 0), 2));
        PlayeXInfoPanel.add(MediterraneanXButton);
        MediterraneanXButton.setBounds(20, 120, 50, 50);

        ConnecticutXButton.setBackground(new java.awt.Color(102, 255, 255));
        ConnecticutXButton.setText("LB3");
        ConnecticutXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 255), 2));
        PlayeXInfoPanel.add(ConnecticutXButton);
        ConnecticutXButton.setBounds(290, 60, 50, 50);

        VentnorXButton.setBackground(new java.awt.Color(255, 255, 51));
        VentnorXButton.setText("Y2");
        VentnorXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 51), 2));
        PlayeXInfoPanel.add(VentnorXButton);
        VentnorXButton.setBounds(440, 120, 50, 50);

        PacificXButton.setBackground(new java.awt.Color(0, 204, 0));
        PacificXButton.setText("G1");
        PacificXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0), 2));
        PlayeXInfoPanel.add(PacificXButton);
        PacificXButton.setBounds(380, 180, 50, 50);

        PennsylvaniaTrainXButton.setBackground(new java.awt.Color(0, 0, 0));
        PennsylvaniaTrainXButton.setText("T2");
        PennsylvaniaTrainXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        PlayeXInfoPanel.add(PennsylvaniaTrainXButton);
        PennsylvaniaTrainXButton.setBounds(340, 240, 50, 50);

        NorthXButton.setBackground(new java.awt.Color(0, 204, 0));
        NorthXButton.setText("G2");
        NorthXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0), 2));
        PlayeXInfoPanel.add(NorthXButton);
        NorthXButton.setBounds(440, 180, 50, 50);

        WaterXButton.setBackground(new java.awt.Color(204, 204, 204));
        WaterXButton.setText("S2");
        WaterXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        PlayeXInfoPanel.add(WaterXButton);
        WaterXButton.setBounds(80, 180, 50, 50);

        PennsylvaniaXButton.setBackground(new java.awt.Color(0, 204, 0));
        PennsylvaniaXButton.setText("G3");
        PennsylvaniaXButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0), 2));
        PlayeXInfoPanel.add(PennsylvaniaXButton);
        PennsylvaniaXButton.setBounds(500, 180, 50, 50);

        infoPanel.add(PlayeXInfoPanel);
        PlayeXInfoPanel.setBounds(830, 340, 560, 300);

        jPanel1.setBackground(new java.awt.Color(164, 208, 167));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setText("Turn of: ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 90, 30);

        TurnLabel.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jPanel1.add(TurnLabel);
        TurnLabel.setBounds(100, 10, 190, 30);

        RollButton.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        RollButton.setText("Roll Dices");
        jPanel1.add(RollButton);
        RollButton.setBounds(10, 50, 140, 50);

        EndTurnButton.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        EndTurnButton.setText("END TURN");
        jPanel1.add(EndTurnButton);
        EndTurnButton.setBounds(10, 110, 140, 50);

        Dice2Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Red1.jpg"))); // NOI18N
        jPanel1.add(Dice2Label);
        Dice2Label.setBounds(190, 90, 63, 60);

        Dice1Label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Red1.jpg"))); // NOI18N
        jPanel1.add(Dice1Label);
        Dice1Label.setBounds(190, 20, 63, 60);

        ChatTextField.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        ChatTextField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ChatTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ChatTextFieldKeyPressed(evt);
            }
        });
        jPanel1.add(ChatTextField);
        ChatTextField.setBounds(270, 130, 280, 30);

        ChatTextArea.setEditable(false);
        ChatTextArea.setColumns(20);
        ChatTextArea.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ChatTextArea.setRows(5);
        jScrollPane2.setViewportView(ChatTextArea);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(270, 10, 280, 110);

        infoPanel.add(jPanel1);
        jPanel1.setBounds(830, 650, 560, 170);

        getContentPane().add(infoPanel);
        infoPanel.setBounds(0, 0, 1400, 900);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ChatTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ChatTextFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ChatTextFieldKeyPressed

    private void BuildButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuildButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuildButtonActionPerformed

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
    public javax.swing.JButton AtlanticButton;
    public javax.swing.JButton AtlanticXButton;
    public javax.swing.JButton BOTrainButton;
    public javax.swing.JButton BOTrainXButton;
    public javax.swing.JButton BalticButton;
    public javax.swing.JButton BalticXButton;
    private javax.swing.JLabel BoardLabel;
    public javax.swing.JButton BoardwalkButoon;
    public javax.swing.JButton BoardwalkXButoon;
    public javax.swing.JButton BuildButton;
    private javax.swing.JPanel ButtonsPanel;
    public javax.swing.JButton BuyButton;
    public javax.swing.JButton CharlesButton;
    public javax.swing.JButton CharlesXButton;
    public javax.swing.JTextArea ChatTextArea;
    public javax.swing.JTextField ChatTextField;
    public javax.swing.JButton ConnecticutButton;
    public javax.swing.JButton ConnecticutXButton;
    public javax.swing.JLabel Dice1Label;
    public javax.swing.JLabel Dice2Label;
    public javax.swing.JButton ElectricButton;
    public javax.swing.JButton ElectricXButton;
    public javax.swing.JButton EndTurnButton;
    public javax.swing.JButton IllionisButton;
    public javax.swing.JButton IllionisXButton;
    public javax.swing.JButton IndianaButton;
    public javax.swing.JButton IndianaXButton;
    public javax.swing.JButton JamesButton;
    public javax.swing.JButton JamesXButton;
    public javax.swing.JButton KentuckyButton;
    public javax.swing.JButton KentuckyXButton;
    public javax.swing.JButton MarvinButton;
    public javax.swing.JButton MarvinXButton;
    public javax.swing.JButton MediterraneanButton;
    public javax.swing.JButton MediterraneanXButton;
    public javax.swing.JButton MortgageButton;
    public javax.swing.JButton NewYorkButton;
    public javax.swing.JButton NewYorkXButton;
    public javax.swing.JButton NextPlayerButton;
    public javax.swing.JButton NorthButton;
    public javax.swing.JButton NorthXButton;
    public javax.swing.JButton OrientalButton;
    public javax.swing.JButton OrientalXButton;
    public javax.swing.JButton PacificButton;
    public javax.swing.JButton PacificXButton;
    public javax.swing.JButton ParkButton;
    public javax.swing.JButton ParkXButton;
    public javax.swing.JButton PennsylvaniaButton;
    public javax.swing.JButton PennsylvaniaTrainButton;
    public javax.swing.JButton PennsylvaniaTrainXButton;
    public javax.swing.JButton PennsylvaniaXButton;
    private javax.swing.JPanel PlayeXInfoPanel;
    public javax.swing.JLabel Player1IconLabel;
    public javax.swing.JLabel Player2IconLabel;
    public javax.swing.JLabel Player3IconLabel;
    public javax.swing.JLabel Player4IconLabel;
    public javax.swing.JLabel Player5IconLabel;
    public javax.swing.JLabel Player6IconLabel;
    public javax.swing.JLabel PlayerXIconLabel;
    public javax.swing.JLabel PlayerXMoney;
    public javax.swing.JLabel PlayerXName;
    public javax.swing.JButton ReadingTrainButton;
    public javax.swing.JButton ReadingTrainXButton;
    public javax.swing.JButton RollButton;
    public javax.swing.JButton SellButton;
    public javax.swing.JButton ShortTrainButton;
    public javax.swing.JButton ShortTrainXButton;
    public javax.swing.JButton StatesButton;
    public javax.swing.JButton StatesXButton;
    public javax.swing.JButton TenesseeButton;
    public javax.swing.JButton TenesseeXButton;
    public javax.swing.JButton TradeButton;
    public javax.swing.JLabel TurnLabel;
    public javax.swing.JButton UnmortgageButton;
    public javax.swing.JLabel UserIconLabel;
    private javax.swing.JPanel UserInfoPanel;
    public javax.swing.JLabel UserMoneyLabel;
    public javax.swing.JLabel UserName;
    public javax.swing.JButton VentnorButton;
    public javax.swing.JButton VentnorXButton;
    public javax.swing.JButton VermontButton;
    public javax.swing.JButton VermontXButton;
    public javax.swing.JButton VirginiaButton;
    public javax.swing.JButton VirginiaXButton;
    public javax.swing.JButton WaterButton;
    public javax.swing.JButton WaterXButton;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
