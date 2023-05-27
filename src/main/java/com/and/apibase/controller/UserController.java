package com.and.apibase.controller;
import java.text.ParseException;
import java.util.List;
//import java.util.Optional;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.and.apibase.model.dts1.*;
import com.and.apibase.model.dts1.dto.Login;
import com.and.apibase.repository.dts1.UserRepository;
import com.and.apibase.service.*;




//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/securityuser")
public class UserController {

    
    
    @Autowired
    private UserService userService;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    AuthenticationService authService;

    @Autowired
    UserRepository userRepository;
    


    



    

    /*********************************************************************************************************
    ****** GET Endpoint [usersecutity/getall] *********************************************************************
    *********************************************************************************************************/
    @GetMapping(value="/getAll", produces="application/json")
	@Operation(summary = "Listar usuários")
	@ApiResponses(value = {	    
	    @ApiResponse(responseCode="404", description="Nenhum usuário cadastrado!")
	})   	        
	public ResponseEntity<List<User>> listAll( //List DTO whitout pass?
            @PageableDefault(page=0, size=10, sort="username", direction=Sort.Direction.ASC) Pageable pageable
        )
    {

        List<User> users = userService.listarTodos();
	    if (users.isEmpty()) {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(users);

    }




   


    

    /*********************************************************************************************************
    ****** PUT Endpoint [usersecutity/add] *******************************************************************
    *********************************************************************************************************/    
    @PutMapping(value="/add", produces="application/json")
    @Operation(summary = "Cadastrar usuário.")
    @ApiResponses(value = {
        @ApiResponse(responseCode="201", description="Usuário cadastrado com sucesso!"),
    })
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> add(@RequestBody User user) throws ParseException{	
				                                            

        //Ctpcomp componente = ctpcompService.mapDTOtoEntity(compDTO);
        User newUser = userService.saveUser(user);
        //CtpcompCAD cadastro = ctpcompService.mapEntityToCAD(newComponente);
		                                
        return ResponseEntity.status(HttpStatus.CREATED) 
			.header("Accept", "application/json")
			.body(newUser);
     
    }



    /*********************************************************************************************************
    ****** POST Endpoint [usersecutity/update] ***************************************************************
    *********************************************************************************************************/    
    @PostMapping(value="/changepassword", produces="application/json")
    @Operation(summary = "Resetar senha.")
    @ApiResponses(value = {
        @ApiResponse(responseCode="200", description="Senha alterada com sucesso!"),
    })
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<User> update(@RequestBody Login login) throws ParseException{	
				
        
        //User user = userService.getByUsername(login.login());

        //UserDetails user = authService.loadUserByUsername(login.login());
       // Optional<User> user = userService.getByUsernameOptional(login.login());
       
       //****User user = userRepository.findByUsername(login.login());


       //Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       //String username = ((UserDetails) principal).getUsername();
       List<User> users = userService.listByUsername(login.login());

       User user0 = null;
        for(User user : users){
            user.setPassword(encoder.encode(login.password()));
            user0 = user;
            userService.saveUser(user);
        }

       //User user = (User) userRepository.findDistinctByUsername(login.login());
       //user.setPassword(encoder.encode(login.password()));
        		                                
        return ResponseEntity.status(HttpStatus.OK) 
            .header("Accept", "application/json")
            .body(user0);
     
    }


    /*********************************************************************************************************
    ****** POST Endpoint [usersecutity/update] ***************************************************************
    *********************************************************************************************************/    
    @PostMapping(value="/update", produces="application/json")
    @Operation(summary = "Alterar usuário.")
    @ApiResponses(value = {
        @ApiResponse(responseCode="201", description="Usuário cadastrado com sucesso!"),
    })
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> update(@RequestBody User user) throws ParseException{	
				
        user.setPassword(encoder.encode(user.getPassword()));
        User newUser = userService.saveUser(user);
        		                                
        return ResponseEntity.status(HttpStatus.CREATED) 
            .header("Accept", "application/json")
            .body(newUser);
     
    }


    /*@PutMapping(value="/add", produces="application/text")		
	public String add(@RequestBody Ctpcomp componente){	
		
		ctpcompService.saveCtpcomp(componente);		
        return "New component is added";

	}*/

}
