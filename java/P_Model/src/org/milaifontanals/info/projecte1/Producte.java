package org.milaifontanals.info.projecte1;

import javax.management.RuntimeMBeanException;

import org.milaifontanals.info.projecte1.Estil;

public abstract class Producte {

    private long id;
    private String titol;
    private String actiu;
    private String estil;
    private String estat;

    public Producte(String titol, String actiu, String estil, String estat) {
        this.titol = titol;
        this.actiu = actiu;
        this.estil = estil;
        this.estat = estat;
    }

       

    public Producte() {
    }

    public Producte(long id, String titol) {
        this.id = id;
        this.titol = titol;
    }

    public Producte(String titol) {
        this.titol = titol;
    }

    
    
    
    
    public Producte(long id, String titol, String actiu) {
        this.id = id;
        this.titol = titol;
        this.actiu = actiu;
    }

    public String getActiu() {
        return actiu;
    }

    public void setActiu(String actiu) {
        this.actiu = actiu;
    }
   
    
    public String getEstil() {
        return estil;
    }

    public void setEstil(String estil) {
        this.estil = estil;
    }

    public String getEstat() {
        return estat;
    }

    public void setEstat(String estat) {
        this.estat = estat;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
