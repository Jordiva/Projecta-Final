package org.milaifontanals.info.projecte1;

import java.util.Date;

public class Reproduccio extends Producte{

    
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Reproduccio(Date date, TipusProducte tipus, int id, String titol, Estil estil, boolean actiu) {
        super(tipus, id, titol, estil, actiu);
        this.date = date;
    }


   
 
    
    @Override
    public int getDurada() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
}
