package com.arjuncodes.studentsystem.controller;
import com.arjuncodes.studentsystem.model.dts1.*;
import com.arjuncodes.studentsystem.model.dts1.dto.CtpattachDTO;
import com.arjuncodes.studentsystem.model.dts1.dto.CtpcompAttach_post;
import com.arjuncodes.studentsystem.model.dts1.dto.CtpcompCAD;
import com.arjuncodes.studentsystem.model.dts1.dto.CtpcompDTOpost;
import com.arjuncodes.studentsystem.model.dts1.dto.CtpcompDTOput;
import com.arjuncodes.studentsystem.service.*;
import java.text.ParseException;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/ctpcomp")
public class CtpcompController {

    
    
    @Autowired
    private CtpcompService ctpcompService;
    @Autowired
    private CtpattachService ctpattachService;
    @Autowired
    private CtpintService ctpintService;

    

    /*********************************************************************************************************
    ****** GET Endpoint [ctpcomp/getall] Don't bring attachs - attach just by single search (listByCode) *****
    *********************************************************************************************************/
    //@PreAuthorize("hasRole(USER')")
	@GetMapping(value="/listall", produces="application/json")
	@Operation(summary = "Lista todos os Componentes")
	@ApiResponses(value = {	    
	    @ApiResponse(responseCode="404", description="Nenhum componente cadastrado!")
	})   	        
	public ResponseEntity<List<CtpcompCAD>> listAll(
            @PageableDefault(page=0, size=10, sort="compid", direction=Sort.Direction.ASC) Pageable pageable
        )
    {

        //buld generic json message:
        //String respJson = 
        //"{ \"status\": 404, \"msg\": \"Nenhum componente cadastrado!\"}";  

        List<CtpcompCAD> componentes = ctpcompService.findAllCAD();	
                
	    if (componentes.isEmpty()) {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respJson);
        }
        return ResponseEntity.status(HttpStatus.OK).body(componentes);

    }	


    
    /*********************************************************************************************************
    ****** GET Endpoint [ctpcomp/getComp/{nroit}] ************************************************************
    *********************************************************************************************************/   
	@GetMapping(value="/getNro/{nroit}", produces="application/json")
	@Operation(summary = "Pega componente por código.")		
	@ApiResponses(value = {
	    @ApiResponse(responseCode="200", description="OK!"),
	    @ApiResponse(responseCode="404", description="Componente não encontrado"),
	    @ApiResponse(responseCode="500", description="Internal Server Error!"),  	    
	})   	
	public ResponseEntity<List<CtpcompCAD>> listByCode(@PathVariable(value="nroit") String nroit){
								
		
		List<CtpcompCAD> cadastros = ctpcompService.findByCode(nroit);
		
        if (cadastros.isEmpty()) {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }                       
        return ResponseEntity.status(HttpStatus.OK).body(cadastros);

		
		//List<Usuario> userRoles = usuarioService.listByUsername(nro_it);		
		//return ResponseEntity.status(HttpStatus.OK).body(usuarioOptional.get());    
	    /*if (!usuarioOptional.isPresent()) {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }*/
        //return ResponseEntity.status(HttpStatus.OK).body(userRoles); 		
	}



    /*********************************************************************************************************
    ****** GET Endpoint [ctpcomp/getComp/{id}] ***************************************************************
    *********************************************************************************************************/   
	@GetMapping(value="/getId/{id}", produces="application/json")
	@Operation(summary = "Pega componente por código.")		
	@ApiResponses(value = {
	    @ApiResponse(responseCode="200", description="OK!"),
	    @ApiResponse(responseCode="404", description="Componente não encontrado"),
	    @ApiResponse(responseCode="500", description="Internal Server Error!"),  	    
	})   	
	public ResponseEntity<CtpcompCAD> getByID(@PathVariable(value="id") long compid){
								
		
		CtpcompCAD cadastro = ctpcompService.getByID(compid);
		
        /*if (cadastro.isEmpty()) {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } */                      
        return ResponseEntity.status(HttpStatus.OK).body(cadastro);

		
		//List<Usuario> userRoles = usuarioService.listByUsername(nro_it);		
		//return ResponseEntity.status(HttpStatus.OK).body(usuarioOptional.get());    
	    /*if (!usuarioOptional.isPresent()) {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }*/
        //return ResponseEntity.status(HttpStatus.OK).body(userRoles); 		
	}





    /*********************************************************************************************************
    ****** PUT Endpoint [ctpcomp/add] ************************************************************************
    *********************************************************************************************************/    
    @PutMapping(value="/add", produces="application/json") ///text if not object class
    @Operation(summary = "Cadastrar componente.")        
    @ApiResponses(value = {
        @ApiResponse(responseCode="201", description="Componente cadastrado com sucesso!"),	    
	    @ApiResponse(responseCode="401", description="Usuário não autorizado."),
        @ApiResponse(responseCode="403", description="Perfil sem acesso a cadastro de componente."),
	    @ApiResponse(responseCode="500", description="Bad request!"),
	})   	    
    @ResponseStatus(HttpStatus.CREATED)    
    public ResponseEntity<CtpcompCAD> add(@RequestBody CtpcompDTOput compDTO) throws ParseException{	
				                                            
        //Insert ctpcomp
		CtpcompCAD cadastroNEW = ctpcompService.save(compDTO);

        //insert ctpattach
        CtpattachDTO atachDTO = new CtpattachDTO(
            cadastroNEW.getCompid(),
            compDTO.getAttachs().get(0).getAtachname(),
            compDTO.getAttachs().get(0).getFileBase64(),
            compDTO.getItaudsys(),
            compDTO.getItaudusr(),
            compDTO.getItaudhst()
        );
        CtpcompAttach_post atachCAD = ctpattachService.save(atachDTO);       
        
        cadastroNEW.getAttachs().add(atachCAD);

        
		return ResponseEntity.status(HttpStatus.CREATED) //ok()
			.header("Accept", "application/json")
			.body(cadastroNEW);
		     
    }



    /*********************************************************************************************************
    ****** POST Endpoint [ctpcomp/update] ********************************************************************
    *********************************************************************************************************/    
    @PostMapping(value="/update", produces="application/json") 
    @Operation(summary = "Altearr componente.")
    @ApiResponses(value = {
        @ApiResponse(responseCode="201", description="Componente alterado com sucesso!"),
    })
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CtpcompCAD> update(@RequestBody CtpcompDTOpost compDTO) throws ParseException{	
				                                            
        
        //Update ctpcomp
        CtpcompCAD cadastroALT = ctpcompService.update(compDTO);

        //Update ctpattach
        CtpattachDTO atachDTO = new CtpattachDTO(
            compDTO.getAttachs().get(0).getAtachid(),  
            compDTO.getCompid(),
            compDTO.getAttachs().get(0).getAtachname(),
            compDTO.getAttachs().get(0).getFileBase64(),
            compDTO.getItaudsys(),
            compDTO.getItaudusr(),
            compDTO.getItaudhst()
        );
        CtpcompAttach_post atachCAD = ctpattachService.save(atachDTO);                 
        cadastroALT.getAttachs().add(atachCAD);
        

        //Insert replication interface (ctpint)
		//Ctpint interface = null;//new CtpintService(;)
        Ctpint reply = new Ctpint(
            cadastroALT.getCompid(), 
            "CTPCOMP", 
            "FER004", 
            "AS400", 
            "SESUITE", 
            "Replica CTPCOMP para SoftExpert", 
            0
            );
        
        ctpintService.saveCtpint(reply);
        
		return ResponseEntity.status(HttpStatus.CREATED) 
			.header("Accept", "application/json")
			.body(cadastroALT);
		     
    }




    /*********************************************************************************************************
    ****** GET Endpoint [ctpcomp/getall] *ADM ****************************************************************
    *********************************************************************************************************/
    @GetMapping(value="/getAll", produces="application/json")
	@Operation(summary = "Lista todos os Componentes (com auditodia) *ADM")
	@ApiResponses(value = {	    
	    @ApiResponse(responseCode="404", description="Nenhum componente cadastrado!")
	})   	        
	public ResponseEntity<List<Ctpcomp>> getAll(
            @PageableDefault(page=0, size=10, sort="compid", direction=Sort.Direction.ASC) Pageable pageable
        )
    {
      
        List<Ctpcomp> componentes = ctpcompService.findAll();				
	    if (componentes.isEmpty()) {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);            
        }
        return ResponseEntity.status(HttpStatus.OK).body(componentes);

    }




    /*********************************************************************************************************
    ****** GET Endpoint [ctpcomp/getall2] (custom select) ****************************************************
    *********************************************************************************************************/    
    @GetMapping(value="/getAll2", produces="application/json")
	@Operation(summary = "Lista todos os Componentes")
	@ApiResponses(value = {	    
	    @ApiResponse(responseCode="404", description="Nenhum componente cadastrado!")
	})   	    
    public ResponseEntity<List<Object[]>> listAll2(){	
        	    
		List<Object[]> componentes = ctpcompService.findAll2();
		if (componentes.isEmpty()) {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(componentes); 		        

    }


}
