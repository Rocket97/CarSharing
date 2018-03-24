
package com.dh.carsharing.ejb;

import com.dh.carsharing.jpa.Car;
import com.dh.carsharing.jpa.Customer;
import com.dh.carsharing.jpa.LoanAgreement;
import com.dh.carsharing.webservice.NotAvailableException;
import java.util.Date;
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
    
    public LoanAgreement lend (Long customerID, Long carID, Date startDate, Date endDate) throws NotAvailableException{
        
         // finde den Customer und das Auto mit der übergebenen ID
        Customer customer = em.find(Customer.class, customerID);
        Car car = em.find(Car.class, carID);
            
        // schauen, ob gewähltes Auto in dem Zeitraum verfügbar ist
        Boolean verfügbar = em.createQuery("SELECT l FROM LoanAgreement l WHERE l.auto = :car AND ((l.beginn BETWEEN :startDate AND :endDate) OR (l.ende BETWEEN :startDate AND :endDate) OR (l.beginn <= :startDate AND :endDate <= l.ende))")
                .setParameter("car", car)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList().isEmpty();
        
        // Wenn keine Leihverträge gefunden wurden, dann ist das Auto verfügbar und der angeforderte Leihvertrag kann erstellt werden
        if (verfügbar){
            
            // legt einen Leihvertrag mit gegebenen Daten an
            LoanAgreement la = new LoanAgreement(customer, car, startDate, endDate);
            
            // Leihvertrag speichern
            this.saveNew(la);
            return la;
        }
        // wenn Auto nicht ausleihbar, dann soll es null zurückgeben
        else{
            throw new NotAvailableException("Das Auto ist nicht in diesem Zeitraum verfügbar.");
        }
    }
    
}
