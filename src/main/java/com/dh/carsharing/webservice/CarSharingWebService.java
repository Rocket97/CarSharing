/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.carsharing.webservice;

import com.dh.carsharing.jpa.*;
import com.dh.carsharing.ejb.*;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author Christian Konstantin
 */

@Stateless
@WebService
public class CarSharingWebService {
    @EJB
    CustomerBean customerBean;
    
    @EJB
    CarBean carBean;
    
    @EJB
    LoanAgreementBean loanAgreementBean;
    
    
    //Registrieren eines neuen Kundendatensatzes
    @WebMethod
    @WebResult(name="customer")
    public Customer createNewCustomer(@WebParam(name="customer") Customer customer) {
        return this.customerBean.saveNew(customer);
    }
    
    //Anlegen eines neuen Fahrzeugs
    @WebMethod
    @WebResult(name="car")
    public Car createNewCar(@WebParam(name="car") Car car) {
        return this.carBean.saveNew(car);
    }
    
    //Ausleihen eines Fahrzeugs 
    @WebMethod
    @WebResult(name="loanAgreement")
    public LoanAgreement lendCar(@WebParam(name="car") Car car, Date startDate, Date endDate) throws NotAvailableException {
        return this.loanAgreementBean.lend(car, startDate, endDate);
    }
    
    //Auflisten aller vorhandenen Fahrzeuge 
    @WebMethod
    @WebResult(name="car")
    public List<Car> getAllCars() {
        return this.carBean.findAll();
    }
    
    //Auflisten aller Leihverträge eines Kunden
    @WebMethod
    @WebResult(name="loanAgreement")
    public List<LoanAgreement> getAllLoanAgreements() {
        return this.loanAgreementBean.findAll();
    }
}
