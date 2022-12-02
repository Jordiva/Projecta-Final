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
    
    


     public static List<Reproduccio> getListReproducio() throws GestorBDExceptionTOT {
        List<Reproduccio> llRep = new ArrayList<Reproduccio>();
        Statement q = null;
        try {
            q = ConexioGeneral.getConnection().createStatement();
            ResultSet rs = q.executeQuery("select rep_id_client ,rep_moment_temporal ,rep_id_catalag from reproducio");
            while (rs.next()) {
                llRep.add(new Reproduccio(rs.getInt("rep_id_client"),rs.getDate("rep_moment_temporal"),rs.getInt("rep_id_catalag")));
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
    
    
     public static List<Clients> getListIdCliens() throws GestorBDExceptionTOT {
        List<Clients> llidcli = new ArrayList<Clients>();
        Statement q = null;
        try {
            q = ConexioGeneral.getConnection().createStatement();
            ResultSet rs = q.executeQuery(" select cli_nom from client ");
            while (rs.next()) {
                llidcli.add(new Clients(rs.getString("cli_nom")));
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Error en intentar recuperar la llista de Clients.\n" + ex.getMessage());
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
        return llidcli;
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
            System.out.println("Error en intentar recuperar la llista de Clients.\n" + ex.getMessage());
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
    
    
    
    
    

}
