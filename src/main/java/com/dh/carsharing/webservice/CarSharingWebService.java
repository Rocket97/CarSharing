/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.carsharing.webservice;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
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
        return this.customerBean.create(customer);
    }
    
    //Anlegen eines neuen Fahrzeugs
    @WebMethod
    @WebResult(name="car")
    public Car createNewCar(@WebParam(name="car") Car car) {
        return this.carBean.create(car);
    }
    
    //Ausleihen eines Fahrzeugs 
    @WebMethod
    @WebResult(name="car")
    public Car lendCar(@WebParam(name="car") Car car) {
        return this.carBean.lend(car);
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
