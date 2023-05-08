package com.arjuncodes.studentsystem.controller;
import com.arjuncodes.studentsystem.model.dts1.*;
import com.arjuncodes.studentsystem.model.dts1.dto.CtpcompCAD;
import com.arjuncodes.studentsystem.model.dts1.dto.CtpcompDTOpost;
import com.arjuncodes.studentsystem.model.dts1.dto.CtpcompDTOput;
import com.arjuncodes.studentsystem.model.dts1.dto.RolesDTO;
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

    


    

    /*********************************************************************************************************
    ****** GET Endpoint [ctpcomp/getall] *********************************************************************
    *********************************************************************************************************/
    @GetMapping(value="/getAll", produces="application/json")
	@Operation(summary = "Lista todos os Componentes")
	@ApiResponses(value = {	    
	    @ApiResponse(responseCode="404", description="Nenhum componente cadastrado!")
	})   	        
	public ResponseEntity<List<Ctpcomp>> listAll(
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
    ****** GET Endpoint [ctpcomp/getall] *********************************************************************
    *********************************************************************************************************/
    //@PreAuthorize("hasRole(USER')")
	@GetMapping(value="/listall", produces="application/json")
	@Operation(summary = "Lista todos os Componentes")
	@ApiResponses(value = {	    
	    @ApiResponse(responseCode="404", description="Nenhum componente cadastrado!")
	})   	        
	public ResponseEntity<List<CtpcompCAD>> listAlluser(
            @PageableDefault(page=0, size=10, sort="compid", direction=Sort.Direction.ASC) Pageable pageable
        )
    {

        List<CtpcompCAD> componentes = ctpcompService.findAllCAD();				
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





    /*********************************************************************************************************
    ****** GET Endpoint [ctpcomp/getComp/{nroit}] ************************************************************
    *********************************************************************************************************/   
	@GetMapping(value="/getComp/{nroit}", produces="application/json")
	@Operation(summary = "Pega componente por código.")		
	@ApiResponses(value = {
	    @ApiResponse(responseCode="200", description="OK!"),
	    @ApiResponse(responseCode="404", description="Componente não encontrado"),
	    @ApiResponse(responseCode="500", description="Internal Server Error!"),  	    
	})   	
	public ResponseEntity<List<CtpcompCAD>> listCompByCode(@PathVariable(value="nroit") String nroit){
								
		
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
    ****** PUT Endpoint [ctpcomp/add] ************************************************************************
    *********************************************************************************************************/    
    @PutMapping(value="/add", produces="application/json") ///text if not object class
    @Operation(summary = "Cadastrar componente.")
    @ApiResponses(value = {
        @ApiResponse(responseCode="201", description="Componente cadastrado com sucesso!"),
    })
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CtpcompCAD> add(@RequestBody CtpcompDTOput compDTO) throws ParseException{	
				                                            
        
		CtpcompCAD cadastroNEW = ctpcompService.save(compDTO);
		                                			
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
    public ResponseEntity<CtpcompCAD> add(@RequestBody CtpcompDTOpost compDTO) throws ParseException{	
				                                            
        
        CtpcompCAD cadastroALT = ctpcompService.update(compDTO);
		                                			
		return ResponseEntity.status(HttpStatus.CREATED) 
			.header("Accept", "application/json")
			.body(cadastroALT);

		     
    }


    /*@PutMapping(value="/add", produces="application/text")		
	public String add(@RequestBody Ctpcomp componente){	
		
		ctpcompService.saveCtpcomp(componente);		
        return "New component is added";

	}*/

}
