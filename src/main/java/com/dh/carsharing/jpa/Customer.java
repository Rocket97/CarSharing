
package com.dh.carsharing.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author Valerie
 */

@Entity
public class Customer implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "customer_ids")
    @TableGenerator(name = "customer_ids", initialValue = 0, allocationSize = 50)
    private long id;
    
    @Column(name = "NACHNAME")
    @NotNull(message = "Der Nachname darf nicht leer sein.")
    private String nachname;
    
    @Column(name = "VORNAME")
    @NotNull(message = "Der Vorname darf nicht leer sein.")
    private String vorname;
    
    @Column(name = "STRASSE")
    @NotNull(message = "Die Strasse darf nicht leer sein.")
    private String strasse;
    
    @Column(name = "HAUSNUMMER", length = 10)
    @NotNull(message = "Die Hausnummer darf nicht leer sein.")
    @Pattern(regexp = "^[0-9]+[a-zA-Z]?$", message = "Die Hausnummer muss mindestens eine Zahl zu Beginn und optional am Ende einen Buchstaben enthalten.")
    private String hausnr;
    
    @Column(name = "PLZ", length = 10)
    @NotNull(message = "Die Postleitzahl darf nicht leer sein.")
    @Size(min = 5, max = 5, message = "Die Postleitzahl muss 5 Zahlen haben.")
    private String plz;
    
    @Column(name = "ORT")
    @NotNull(message = "Der Ort darf nicht leer sein.")
    private String ort;
    
    @Column(name = "LAND")
    @NotNull(message = "Das Land darf nicht leer sein.")
    private String land;
    
    @OneToMany
    private List<LoanAgreement> la_list;

    //<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public Customer() {
    }
    
    public Customer(long id, String nachname, String vorname, String strasse, String hausnr, String plz, String ort, String land, List<LoanAgreement> la_list) {
        this.id = id;
        this.nachname = nachname;
        this.vorname = vorname;
        this.strasse = strasse;
        this.hausnr = hausnr;
        this.plz = plz;
        this.ort = ort;
        this.land = land;
        this.la_list = la_list;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getNachname() {
        return nachname;
    }
    
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    
    public String getVorname() {
        return vorname;
    }
    
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    
    public String getStrasse() {
        return strasse;
    }
    
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }
    
    public String getHausnr() {
        return hausnr;
    }
    
    public void setHausnr(String hausnr) {
        this.hausnr = hausnr;
    }
    
    public String getPlz() {
        return plz;
    }
    
    public void setPlz(String plz) {
        this.plz = plz;
    }
    
    public String getOrt() {
        return ort;
    }
    
    public void setOrt(String ort) {
        this.ort = ort;
    }
    
    public String getLand() {
        return land;
    }
    
    public void setLand(String land) {
        this.land = land;
    }

    public List<LoanAgreement> getLa_list() {
        return la_list;
    }

    public void setLa_list(List<LoanAgreement> la_list) {
        this.la_list = la_list;
    }
     //</editor-fold>
}
