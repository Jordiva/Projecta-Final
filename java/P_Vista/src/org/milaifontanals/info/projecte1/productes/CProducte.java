/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milaifontanals.info.projecte1.productes;

import org.milaifontanals.info.projecte1.reproduccio.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.milaifontanals.info.projecte1.BDReproduccio;
import org.milaifontanals.info.projecte1.Clients;
import org.milaifontanals.info.projecte1.Estil;
import org.milaifontanals.info.projecte1.GestorBDReproduccioJdbcException;
import org.milaifontanals.info.projecte1.Principal;

/**
 *
 * @author Usuari
 */
public class CProducte extends javax.swing.JPanel {

    /**
     * Creates new form CReproduccio
     */
    public CProducte() {
        initComponents();
        Conection();
        OmpleEstils();
    }

    
           BDReproduccio gbd = null;

     private void Conection() {

        try {
            gbd = new BDReproduccio();
        } catch (GestorBDReproduccioJdbcException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    private void OmpleEstils(){
        
        estilsComboBox.removeAllItems();
                   try {
                    List<Estil> llEs = gbd.getListEstils();
                    for (Estil p : llEs) {
                       estilsComboBox.addItem(p.toString());
                    }
                    
                    return;
                } catch (GestorBDReproduccioJdbcException ex) {
                    System.out.println("Problemes en efectuar la cerca.\n\nMotiu:\n\n" + ex.getMessage());
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
        estilsComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Crear = new javax.swing.JButton();
        ActiuComboxob = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        TipusCombobox = new javax.swing.JComboBox<>();
        estilsComboBox3 = new javax.swing.JComboBox<>();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Crear", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Titol");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 39, -1, -1));

        estilsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Llista", "Canço", "Artista" }));
        estilsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estilsComboBoxActionPerformed(evt);
            }
        });
        add(estilsComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 94, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Actiu");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Estil");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 94, -1));

        Crear.setText("Crear");
        Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearActionPerformed(evt);
            }
        });
        add(Crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, -1, -1));

        ActiuComboxob.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N", "Y" }));
        ActiuComboxob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActiuComboxobActionPerformed(evt);
            }
        });
        add(ActiuComboxob, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 77, 94, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tipus ");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        TipusCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Llista", "Canço", "Artista" }));
        TipusCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipusComboboxActionPerformed(evt);
            }
        });
        add(TipusCombobox, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 94, -1));

        estilsComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Llista", "Canço", "Artista" }));
        estilsComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estilsComboBox3ActionPerformed(evt);
            }
        });
        add(estilsComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 94, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void estilsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estilsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estilsComboBoxActionPerformed

    private void CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CrearActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void ActiuComboxobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActiuComboxobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActiuComboxobActionPerformed

    private void TipusComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipusComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TipusComboboxActionPerformed

    private void estilsComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estilsComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estilsComboBox3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ActiuComboxob;
    private javax.swing.JButton Crear;
    private javax.swing.JComboBox<String> TipusCombobox;
    private javax.swing.JComboBox<String> estilsComboBox;
    private javax.swing.JComboBox<String> estilsComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
