package com.arjuncodes.studentsystem.controller;
import com.arjuncodes.studentsystem.model.dts1.*;
import com.arjuncodes.studentsystem.service.*;

import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/student")
//@CrossOrigin
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private UserRolesService userRolesService;

    @PostMapping(value="/add", produces="application/text")
    @Operation(summary = "Cadastra estudante!!!")
    @ApiResponses(value = {
        @ApiResponse(responseCode="201", description="{id: string}"),
    })
    public String add(@RequestBody Student student){
        studentService.saveStudent(student);
        return "New student is added";
    }

    //@PreAuthorize("hasRole('USER')")
    @GetMapping(value="/getAll", produces="application/json")
    @Operation(summary = "Lista todos os estudantes--!")
    /*@ApiResponses(value = {
        @ApiResponse(responseCode="200", description="OK!"),
        @ApiResponse(responseCode="500", description="Internal Server Error!"),       
    })*/    
    public List<Student> list(){
        return studentService.getAllStudents();
    }



    @GetMapping(value="/getRoles", produces="application/json")
    @Operation(summary = "List user's roles")
    public List<UserRoles> Listar(){
        return userRolesService.listarTodos();
    }


}
