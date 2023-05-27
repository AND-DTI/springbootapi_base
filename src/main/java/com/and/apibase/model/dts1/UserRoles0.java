package com.and.apibase.model.dts1;

import javax.persistence.*;
import javax.persistence.Id;
//import io.swagger.annotations.ApiModelProperty;
//import org.hibernate.annotations.*;
import org.hibernate.annotations.Immutable;
//import org.springframework.data.annotation.*;
import java.io.Serializable;


@Entity
@Immutable
@Table(name = "vw_user_roles")
public class UserRoles0 implements Serializable {

    @Id
    private String name;

    private String role;

    public String getName() {
        return name;
    }


    public String getRole() {
        return role;
    }


    public UserRoles0() {

    }

    public UserRoles0(String name, String role) {
        super();
        this.name = name;
        this.role = role;
    }



}
