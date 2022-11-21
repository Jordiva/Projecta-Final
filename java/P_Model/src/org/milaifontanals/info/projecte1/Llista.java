/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milaifontanals.info.projecte1;

/**
 *
 * @author isard
 */
public class Llista {
    
    
    private String Titol;
    private int durada;
    

    public Llista(String Titol, int durada) {
        this.Titol = Titol;
        this.durada = durada;
    }
    
    
    

    public String getTitol() {
        return Titol;
    }

    public void setTitol(String Titol) {
        this.Titol = Titol;
    }

    public int getDurada() {
        return durada;
    }

    public void setDurada(int durada) {
        this.durada = durada;
    }
    
    
    
    
    
}
