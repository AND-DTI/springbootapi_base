package com.arjuncodes.studentsystem.controller;

import com.arjuncodes.studentsystem.model.Student;
import com.arjuncodes.studentsystem.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/student")
//@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping(value="/add", produces="application/text")
    @Operation(summary = "Cadastra estudante!!!")
    @ApiResponses(value = {
        @ApiResponse(responseCode="201", description="{id: string}"),
    })
    public String add(@RequestBody Student student){
        studentService.saveStudent(student);
        return "New student is added";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value="/getAll", produces="application/json")
    @Operation(summary = "Lista todos os estudantes--!")
    /*@ApiResponses(value = {
        @ApiResponse(responseCode="200", description="OK!"),
        @ApiResponse(responseCode="500", description="Internal Server Error!"),       
    })*/    
    public List<Student> list(){
        return studentService.getAllStudents();
    }
}
