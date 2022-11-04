/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milaifontanals.info.projecte1;

/**
 *
 * @author Usuari
 */
public class Estil {
    
    private long id;
    private String nom;

    public Estil(long id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    
    
    
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
    
}
