package org.milaifontanals.info.projecte1;

import javax.management.RuntimeMBeanException;

import org.milaifontanals.info.projecte1.Estil;

public abstract class Producte {

    private long id;
    private String titol;
    private boolean actiu;

    public Producte() {
    }

    public Producte(long id, String titol, boolean actiu) {
        this.id = id;
        this.titol = titol;
        this.actiu = actiu;
    }
   
    

    public void setId(int id) {
        this.id = id;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    


    public boolean isActiu() {
        return actiu;
    }

    public void setActiu(boolean actiu) {
        this.actiu = actiu;
    }
    
    
    
    enum TipusProducte {
        CANSO,
        ALBUM,
        LLISTA_REP
    } 

    
    
    
  public int getDurada(){
        int durada=0;
        
        return durada;
    }



}
