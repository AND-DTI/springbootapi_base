package com.arjuncodes.studentsystem.repository.dts1;

import java.util.List;
import com.arjuncodes.studentsystem.model.dts1.UserRoles0;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles0,String> {


    public List<UserRoles0> findAll();

    //List<UserRoles> findDistinctBy();

    //List<UserRoles>

    //List<UserRoles> find


}