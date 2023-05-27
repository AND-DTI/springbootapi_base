package com.and.apibase.service;

import java.util.List;

import com.and.apibase.model.dts1.Student;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
}
