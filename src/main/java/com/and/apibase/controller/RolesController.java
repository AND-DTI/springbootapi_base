package com.and.apibase.controller;
import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.Date;
import java.util.List;
//import java.util.Locale;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
//import nonapi.io.github.classgraph.utils.StringUtils;
//import org.apache.commons.lang3.StringUtils;

import com.and.apibase.model.dts1.*;
import com.and.apibase.model.dts1.dto.RolesDTO;
import com.and.apibase.service.*;



//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/user_role")
public class RolesController {

    
    
    @Autowired
    private RolesService rolesService;

    


    @GetMapping(value="/getAll", produces="application/json")
    @Operation(summary = "List all user's roles!")
    public List<Roles> list(){
        return rolesService.listAll();
    }


    
    @PutMapping(value="/add", produces="application/text")
    @Operation(summary = "Cadastrar User Role.")
    @ApiResponses(value = {
        @ApiResponse(responseCode="201", description="{roleid: string}"),
    })
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> add(@RequestBody RolesDTO usrDTO) throws ParseException{	
				                                            

        Roles userrole = rolesService.mapDTOtoEntity(usrDTO);
        Roles newUserrole = rolesService.saveUser_role(userrole);
		                        
        return ResponseEntity.status(HttpStatus.CREATED).body("User Role [ID "+newUserrole.getRoleid()+"] added!");

        /*User_role userrole = new User_role(
            "ADM_CADASTROS", 
            "Full access to master registers"
            );*/

    }


}
