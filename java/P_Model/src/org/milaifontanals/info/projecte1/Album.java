/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.milaifontanals.info.projecte1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Usuari
 */
public class Album extends Producte{
  
    public String titol;
    public int durada;
    public Date dataCreacio;

    public int getDurada() {
        return durada;
    }

    public Album(String titol) {
        this.titol = titol;
    }
    
    
    public void setDurada(int durada) {
        this.durada = durada;
    }

    public Album(String titol, int durada, Date dataCreacio) {
        this.titol = titol;
        this.durada = durada;
        this.dataCreacio = dataCreacio;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public String getDataCreacio() {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        String resultat = null;

        resultat = df.format(dataCreacio);

        return resultat;
    }

    public void setDataCreacio(Date dataCreacio) {
        this.dataCreacio = dataCreacio;
    }
    
 
}
