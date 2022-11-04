package org.milaifontanals.info.projecte1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Reproduccio {

    private Clients idCli;
    private Date date;
    private Producte idProd;

    public Clients getIdCli() {
        return idCli;
    }

    public void setIdCli(Clients idCli) {
        this.idCli = idCli;
    }

    public Producte getIdProd() {
        return idProd;
    }

    public void setIdProd(Producte idProd) {
        this.idProd = idProd;
    }
    
    

    

    public void setDate(Date date) {
        this.date = date;
    }
    public Reproduccio(Date date) {
        this.date = date;
    }

    
    
    public String getDate() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        
        String resultat=null;
        
        resultat=df.format(date);
        
        return resultat;
    }
    
    
    /*
    public Reproduccio(Date date, TipusProducte tipus, int id, String titol, Estil estil, boolean actiu) {
        super(tipus, id, titol, estil, actiu);
        this.date = date;
    }
    
 


    
    @Override
    public int getDurada() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    */
    
    
    
}
