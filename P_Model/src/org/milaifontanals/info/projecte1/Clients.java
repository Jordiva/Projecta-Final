package org.milaifontanals.info.projecte1;

import java.util.Date;

public class Clients {
    
    private long id;
    private String email;
    private String nom;
    private String cognom;
    private Date dataNaixement;
    private String cp;
    private String dmini1;
    private String dmini2;
    private String poblacio;
    private Pais pais;

    public Clients() {
    }

    public Clients(long id) {
        this.id = id;
    }
    

    public Clients(long id, String nom, String cognom) {
        this.id = id;
        this.nom = nom;
        this.cognom = cognom;
    }

    public Clients(long id, String nom) {
        this.id = id;
        this.nom = nom;
    }
    
    
    
    
    public Clients(long id, String email, String nom, String cognom, Date dataNaixement, String cp, String dmini1,
            String dmini2, String poblacio, Pais pais) {
        this.id = id;
        this.email = email;
        this.nom = nom;
        this.cognom = cognom;
        this.dataNaixement = dataNaixement;
        this.cp = cp;
        this.dmini1 = dmini1;
        this.dmini2 = dmini2;
        this.poblacio = poblacio;
        this.pais = pais;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getCognom() {
        return cognom;
    }
    public void setCognom(String cognom) {
        this.cognom = cognom;
    }
    public Date getDataNaixement() {
        return dataNaixement;
    }
    public void setDataNaixement(Date dataNaixement) {
        this.dataNaixement = dataNaixement;
    }
    public String getCp() {
        return cp;
    }
    public void setCp(String cp) {
        this.cp = cp;
    }
    public String getDmini1() {
        return dmini1;
    }
    public void setDmini1(String dmini1) {
        this.dmini1 = dmini1;
    }
    public String getDmini2() {
        return dmini2;
    }
    public void setDmini2(String dmini2) {
        this.dmini2 = dmini2;
    }
    public String getPoblacio() {
        return poblacio;
    }
    public void setPoblacio(String poblacio) {
        this.poblacio = poblacio;
    }

    public Pais getPais() {
        return pais;
    }
    public void setPais(Pais pais) {
        this.pais = pais;
    }


    

}
