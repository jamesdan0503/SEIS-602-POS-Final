/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package point.of.sale.system;

import java.io.FileReader;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Anakin, Will, Eric
 */
public class ReturnPage extends javax.swing.JFrame {

    private String tranID;

    /**
     * Creates new form ReturnPage
     */
    public ReturnPage(String tranID) {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

        this.tranID = tranID;
        this.returnTrans(tranID);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void returnTrans(String transNum) {
        JSONParser parser = new JSONParser();
        long appleNum = 0, bananaNum = 0, cherryNum = 0;
        try {

            Object obj = parser.parse(new FileReader("C:\\SEIS602 Java\\transaction\\" + transNum + ".json"));

            JSONObject jobj = (JSONObject) obj;

            appleNum = (long) jobj.get("apple");
            bananaNum = (long) jobj.get("banana");
            cherryNum = (long) jobj.get("cherry");
        } catch (Exception e) {
            e.printStackTrace();
        }
        appleLb.setText(appleNum + "");
        bananaLb.setText(bananaNum + "");
        cherryLb.setText(cherryNum + "");
        jLabel8.setText("Transaction: " + tranID);
        System.out.print(tranID);

    }

    public void updateInventory() {
        int appleNum = 0, bananaNum = 0, cherryNum = 0;
        long appleNum_inv = 0, bananaNum_inv = 0, cherryNum_inv = 0;
        if ((appleReturn.getText().matches("\\D+")) || appleReturn.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "input invalid", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        } else if ((bananaReturn.getText().matches("\\D+")) || bananaReturn.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "input invalid", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        } else if ((cherryReturn.getText().matches("\\D+")) || cherryReturn.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "input invalid", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        } else {
            appleNum = Integer.parseInt(appleReturn.getText());
            bananaNum = Integer.parseInt(bananaReturn.getText());
            cherryNum = Integer.parseInt(cherryReturn.getText());

            JSONParser parser = new JSONParser();
            try {

                Object obj = parser.parse(new FileReader("C:\\SEIS602 Java\\inventory\\info.json"));
                JSONObject jobj = (JSONObject) obj;
                appleNum_inv = (long) jobj.get("apple");
                bananaNum_inv = (long) jobj.get("banana");
                cherryNum_inv = (long) jobj.get("cherry");
            } catch (Exception e) {
                e.printStackTrace();
            }

            appleNum_inv = appleNum_inv + appleNum;
            bananaNum_inv = bananaNum_inv + bananaNum;
            cherryNum_inv = cherryNum_inv + cherryNum;

            JsonWR inventoryChange = new JsonWR();
            inventoryChange.inventoryWrite(inventoryChange.json_obj(appleNum_inv, bananaNum_inv, cherryNum_inv));
        }

    }

    public void updateTransaction(String transNum) {
        int appleNum = 0, bananaNum = 0, cherryNum = 0;
        long appleNum_inv = 0, bananaNum_inv = 0, cherryNum_inv = 0;
        if ((appleReturn.getText().matches("\\D+")) || appleReturn.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "input invalid", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        } else if ((bananaReturn.getText().matches("\\D+")) || bananaReturn.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "input invalid", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        } else if ((cherryReturn.getText().matches("\\D+")) || cherryReturn.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "input invalid", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        } else {
            appleNum = Integer.parseInt(appleReturn.getText());
            bananaNum = Integer.parseInt(bananaReturn.getText());
            cherryNum = Integer.parseInt(cherryReturn.getText());

            JSONParser parser = new JSONParser();
            try {

                Object obj = parser.parse(new FileReader("C:\\SEIS602 Java\\transaction\\" + transNum + ".json"));
                JSONObject jobj = (JSONObject) obj;
                appleNum_inv = (long) jobj.get("apple");
                bananaNum_inv = (long) jobj.get("banana");
                cherryNum_inv = (long) jobj.get("cherry");
            } catch (Exception e) {
                e.printStackTrace();
            }

            appleNum_inv = appleNum_inv - appleNum;
            bananaNum_inv = bananaNum_inv - bananaNum;
            cherryNum_inv = cherryNum_inv - cherryNum;

            JsonWR transactionChange = new JsonWR();
            transactionChange.transactionWrite(transactionChange.json_obj(appleNum_inv, bananaNum_inv, cherryNum_inv),
                    "C:\\SEIS602 Java\\transaction\\", Integer.parseInt(transNum));
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        appleReturn = new javax.swing.JTextField();
        bananaReturn = new javax.swing.JTextField();
        cherryReturn = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        appleLb = new javax.swing.JLabel();
        bananaLb = new javax.swing.JLabel();
        cherryLb = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 36)); // NOI18N
        jLabel1.setText("Return Menu");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Apple   : ");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Banana :");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Cherry   :");

        appleReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appleReturnActionPerformed(evt);
            }
        });

        cherryReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cherryReturnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Amount");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Return Amt");

        jButton1.setText("Return");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Check Inventory");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        appleLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        bananaLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        cherryLb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton3.setText("Close");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(28, 28, 28)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(appleLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bananaLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cherryLb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bananaReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(appleReturn)
                                        .addComponent(cherryReturn))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(63, 63, 63))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(appleLb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(appleReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bananaLb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bananaReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cherryLb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cherryReturn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cherryReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cherryReturnActionPerformed

    }//GEN-LAST:event_cherryReturnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (Integer.parseInt(appleReturn.getText()) > Integer.parseInt(appleLb.getText())
                || Integer.parseInt(bananaReturn.getText()) > Integer.parseInt(bananaLb.getText())
                || Integer.parseInt(cherryReturn.getText()) > Integer.parseInt(cherryLb.getText())) {
            JOptionPane.showMessageDialog(null, "Return amount cannot exceed transcation amount", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
        } else {
            this.updateInventory();
            this.updateTransaction(tranID);
            this.returnTrans(tranID);
            this.setVisible(false);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        InventoryList il = new InventoryList();
        il.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void appleReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appleReturnActionPerformed

    }//GEN-LAST:event_appleReturnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appleLb;
    private javax.swing.JTextField appleReturn;
    private javax.swing.JLabel bananaLb;
    private javax.swing.JTextField bananaReturn;
    private javax.swing.JLabel cherryLb;
    private javax.swing.JTextField cherryReturn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
