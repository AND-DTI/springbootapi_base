package com.arjuncodes.studentsystem.model.dts1;
import java.io.Serializable;



public class CustomersKey implements Serializable {

    private Integer order_id;
    private Integer product_id;

    // default constructor
    public CustomersKey(){

    }

    public CustomersKey(Integer order_id, Integer product_id) {
        this.order_id = order_id;
        this.product_id = product_id;
    }

    // equals() and hashCode()
}

