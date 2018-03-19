
package com.dh.carsharing.ejb;

import com.dh.carsharing.jpa.Customer;

/**
 *
 * @author Valerie
 */
public class CustomerBean extends EntityBean<Customer, Long>{
    
    public CustomerBean (){
        super(Customer.class);
    }
    
    
}
