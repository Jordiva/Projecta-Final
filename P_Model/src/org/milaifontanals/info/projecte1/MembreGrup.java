/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.milaifontanals.info.projecte1;

import java.util.Date;

/**
 *
 * @author joval
 */
public class MembreGrup {
    private Date datainici;
    private Date dataFinal;

    public MembreGrup(Date datainici) {
        this.datainici = datainici;
    }

    public MembreGrup(Date datainici, Date dataFinal) {
        this.datainici = datainici;
        this.dataFinal = dataFinal;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Date getDatainici() {
        return datainici;
    }

    public void setDatainici(Date datainici) {
        this.datainici = datainici;
    }
    
    
    
    
}
