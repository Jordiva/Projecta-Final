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
public class Album extends Producte{
    private int anyCreacio;

    
    public int getAnyCreacio() {
        return anyCreacio;
    }

    public void setAnyCreacio(int anyCreacio) {
        this.anyCreacio = anyCreacio;
    }

    public Album(int anyCreacio) {
        super();
        this.anyCreacio = anyCreacio;
    }

    
    @Override
    public int getDurada() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   
    
}
