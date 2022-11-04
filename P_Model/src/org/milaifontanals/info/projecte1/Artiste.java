package org.milaifontanals.info.projecte1;

import java.util.List;


public abstract class Artiste  {

    private long id;
    private String nom;
    private Canso interpreta;
    private TipusArtiste tipusArtiste;
    public long getId() {
        return id;
    }
    public TipusArtiste getTipusArtiste() {
        return tipusArtiste;
    }
    public void setTipusArtiste(TipusArtiste tipusArtiste) {
        this.tipusArtiste = tipusArtiste;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public Canso getInterpreta() {
        return interpreta;
    }
    public void setInterpreta(Canso interpreta) {
        this.interpreta = interpreta;
    }
    public Artiste(long id, String nom, Canso interpreta, TipusArtiste tipusArtiste) {
        this.id = id;
        this.nom = nom;
        this.interpreta = interpreta;
        this.tipusArtiste = tipusArtiste;
    }
    private List<Canso> getCansosInterpretats() {
        return null;
    }

    
    enum TipusArtiste {
        INDIVIDUAL, GRUP
        
    } 


    
    
}
