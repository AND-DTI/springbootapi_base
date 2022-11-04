package com.arjuncodes.studentsystem.service;

import com.arjuncodes.studentsystem.model.dts1.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
}
