
package com.dh.carsharing.ejb;

import com.dh.carsharing.jpa.Car;

/**
 *
 * @author Valerie
 */
public class CarBean extends EntityBean<Car, Long>{
    
    public CarBean (){
        super(Car.class);
    }
    
    
}
