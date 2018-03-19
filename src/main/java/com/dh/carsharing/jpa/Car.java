/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.carsharing.jpa;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author Valerie
 */

@Entity
public class Car implements Serializable{
     
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(generator = "car_ids")
    @TableGenerator(name = "car_ids", initialValue = 0, allocationSize = 50)
    private long id;
    
    @Column(name = "HERSTELLER")
    @NotNull(message = "Der Name des Herstellers darf nicht leer sein.")
    private String hersteller;
    
    @Column(name = "MODELL", length = 64)
    @NotNull(message = "Der Name des Modells darf nicht leer sein.")
    private String modell;
    
    @Column(name = "BAUJAHR", precision = 4)
    @NotNull(message = "Das Baujahr darf nicht leer sein.")
    @Size(min = 4, max = 4, message = "Das Jahr muss 4 Zahlen haben.")
    @DecimalMin(value = "1886", message = "Das erste Auto wurde im Jahr 1886 gebaut. Sie können mich nicht verarschen ;D .")
    private int baujahr;

    //<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public Car() {
    }
    
    public Car(long id, String hersteller, String modell, int baujahr) {
        this.id = id;
        this.hersteller = hersteller;
        this.modell = modell;
        this.baujahr = baujahr;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getter und Setter">
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getHersteller() {
        return hersteller;
    }
    
    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }
    
    public String getModell() {
        return modell;
    }
    
    public void setModell(String modell) {
        this.modell = modell;
    }
    
    public int getBaujahr() {
        return baujahr;
    }
    
    public void setBaujahr(int baujahr) {
        this.baujahr = baujahr;
    }
    //</editor-fold>
    
    
}
