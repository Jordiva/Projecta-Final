/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.milaifontanals.info.projecte1;

import org.milaifontanals.info.projecte1.reproduccio.*;
import java.awt.BorderLayout;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author joval
 */
public class PReproduccions extends javax.swing.JPanel {

    /**
     * Creates new form Reproduccions
     */
    public PReproduccions() {
        initComponents();
        Conection();
      

    }
  private void Conection() {

        try {
            gbd = new BDReproduccio();
        } catch (GestorBDReproduccioJdbcException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableReproduccio = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        BotoFiltre = new javax.swing.JButton();
        CrearButo = new javax.swing.JButton();
        ActualitzaBoto = new javax.swing.JButton();
        BorrarBoto = new javax.swing.JButton();
        MostraTotBoto = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Reproduccions");

        tableReproduccio.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(tableReproduccio);
        tableReproduccio.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 358, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 226, Short.MAX_VALUE)
        );

        BotoFiltre.setText("Filtres");
        BotoFiltre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotoFiltreActionPerformed(evt);
            }
        });

        CrearButo.setText("Crear");
        CrearButo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearButoActionPerformed(evt);
            }
        });

        ActualitzaBoto.setText("Actualitza");
        ActualitzaBoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualitzaBotoActionPerformed(evt);
            }
        });

        BorrarBoto.setText("Borrar");
        BorrarBoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarBotoActionPerformed(evt);
            }
        });

        MostraTotBoto.setText("Mostra Tot");
        MostraTotBoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostraTotBotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(MostraTotBoto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 219, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotoFiltre)
                            .addComponent(CrearButo)
                            .addComponent(ActualitzaBoto)
                            .addComponent(BorrarBoto))
                        .addGap(75, 75, 75))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MostraTotBoto)
                        .addGap(40, 40, 40)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(BotoFiltre)
                        .addGap(18, 18, 18)
                        .addComponent(CrearButo)
                        .addGap(18, 18, 18)
                        .addComponent(ActualitzaBoto)
                        .addGap(18, 18, 18)
                        .addComponent(BorrarBoto)))
                .addGap(83, 83, 83))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void BotoFiltreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotoFiltreActionPerformed
        // TODO add your handling code here:
        filtre();
    }//GEN-LAST:event_BotoFiltreActionPerformed

    private void CrearButoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearButoActionPerformed
        // TODO add your handling code here:
        
        Crear();
    }//GEN-LAST:event_CrearButoActionPerformed

    private void ActualitzaBotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualitzaBotoActionPerformed

        // TODO add your handling code here:
        Actualitza();
    }//GEN-LAST:event_ActualitzaBotoActionPerformed

    private void BorrarBotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarBotoActionPerformed
        // TODO add your handling code here:
        Borrar();
    }//GEN-LAST:event_BorrarBotoActionPerformed


    private void MostraTotBotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostraTotBotoActionPerformed
        // TODO add your handling code here:    
         DefaultTableModel model = new DefaultTableModel();

                model.addColumn("ID Client");
                model.addColumn("Moment Temporal");
                model.addColumn("ID Producte");
                
                
        try {
            List<Reproduccio> llRep = gbd.getListReproducio();
            for (Reproduccio p : llRep) {
              model.addRow(new Object[]{p.getIdCli(), p.getDate(),p.getIdProd()});
            }
            tableReproduccio.setModel(model);
            return;
        } catch (GestorBDReproduccioJdbcException ex) {
            System.out.println("Problemes en efectuar la cerca.\n\nMotiu:\n\n" + ex.getMessage());
        }
        
        
    }//GEN-LAST:event_MostraTotBotoActionPerformed

    
    private void filtre(){
        FReproduccio rep = new FReproduccio();
        rep.setSize(358, 226);
        rep.setLocation(0,0);
        
        jPanel2.removeAll();
        jPanel2.add(rep,BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel2.repaint();
    }
    
     private void Crear(){
        CReproduccio rep = new CReproduccio();
        rep.setSize(358, 226);
        rep.setLocation(0,0);
        
        jPanel2.removeAll();
        jPanel2.add(rep,BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel2.repaint();
    }
    
    private void Actualitza(){
        AReproduccio rep = new AReproduccio();
        rep.setSize(358, 226);
        rep.setLocation(0,0);
        
        jPanel2.removeAll();
        jPanel2.add(rep,BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel2.repaint();
    }
    
    private void Borrar(){
        BReproduccio rep = new BReproduccio();
        rep.setSize(358, 226);
        rep.setLocation(0,0);
        
        jPanel2.removeAll();
        jPanel2.add(rep,BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel2.repaint();
    }
     
         private BDReproduccio gbd = null;


         
         
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualitzaBoto;
    private javax.swing.JButton BorrarBoto;
    private javax.swing.JButton BotoFiltre;
    private javax.swing.JButton CrearButo;
    private javax.swing.JButton MostraTotBoto;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableReproduccio;
    // End of variables declaration//GEN-END:variables
}