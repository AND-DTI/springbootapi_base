package com.and.apibase.model.dts1;

import static com.and.apibase.utils.Auxiliar.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import com.arjuncodes.studentsystem.utils.Auxiliar;
import io.swagger.annotations.ApiModelProperty;

@Entity
public class Student {

    @ApiModelProperty(value = "ID da pessoa", readOnly = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    
    public Student() {
    
    }

	public Student(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {

        var texto = text.nvl2() + nvl(address);
        return texto;
        //return nvl(address);
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
