package com.arjuncodes.studentsystem.repository.dts1;

import java.util.List;

import com.arjuncodes.studentsystem.model.dts1.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface CustomersRepository extends JpaRepository<Customers,String> {

}


