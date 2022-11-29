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
import javax.swing.JOptionPane;
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
        bntFiltre.setEnabled(false);
        ActualitzaBoto.setEnabled(false);
        BorrarBoto.setEnabled(false);

    }
    private BDProducte gbd = null;
    private DefaultTableModel info = new DefaultTableModel();

    private void borrainfo() {

        Titolbox.setText("");
        Estilbox.setText("");
        Actiubox.setText("");
        Tiposbox.setText("");
        DuradaTxt.setText("");
        AnyTxt.setText("");
        artviw.setVisible(false);
        ArtTxt.setText("");

    }

    public void informacio() {

        ListSelectionModel listSelectionModel = tableProducte.getSelectionModel();
        listSelectionModel.addListSelectionListener(
                new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {

                Titolbox.setText(tableProducte.getValueAt(tableProducte.getSelectedRow(), 0).toString());
                Estilbox.setText(tableProducte.getValueAt(tableProducte.getSelectedRow(), 1).toString());
                Actiubox.setText(tableProducte.getValueAt(tableProducte.getSelectedRow(), 2).toString());

                String tip = tableProducte.getValueAt(tableProducte.getSelectedRow(), 3).toString();

                if (tip.equals("L")) {
                    Tiposbox.setText("Llista");
                }
                if (tip.equals("C")) {
                    Tiposbox.setText("Canço");
                }
                if (tip.equals("A")) {
                    Tiposbox.setText("Album");
                }

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
    DefaultTableModel model = new DefaultTableModel();

    private void ompletabla() {

        model.addColumn("Titol");
        model.addColumn("Actiu");
        model.addColumn("Estil");
        model.addColumn("Tipus");

        try {
            List<Producte> llRep = gbd.getListProducte();
            for (Producte p : llRep) {
                model.addRow(new Object[]{p.getTitol(), p.getActiu(), p.getEstil(), p.getEstat()});
            }
            tableInfo.setDefaultEditor(Object.class, null);
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
        jLabel6 = new javax.swing.JLabel();
        anyviw = new javax.swing.JLabel();
        DuradaTxt = new javax.swing.JLabel();
        AnyTxt = new javax.swing.JLabel();
        artviw = new javax.swing.JLabel();
        ArtTxt = new javax.swing.JLabel();
        bntFiltre = new javax.swing.JButton();
        Inactiurb = new javax.swing.JRadioButton();
        actiurb = new javax.swing.JRadioButton();
        Actiu_inacT_RB = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rbAlbum = new javax.swing.JRadioButton();
        RbLlista = new javax.swing.JRadioButton();
        rbCanco = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        txbtitiol = new javax.swing.JTextField();

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

        jLabel6.setText("Durada");

        anyviw.setText("Any Creacio");

        DuradaTxt.setText("jLabel3");

        AnyTxt.setText("jLabel3");

        artviw.setText("Artista");

        ArtTxt.setText("jLabel3");

        bntFiltre.setText("Filtres");
        bntFiltre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntFiltreActionPerformed(evt);
            }
        });

        Inactiurb.setText("Inactiu");
        Inactiurb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InactiurbActionPerformed(evt);
            }
        });

        actiurb.setText("Actiu");
        actiurb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actiurbActionPerformed(evt);
            }
        });

        Actiu_inacT_RB.setText("Actiu/Inactiu");
        Actiu_inacT_RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Actiu_inacT_RBActionPerformed(evt);
            }
        });

        jLabel7.setText("Actiu");

        jLabel8.setText("Tipus");

        rbAlbum.setText("Album");
        rbAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAlbumActionPerformed(evt);
            }
        });

        RbLlista.setText("Llista");
        RbLlista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RbLlistaActionPerformed(evt);
            }
        });

        rbCanco.setText("Canço");
        rbCanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCancoActionPerformed(evt);
            }
        });

        jLabel9.setText("Titol");

        txbtitiol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txbtitiolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bntFiltre))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(DuradaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(anyviw)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(AnyTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(Titolbox, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Estilbox, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(Actiubox, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(Tiposbox, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(artviw)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ArtTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Actiu_inacT_RB)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txbtitiol, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(actiurb)
                            .addComponent(Inactiurb)
                            .addComponent(RbLlista)
                            .addComponent(rbCanco)
                            .addComponent(rbAlbum))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CrearButo)
                            .addComponent(ActualitzaBoto)
                            .addComponent(BorrarBoto))
                        .addGap(75, 75, 75))
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
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
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(DuradaTxt))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(anyviw)
                                    .addComponent(AnyTxt)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(artviw)
                            .addComponent(ArtTxt)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bntFiltre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(txbtitiol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(CrearButo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(actiurb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Inactiurb)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(ActualitzaBoto)
                                .addGap(18, 18, 18)
                                .addComponent(BorrarBoto))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Actiu_inacT_RB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RbLlista)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbAlbum)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbCanco))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 600));
    }// </editor-fold>//GEN-END:initComponents

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


    }//GEN-LAST:event_BorrarBotoActionPerformed

    private void tableProducteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProducteMouseClicked
        // TODO add your handling code here:

        String Tipus = tableProducte.getValueAt(tableProducte.getSelectedRow(), 3).toString();
        String titol = tableProducte.getValueAt(tableProducte.getSelectedRow(), 0).toString();

        ActualitzaBoto.setEnabled(true);
        BorrarBoto.setEnabled(true);
        info.setColumnCount(0);
        tableInfo.setModel(info);
        artviw.setVisible(false);
        anyviw.setVisible(false);
        AnyTxt.setText("");
        ArtTxt.setText("");

        if (tableProducte.getSelectedRowCount() > 1) {
            JOptionPane.showMessageDialog(null, "No Pots Selecionar mes deuna fila a la vegada", "Error", JOptionPane.ERROR_MESSAGE);
            tableProducte.clearSelection();
            borrainfo();
        } else {
               
            if (Tipus.equals("L")) {

                info.setRowCount(0);
                info.addColumn("Tiol Canço");
                tableInfo.setModel(info);
                try {
                    List<Llista> llRep;
                    llRep = gbd.getLlista(titol);
                    List<Llista> ll = gbd.getLlistaCont(titol);

                    for (Llista p : llRep) {
                        DuradaTxt.setText("" + p.getDurada());
                    }
                    for (Llista p : ll) {
                        info.addRow(new Object[]{p.getTitol()});
                    }
                    tableInfo.setModel(info);
                    return;
                } catch (GestorBDProducteJdbcException ex) {
                    ex.printStackTrace();
                    System.out.println("Problemes en efectuar la cerca. " + Tipus + " \n\nMotiu:\n\n" + ex.getMessage());
                }
                tableInfo.setModel(info);

            }
            if (Tipus.equals("C")) {

                artviw.setVisible(true);
                anyviw.setVisible(true);

                try {
                    List<Canso> ll;
                    ll = gbd.getCanco(titol);

                    for (Canso p : ll) {

                        ArtTxt.setText(p.getArt());
                        AnyTxt.setText(p.getAnyCreacio());
                        DuradaTxt.setText("" + p.getDurada());
                    }

                    return;
                } catch (GestorBDProducteJdbcException ex) {
                    ex.printStackTrace();
                    System.out.println("Problemes en efectuar la cerca. " + Tipus + " \n\nMotiu:\n\n" + ex.getMessage());
                }

            }
            if (Tipus.equals("A")) {

                info.setRowCount(0);
                info.addColumn("Tiol Canço");
                tableInfo.setModel(info);
                anyviw.setVisible(true);

                try {
                    List<Album> ll;
                    ll = gbd.getAlbum(titol);
                    List<Album> llRep = gbd.getAlbumCont(titol);

                    for (Album p : ll) {
                        AnyTxt.setText(p.getDataCreacio());
                        DuradaTxt.setText("" + p.getDurada());
                    }
                    for (Album p : llRep) {
                        info.addRow(new Object[]{p.getTitol()});
                    }
                    tableInfo.setModel(info);

                    return;
                } catch (GestorBDProducteJdbcException ex) {
                    ex.printStackTrace();
                    System.out.println("Problemes en efectuar la cerca. " + Tipus + " \n\nMotiu:\n\n" + ex.getMessage());
                }

            }
        }


    }//GEN-LAST:event_tableProducteMouseClicked

    private void bntFiltreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntFiltreActionPerformed
        // TODO add your handling code here:

        String titol = null;
        String Actiu = null;
        String L = null;
        String C = null;
        String A = null;

        titol = txbtitiol.getText().toString();

        if (Inactiurb.isSelected()) {
            // System.out.println("inactiu");
            Actiu = "N";

        }
        if (Actiu_inacT_RB.isSelected()) {
            //  System.out.println("dos");
            Actiu = "dos";

        }
        if (actiurb.isSelected()) {
            //  System.out.println("actiu");
            Actiu = "S";
        }

        if (RbLlista.isSelected()) {
            // System.out.println("Llista");
            L = "L";
        }
        if (rbAlbum.isSelected()) {
            //System.out.println("Album");
            A = "A";
        }
        if (rbCanco.isSelected()) {
            // System.out.println("Canço");
            C = "C";
        }

        model.setRowCount(0);
        tableProducte.setModel(model);

        try {
            List<Producte> llRep = gbd.getFiltre(titol, C, A, L, Actiu);
            for (Producte p : llRep) {
                model.addRow(new Object[]{p.getTitol(), p.getActiu(), p.getEstil(), p.getEstat()});
            }
            tableInfo.setDefaultEditor(Object.class, null);
            tableProducte.setDefaultEditor(Object.class, null);
            tableProducte.setModel(model);
            return;
        } catch (GestorBDProducteJdbcException ex) {
            System.out.println("Problemes en efectuar la cerca.\n\nMotiu:\n\n" + ex.getMessage());
        }


    }//GEN-LAST:event_bntFiltreActionPerformed

    private void actiurbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actiurbActionPerformed
        // TODO add your handling code here:

        bntFiltre.setEnabled(true);
        Inactiurb.setSelected(false);
        Actiu_inacT_RB.setSelected(false);


    }//GEN-LAST:event_actiurbActionPerformed

    private void InactiurbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InactiurbActionPerformed
        // TODO add your handling code here:
        bntFiltre.setEnabled(true);
        actiurb.setSelected(false);
        Actiu_inacT_RB.setSelected(false);
    }//GEN-LAST:event_InactiurbActionPerformed

    private void Actiu_inacT_RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Actiu_inacT_RBActionPerformed
        // TODO add your handling code here:
        bntFiltre.setEnabled(true);
        Inactiurb.setSelected(false);
        actiurb.setSelected(false);
    }//GEN-LAST:event_Actiu_inacT_RBActionPerformed

    private void RbLlistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RbLlistaActionPerformed
        // TODO add your handling code here:
        if (RbLlista.isSelected()) {
            bntFiltre.setEnabled(true);
        }

    }//GEN-LAST:event_RbLlistaActionPerformed

    private void rbAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAlbumActionPerformed
        // TODO add your handling code here:
        if (rbAlbum.isSelected()) {
            bntFiltre.setEnabled(true);
        }

    }//GEN-LAST:event_rbAlbumActionPerformed

    private void rbCancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCancoActionPerformed
        // TODO add your handling code here:
        if (rbCanco.isSelected()) {
            bntFiltre.setEnabled(true);
        }
    }//GEN-LAST:event_rbCancoActionPerformed

    private void txbtitiolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txbtitiolActionPerformed
        // TODO add your handling code here:
        String titolemp = txbtitiol.getText().toString();
        if (!titolemp.isEmpty()) {

            bntFiltre.setEnabled(true);

        }
    }//GEN-LAST:event_txbtitiolActionPerformed

    private void Crear() {
        CProducte rep = new CProducte();
        rep.setSize(400, 300);
        rep.setLocation(0, 0);

        jPanel2.removeAll();
        jPanel2.add(rep, BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel2.repaint();
    }

    private void Actualitza() {
        AProducte rep = new AProducte(tableProducte.getValueAt(tableProducte.getSelectedRow(), 0).toString(), tableProducte.getValueAt(tableProducte.getSelectedRow(), 1).toString(), tableProducte.getValueAt(tableProducte.getSelectedRow(), 2).toString(), tableProducte.getValueAt(tableProducte.getSelectedRow(), 3).toString());
        rep.setSize(358, 226);
        rep.setLocation(0, 0);

        jPanel2.removeAll();
        jPanel2.add(rep, BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel2.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Actiu_inacT_RB;
    private javax.swing.JLabel Actiubox;
    private javax.swing.JButton ActualitzaBoto;
    private javax.swing.JLabel AnyTxt;
    private javax.swing.JLabel ArtTxt;
    private javax.swing.JButton BorrarBoto;
    private javax.swing.JButton CrearButo;
    private javax.swing.JLabel DuradaTxt;
    private javax.swing.JLabel Estilbox;
    private javax.swing.JRadioButton Inactiurb;
    private javax.swing.JRadioButton RbLlista;
    private javax.swing.JLabel Tiposbox;
    private javax.swing.JLabel Titolbox;
    private javax.swing.JRadioButton actiurb;
    private javax.swing.JLabel anyviw;
    private javax.swing.JLabel artviw;
    private javax.swing.JButton bntFiltre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbAlbum;
    private javax.swing.JRadioButton rbCanco;
    private javax.swing.JTable tableInfo;
    private javax.swing.JTable tableProducte;
    private javax.swing.JTextField txbtitiol;
    // End of variables declaration//GEN-END:variables
}
