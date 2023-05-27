package com.and.apibase.repository.dts1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.and.apibase.model.dts1.UserRoles0;






public interface UserRolesRepository extends JpaRepository<UserRoles0,String> {


    public List<UserRoles0> findAll();

    //List<UserRoles> findDistinctBy();

    //List<UserRoles>

    //List<UserRoles> find


}