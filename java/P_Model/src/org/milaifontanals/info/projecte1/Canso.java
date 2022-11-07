package org.milaifontanals.info.projecte1;

import java.util.List;

public class Canso extends Producte {

    

    private long durada;
    private int anyCreacio;

    public Canso(long durada, int anyCreacio) {
        super();
        this.durada = durada;
        this.anyCreacio = anyCreacio;
    }


    
    
    
    public void setDurada(long durada) {
        this.durada = durada;
    }

    public int getAnyCreacio() {
        return anyCreacio;
    }

    public void setAnyCreacio(int anyCreacio) {
        this.anyCreacio = anyCreacio;
    }


    @Override
    public int getDurada() {
        return (int) durada;
    }

    /*
    public List<Canso> getCansonsinterpretades(){
        return ;
    }
    */
}
