package org.milaifontanals.info.projecte1;

import javax.management.RuntimeMBeanException;

import org.milaifontanals.info.projecte1.Estil;

public abstract class Producte {

    private TipusProducte tipus;
    private int  id;
    private String titol;
    private Estil estil;
    private boolean actiu;
    
    public TipusProducte getTipus() {
        return tipus;
    }

    public void setTipus(TipusProducte tipus) {
        this.tipus = tipus;
    }

    public int getId() {
        return id;
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

    public Estil getEstil() {
        return estil;
    }

    public void setEstil(Estil estil) {
        //comprobar si el estil existeix
        if (estil == null) {
            throw new RuntimeException("Estil no existeix");
        }else{
            this.estil = estil;
        }   
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

    public Producte(TipusProducte tipus, int id, String titol, Estil estil, boolean actiu) {
        this.tipus = tipus;
        this.id = id;
        this.titol = titol;
        this.estil = estil;
        this.actiu = actiu;
    }

    public abstract int getDurada();



}
