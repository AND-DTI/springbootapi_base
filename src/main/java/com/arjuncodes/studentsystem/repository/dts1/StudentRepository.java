package com.arjuncodes.studentsystem.repository.dts1;

import com.arjuncodes.studentsystem.model.dts1.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {



}
