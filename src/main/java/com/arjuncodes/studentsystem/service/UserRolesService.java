package com.arjuncodes.studentsystem.service;

import java.util.List;
import com.arjuncodes.studentsystem.model.dts1.UserRoles0;
import com.arjuncodes.studentsystem.repository.dts1.UserRolesRepository;
import org.springframework.stereotype.Service;



@Service
public class UserRolesService
{

    final UserRolesRepository urRepository;

    public UserRolesService(UserRolesRepository urRepository) {
        this.urRepository = urRepository;
    }

    public List<UserRoles0> listarTodos() {

        //return urRepository.findDistinctBy();


//@Query("SELECT distinct a FROM Activity a ")
        return urRepository.findAll();


        //return urRepository.findAllById(Iterable<String> ids);

        //return urRepository.findDistinctByID();
    }

}
