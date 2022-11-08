package com.arjuncodes.studentsystem.service;

import java.util.List;
import com.arjuncodes.studentsystem.model.dts1.Customers;
import com.arjuncodes.studentsystem.repository.dts1.CustomersRepository;
import org.springframework.stereotype.Service;




@Service
public class CustomersService
{

    final CustomersRepository cusRepository;

    public CustomersService(CustomersRepository cusRepository) {
        this.cusRepository = cusRepository;
    }

    public List<Customers> listAll() {

        //@Query("SELECT distinct a FROM Activity a ")
        return cusRepository.findAll();

    }

}
