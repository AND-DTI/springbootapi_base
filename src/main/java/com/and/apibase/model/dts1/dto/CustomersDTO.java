package com.and.apibase.model.dts1.dto;
//import org.aspectj.apache.bcel.generic.Type;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel
public class CustomersDTO {
    


    @ApiModelProperty(position=0, value="Order Nº", example="000123", dataType="Int")
    private String order; //map order_id (integer) to "000999" format

    @ApiModelProperty(value="Product ID", example="100010", position=1, hidden=false)
    private Integer product_id;

    @ApiModelProperty(value="Quantity", example="120", position=2)
    private Integer amount;


    
    public String getOrder() {        return order;    }
    public void setOrder(String order) {
        this.order = order;
    }  

    public Integer getProduct_id() {        return product_id;    }
    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getAmount() {        return amount;    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }



    public CustomersDTO(String order, Integer product_id, Integer amount) {
        this.order = order;
        this.product_id = product_id;
        this.amount = amount;
    }

    
}
