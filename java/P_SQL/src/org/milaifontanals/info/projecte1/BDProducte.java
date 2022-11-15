/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.milaifontanals.info.projecte1;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author joval
 */
public class BDProducte {

    private Connection conn;

    private PreparedStatement qAddReproduccio;
    private PreparedStatement qUpdReproduccio;
    private PreparedStatement qDelReproduccio;

    public BDProducte() throws GestorBDProducteJdbcException {
        this("Oracle.properties");
    }

    public BDProducte(String nomFitxerPropietats) throws GestorBDProducteJdbcException {
        try {
            Properties props = new Properties();
            props.load(new FileInputStream(nomFitxerPropietats));
            String[] claus = {"url", "user", "password"};
            String[] valors = new String[3];
            for (int i = 0; i < claus.length; i++) {
                valors[i] = props.getProperty(claus[i]);
                if (valors[i] == null || valors[i].isEmpty()) {
                    throw new GestorBDProducteJdbcException("L'arxiu " + nomFitxerPropietats + " no troba la clau " + claus[i]);
                }
            }
            conn = DriverManager.getConnection(valors[0], valors[1], valors[2]);
            conn.setAutoCommit(false);
        } catch (IOException ex) {
            throw new GestorBDProducteJdbcException("Problemes en recuperar l'arxiu de configuració " + nomFitxerPropietats + "\n" + ex.getMessage());
        } catch (SQLException ex) {
            throw new GestorBDProducteJdbcException("No es pot establir la connexió.\n" + ex.getMessage());
        }
    }

    public void tancar() throws GestorBDProducteJdbcException {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new GestorBDProducteJdbcException("Error en fer rollback final.\n" + ex.getMessage());
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new GestorBDProducteJdbcException("Error en tancar la connexió.\n" + ex.getMessage());
            }
        }
    }

    /**
     *
     * @return @throws GestorBDProducteJdbcException
     */
    public List<Producte> getListProducte() throws GestorBDProducteJdbcException {
        List<Producte> llRep = new ArrayList<Producte>();
        Statement q = null;
        try {
            q = conn.createStatement();
            ResultSet rs = q.executeQuery("select cat_id , cat_titol , cat_actiu from cataleg");
            while (rs.next()) {
                llRep.add(new Producte(rs.getInt("cat_id"), rs.getString("cat_titol"), rs.getString("cat_actiu")) {
                });
            }
            rs.close();
        } catch (SQLException ex) {
            throw new GestorBDProducteJdbcException("Error en intentar recuperar la llista de productes.\n" + ex.getMessage());
        } finally {
            if (q != null) {
                try {
                    q.close();
                } catch (SQLException ex) {
                    throw new GestorBDProducteJdbcException("Error en intentar tancar la sentència que ha recuperat la llista de productes.\n" + ex.getMessage());
                }
            }
        }
        return llRep;
    }
    
    public List<Producte> getTitol() throws GestorBDProducteJdbcException {
        List<Producte> llRep = new ArrayList<Producte>();
        Statement q = null;
        try {
            q = conn.createStatement();
            ResultSet rs = q.executeQuery("select cat_titol from cataleg");
            while (rs.next()) {
                llRep.add(new Producte(rs.getString("cat_titol")) {
                });
            }
            rs.close();
        } catch (SQLException ex) {
            throw new GestorBDProducteJdbcException("Error en intentar recuperar la llista de productes.\n" + ex.getMessage());
        } finally {
            if (q != null) {
                try {
                    q.close();
                } catch (SQLException ex) {
                    throw new GestorBDProducteJdbcException("Error en intentar tancar la sentència que ha recuperat la llista de productes.\n" + ex.getMessage());
                }
            }
        }
        return llRep;
    }

    
     public List<Estil> getListEstils() throws GestorBDReproduccioJdbcException {
        List<Estil> llest = new ArrayList<Estil>();
        Statement q = null;
        try {
            q = conn.createStatement();
            ResultSet rs = q.executeQuery(" select est_nom from estil  ");
            while (rs.next()) {
                llest.add(new Estil(rs.getString("est_nom")));
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error en intentar recuperar la llista de Clients.\n" + ex.getMessage());
                       // throw new GestorBDReproduccioJdbcException("Error en intentar recuperar la llista de Clients.\n" + ex.getMessage());
        } finally {
            if (q != null) {
                try {
                    q.close();
                } catch (SQLException ex) {
                    throw new GestorBDReproduccioJdbcException("Error en intentar tancar la sentència que ha recuperat la llista de productes.\n" + ex.getMessage());
                }

            }
        }
        return llest;
    }  
    
    
}
