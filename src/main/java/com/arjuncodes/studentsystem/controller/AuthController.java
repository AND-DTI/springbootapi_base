package com.arjuncodes.studentsystem.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
/* 
import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.*;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
*/

import com.arjuncodes.studentsystem.model.dts1.User;
import com.arjuncodes.studentsystem.model.dts1.dto.Login;
import com.arjuncodes.studentsystem.service.TokenService;
import com.arjuncodes.studentsystem.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;
//import org.springframework.beans.factory.annotation.Autowired;



@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api")
public class AuthController {




    @Autowired
    AuthenticationManager authManager;

    @Autowired
    TokenService tokenService;
    //UserService userService;



    /*********************************************************************************************************
    ****** POST Endpoint [auth] ******************************************************************************
    *********************************************************************************************************/    
    @PostMapping(value="/auth", produces="application/json") 
    @Operation(summary = "Autenticar.")
    @ApiResponses(value = {
        @ApiResponse(responseCode="200", description="Autenticado com sucesso!"),
    })
    @ResponseStatus(HttpStatus.OK)    
    public ResponseEntity<String> autheticate(@RequestBody Login login){
    //public ResponseEntity<CtpcompCAD> add(@RequestBody CtpcompDTOpost compDTO) throws ParseException{	
				                                            
        UsernamePasswordAuthenticationToken userpassAuthenticationToken = 
            new UsernamePasswordAuthenticationToken(login.login(),  login.password());
        

        try{
                
            Authentication authenticate = this.authManager.authenticate(userpassAuthenticationToken);

            var usuario = (User) authenticate.getPrincipal();

            String token = tokenService.gerarToken(usuario);

            //Update user token on database...
            //***create update on UserService */

            //CtpcompCAD cadastroALT = ctpcompService.update(compDTO);		                                			
            return ResponseEntity.status(HttpStatus.OK) 
                .header("Accept", "application/json")
                .body(token);

        } catch (BadCredentialsException be) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED) 
            .header("Accept", "application/json")
            .body(be.getMessage());
        }

        //} catch (AuthenticationException e) {
        //    return ResponseEntity.badRequest().build();
        //}


    }




    
}
