package com.arjuncodes.studentsystem.model.dts1;
import javax.persistence.*;
import javax.persistence.Id;
//import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Immutable;
//import org.springframework.data.annotation.*;

@Entity
@Immutable
@Table(name = "Customers")
@IdClass(CustomersKey.class)
public class Customers {

    @Id
    private Integer order_id;

    @Id
    private Integer product_id;

    private Integer amount;




    public Integer getOrder_id() { return order_id;   }
    public void setOrder_id(Integer order_id) { this.order_id = order_id; }

    public Integer getProduct_id() { return product_id; }
    public void setProduct_id(Integer product_id) { this.product_id = product_id; }

    public Integer getAmount() { return amount;  }
    public void setAmount(Integer amount) {   this.amount = amount;   }


    public Customers() {

    }
}

