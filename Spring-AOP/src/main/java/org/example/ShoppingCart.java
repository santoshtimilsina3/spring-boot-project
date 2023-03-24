package org.example;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {

    public String checkout(String status){
        //Logging
        //Authentication and Authorization
        //Sanitize the Data
        System.out.println("checkout method from shopping cart called"+ status);
        return status;
    }
}
