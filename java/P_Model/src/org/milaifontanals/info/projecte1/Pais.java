package org.milaifontanals.info.projecte1;

public class Pais {
    
    private String nom;
    private String iso;
    
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getIso() {
        return iso;
    }
    public void setIso(String iso) {
        this.iso = iso;
    }
    
    public Pais(String nom, String iso) {
        this.nom = nom;
        this.iso = iso;
    }



    
}
