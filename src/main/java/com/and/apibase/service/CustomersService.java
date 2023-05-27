package com.and.apibase.service;

import java.util.List;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.and.apibase.model.dts1.Customers;
import com.and.apibase.model.dts1.dto.CustomersDTO;
import com.and.apibase.repository.dts1.CustomersRepository;




@Service
public class CustomersService
{

    final CustomersRepository cusRepository;
    
    @Autowired
	private ModelMapper mapper;

    public CustomersService(CustomersRepository cusRepository, ModelMapper mapper) {
        this.cusRepository = cusRepository;
        this.mapper = mapper;
    }

    public List<Customers> listAll() {

        //@Query("SELECT distinct a FROM Activity a ")
        return cusRepository.findAll();

    }

    public Customers mapDTOtoEntity(CustomersDTO cuDTO){

        Customers customer = mapper.map(cuDTO, Customers.class);//new Customers();

        return customer;

    }

    /*public Customers mapEntityToDTO(Customers cu){

        //create mapper2
        //Customers customer = mapper.map(cuDTO, Customers.class);//new Customers();

        //return customer;

    }*/




    //DTO definitions
    //@Autowired
	//private ModelMapper mapper;
    
    /*@Autowired
    public CustomersService(ModelMapper mapper) {
       this.mapper = mapper;
       this.mapper.addConverter(myConverter);
       //this.mapper.addConverter(handlePhoneNumbersEntered);
    }*/

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



        /*private static ModelMapper mapper = new ModelMapper();

    private static Converter<CustomersDTO, Customers> myConverter = new Converter<CustomersDTO, Customers>()
      {
          public Customers convert(MappingContext<CustomersDTO, Customers> context)
          {
            CustomersDTO s = context.getSource(); //origem
            Customers d = new Customers(); //destinbo //*context.getDestination() bug Null
              d.setAmount(s.getProduct_id());
              //d.setOrder_id(Integer.valueOf(s.getOrder())); //String to int example
              //d.setLarge(s.getMass() > 25);
              return d;
          }
      };*/

}
