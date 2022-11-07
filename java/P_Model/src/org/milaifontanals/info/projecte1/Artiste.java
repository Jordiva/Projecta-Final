package org.milaifontanals.info.projecte1;

import java.util.ArrayList;
import java.util.List;


public abstract class Artiste  {

    private long id;
    private String nom;
   
    public long getId() {
        return id;
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
    
    public Artiste(long id, String nom) {
        this.id = id;
        this.nom = nom;
     
    }

    public Artiste() {
    }
    
    
    
    private List<Canso> getCansosInterpretats() {
        List <Canso> resultat = new ArrayList<Canso>();
        
        return resultat;    }

    
    enum TipusArtiste {
        INDIVIDUAL, GRUP
        
    } 


    
    
}
