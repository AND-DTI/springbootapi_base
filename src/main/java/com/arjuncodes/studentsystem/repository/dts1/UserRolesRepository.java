package com.arjuncodes.studentsystem.repository.dts1;

import com.arjuncodes.studentsystem.model.dts1.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles,String> {


    public List<UserRoles> findAll();

    //List<UserRoles> findDistinctBy();

    //List<UserRoles>

    //List<UserRoles> find


}