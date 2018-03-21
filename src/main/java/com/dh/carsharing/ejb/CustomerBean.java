
package com.dh.carsharing.ejb;

import com.dh.carsharing.jpa.Customer;
import javax.ejb.Stateless;

/**
 *
 * @author Valerie
 */
@Stateless
public class CustomerBean extends EntityBean<Customer, Long>{
    
    public CustomerBean (){
        super(Customer.class);
    }
    
    
}
