/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milaifontanals.info.projecte1;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicListUI.ListSelectionHandler;
import javax.swing.table.DefaultTableModel;
import org.milaifontanals.info.projecte1.productes.*;
import org.milaifontanals.info.projecte1.reproduccio.AReproduccio;
import org.milaifontanals.info.projecte1.reproduccio.BReproduccio;
import org.milaifontanals.info.projecte1.reproduccio.CReproduccio;
import org.milaifontanals.info.projecte1.reproduccio.FReproduccio;

/**
 *
 * @author isard
 */
public class PProducte extends javax.swing.JPanel {

    /**
     * Creates new form Producte
     */
    public PProducte() {
        initComponents();
        Conection();
        borrainfo();
        ompletabla();
        informacio();

    }
    private BDProducte gbd = null;
    private DefaultTableModel info = new DefaultTableModel();

    private void borrainfo() {

        Titolbox.setText("");
        Estilbox.setText("");
        Actiubox.setText("");
        Tiposbox.setText("");

    }

    private void informacio() {

        ListSelectionModel listSelectionModel = tableProducte.getSelectionModel();
        listSelectionModel.addListSelectionListener(
                new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {

                Titolbox.setText(tableProducte.getValueAt(tableProducte.getSelectedRow(), 0).toString());
                Estilbox.setText(tableProducte.getValueAt(tableProducte.getSelectedRow(), 1).toString());
                Actiubox.setText(tableProducte.getValueAt(tableProducte.getSelectedRow(), 2).toString());
                Tiposbox.setText(tableProducte.getValueAt(tableProducte.getSelectedRow(), 3).toString());

                String Tipus = tableProducte.getValueAt(tableProducte.getSelectedRow(), 3).toString();

            }

        });

    }

    private void Conection() {

        try {
            gbd = new BDProducte();
        } catch (GestorBDProducteJdbcException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void ompletabla() {

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Titol");
        model.addColumn("Actiu");
        model.addColumn("Estil");
        model.addColumn("Tipus");

        try {
            List<Producte> llRep = gbd.getListProducte();
            for (Producte p : llRep) {
                model.addRow(new Object[]{p.getTitol(), p.getActiu(), p.getEstil(), p.getEstat()});
            }
            tableProducte.setDefaultEditor(Object.class, null);
            tableProducte.setModel(model);
            return;
        } catch (GestorBDProducteJdbcException ex) {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProducte = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        BotoFiltre = new javax.swing.JButton();
        CrearButo = new javax.swing.JButton();
        ActualitzaBoto = new javax.swing.JButton();
        BorrarBoto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Titolbox = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Estilbox = new javax.swing.JLabel();
        Actiubox = new javax.swing.JLabel();
        Tiposbox = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableInfo = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Productes");

        tableProducte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProducteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProducte);

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

        jLabel1.setText("Titol");

        Titolbox.setText("jLabel3");

        jLabel3.setText("Actiu");

        jLabel4.setText("Estil");

        Estilbox.setText("jLabel3");

        Actiubox.setText("jLabel3");

        Tiposbox.setText("jLabel3");

        jLabel5.setText("Tipos");

        tableInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tableInfo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addComponent(Titolbox, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Estilbox, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Actiubox, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(36, 36, 36)
                                .addComponent(Tiposbox, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotoFiltre)
                            .addComponent(CrearButo)
                            .addComponent(ActualitzaBoto)
                            .addComponent(BorrarBoto))
                        .addGap(75, 75, 75))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Titolbox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Estilbox)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(Actiubox, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tiposbox)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
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

    private void tableProducteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProducteMouseClicked
        // TODO add your handling code here:

        String Tipus = tableProducte.getValueAt(tableProducte.getSelectedRow(), 3).toString();
        String titol = tableProducte.getValueAt(tableProducte.getSelectedRow(), 0).toString();

        System.out.println( titol +Tipus);

        
        
                info.setColumnCount(0);
                tableInfo.setModel(info);

                
                if (Tipus.equals("L")) {

                    
                    info.addColumn("Titol");
                    info.addColumn("Durada");
                    
                   try {
                    List<Llista> llRep = gbd.getLlista(titol);
                    for (Llista p : llRep) {
                      info.addRow(new Object[]{p.getTitol(),p.getDurada()});
                    }
                    tableInfo.setModel(info);
                    return;
                } catch (GestorBDReproduccioJdbcException ex) {
                    System.out.println("Problemes en efectuar la cerca.\n\nMotiu:\n\n" + ex.getMessage());
                }
                    

                }
                if (Tipus.equals("C")) {


                    info.addColumn("Any Creacio");
                    info.addColumn("Artista");
                    info.addColumn("Durada");

                    tableInfo.setModel(info);


                }
                if (Tipus.equals("A")) {

                    
                    info.addColumn("Any Creacio");
                    info.addColumn("Durada");

                    tableInfo.setModel(info);
                    
                }



    }//GEN-LAST:event_tableProducteMouseClicked

    private void filtre() {
        FProducte rep = new FProducte();
        rep.setSize(358, 226);
        rep.setLocation(0, 0);

        jPanel2.removeAll();
        jPanel2.add(rep, BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel2.repaint();
    }

    private void Crear() {
        CProducte rep = new CProducte();
        rep.setSize(358, 226);
        rep.setLocation(0, 0);

        jPanel2.removeAll();
        jPanel2.add(rep, BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel2.repaint();
    }

    private void Actualitza() {
        AProducte rep = new AProducte();
        rep.setSize(358, 226);
        rep.setLocation(0, 0);

        jPanel2.removeAll();
        jPanel2.add(rep, BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel2.repaint();
    }

    private void Borrar() {
        BProducte rep = new BProducte();
        rep.setSize(358, 226);
        rep.setLocation(0, 0);

        jPanel2.removeAll();
        jPanel2.add(rep, BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel2.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Actiubox;
    private javax.swing.JButton ActualitzaBoto;
    private javax.swing.JButton BorrarBoto;
    private javax.swing.JButton BotoFiltre;
    private javax.swing.JButton CrearButo;
    private javax.swing.JLabel Estilbox;
    private javax.swing.JLabel Tiposbox;
    private javax.swing.JLabel Titolbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableInfo;
    private javax.swing.JTable tableProducte;
    // End of variables declaration//GEN-END:variables
}
