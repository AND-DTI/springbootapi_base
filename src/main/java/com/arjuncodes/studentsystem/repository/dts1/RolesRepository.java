package com.arjuncodes.studentsystem.repository.dts1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arjuncodes.studentsystem.model.dts1.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, String>{
    
}
