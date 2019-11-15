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
public class TradeRequestView extends javax.swing.JFrame {

    /**
     * Creates new form TradeRequestView
     */
    public TradeRequestView() {
        initComponents();
        setSize(530,319);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        DeclineButton = new javax.swing.JButton();
        AcceptButton = new javax.swing.JButton();
        MessageLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(164, 208, 167));
        jPanel1.setForeground(new java.awt.Color(164, 208, 167));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Trade Request");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(150, 20, 220, 50);

        DeclineButton.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        DeclineButton.setForeground(new java.awt.Color(0, 0, 0));
        DeclineButton.setText("Decline");
        jPanel1.add(DeclineButton);
        DeclineButton.setBounds(320, 210, 130, 40);

        AcceptButton.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        AcceptButton.setForeground(new java.awt.Color(0, 0, 0));
        AcceptButton.setText("Accept");
        jPanel1.add(AcceptButton);
        AcceptButton.setBounds(50, 210, 130, 40);

        MessageLabel.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        MessageLabel.setForeground(new java.awt.Color(0, 0, 0));
        MessageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MessageLabel.setText("Ignacio wants to trade Baltic Avenue for New York Avenue");
        jPanel1.add(MessageLabel);
        MessageLabel.setBounds(11, 110, 500, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 520, 290);

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
            java.util.logging.Logger.getLogger(TradeRequestView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TradeRequestView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TradeRequestView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TradeRequestView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TradeRequestView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton AcceptButton;
    public javax.swing.JButton DeclineButton;
    public javax.swing.JLabel MessageLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
