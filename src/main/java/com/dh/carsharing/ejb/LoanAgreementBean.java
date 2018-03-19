
package com.dh.carsharing.ejb;

import com.dh.carsharing.jpa.Car;
import com.dh.carsharing.jpa.LoanAgreement;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Valerie
 */
public class LoanAgreementBean extends EntityBean<LoanAgreement, Long>{
    
    //Konstruktor
    public LoanAgreementBean(){
        super(LoanAgreement.class);
    }
    
    public LoanAgreement lend (Car car, Date startDate, Date endDate){
        
        // schauen, ob gewähltes Auto in dem Zeitraum verfügbar ist
        List<LoanAgreement> la_list = em.createQuery("SELECT l FROM Leihvertrag l WHERE Car.id = :carId AND ((beginn BETWEEN :startDate AND :endDate) OR (ende BETWEEN :startDate AND endDate)) ORDER BY p.startTime, p.Name")
                .setParameter("carId", car.getId())
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
        
        LoanAgreement la = new LoanAgreement();
        
        // Leihvertrag speichern
        this.saveNew(la);
        
        return la;
    }
    
}
