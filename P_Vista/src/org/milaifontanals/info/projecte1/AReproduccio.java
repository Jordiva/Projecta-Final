/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milaifontanals.info.projecte1;

/**
 *
 * @author Usuari
 */
public class AReproduccio extends javax.swing.JPanel {

    /**
     * Creates new form CReproduccio
     */
    public AReproduccio() {
        initComponents();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        estilsComboBox = new javax.swing.JComboBox<>();
        clientsCombobox = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        Actualitza = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actualitza", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Clients");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 39, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Estils");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 77, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Producte Nom");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 115, -1, -1));

        estilsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        estilsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estilsComboBoxActionPerformed(evt);
            }
        });
        add(estilsComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 77, 94, -1));

        clientsCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        clientsCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientsComboboxActionPerformed(evt);
            }
        });
        add(clientsCombobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 39, 94, -1));
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 115, 94, -1));

        Actualitza.setText("Actualitza");
        Actualitza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualitzaActionPerformed(evt);
            }
        });
        add(Actualitza, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 171, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void estilsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estilsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estilsComboBoxActionPerformed

    private void clientsComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientsComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientsComboboxActionPerformed

    private void ActualitzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualitzaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActualitzaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualitza;
    private javax.swing.JComboBox<String> clientsCombobox;
    private javax.swing.JComboBox<String> estilsComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
