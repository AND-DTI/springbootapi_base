package com.arjuncodes.studentsystem.controller;
import com.arjuncodes.studentsystem.model.dts1.*;
import com.arjuncodes.studentsystem.model.dts1.dto.User_roleDTO;
import com.arjuncodes.studentsystem.service.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import nonapi.io.github.classgraph.utils.StringUtils;
import org.apache.commons.lang3.StringUtils;



//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/user_role")
public class User_roleController {

    
    
    @Autowired
    private User_roleService user_roleService;

    


    @GetMapping(value="/getAll", produces="application/json")
    @Operation(summary = "List all user's roles!")
    public List<User_role> list(){
        return user_roleService.listAll();
    }


    
    @PutMapping(value="/add", produces="application/text")
    @Operation(summary = "Cadastrar User Role.")
    @ApiResponses(value = {
        @ApiResponse(responseCode="201", description="{roleid: string}"),
    })
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> add(@RequestBody User_roleDTO usrDTO) throws ParseException{	
				                                            

        User_role userrole = user_roleService.mapDTOtoEntity(usrDTO);
        User_role newUserrole = user_roleService.saveUser_role(userrole);
		                        
        return ResponseEntity.status(HttpStatus.CREATED).body("User Role [ID "+newUserrole.getRoleid()+"] added!");

        /*User_role userrole = new User_role(
            "ADM_CADASTROS", 
            "Full access to master registers"
            );*/

    }


}
