package com.arjuncodes.studentsystem.controller;
import com.arjuncodes.studentsystem.model.dts1.*;
import com.arjuncodes.studentsystem.model.dts1.dto.CustomersDTO;
import com.arjuncodes.studentsystem.service.*;

import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/customers")
public class CustomersController {

    @Autowired
    private CustomersService customersService;

    @Autowired
	private ModelMapper mapper;
    @Autowired
    public CustomersController(ModelMapper mapper) {
       this.mapper = mapper;
       this.mapper.addConverter(myConverter);
       //this.mapper.addConverter(handlePhoneNumbersEntered);
    }


    @GetMapping(value="/getAll", produces="application/json")
    @Operation(summary = "List all customers!")
    public List<Customers> list(){
        return customersService.listAll();
    }


    //Model Mapper example
    @PutMapping(value="/add", produces="application/text")
    @Operation(summary = "Cadastrar componente.")
    @ApiResponses(value = {
        @ApiResponse(responseCode="201", description="{compid: string}"),
    })
    //public String add(@RequestBody CustomersDTO cuDTO){	
    public ResponseEntity<String> add(@RequestBody CustomersDTO cuDTO){	
		
		String var1 = "";

        //Customers cu = mapper.map(cuDTO, Customers.class); OK
        Customers cu = customersService.mapDTOtoEntity(cuDTO);



		/*Ctpcomp componente = mapper.map(compDTO, Ctpcomp.class);		
		Ctpcomp newComp = ctpcompService.saveCtpcomp(componente);
        */
        //return "New component is added [id: ";//+newComp.getCompid()+"]!";
        return ResponseEntity.status(HttpStatus.OK).body("Order ID: "+cu.getOrder_id()+"added!");


    }



    Converter<CustomersDTO, Customers> myConverter = new Converter<CustomersDTO, Customers>()
    {
        
        @Override        
        public Customers convert(MappingContext<CustomersDTO, Customers> context)
        {
          CustomersDTO s = context.getSource(); //origem
          Customers d = new Customers(); //destinbo //*context.getDestination() bug Null            
            d.setOrder_id(Integer.valueOf(s.getOrder()));
            d.setProduct_id(s.getProduct_id());
            d.setAmount(s.getAmount()+1000);
            //d.setLarge(s.getMass() > 25);
            return d;
        }
    };

}
