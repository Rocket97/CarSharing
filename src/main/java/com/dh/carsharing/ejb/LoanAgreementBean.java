
package com.dh.carsharing.ejb;

import com.dh.carsharing.jpa.Car;
import com.dh.carsharing.jpa.Customer;
import com.dh.carsharing.jpa.LoanAgreement;
import com.dh.carsharing.webservice.NotAvailableException;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Valerie
 */
@Stateless
public class LoanAgreementBean extends EntityBean<LoanAgreement, Long>{
    
    //Konstruktor
    public LoanAgreementBean() {
        super(LoanAgreement.class);
    }
    
    public LoanAgreement lend (Customer customer, Car car, Date startDate, Date endDate) throws NotAvailableException{
        
        // schauen, ob gewähltes Auto in dem Zeitraum verfügbar ist
        List<LoanAgreement> la_list = em.createQuery("SELECT l FROM LoanAgreement l WHERE auto_id = :carId AND ((beginndatum BETWEEN :startDate AND :endDate) OR (endedatum BETWEEN :startDate AND :endDate) OR (beginndatum <= :startDate AND :endDate <= endedatum))")
                .setParameter("carId", car.getId())
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
        if (la_list == null){
            LoanAgreement la = new LoanAgreement(customer, car, startDate, endDate);
            // Leihvertrag speichern
            this.saveNew(la);
            return la;
        }
        // wenn Auto nicht ausleihbar, dann soll es null zurückgeben
        else{
            throw new NotAvailableException("Das Auto ist nicht in diesem zeitraum verfügbar.");
        }
    }
    
}
