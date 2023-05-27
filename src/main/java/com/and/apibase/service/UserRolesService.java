package com.and.apibase.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.and.apibase.model.dts1.UserRoles0;
import com.and.apibase.repository.dts1.UserRolesRepository;



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
