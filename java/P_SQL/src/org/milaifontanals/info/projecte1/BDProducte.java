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
            ResultSet rs = q.executeQuery("select c.cat_titol, c.cat_actiu , e.est_nom  , c.cat_tipus from cataleg c join estil e on e.est_id = c.cat_estil  ");
            while (rs.next()) {
                llRep.add(new Producte(rs.getString("cat_titol"), rs.getString("cat_actiu"), rs.getString("est_nom"), rs.getString("cat_tipus")) {
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

    public int getId(String nom) throws GestorBDReproduccioJdbcException {
        
        PreparedStatement ps;
        try {
            String sql = "select cat_id from cataleg where cat_titol like ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,nom);
            ResultSet rs = ps.executeQuery();
                rs.next();
               // id = rs.getInt("cat_id");
               return  rs.getInt("cat_id");

        } catch (SQLException e) {
            throw new GestorBDReproduccioJdbcException("Error en la consulta de la llista de get id:\n" + e.getMessage());
        }
    }

    public List<Llista> getLlista(String nom) throws GestorBDReproduccioJdbcException {
        List<Llista> llest = new ArrayList<Llista>();
        Statement q = null;
        PreparedStatement ps = null;
        int id = getId(nom);
        try {
            String sql = " select c.cat_titol ,l.lli_durada  from cataleg c join llista l on l.lli_id = c.cat_id where c.cat_id like ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                llest.add(new Llista(rs.getString("cat_titol"), rs.getInt("lli_durada")));
            }
            rs.close();
        } catch (SQLException ex) {
            throw new GestorBDReproduccioJdbcException("Error en intentar recuperar la llista .\n" + ex.getMessage());
            // throw new GestorBDReproduccioJdbcException("Error en intentar recuperar la llista de Clients.\n" + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new GestorBDReproduccioJdbcException("Error en intentar tancar la sentència que ha recuperat la llista de productes.\n" + ex.getMessage());
                }

            }
        }
        return llest;
    }

    
       
    public List<Canso> getCanco(String nom) throws GestorBDReproduccioJdbcException {
        List<Canso> can = new ArrayList<Canso>();
        Statement q = null;
        PreparedStatement ps = null;
        int id = getId(nom);
        try {
            String sql = " select  ca.can_any_creacio, ar.art_nom ,ca.can_durada  from cataleg c join CANÇO ca on ca.can_id=c.cat_id join artista ar on ar.art_id= c.cat_id where c.cat_id like ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                can.add(new Canso( rs.getLong("can_durada"),rs.getDate("can_any_creacio"), rs.getString("art_nom")));
            }
            rs.close();
        } catch (SQLException ex) {
            throw new GestorBDReproduccioJdbcException("Error en intentar recuperar la llista .\n" + ex.getMessage());
            // throw new GestorBDReproduccioJdbcException("Error en intentar recuperar la llista de Clients.\n" + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new GestorBDReproduccioJdbcException("Error en intentar tancar la sentència que ha recuperat la llista de productes.\n" + ex.getMessage());
                }

            }
        }
        return can;
    }
    
    
    
    
    
       
    public List<Album> getAlbum(String nom) throws GestorBDReproduccioJdbcException {
        List<Album> alb = new ArrayList<Album>();
        Statement q = null;
        PreparedStatement ps = null;
        int id = getId(nom);
        try {
            String sql = "select c.cat_titol , a.alb_any_creacio , a.alb_durada  from cataleg c join album a on a.alb_id = c.cat_id where c.cat_id like ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                alb.add(new Album( rs.getString("cat_titol"),rs.getInt("alb_durada"),rs.getDate("alb_any_creacio")));
            }
            rs.close();
        } catch (SQLException ex) {
            throw new GestorBDReproduccioJdbcException("Error en intentar recuperar la llista .\n" + ex.getMessage());
            // throw new GestorBDReproduccioJdbcException("Error en intentar recuperar la llista de Clients.\n" + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new GestorBDReproduccioJdbcException("Error en intentar tancar la sentència que ha recuperat la llista de productes.\n" + ex.getMessage());
                }

            }
        }
        return alb;
    }
    
    public List<Album> getAlbumCont(String nom) throws GestorBDReproduccioJdbcException {
        List<Album> alb = new ArrayList<Album>();
        Statement q = null;
        PreparedStatement ps = null;
        int id = getId(nom);
        try {
            String sql = "select c.cat_titol from cataleg c join album_contingut abc on c.cat_id=abc.alco_id_canço where abc.alco_id_album like ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                alb.add(new Album( rs.getString("cat_titol")));
            }
            rs.close();
        } catch (SQLException ex) {
            throw new GestorBDReproduccioJdbcException("Error en intentar recuperar la llista .\n" + ex.getMessage());
            // throw new GestorBDReproduccioJdbcException("Error en intentar recuperar la llista de Clients.\n" + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new GestorBDReproduccioJdbcException("Error en intentar tancar la sentència que ha recuperat la llista de productes.\n" + ex.getMessage());
                }

            }
        }
        return alb;
    }
    
    
    
    
    
    
    
    
    
}
