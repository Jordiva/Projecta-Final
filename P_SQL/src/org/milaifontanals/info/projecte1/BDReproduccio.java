/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.milaifontanals.info.projecte1;

import java.io.FileInputStream;
import java.io.FileReader;
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
public class BDReproduccio {
    
    
    
    private Connection conn;

    private PreparedStatement qAddReproduccio;
    private PreparedStatement qUpdReproduccio; 
    private PreparedStatement qDelReproduccio;



    public BDReproduccio() throws GestorBDReproduccioJdbcException{
        this("Oracle.properties");
    }
    

    public BDReproduccio(String nomFitxerPropietats) throws GestorBDReproduccioJdbcException {
    
        Properties p = new Properties();
        try {
            p.load(new FileReader(nomFitxerPropietats));
        } catch (IOException ex) {
            System.out.println("Problemes en carregar el fitxer de configuració");
            System.out.println("Més info: " + ex.getMessage());
            System.exit(1);
        }
        // p conté les propietats necessàries per la connexió
        String url = p.getProperty("url");
        String usu = p.getProperty("usuari");
        String pwd = p.getProperty("contrasenya");
        if (url == null || usu == null || pwd == null) {
            System.out.println("Manca alguna de les propietats: url, usuari, contrasenya");
            System.exit(1);
        }
        // Ja tenim les 3 propietats
        try {
            // Podem intentar establir connexió
            conn = DriverManager.getConnection(url, usu, pwd);
            System.out.println("Connexió establerta");
            conn.setAutoCommit(false);
            System.out.println("Autocommit desactivat");
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            if (ex.getCause() != null) {
                System.out.println("Cause: " + ex.getCause().getMessage());
            }
            System.exit(1);
        }
    }
    
    
    public void tancar() throws GestorBDReproduccioJdbcException {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new GestorBDReproduccioJdbcException("Error en fer rollback final.\n" + ex.getMessage());
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new GestorBDReproduccioJdbcException("Error en tancar la connexió.\n" + ex.getMessage());
            }
        }
    }
    
     public List<Reproduccio> getListReproducio() throws GestorBDReproduccioJdbcException {
        List<Reproduccio> llRep = new ArrayList<Reproduccio>();
        Statement q = null;
        try {
            q = conn.createStatement();
            ResultSet rs = q.executeQuery("select rep_id_client ,rep_moment_temporal ,rep_id_catalag from reproducio");
            while (rs.next()) {
                llRep.add(new Reproduccio(rs.getInt("rep_id_client"),rs.getDate("rep_moment_temporal"),rs.getInt("rep_id_catalag")));
            }
            rs.close();
        } catch (SQLException ex) {
            throw new GestorBDReproduccioJdbcException("Error en intentar recuperar la llista de productes.\n" + ex.getMessage());
        } finally {
            if (q != null) {
                try {
                    q.close();
                } catch (SQLException ex) {
                    throw new GestorBDReproduccioJdbcException("Error en intentar tancar la sentència que ha recuperat la llista de productes.\n" + ex.getMessage());
                }
            }
        }
        return llRep;
    }
    
    
     public List<Clients> getListIdCliens() throws GestorBDReproduccioJdbcException {
        List<Clients> llidcli = new ArrayList<Clients>();
        Statement q = null;
        try {
            q = conn.createStatement();
            ResultSet rs = q.executeQuery(" select cli_id from client ");
            while (rs.next()) {
                llidcli.add(new Clients(rs.getInt("cli_id")));
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
        return llidcli;
    }
            
            
    
    
    
    
    

}
