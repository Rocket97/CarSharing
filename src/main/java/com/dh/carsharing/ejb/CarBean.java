
package com.dh.carsharing.ejb;

import com.dh.carsharing.jpa.Car;
import javax.ejb.Stateless;

/**
 *
 * @author Valerie
 */
@Stateless
public class CarBean extends EntityBean<Car, Long>{
    
    public CarBean (){
        super(Car.class);
    }
    
    
}
