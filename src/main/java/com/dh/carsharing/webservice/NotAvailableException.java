/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dh.carsharing.webservice;

/**
 *
 * @author rocket
 */
public class NotAvailableException extends Exception {
    public NotAvailableException(String message) {
        super(message);
    }
}
