package com.arjuncodes.studentsystem.model.dts1;

import javax.persistence.*;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;
//import org.hibernate.annotations.*;
import org.hibernate.annotations.Immutable;
import org.springframework.data.annotation.*;

@Entity
@Immutable
@Table(name = "vw_user_roles")
public class UserRoles {

    @Id
    private String name;
    private String role;

    public String getName() {
        return name;
    }


    public String getRole() {
        return role;
    }


    public UserRoles() {

    }

    public UserRoles(String name, String role) {
        super();
        this.name = name;
        this.role = role;
    }



}
