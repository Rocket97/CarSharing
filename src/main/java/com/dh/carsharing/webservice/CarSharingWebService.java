/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.carsharing.webservice;

import com.dh.carsharing.jpa.*;
import com.dh.carsharing.ejb.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    
    @EJB
    ValidationBean validationBean;
    
    
    //Registrieren eines neuen Kundendatensatzes
    @WebMethod
    @WebResult(name="customer")
    public Customer createNewCustomer(@WebParam(name="customer") Customer customer) {
        return this.customerBean.saveNew(customer);
    }
    
    //Finden eines Customers mittels der ID
    @WebMethod
    @WebResult(name="find_customer")
    public Customer getCustomerById(@WebParam(name="id") long id) {
        return this.customerBean.findById(id);
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
    public LoanAgreement lendCar(@WebParam(name="customer")  Customer customer, @WebParam(name="car") Car car, @WebParam(name="startDate") String startDate, @WebParam(name="endDate") String endDate) throws NotAvailableException, ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return this.loanAgreementBean.lend(customer, car, sdf.parse(startDate), sdf.parse(endDate));
    }

    //Auflisten aller vorhandenen Fahrzeuge 
    @WebMethod
    @WebResult(name="findAll_cars")
    public List<Car> getAllCars() {
        return this.carBean.findAll();
    }
    
    //Finden eines Fahrzeuges mit der ID
    @WebMethod
    @WebResult(name="find_car")
    public Car getCarById(@WebParam(name="id") long id) {
        return this.carBean.findById(id);
    }
    
    //Auflisten aller Leihverträge eines Kunden
    @WebMethod
    @WebResult(name="findAll_loanAgreements")
    public List<LoanAgreement> getAllLoanAgreements() {
        return this.loanAgreementBean.findAll();
    }
    
    // Überprüfung der Daten des zu speichernden Objekts auf die Annotationen in .jpa
    @WebMethod
    @WebResult(name="validate_customer")
    public List<String> validateCustomer(@WebParam(name="customer")Customer customer) {
        return this.validationBean.validate(customer);
    }
    
    @WebMethod
    @WebResult(name="validate_car")
    public List<String> validateCar(@WebParam(name="car") Car car) {
        return this.validationBean.validate(car);
    }
}
