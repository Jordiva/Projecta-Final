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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joval
 */
public class BDProducte {

    private Connection conn;
    private PreparedStatement qAddReproduccio;
    private PreparedStatement qUpdReproduccio;
    private PreparedStatement qDelReproduccio;
    
    
    
    public static List<Artiste> getListInterpret()throws GestorBDExceptionTOT {
        List<Artiste> llRep = new ArrayList<Artiste>();
        Statement q = null;
        try {
            q = ConexioGeneral.getConnection().createStatement();
            ResultSet rs = q.executeQuery("select art_nom from  artista where artista.art_tipus like 'I'");
            while (rs.next()) {
                llRep.add(new Artiste(rs.getString("art_nom")) {
                });
            }
            rs.close();
        } catch (SQLException ex) {
            throw new GestorBDExceptionTOT("Error en intentar recuperar la llista de productes.\n" + ex.getMessage());
        } finally {
            if (q != null) {
                try {
                    q.close();
                } catch (SQLException ex) {
                    throw new GestorBDExceptionTOT("Error en intentar tancar la sentència que ha recuperat la llista de productes.\n" + ex.getMessage());
                }
            }
        }
        return llRep;
    }


    public static List<Producte> getListProducte() throws GestorBDExceptionTOT {
        List<Producte> llRep = new ArrayList<Producte>();
        Statement q = null;
        try {
            q = ConexioGeneral.getConnection().createStatement();
            ResultSet rs = q.executeQuery("select c.cat_titol, c.cat_actiu , e.est_nom  , c.cat_tipus from cataleg c join estil e on e.est_id = c.cat_estil  ");
            while (rs.next()) {
                llRep.add(new Producte(rs.getString("cat_titol"), rs.getString("cat_actiu"), rs.getString("est_nom"), rs.getString("cat_tipus")) {
                });
            }
            rs.close();
        } catch (SQLException ex) {
            throw new GestorBDExceptionTOT("Error en intentar recuperar la llista de productes.\n" + ex.getMessage());
        } finally {
            if (q != null) {
                try {
                    q.close();
                } catch (SQLException ex) {
                    throw new GestorBDExceptionTOT("Error en intentar tancar la sentència que ha recuperat la llista de productes.\n" + ex.getMessage());
                }
            }
        }
        return llRep;
    }

    public static List<Producte> getTitol() throws GestorBDExceptionTOT {
        List<Producte> llRep = new ArrayList<Producte>();
        Statement q = null;
        try {
            q = ConexioGeneral.getConnection().createStatement();
            ResultSet rs = q.executeQuery("select cat_titol from cataleg");
            while (rs.next()) {
                llRep.add(new Producte(rs.getString("cat_titol")) {
                });
            }
            rs.close();
        } catch (SQLException ex) {
            throw new GestorBDExceptionTOT("Error en intentar recuperar la llista de productes.\n" + ex.getMessage());
        } finally {
            if (q != null) {
                try {
                    q.close();
                } catch (SQLException ex) {
                    throw new GestorBDExceptionTOT("Error en intentar tancar la sentència que ha recuperat la llista de productes.\n" + ex.getMessage());
                }
            }
        }
        return llRep;
    }

    public static List<Estil> getListEstils() throws GestorBDExceptionTOT {
        List<Estil> llest = new ArrayList<Estil>();
        Statement q = null;
        try {
            q = ConexioGeneral.getConnection().createStatement();
            ResultSet rs = q.executeQuery(" select est_nom from estil  ");
            while (rs.next()) {
                llest.add(new Estil(rs.getString("est_nom")));
            }
            rs.close();
        } catch (SQLException ex) {
            throw new GestorBDExceptionTOT("Error en intentar recuperar la llista de Clients.\n" + ex.getMessage());
            // throw new GestorBDExceptionTOT("Error en intentar recuperar la llista de Clients.\n" + ex.getMessage());
        } finally {
            if (q != null) {
                try {
                    q.close();
                } catch (SQLException ex) {
                    throw new GestorBDExceptionTOT("Error en intentar tancar la sentència que ha recuperat la llista de productes.\n" + ex.getMessage());
                }

            }
        }
        return llest;
    }

    public static int getId(String nom) throws GestorBDExceptionTOT {

        PreparedStatement ps;
        try {
            String sql = "select cat_id from cataleg where cat_titol like ?";
            ps = ConexioGeneral.getConnection().prepareStatement(sql);
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();
            rs.next();
            // id = rs.getInt("cat_id");
            return rs.getInt("cat_id");
        } catch (SQLException e) {
            throw new GestorBDExceptionTOT("Error en la consulta de la llista de get id:\n" + e.getMessage());
        }
    }

    public static int getIDestil(String nom) throws GestorBDExceptionTOT {

        PreparedStatement ps;
        try {
            String sql = "select est_id from estil where  est_nom like ?";
            ps = ConexioGeneral.getConnection().prepareStatement(sql);
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt("est_id");
        } catch (SQLException e) {
            throw new GestorBDExceptionTOT("Error en la consulta de la llista de get id Estil:\n" + e.getMessage());
        }
    }
    
    public static List<Llista> getLlista(String nom) throws GestorBDExceptionTOT {
        List<Llista> llest = new ArrayList<Llista>();
        Statement q = null;
        PreparedStatement ps = null;
        int id = getId(nom);
        try {
            String sql = " select c.cat_titol ,l.lli_durada  from cataleg c join llista l on l.lli_id = c.cat_id where c.cat_id like ?";
            ps = ConexioGeneral.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                llest.add(new Llista(rs.getString("cat_titol"), rs.getInt("lli_durada")));
            }
            rs.close();
        } catch (SQLException ex) {
            throw new GestorBDExceptionTOT("Error en intentar recuperar la llista .\n" + ex.getMessage());
            // throw new GestorBDExceptionTOT("Error en intentar recuperar la llista de Clients.\n" + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new GestorBDExceptionTOT("Error en intentar tancar la sentència que ha recuperat la llista de productes.\n" + ex.getMessage());
                }

            }
        }
        return llest;
    }

    public static List<Canso> getCanco(String nom) throws GestorBDExceptionTOT {
        List<Canso> can = new ArrayList<Canso>();
        Statement q = null;
        PreparedStatement ps = null;
        int id = getId(nom);
        try {
            String sql = " select  ca.can_any_creacio, ar.art_nom ,ca.can_durada  from cataleg c join CANÇO ca on ca.can_id=c.cat_id join artista ar on ar.art_id= c.cat_id where c.cat_id like ?";
            ps = ConexioGeneral.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                can.add(new Canso(rs.getLong("can_durada"), rs.getDate("can_any_creacio"), rs.getString("art_nom")));
            }
            rs.close();
        } catch (SQLException ex) {
            throw new GestorBDExceptionTOT("Error en intentar recuperar la llista .\n" + ex.getMessage());
            // throw new GestorBDExceptionTOT("Error en intentar recuperar la llista de Clients.\n" + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new GestorBDExceptionTOT("Error en intentar tancar la sentència que ha recuperat la llista de productes.\n" + ex.getMessage());
                }

            }
        }
        return can;
    }

    public static List<Album> getAlbum(String nom) throws GestorBDExceptionTOT {
        List<Album> alb = new ArrayList<Album>();
        Statement q = null;
        PreparedStatement ps = null;
        int id = getId(nom);
        try {
            String sql = "select c.cat_titol , a.alb_any_creacio , a.alb_durada  from cataleg c join album a on a.alb_id = c.cat_id where c.cat_id like ?";
            ps = ConexioGeneral.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                alb.add(new Album(rs.getString("cat_titol"), rs.getInt("alb_durada"), rs.getDate("alb_any_creacio")));
            }
            rs.close();
        } catch (SQLException ex) {
            throw new GestorBDExceptionTOT("Error en intentar recuperar la llista .\n" + ex.getMessage());
            // throw new GestorBDExceptionTOT("Error en intentar recuperar la llista de Clients.\n" + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new GestorBDExceptionTOT("Error en intentar tancar la sentència que ha recuperat la llista de productes.\n" + ex.getMessage());
                }

            }
        }
        return alb;
    }

    public static List<Album> getAlbumCont(String nom) throws GestorBDExceptionTOT {
        List<Album> alb = new ArrayList<Album>();
        Statement q = null;
        PreparedStatement ps = null;
        int id = getId(nom);
        try {
            String sql = "select c.cat_titol from cataleg c join album_contingut abc on c.cat_id=abc.alco_id_canço where abc.alco_id_album like ?";
            ps = ConexioGeneral.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                alb.add(new Album(rs.getString("cat_titol")));
            }
            rs.close();
        } catch (SQLException ex) {
            throw new GestorBDExceptionTOT("Error en intentar recuperar la llista .\n" + ex.getMessage());
            // throw new GestorBDExceptionTOT("Error en intentar recuperar la llista de Clients.\n" + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new GestorBDExceptionTOT("Error en intentar tancar la sentència que ha recuperat la llista de productes.\n" + ex.getMessage());
                }

            }
        }
        return alb;
    }

    public static List<Llista> getLlistaCont(String nom) throws GestorBDExceptionTOT {
        List<Llista> alb = new ArrayList<Llista>();
        Statement q = null;
        PreparedStatement ps = null;
        int id = getId(nom);
        try {
            String sql = "select c.cat_titol from cataleg c join llista_contingut ll on ll.llcon_id_catalag = c.cat_id where ll.llcon_id_llista like ?";
            ps = ConexioGeneral.getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                alb.add(new Llista(rs.getString("cat_titol")));
            }
            rs.close();
        } catch (SQLException ex) {
            throw new GestorBDExceptionTOT("Error en intentar recuperar la llista .\n" + ex.getMessage());
            // throw new GestorBDExceptionTOT("Error en intentar recuperar la llista de Clients.\n" + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new GestorBDExceptionTOT("Error en intentar tancar la sentència que ha recuperat la llista de productes.\n" + ex.getMessage());
                }

            }
        }
        return alb;
    }

    public static List<Producte> getFiltre(String titol,String C, String A, String L, String Actiu) throws GestorBDExceptionTOT {
        List<Producte> alb = new ArrayList<Producte>();
        Statement q = null;
        PreparedStatement ps = null;

        try {

            //select * from cataleg where cat_actiu like 'S'
            //select * from cataleg where cat_tipus like ? or cat_tipus like ? or cat_tipus like ? 
            String sql = "select c.cat_titol, c.cat_actiu , e.est_nom  , c.cat_tipus from cataleg c join estil e on e.est_id = c.cat_estil ";
            boolean dos = false;
            boolean tipus = false;
            boolean fet = true;


            if ((Actiu != null) && (C != null || A != null || L != null) == true) {

                if (Actiu.equals("dos")) {

                    if (fet != false) {
                        if (C != null && A != null && L != null) {
                            sql += " where ";
                            sql += "  cat_actiu like 'S' or  cat_actiu like 'N' ";
                            sql += " and cat_tipus like ? or cat_tipus like ? or cat_tipus like ? ";

                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, C);
                            ps.setString(2, A);
                            ps.setString(3, L);

                        }
                    }
                    if (fet != false) {
                        if (C != null && A != null) {
                            sql += " where ";
                            sql += "  cat_actiu like 'S' or  cat_actiu like 'N' ";
                            sql += " and cat_tipus like ? or cat_tipus like ?";

                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, C);
                            ps.setString(2, A);

                        }
                    }
                    if (fet != false) {
                        if (C != null && L != null) {
                            sql += " where ";
                            sql += "  cat_actiu like 'S' or  cat_actiu like 'N' ";
                            sql += " and cat_tipus like ? or cat_tipus like ?";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, C);
                            ps.setString(2, L);

                        }
                    }

                    if (fet != false) {
                        if (L != null && A != null) {
                            sql += " where ";
                            sql += "  cat_actiu like 'S' or  cat_actiu like 'N' ";
                            sql += " and cat_tipus like ? or cat_tipus like ?";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, L);
                            ps.setString(2, A);
                        }
                    }
                    if (fet != false) {
                        if (L != null && C != null) {
                            sql += " where ";
                            sql += "  cat_actiu like 'S' or  cat_actiu like 'N' ";
                            sql += " and cat_tipus like ? or cat_tipus like ?";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, L);
                            ps.setString(2, C);
                        }
                    }

                    if (fet != false) {
                        if (A != null && C != null) {
                            sql += " where ";
                            sql += "  cat_actiu like 'S' or  cat_actiu like 'N' ";
                            sql += " and cat_tipus like ? or cat_tipus like ?";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, A);
                            ps.setString(2, C);
                        }
                    }
                    if (fet != false) {
                        if (A != null && L != null) {
                            sql += " where ";
                            sql += "  cat_actiu like 'S' or  cat_actiu like 'N' ";
                            sql += " and cat_tipus like ? or cat_tipus like ?";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, A);
                            ps.setString(2, L);
                        }
                    }

                    if (fet != false) {
                        if (C != null) {
                            sql += " where ";
                            sql += "  cat_actiu like 'S' or  cat_actiu like 'N' ";
                            sql += " and cat_tipus like ? ";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, C);

                        }
                    }
                    if (fet != false) {
                        if (A != null) {
                            sql += " where ";
                            sql += "  cat_actiu like 'S' or  cat_actiu like 'N' ";
                            sql += " and cat_tipus like ? ";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, A);
                        }
                    }
                    if (fet != false) {
                        if (L != null) {
                            sql += " where ";
                            sql += "  cat_actiu like 'S' or  cat_actiu like 'N' ";
                            sql += " and cat_tipus like ? ";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, L);
                        }
                    }
                } else {

                    if (fet != false) {
                        if (C != null && A != null && L != null) {
                            sql += " where ";
                            sql += " cat_actiu like ?";
                            sql += " and cat_tipus like ? or cat_tipus like ? or cat_tipus like ? ";

                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, Actiu);
                            ps.setString(2, C);
                            ps.setString(3, A);
                            ps.setString(4, L);

                        }
                    }
                    if (fet != false) {
                        if (C != null && A != null) {
                            sql += " where ";
                            sql += " cat_actiu like ?";
                            sql += " and cat_tipus like ? or cat_tipus like ?";

                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, Actiu);
                            ps.setString(2, C);
                            ps.setString(3, A);

                        }
                    }
                    if (fet != false) {
                        if (C != null && L != null) {
                            sql += " where ";
                            sql += " cat_actiu like ?";
                            sql += " and cat_tipus like ? or cat_tipus like ?";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, Actiu);
                            ps.setString(2, C);
                            ps.setString(3, L);

                        }
                    }

                    if (fet != false) {
                        if (L != null && A != null) {
                            sql += " where ";
                            sql += " cat_actiu like ?";
                            sql += " and cat_tipus like ? or cat_tipus like ?";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, Actiu);
                            ps.setString(2, L);
                            ps.setString(3, A);
                        }
                    }
                    if (fet != false) {
                        if (L != null && C != null) {
                            sql += " where ";
                            sql += " cat_actiu like ?";
                            sql += " and cat_tipus like ? or cat_tipus like ?";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, Actiu);
                            ps.setString(2, L);
                            ps.setString(3, C);
                        }
                    }

                    if (fet != false) {
                        if (A != null && C != null) {
                            sql += " where ";
                            sql += " cat_actiu like ?";
                            sql += " and cat_tipus like ? or cat_tipus like ?";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, Actiu);
                            ps.setString(2, A);
                            ps.setString(3, C);
                        }
                    }
                    if (fet != false) {
                        if (A != null && L != null) {
                            sql += " where ";
                            sql += " cat_actiu like ?";
                            sql += " and cat_tipus like ? or cat_tipus like ?";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, Actiu);
                            ps.setString(2, A);
                            ps.setString(3, L);
                        }
                    }

                    if (fet != false) {
                        if (C != null) {
                            sql += " where ";
                            sql += " cat_actiu like ?";
                            sql += " and cat_tipus like ? ";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, Actiu);
                            ps.setString(2, C);

                        }
                    }
                    if (fet != false) {
                        if (A != null) {
                            sql += " where ";
                            sql += " cat_actiu like ?";
                            sql += " and cat_tipus like ? ";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, Actiu);
                            ps.setString(2, A);
                        }
                    }
                    if (fet != false) {
                        if (L != null) {
                            sql += " where ";
                            sql += " cat_actiu like ?";
                            sql += " and cat_tipus like ? ";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, Actiu);
                            ps.setString(2, L);
                        }
                    }

                }

            } else {
                if (Actiu != null) {
                    switch (Actiu) {

                        case "dos":
                            sql += " where ";
                            sql += "  cat_actiu like 'S' or  cat_actiu like 'N' ";
                            dos = true;
                            break;

                        case "N":
                            sql += " where ";
                            sql += "  cat_actiu like ? ";
                            break;

                        case "S":
                            sql += " where ";
                            sql += "  cat_actiu like ? ";
                            break;
                    }
                    if (!dos) {
                        ps = ConexioGeneral.getConnection().prepareStatement(sql);
                        ps.setString(1, Actiu);
                    } else {
                        ps = ConexioGeneral.getConnection().prepareStatement(sql);
                    }
                }
                if (C != null || A != null || L != null) {

                    sql += " where ";

                    if (fet != false) {
                        if (C != null && A != null && L != null) {
                            sql += "  cat_tipus like ? or cat_tipus like ? or cat_tipus like ? ";

                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, C);
                            ps.setString(2, A);
                            ps.setString(3, L);

                        }
                    }
                    if (fet != false) {
                        if (C != null && A != null) {
                            sql += "  cat_tipus like ? or cat_tipus like ?";

                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, C);
                            ps.setString(2, A);

                        }
                    }
                    if (fet != false) {
                        if (C != null && L != null) {
                            sql += "  cat_tipus like ? or cat_tipus like ?";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, C);
                            ps.setString(2, L);

                        }
                    }

                    if (fet != false) {
                        if (L != null && A != null) {
                            sql += "  cat_tipus like ? or cat_tipus like ?";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, L);
                            ps.setString(2, A);
                        }
                    }
                    if (fet != false) {
                        if (L != null && C != null) {
                            sql += "  cat_tipus like ? or cat_tipus like ?";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, L);
                            ps.setString(2, C);
                        }
                    }

                    if (fet != false) {
                        if (A != null && C != null) {
                            sql += "  cat_tipus like ? or cat_tipus like ?";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, A);
                            ps.setString(2, C);
                        }
                    }
                    if (fet != false) {
                        if (A != null && L != null) {
                            sql += "  cat_tipus like ? or cat_tipus like ?";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, A);
                            ps.setString(2, L);
                        }
                    }

                    if (fet != false) {
                        if (C != null) {
                            sql += "  cat_tipus like ? ";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, C);

                        }
                    }
                    if (fet != false) {
                        if (A != null) {
                            sql += "  cat_tipus like ? ";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, A);
                        }
                    }
                    if (fet != false) {
                        if (L != null) {
                            sql += "  cat_tipus like ? ";
                            fet = false;
                            ps = ConexioGeneral.getConnection().prepareStatement(sql);
                            ps.setString(1, L);
                        }
                    }

                    
                }
               if (titol != null) {
               sql += " where ";
               sql += " cat_titol like ?";
               ps = ConexioGeneral.getConnection().prepareStatement(sql);
               ps.setString(1,"%"+titol+"%");
            }
            }
            

            String resultat = sql;

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                alb.add(new Producte(rs.getString("cat_titol"), rs.getString("cat_actiu"), rs.getString("est_nom"), rs.getString("cat_tipus")) {
                });
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new GestorBDExceptionTOT("Error en intentar recuperar la llista .\n" + ex.getMessage());
            // throw new GestorBDExceptionTOT("Error en intentar recuperar la llista de Clients.\n" + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new GestorBDExceptionTOT("Error en intentar tancar la sentència que ha recuperat la llista de productes.\n" + ex.getMessage());
                }

            }
        }

        return alb;

    }

    
    
    
    
    
    
    public static void updateProducte(String titol , String actiu , String estil , String tipus ) throws GestorBDExceptionTOT {
        Statement q = null;
        PreparedStatement ps = null;
        try {
            String sql = "update cataleg set cat_titol = ?, cat_actiu = ?, cat_estil = (select estil.est_id from estil where estil.est_nom = ?), cat_tipus = ? where cat_id = ?";
            ps = ConexioGeneral.getConnection().prepareStatement(sql);
            ps.setString(1,titol);
            ps.setString(2,actiu);
            ps.setString(3,estil);
            ps.setString(4,tipus);
            ps.executeUpdate();     
            ps.close();           
        } catch (SQLException ex) {
            throw new GestorBDExceptionTOT("Error en intentar a fer el update .\n" + ex.getMessage());
            // throw new GestorBDExceptionTOT("Error en intentar recuperar la llista de Clients.\n" + ex.getMessage());
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    throw new GestorBDExceptionTOT("Error en intentar tancar la sentència que ha recuperat la llista de productes.\n" + ex.getMessage());
                }
            }
        }
    }

    public static void createProducte(String titol , String actiu , String estil , String tipus ) throws GestorBDExceptionTOT {
        Statement q = null;
        PreparedStatement ps = null;
        int idestil = getIDestil(estil);
        try {
            String sql = "INSERT INTO CATALEG (CAT_TITOL,CAT_ACTIU,CAT_ESTIL,CAT_TIPUS) VALUES(?,?,?,?)";
            ps = ConexioGeneral.getConnection().prepareStatement(sql);
            ps.setString(1,titol);
            ps.setString(2,actiu);
            ps.setInt(3,idestil);
            ps.setString(4,tipus);
            ps.executeUpdate();     
            ps.close();
        } catch (SQLException ex) {
            throw new GestorBDExceptionTOT("Error en intentar a fer el update .\n" + ex.getMessage());
            // throw new GestorBDExceptionTOT("Error en intentar recuperar la llista de Clients.\n" + ex.getMessage());
        } 
    }
    
    public void borra(){
        
        
        
    }
    
    
    
    
}
