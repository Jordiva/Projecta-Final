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
        visible();
        OmpleEstils();
//        informacio();
        bntFiltre.setEnabled(false);
        ActualitzaBoto.setEnabled(false);
        BorrarBoto.setEnabled(false);
        ACboton.setVisible(false);
        BorraCoontingut.setVisible(false);


    }
    private DefaultTableModel info = new DefaultTableModel();

    private void borrainfo() {

        Titolbox.setText("");
        Actiubox.setText("");
        Estilbox.setText("");
        Tiposbox.setText("");
        DuradaTxt.setText("");
        AnyTxt.setText("");
        artviw.setVisible(false);
        ArtTxt.setText("");

    }

    private void visible() {
        txtTitol.setVisible(false);
        Edititle.setVisible(false);
        txtActiu.setVisible(false);
        Si.setVisible(false);
        No.setVisible(false);
        txtEstil.setVisible(false);
        cmbEstil.setVisible(false);
        TD.setVisible(false);
        txtDurada.setVisible(false);
        txtCA.setVisible(false);
        cmbCreacioLlistaContingut.setVisible(false);
        butncontingut.setVisible(false);
        rLlista.setVisible(false);
        rAlbum.setVisible(false);
        rCanço.setVisible(false);
        tableInfoLlistaAlbum.setVisible(false);
    }

//    public void informacio() {
//
//        ListSelectionModel listSelectionModel = tableProducte.getSelectionModel();
//        listSelectionModel.addListSelectionListener(
//                new ListSelectionListener() {
//            @Override
//            public void valueChanged(ListSelectionEvent arg0) {
//
//                Titolbox.setText(tableProducte.getValueAt(tableProducte.getSelectedRow(), 0).toString());
//                Estilbox.setText(tableProducte.getValueAt(tableProducte.getSelectedRow(), 1).toString());
//                Actiubox.setText(tableProducte.getValueAt(tableProducte.getSelectedRow(), 2).toString());
//
//                String tip = tableProducte.getValueAt(tableProducte.getSelectedRow(), 3).toString();
//
//                if (tip.equals("L")) {
//                    Tiposbox.setText("Llista");
//                }
//                if (tip.equals("C")) {
//                    Tiposbox.setText("Canço");
//                }
//                if (tip.equals("A")) {
//                    Tiposbox.setText("Album");
//                }
//
//            }
//
//        });
//
//    }
    private void Conection() {

        try {
            ConexioGeneral.getConnection();
        } catch (GestorBDExceptionTOT ex) {
            System.out.println("Error a connectar " + ex.getMessage());
        }

    }
    DefaultTableModel model = new DefaultTableModel();

    private void ompletabla() {

        model.addColumn("Titol");
        model.addColumn("Actiu");
        model.addColumn("Estil");
        model.addColumn("Tipus");

        try {
            List<Producte> llRep = BDProducte.getListProducte();
            for (Producte p : llRep) {
                model.addRow(new Object[]{p.getTitol(), p.getActiu(), p.getEstil(), p.getEstat()});
            }
            tableInfoLlistaAlbum.setDefaultEditor(Object.class, null);
            tableProducte.setDefaultEditor(Object.class, null);
            tableProducte.setModel(model);
            return;
        } catch (GestorBDExceptionTOT ex) {
            System.out.println("Problemes en efectuar la cerca.\n\nMotiu:\n\n" + ex.getMessage());
        }

    }

    private void ompletablaInformcaio() {

        try {
            List<Producte> llRep = BDProducte.getListProducte();
            for (Producte p : llRep) {
                model.addRow(new Object[]{p.getTitol(), p.getActiu(), p.getEstil(), p.getEstat()});
            }
            tableInfoLlistaAlbum.setDefaultEditor(Object.class, null);
            tableProducte.setDefaultEditor(Object.class, null);
            tableProducte.setModel(model);
            return;
        } catch (GestorBDExceptionTOT ex) {
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
        Actiubox = new javax.swing.JLabel();
        Estilbox = new javax.swing.JLabel();
        Tiposbox = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableInfoLlistaAlbum = new javax.swing.JTable();
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
        cambis = new javax.swing.JButton();
        Rollback = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableInfo = new javax.swing.JTable();
        rAlbum = new javax.swing.JRadioButton();
        rLlista = new javax.swing.JRadioButton();
        rCanço = new javax.swing.JRadioButton();
        txtTitol = new javax.swing.JLabel();
        txtActiu = new javax.swing.JLabel();
        Edititle = new javax.swing.JTextField();
        Si = new javax.swing.JRadioButton();
        No = new javax.swing.JRadioButton();
        txtEstil = new javax.swing.JLabel();
        cmbEstil = new javax.swing.JComboBox<>();
        TD = new javax.swing.JLabel();
        txtDurada = new javax.swing.JTextField();
        cmbCreacioLlistaContingut = new javax.swing.JComboBox<>();
        txtCA = new javax.swing.JLabel();
        butncontingut = new javax.swing.JButton();
        ACboton = new javax.swing.JButton();
        BorraCoontingut = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Productes");

        tableProducte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableProducteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableProducte);

        jPanel2.setPreferredSize(new java.awt.Dimension(488, 300));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 666, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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

        Actiubox.setText("jLabel3");

        Estilbox.setText("jLabel3");

        Tiposbox.setText("jLabel3");

        jLabel5.setText("Tipos");

        tableInfoLlistaAlbum.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableInfoLlistaAlbum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableInfoLlistaAlbumMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableInfoLlistaAlbum);

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

        cambis.setText("Validar Cambis");
        cambis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambisActionPerformed(evt);
            }
        });

        Rollback.setText("Rolleback");
        Rollback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RollbackActionPerformed(evt);
            }
        });

        tableInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tableInfo);

        rAlbum.setText("Album");
        rAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rAlbumActionPerformed(evt);
            }
        });

        rLlista.setText("Llista");
        rLlista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rLlistaActionPerformed(evt);
            }
        });

        rCanço.setText("Canço");
        rCanço.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rCançoActionPerformed(evt);
            }
        });

        txtTitol.setText("Titol");

        txtActiu.setText("Actiu");

        Si.setText("S");
        Si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiActionPerformed(evt);
            }
        });

        No.setText("N");
        No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoActionPerformed(evt);
            }
        });

        txtEstil.setText("Estil");

        cmbEstil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEstil.setSelectedIndex(1);
        cmbEstil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstilActionPerformed(evt);
            }
        });

        TD.setText("Durada");

        txtDurada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuradaActionPerformed(evt);
            }
        });

        cmbCreacioLlistaContingut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCreacioLlistaContingut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCreacioLlistaContingutActionPerformed(evt);
            }
        });

        txtCA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCA.setText("Canço/Album");

        butncontingut.setText("Afagi Contingut");
        butncontingut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butncontingutActionPerformed(evt);
            }
        });

        ACboton.setText("Actualitza");
        ACboton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ACbotonActionPerformed(evt);
            }
        });

        BorraCoontingut.setText("Borra Contingut");
        BorraCoontingut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorraCoontingutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Titolbox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Tiposbox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Actiubox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Estilbox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(artviw)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ArtTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cambis)
                                .addGap(26, 26, 26)
                                .addComponent(Rollback)
                                .addGap(223, 223, 223)
                                .addComponent(bntFiltre))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbCanco)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Actiu_inacT_RB)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txbtitiol, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(actiurb)
                                    .addComponent(Inactiurb)
                                    .addComponent(RbLlista)
                                    .addComponent(rbAlbum)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CrearButo)
                                    .addComponent(BorrarBoto)
                                    .addComponent(ActualitzaBoto))))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(50, 50, 50)
                                            .addComponent(txtTitol)
                                            .addGap(22, 22, 22)
                                            .addComponent(Edititle, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(58, 58, 58)
                                            .addComponent(txtActiu)
                                            .addGap(18, 18, 18)
                                            .addComponent(Si)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(No)))
                                    .addGap(75, 75, 75)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TD)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addComponent(txtEstil)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtDurada, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbEstil, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(100, 100, 100)
                                    .addComponent(rAlbum)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(rLlista)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rCanço)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmbCreacioLlistaContingut, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(butncontingut)
                                .addComponent(txtCA)))
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ACboton)
                            .addComponent(BorraCoontingut))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Titolbox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Actiubox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(Estilbox))
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
                                    .addComponent(AnyTxt))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(artviw)
                                    .addComponent(ArtTxt))))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bntFiltre)
                        .addComponent(cambis)
                        .addComponent(Rollback))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(txbtitiol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(actiurb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Inactiurb)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Actiu_inacT_RB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RbLlista)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbAlbum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbCanco))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CrearButo)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtTitol)
                                        .addComponent(Edititle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtActiu, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Si)
                                    .addComponent(No)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCA)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbCreacioLlistaContingut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(butncontingut))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtEstil)
                                            .addComponent(cmbEstil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(TD)
                                            .addComponent(txtDurada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ActualitzaBoto)
                                .addGap(18, 18, 18)
                                .addComponent(BorrarBoto)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rAlbum)
                                    .addComponent(rLlista)
                                    .addComponent(rCanço))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(ACboton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                                .addComponent(BorraCoontingut)
                                .addGap(55, 55, 55))))))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 650));
    }// </editor-fold>//GEN-END:initComponents

    private void CrearButoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearButoActionPerformed
        // TODO add your handling code here:

        Crear();
    }//GEN-LAST:event_CrearButoActionPerformed

    String Atitol;
    int durada;
    boolean fet = false;

    private void ActualitzaBotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualitzaBotoActionPerformed

        fet = true;
BorraCoontingut.setVisible(true);
        // TODO add your handling code here:
        txtTitol.setVisible(true);
        Edititle.setVisible(true);
        txtActiu.setVisible(true);
        Si.setVisible(true);
        No.setVisible(true);
        txtEstil.setVisible(true);
        cmbEstil.setVisible(true);
        TD.setVisible(true);
        txtDurada.setVisible(true);
        rLlista.setVisible(true);
        rAlbum.setVisible(true);
        rCanço.setVisible(true);
        ACboton.setVisible(true);

        if (Tipus.equals("L")) {
            txtCA.setVisible(true);
            cmbCreacioLlistaContingut.setVisible(true);
            butncontingut.setVisible(true);
        }
        if (Tipus.equals("A")) {
            txtCA.setVisible(true);
            cmbCreacioLlistaContingut.setVisible(true);
            butncontingut.setVisible(true);
        }
        if (Tipus.equals("C")) {
            txtCA.setVisible(false);
            cmbCreacioLlistaContingut.setVisible(false);
            butncontingut.setVisible(false);
        }

        tableInfoLlistaAlbum.setVisible(true);


    }//GEN-LAST:event_ActualitzaBotoActionPerformed
    String titol;

    private void ompleAC() {
        cmbCreacioLlistaContingut.removeAllItems();

        try {
            List<Producte> llEs = BDProducte.getListCancoAlbum();
            for (Producte p : llEs) {
                cmbCreacioLlistaContingut.addItem(p.toString());
            }
            return;
        } catch (GestorBDExceptionTOT ex) {
            System.out.println("Problemes en efectuar la cerca.\n\nMotiu:\n\n" + ex.getMessage());
        }
    }

    private void ompleACA() {
        cmbCreacioLlistaContingut.removeAllItems();

        try {
            List<Producte> llEs = BDProducte.getListAlbumOmpli();
            for (Producte p : llEs) {
                cmbCreacioLlistaContingut.addItem(p.toString());
            }
            return;
        } catch (GestorBDExceptionTOT ex) {
            System.out.println("Problemes en efectuar la cerca.\n\nMotiu:\n\n" + ex.getMessage());
        }
    }

    private void OmpleEstils() {

        cmbEstil.removeAllItems();
        try {
            List<Estil> llEs = BDProducte.getListEstils();
            for (Estil p : llEs) {
                cmbEstil.addItem(p.toString());
            }

            return;
        } catch (GestorBDExceptionTOT ex) {
            System.out.println("Problemes en efectuar la cerca.\n\nMotiu:\n\n" + ex.getMessage());
        }
    }

    private void BorrarBotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarBotoActionPerformed
        // TODO add your handling code here:

        int i = JOptionPane.showConfirmDialog(null, "Estas Segur de borra ?");
        String opcions = Tiposbox.getText().toString();

        if (i == 0) {
            System.out.println("0");

            if (opcions.equals("Canço")) {
                try {
                    BDProducte.borraCanço(titol);
                } catch (GestorBDExceptionTOT ex) {
                    JOptionPane.showMessageDialog(null, "No sa pugut borrar Canço te contingut", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            if (opcions.equals("Album")) {
                try {
                    BDProducte.borraAlbum(titol);
                } catch (GestorBDExceptionTOT ex) {
                    JOptionPane.showMessageDialog(null, "No sa pugut borrar Album te continugt", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
            if (opcions.equals("Llista")) {

                try {
                    BDProducte.borraLlista(titol);
                } catch (GestorBDExceptionTOT ex) {
                    JOptionPane.showMessageDialog(null, "No sa pugut borrar Llista te contingut", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            try {
                BDProducte.borra(titol);
                borrainfo();

                // model.removeRow(tableProducte.getSelectedRow());
                //tableProducte.setModel(model);
            } catch (GestorBDExceptionTOT ex) {
                JOptionPane.showMessageDialog(null, "No sa pugut borrar", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        if (i == 1) {
            System.out.println("1");
        }
        if (i == 2) {
            System.out.println("3");
        }


    }//GEN-LAST:event_BorrarBotoActionPerformed
    String Tipus;
    String borr;
    private void tableProducteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableProducteMouseClicked
        // TODO add your handling code here:

        Tipus = tableProducte.getValueAt(tableProducte.getSelectedRow(), 3).toString();
        titol = tableProducte.getValueAt(tableProducte.getSelectedRow(), 0).toString();

        ActualitzaBoto.setEnabled(true);
        BorrarBoto.setEnabled(true);
        info.setColumnCount(0);
        tableInfoLlistaAlbum.setModel(info);

        artviw.setVisible(false);
        anyviw.setVisible(false);
        AnyTxt.setText("");
        ArtTxt.setText("");
        Titolbox.setText(tableProducte.getValueAt(tableProducte.getSelectedRow(), 0).toString());
        Actiubox.setText(tableProducte.getValueAt(tableProducte.getSelectedRow(), 1).toString());
        Estilbox.setText(tableProducte.getValueAt(tableProducte.getSelectedRow(), 2).toString());

        String act = tableProducte.getValueAt(tableProducte.getSelectedRow(), 1).toString();

        int dura;

        int i = info.getRowCount();

        Atitol = tableProducte.getValueAt(tableProducte.getSelectedRow(), 0).toString();

        Edititle.setText(Atitol);

        String tip = tableProducte.getValueAt(tableProducte.getSelectedRow(), 3).toString();

        String a = tableProducte.getValueAt(tableProducte.getSelectedRow(), 2).toString();
        if (a.equals("trap")) {
            cmbEstil.setSelectedIndex(0);
        }
        if (a.equals("rock")) {
            cmbEstil.setSelectedIndex(1);
        }
        if (a.equals("pop")) {
            cmbEstil.setSelectedIndex(2);
        }

        if (act.equals("S")) {
            Si.setSelected(true);
            No.setSelected(false);
        }
        if (act.equals("N")) {
            No.setSelected(true);
            Si.setSelected(false);

        }

        if (tip.equals("L")) {
            Tiposbox.setText("Llista");
            txtDurada.setEditable(false);
                    BorraCoontingut.setVisible(true);


        }
        if (tip.equals("C")) {
            Tiposbox.setText("Canço");
            txtDurada.setEditable(true);
        BorraCoontingut.setVisible(false);

        }
        if (tip.equals("A")) {
            Tiposbox.setText("Album");
            txtDurada.setEditable(false);
            BorraCoontingut.setVisible(true);


        }

        if (tableProducte.getSelectedRowCount() > 1) {
            JOptionPane.showMessageDialog(null, "No Pots Selecionar mes deuna fila a la vegada", "Error", JOptionPane.ERROR_MESSAGE);
            tableProducte.clearSelection();
            borrainfo();
        } else {

            if (Tipus.equals("L")) {
                if (fet) {
                    txtCA.setVisible(true);
                    cmbCreacioLlistaContingut.setVisible(true);
                    butncontingut.setVisible(true);

                }

                info.setRowCount(0);
                info.addColumn("Tiol Canço");
                tableInfo.setModel(info);
                ompleAC();
                System.out.println(i);
                if (i > 0) {
                    rAlbum.setSelected(false);
                    rCanço.setSelected(false);
                    rLlista.setSelected(true);
                    rLlista.setEnabled(false);
                    rCanço.setEnabled(false);
                    rAlbum.setEnabled(false);
                }
                ompleAC();
                try {
                    List<Llista> llRep;
                    llRep = BDProducte.getLlista(titol);
                    List<Llista> ll = BDProducte.getLlistaCont(titol);

                    for (Llista p : llRep) {
                        DuradaTxt.setText("" + p.getDurada());
                        txtDurada.setText("" + p.getDurada());
                    }
                    for (Llista p : ll) {
                        info.addRow(new Object[]{p.getTitol()});
                    }
                    tableInfo.setModel(info);

                    return;
                } catch (GestorBDExceptionTOT ex) {
                    ex.printStackTrace();
                    System.out.println("Problemes en efectuar la cerca. " + Tipus + " \n\nMotiu:\n\n" + ex.getMessage());
                }
                tableInfo.setModel(info);

            }
            if (Tipus.equals("C")) {
                if (fet) {
                    txtCA.setVisible(false);
                    cmbCreacioLlistaContingut.setVisible(false);
                    butncontingut.setVisible(false);
                }

                artviw.setVisible(true);
                anyviw.setVisible(true);

                rAlbum.setSelected(false);
                rCanço.setSelected(true);
                rLlista.setSelected(false);
                rLlista.setEnabled(false);
                rCanço.setEnabled(false);
                rAlbum.setEnabled(false);

                try {
                    List<Canso> ll;
                    ll = BDProducte.getCanco(titol);

                    for (Canso p : ll) {

                        ArtTxt.setText(p.getArt());
                        AnyTxt.setText(p.getAnyCreacio());
                        DuradaTxt.setText("" + p.getDurada());
                        dura = p.getDurada();
                        System.out.println(dura);
                        txtDurada.setText("" + p.getDurada());
                    }

                    return;
                } catch (GestorBDExceptionTOT ex) {
                    ex.printStackTrace();
                    System.out.println("Problemes en efectuar la cerca. " + Tipus + " \n\nMotiu:\n\n" + ex.getMessage());
                }

            }
            if (Tipus.equals("A")) {

                if (fet) {
                    txtCA.setVisible(true);
                    cmbCreacioLlistaContingut.setVisible(true);
                    butncontingut.setVisible(true);

                }
                info.setRowCount(0);
                info.addColumn("Tiol Canço");

                tableInfo.setModel(info);
                anyviw.setVisible(true);
                ompleACA();

                if (i > 0) {
                    rAlbum.setSelected(true);
                    rCanço.setSelected(false);
                    rLlista.setSelected(false);
                    rLlista.setEnabled(false);
                    rCanço.setEnabled(false);
                    rAlbum.setEnabled(false);

                }

                try {
                    List<Album> ll;
                    ll = BDProducte.getAlbum(titol);
                    List<Album> llRep = BDProducte.getAlbumCont(titol);

                    for (Album p : ll) {
                        AnyTxt.setText(p.getDataCreacio());
                        DuradaTxt.setText("" + p.getDurada());
                        txtDurada.setText("" + p.getDurada());
                    }
                    for (Album p : llRep) {
                        info.addRow(new Object[]{p.getTitol()});
                    }
                    tableInfo.setModel(info);

                    return;
                } catch (GestorBDExceptionTOT ex) {
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
            List<Producte> llRep = BDProducte.getFiltre(titol, C, A, L, Actiu);
            for (Producte p : llRep) {
                model.addRow(new Object[]{p.getTitol(), p.getActiu(), p.getEstil(), p.getEstat()});
            }
            tableInfo.setDefaultEditor(Object.class, null);
            tableProducte.setDefaultEditor(Object.class, null);
            tableProducte.setModel(model);
            return;
        } catch (GestorBDExceptionTOT ex) {
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

    private void RollbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RollbackActionPerformed
        try {
            model.setColumnCount(0);

            model.setRowCount(0);
            tableProducte.setModel(model);
            ConexioGeneral.desferCanvis();
            ompletabla();
        } catch (GestorBDExceptionTOT ex) {
            System.out.println("Eroor a fer el rrollback");
        }


    }//GEN-LAST:event_RollbackActionPerformed

    private void cambisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambisActionPerformed
        // TODO add your handling code here:
        try {
            model.setColumnCount(0);
            model.setRowCount(0);
            tableProducte.setModel(model);
            ConexioGeneral.validarCanvis();
            ompletabla();

        } catch (GestorBDExceptionTOT ex) {
            System.out.println("Eroor a fer el rrollback");
        }

    }//GEN-LAST:event_cambisActionPerformed

    private void cmbEstilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstilActionPerformed

    private void cmbCreacioLlistaContingutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCreacioLlistaContingutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCreacioLlistaContingutActionPerformed

    private void butncontingutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butncontingutActionPerformed
        // TODO add your handling code here:

        String can = cmbCreacioLlistaContingut.getSelectedItem().toString();

        if (tt == null) {
            if (rLlista.isSelected()) {
                try {
                    BDProducte.Insertar_producteLlista(titol, can);
                } catch (GestorBDExceptionTOT ex) {
                    System.out.println("Error al crear el producte Canço " + ex.getMessage());
                }
            }
            if (rAlbum.isSelected()) {
                try {
                    BDProducte.Insertar_producteAlbum(titol, can);
                } catch (GestorBDExceptionTOT ex) {
                    System.out.println("Error al crear el producte Canço " + ex.getMessage());
                }
            }
        } else {
            if (rLlista.isSelected()) {
                try {
                    BDProducte.Insertar_producteLlista(tt, can);
                } catch (GestorBDExceptionTOT ex) {
                    System.out.println("Error al crear el producte Canço " + ex.getMessage());
                }
            }
            if (rAlbum.isSelected()) {
                try {
                    BDProducte.Insertar_producteAlbum(tt, can);
                } catch (GestorBDExceptionTOT ex) {
                    System.out.println("Error al crear el producte Canço " + ex.getMessage());
                }
            }
        }


    }//GEN-LAST:event_butncontingutActionPerformed

    private void txtDuradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuradaActionPerformed

    private void rAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rAlbumActionPerformed
        // TODO add your handling code here:

        rLlista.setSelected(false);
        rCanço.setSelected(false);

    }//GEN-LAST:event_rAlbumActionPerformed

    private void SiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiActionPerformed
        // TODO add your handling code here:

        No.setSelected(false);
    }//GEN-LAST:event_SiActionPerformed

    private void NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoActionPerformed
        // TODO add your handling code here:
        Si.setSelected(false);
    }//GEN-LAST:event_NoActionPerformed

    private void rLlistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rLlistaActionPerformed
        // TODO add your handling code here:

        rCanço.setSelected(false);
        rAlbum.setSelected(false);

    }//GEN-LAST:event_rLlistaActionPerformed

    private void rCançoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rCançoActionPerformed
        // TODO add your handling code here:
        rLlista.setSelected(false);
        rAlbum.setSelected(false);
    }//GEN-LAST:event_rCançoActionPerformed
    String tt;
    private void ACbotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ACbotonActionPerformed
        // TODO add your handling code here:

        String estil = cmbEstil.getSelectedItem().toString();
        String A = null;

        if (Si.isSelected()) {
            A = "S";
        }
        if (No.isSelected()) {
            A = "N";
        }

        durada = Integer.parseInt(txtDurada.getText().toString());

        tt = Edititle.getText().toString();

        System.out.println(tt);
        System.out.println(A);
        System.out.println(estil);
        System.out.println(Tipus);
        System.out.println(durada);

        try {
            BDProducte.updateProducte(titol, tt, A, estil, Tipus, durada);

        } catch (GestorBDExceptionTOT e) {
            System.out.println("Error a update" + e);
        }


    }//GEN-LAST:event_ACbotonActionPerformed

    private void tableInfoLlistaAlbumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableInfoLlistaAlbumMouseClicked
        // TODO add your handling code here:

        borr = tableInfoLlistaAlbum.getValueAt(tableInfoLlistaAlbum.getSelectedRow(), 0).toString();
        System.out.println(borr);


    }//GEN-LAST:event_tableInfoLlistaAlbumMouseClicked

    private void BorraCoontingutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorraCoontingutActionPerformed
        // TODO add your handling code here:

        System.out.println(titol);

        if (Tipus.equals("L")) {
            try {
                BDProducte.borraLlistaContingut(borr, tt);
            } catch (GestorBDExceptionTOT e) {
                System.out.println("Borra error llista contingut" + e);
            }

        }
        if (Tipus.equals("A")) {
            try {
                BDProducte.borraAlbuContingut(borr, tt);
            } catch (GestorBDExceptionTOT e) {
                System.out.println("Error borra album contingut"+e);
            }

        }


    }//GEN-LAST:event_BorraCoontingutActionPerformed

    private void Crear() {
        CProducte rep = new CProducte();
        rep.setSize(666, 300);
        rep.setLocation(0, 0);

        jPanel2.removeAll();
        jPanel2.add(rep, BorderLayout.CENTER);
        jPanel2.revalidate();
        jPanel2.repaint();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ACboton;
    private javax.swing.JRadioButton Actiu_inacT_RB;
    private javax.swing.JLabel Actiubox;
    private javax.swing.JButton ActualitzaBoto;
    private javax.swing.JLabel AnyTxt;
    private javax.swing.JLabel ArtTxt;
    private javax.swing.JButton BorraCoontingut;
    private javax.swing.JButton BorrarBoto;
    private javax.swing.JButton CrearButo;
    private javax.swing.JLabel DuradaTxt;
    private javax.swing.JTextField Edititle;
    private javax.swing.JLabel Estilbox;
    private javax.swing.JRadioButton Inactiurb;
    private javax.swing.JRadioButton No;
    private javax.swing.JRadioButton RbLlista;
    private javax.swing.JButton Rollback;
    private javax.swing.JRadioButton Si;
    private javax.swing.JLabel TD;
    private javax.swing.JLabel Tiposbox;
    private javax.swing.JLabel Titolbox;
    private javax.swing.JRadioButton actiurb;
    private javax.swing.JLabel anyviw;
    private javax.swing.JLabel artviw;
    private javax.swing.JButton bntFiltre;
    private javax.swing.JButton butncontingut;
    private javax.swing.JButton cambis;
    private javax.swing.JComboBox<String> cmbCreacioLlistaContingut;
    private javax.swing.JComboBox<String> cmbEstil;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rAlbum;
    private javax.swing.JRadioButton rCanço;
    private javax.swing.JRadioButton rLlista;
    private javax.swing.JRadioButton rbAlbum;
    private javax.swing.JRadioButton rbCanco;
    private javax.swing.JTable tableInfo;
    private javax.swing.JTable tableInfoLlistaAlbum;
    private javax.swing.JTable tableProducte;
    private javax.swing.JTextField txbtitiol;
    private javax.swing.JLabel txtActiu;
    private javax.swing.JLabel txtCA;
    private javax.swing.JTextField txtDurada;
    private javax.swing.JLabel txtEstil;
    private javax.swing.JLabel txtTitol;
    // End of variables declaration//GEN-END:variables
}
