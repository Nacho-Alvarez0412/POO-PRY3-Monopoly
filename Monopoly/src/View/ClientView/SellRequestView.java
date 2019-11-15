/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.ClientView;

import Model.Packages.SellRequestPackage;

/**
 *
 * @author nacho
 */
public class SellRequestView extends javax.swing.JFrame {

    /**
     * Creates new form SellRequestView
     */
    public SellRequestView() {
        initComponents();
        setSize(600, 320);
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
        MessageLabel = new javax.swing.JLabel();
        DeclineButton = new javax.swing.JButton();
        AcceptButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(164, 208, 167));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("SELL REQUEST");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(190, 10, 240, 60);

        MessageLabel.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        MessageLabel.setForeground(new java.awt.Color(0, 0, 0));
        MessageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MessageLabel.setText("Ignacio wants to sell Baltic Avenue for $400");
        jPanel1.add(MessageLabel);
        MessageLabel.setBounds(10, 80, 560, 60);

        DeclineButton.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        DeclineButton.setForeground(new java.awt.Color(0, 0, 0));
        DeclineButton.setText("DECLINE");
        jPanel1.add(DeclineButton);
        DeclineButton.setBounds(330, 190, 160, 42);

        AcceptButton.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        AcceptButton.setForeground(new java.awt.Color(0, 0, 0));
        AcceptButton.setText("ACCEPT");
        jPanel1.add(AcceptButton);
        AcceptButton.setBounds(120, 190, 150, 42);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 590, 300);

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
            java.util.logging.Logger.getLogger(SellRequestView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SellRequestView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SellRequestView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SellRequestView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SellRequestView().setVisible(true);
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
