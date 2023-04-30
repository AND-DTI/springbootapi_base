package com.arjuncodes.studentsystem.repository.dts1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arjuncodes.studentsystem.model.dts1.User_role;

@Repository
public interface User_roleRepository extends JpaRepository<User_role, String>{
    
}
