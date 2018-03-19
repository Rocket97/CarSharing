
package com.dh.carsharing.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 *
 * @author Valerie
 */

@Entity
public class LoanAgreement implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(generator = "loanAgreement_ids")
    @TableGenerator(name = "loanAgreement_ids", initialValue = 0, allocationSize = 50)
    private long id;
    
    @ManyToOne
    private Customer kunde;
    
    @ManyToOne
    private Car auto;
    
    @Column(name = "BEGINNDATUM")
    @NotNull(message = "Das Beginndatum darf nicht leer sein.")
    @Future(message = "Das Datum muss in der Zukunft liegen.")
    @Temporal(TemporalType.DATE)
    private Date beginn;
    
    @Column(name = "ENDEDATUM")
    @NotNull(message = "Das Endedatum darf nicht leer sein.")
    @Future(message = "Das Datum muss in der Zukunft liegen.")
    @Temporal(TemporalType.DATE)
    private Date ende;

    //<editor-fold defaultstate="collapsed" desc="Konstruktoren">
    public LoanAgreement() {
    }
    
    public LoanAgreement(long id, Customer kunde, Car auto, Date beginn, Date ende) {
        this.id = id;
        this.kunde = kunde;
        this.auto = auto;
        this.beginn = beginn;
        this.ende = ende;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getter und Setter">
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public Customer getKunde() {
        return kunde;
    }
    
    public void setKunde(Customer kunde) {
        this.kunde = kunde;
    }
    
    public Car getAuto() {
        return auto;
    }
    
    public void setAuto(Car auto) {
        this.auto = auto;
    }
    
    public Date getBeginn() {
        return beginn;
    }
    
    public void setBeginn(Date beginn) {
        this.beginn = beginn;
    }
    
    public Date getEnde() {
        return ende;
    }
    
    public void setEnde(Date ende) {
        this.ende = ende;
    }
    //</editor-fold>
    
    
    
}
