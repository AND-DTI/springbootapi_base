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



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
        result = prime * result + ((product_id == null) ? 0 : product_id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CustomersKey other = (CustomersKey) obj;
        if (order_id == null) {
            if (other.order_id != null)
                return false;
        } else if (!order_id.equals(other.order_id))
            return false;
        if (product_id == null) {
            if (other.product_id != null)
                return false;
        } else if (!product_id.equals(other.product_id))
            return false;
        return true;
    }

}

