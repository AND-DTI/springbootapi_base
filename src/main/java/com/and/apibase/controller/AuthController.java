package com.and.apibase.controller;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
/* 
import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.*;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
*/

import com.and.apibase.model.dts1.User;
import com.and.apibase.model.dts1.User_Role;
import com.and.apibase.model.dts1.dto.Login;
import com.and.apibase.model.dts1.dto.LoginAD;
import com.and.apibase.model.dts1.dto.User_RoleDTO;
import com.and.apibase.service.TokenService;
import com.and.apibase.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;
//import org.springframework.beans.factory.annotation.Autowired;



@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {




    @Autowired
    AuthenticationManager authManager;
    @Autowired
    TokenService tokenService;
    @Autowired
    private UserService userService;



      
    



/*********************************************************************************************************
    ****** POST Endpoint [auth] 
 * @throws UnknownHostException******************************************************************************
    *********************************************************************************************************/    
    @GetMapping(value="/showuser", produces="application/json") 
    @Operation(summary = "Show AD User.")
    @ApiResponses(value = {
        @ApiResponse(responseCode="200", description="Usuário encontrado!"),
    })
    @ResponseStatus(HttpStatus.OK)    
    public ResponseEntity<LoginAD> showuser(HttpServletRequest request){

        
        //see InetSocketAddress           
                
        LoginAD userAD = new LoginAD(request);                
        Login login = new Login(userAD.getUser(), "noppass");        
        List<User> users = userService.listByUsername("SB011666"/*login.login()*/);

        
        //get user roles and add to loginAD                
        User user = users.get(0);
        //Set<User_Role> roles = Collections.emptySet();          
        for(GrantedAuthority aut: user.getAuthorities()){
            User_RoleDTO ur = new User_RoleDTO(                
                0, aut.getAuthority(), "desc role..."
            );
            userAD.getRoles().add(ur);
        }
         
                                                                      
        return ResponseEntity.status(HttpStatus.OK) 
            .header("Accept", "application/json")
            .body(userAD);                     

    }


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
