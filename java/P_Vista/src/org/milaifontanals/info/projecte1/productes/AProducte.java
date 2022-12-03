/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milaifontanals.info.projecte1.productes;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.milaifontanals.info.projecte1.BDProducte;
import org.milaifontanals.info.projecte1.ConexioGeneral;
import org.milaifontanals.info.projecte1.Estil;
import org.milaifontanals.info.projecte1.GestorBDExceptionTOT;
import org.milaifontanals.info.projecte1.PProducte;
import org.milaifontanals.info.projecte1.Principal;
import org.milaifontanals.info.projecte1.reproduccio.*;

/**
 *
 * @author Usuari
 */
public class AProducte extends javax.swing.JPanel {

    /**
     * Creates new form CReproduccio
     */
    String titol;
    String actiu;
    String tipus;
    String estil;

    public AProducte(String titol, String actiu, String tipus, String estil) {
        this.titol = titol;
        this.actiu = actiu;
        this.tipus = tipus;
        this.estil = estil;
        
        initComponents();
        Conection();
        OmpleEstils();
        
        
        
        
        System.out.println(titol);
        System.out.println(actiu);
        System.out.println(tipus);
        System.out.println(estil);
    }


    private void Conection() {

        try {
            ConexioGeneral.getConnection();
        } catch (GestorBDExceptionTOT ex) {
            System.out.println("Error a connectar "+ex.getMessage());
        }
    }

    private void OmpleEstils() {

        estilsComboBox.removeAllItems();
        try {
            List<Estil> llEs = BDProducte.getListEstils();
            for (Estil p : llEs) {
                estilsComboBox.addItem(p.toString());
            }

            return;
        } catch (GestorBDExceptionTOT ex) {
            System.out.println("Problemes en efectuar la cerca.\n\nMotiu:\n\n" + ex.getMessage());
        }
    }

    private void ompleinfo() {

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
        Titoltxb = new javax.swing.JTextField();
        Crear = new javax.swing.JButton();
        ActiuComboxob = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        Tipus_combo = new javax.swing.JComboBox<>();

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actualitza", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
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

        Titoltxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TitoltxbActionPerformed(evt);
            }
        });
        add(Titoltxb, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 94, -1));

        Crear.setText("Actualitza");
        Crear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CrearMouseClicked(evt);
            }
        });
        add(Crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, -1, -1));

        ActiuComboxob.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N", "S" }));
        ActiuComboxob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActiuComboxobActionPerformed(evt);
            }
        });
        add(ActiuComboxob, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 77, 94, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tipus ");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        Tipus_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Llista", "Canço", "Artista" }));
        Tipus_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tipus_comboActionPerformed(evt);
            }
        });
        add(Tipus_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 94, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void estilsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estilsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estilsComboBoxActionPerformed

    private void TitoltxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TitoltxbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TitoltxbActionPerformed

    private void CrearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CrearMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_CrearMouseClicked

    private void ActiuComboxobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActiuComboxobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActiuComboxobActionPerformed

    private void Tipus_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tipus_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tipus_comboActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ActiuComboxob;
    private javax.swing.JButton Crear;
    private javax.swing.JComboBox<String> Tipus_combo;
    private javax.swing.JTextField Titoltxb;
    private javax.swing.JComboBox<String> estilsComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
