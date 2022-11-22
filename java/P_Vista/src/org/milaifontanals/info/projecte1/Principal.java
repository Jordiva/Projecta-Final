/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.milaifontanals.info.projecte1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joval
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
        private BDReproduccio gbd = null;

    public Principal() {
        
        initComponents();
        Conection();
    }

    public void setConection(BDReproduccio cbd) {

        cbd = gbd;

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
        jMenuBar1 = new javax.swing.JMenuBar();
        artisteMenu = new javax.swing.JMenu();
        paisosMenu = new javax.swing.JMenuItem();
        catalegMenu = new javax.swing.JMenu();
        estilsMenu = new javax.swing.JMenuItem();
        producteMenu = new javax.swing.JMenuItem();
        clientMenu = new javax.swing.JMenu();
        paisosMenu1 = new javax.swing.JMenuItem();
        eliminarClientMenu = new javax.swing.JMenuItem();
        reproduccionsMenu = new javax.swing.JMenu();
        ajudaMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 833, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        jMenuBar1.setBorder(null);
        jMenuBar1.setAlignmentX(1.0F);
        jMenuBar1.setAlignmentY(1.0F);
        jMenuBar1.setRequestFocusEnabled(false);

        artisteMenu.setText("Artiste");
        artisteMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        artisteMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                artisteMenuMouseEntered(evt);
            }
        });

        paisosMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        paisosMenu.setText("Paisos");
        paisosMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paisosMenuMousePressed(evt);
            }
        });
        paisosMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paisosMenuActionPerformed(evt);
            }
        });
        artisteMenu.add(paisosMenu);

        jMenuBar1.add(artisteMenu);

        catalegMenu.setText("Cataleg");
        catalegMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        catalegMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                catalegMenuMouseEntered(evt);
            }
        });

        estilsMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        estilsMenu.setText("Estils");
        estilsMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                estilsMenuMousePressed(evt);
            }
        });
        catalegMenu.add(estilsMenu);

        producteMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        producteMenu.setText("Producte");
        producteMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                producteMenuActionPerformed(evt);
            }
        });
        catalegMenu.add(producteMenu);

        jMenuBar1.add(catalegMenu);

        clientMenu.setText("Client");
        clientMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        clientMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clientMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clientMenuMouseEntered(evt);
            }
        });

        paisosMenu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        paisosMenu1.setText("Paisos");
        paisosMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                paisosMenu1MousePressed(evt);
            }
        });
        clientMenu.add(paisosMenu1);

        eliminarClientMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        eliminarClientMenu.setText("Eliminar Client");
        clientMenu.add(eliminarClientMenu);

        jMenuBar1.add(clientMenu);

        reproduccionsMenu.setText("Reproduccions");
        reproduccionsMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        reproduccionsMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reproduccionsMenuMouseClicked(evt);
            }
        });
        reproduccionsMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reproduccionsMenuActionPerformed(evt);
            }
        });
        jMenuBar1.add(reproduccionsMenu);

        ajudaMenu.setText("Ajuda");
        ajudaMenu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenuBar1.add(ajudaMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void producteMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_producteMenuActionPerformed
        // TODO add your handling code here:
        productes();
    }//GEN-LAST:event_producteMenuActionPerformed

    private void reproduccionsMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reproduccionsMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reproduccionsMenuActionPerformed

    private void reproduccionsMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reproduccionsMenuMouseClicked
        // TODO add your handling code here:
        reproduccions();
    }//GEN-LAST:event_reproduccionsMenuMouseClicked

    private void paisosMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paisosMenuMousePressed
        todo();
    }//GEN-LAST:event_paisosMenuMousePressed

    private void estilsMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estilsMenuMousePressed
        // TODO add your handling code here:
        todo();
    }//GEN-LAST:event_estilsMenuMousePressed

    private void paisosMenu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paisosMenu1MousePressed
        // TODO add your handling code here:
        todo();
    }//GEN-LAST:event_paisosMenu1MousePressed

    private void clientMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientMenuMouseClicked
        // TODO add your handling code here:
        todo();
    }//GEN-LAST:event_clientMenuMouseClicked

    private void artisteMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_artisteMenuMouseEntered
        // TODO add your handling code here:
        artisteMenu.doClick();
    }//GEN-LAST:event_artisteMenuMouseEntered

    private void clientMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientMenuMouseEntered
        // TODO add your handling code here:
        clientMenu.doClick();
    }//GEN-LAST:event_clientMenuMouseEntered

    private void catalegMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_catalegMenuMouseEntered
        // TODO add your handling code here:
        catalegMenu.doClick();
    }//GEN-LAST:event_catalegMenuMouseEntered

    private void paisosMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paisosMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paisosMenuActionPerformed

    private void todo() {
        TODO t = new TODO();
        t.setSize(845, 594);
        t.setLocation(0, 0);

        jPanel1.removeAll();
        jPanel1.add(t, BorderLayout.CENTER);
        jPanel1.revalidate();
        jPanel1.repaint();
    }

    private void reproduccions() {
        PReproduccions rep = new PReproduccions();
        rep.setSize(845, 594);
        rep.setLocation(0, 0);

        jPanel1.removeAll();
        jPanel1.add(rep, BorderLayout.CENTER);
        jPanel1.revalidate();
        jPanel1.repaint();

    }
    
    private void productes() {
        PProducte rep = new PProducte();
        setSize(904, 648);
        rep.setSize(904, 648);
        rep.setLocation(0, 0);

        jPanel1.removeAll();
        jPanel1.add(rep, BorderLayout.CENTER);
        jPanel1.revalidate();
        jPanel1.repaint();

    }

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ajudaMenu;
    private javax.swing.JMenu artisteMenu;
    private javax.swing.JMenu catalegMenu;
    private javax.swing.JMenu clientMenu;
    private javax.swing.JMenuItem eliminarClientMenu;
    private javax.swing.JMenuItem estilsMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem paisosMenu;
    private javax.swing.JMenuItem paisosMenu1;
    private javax.swing.JMenuItem producteMenu;
    private javax.swing.JMenu reproduccionsMenu;
    // End of variables declaration//GEN-END:variables
}
