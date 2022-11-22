package org.milaifontanals.info.projecte1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Canso extends Producte {

    

    private long durada;
    private Date anyCreacio;
    private String art;
    
    
     public Canso(long durada, Date anyCreacio, String art) {
        this.durada = durada;
        this.anyCreacio = anyCreacio;
        this.art = art;
    }


    public void setAnyCreacio(Date anyCreacio) {
        this.anyCreacio = anyCreacio;
    }

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    
     
    public void setDurada(long durada) {
        this.durada = durada;
    }

   
    
    public String getAnyCreacio() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        String resultat = null;

        resultat = df.format(anyCreacio);

        return resultat;
    }

    @Override
    public int getDurada() {
        return (int) durada;
    }

    /*
    public List<Canso> getCansonsinterpretades(){
        return ;
    }
    */
}
