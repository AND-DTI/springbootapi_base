package com.arjuncodes.studentsystem.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import com.arjuncodes.studentsystem.model.dts1.User_role;
import com.arjuncodes.studentsystem.model.dts1.dto.User_roleDTO;
import com.arjuncodes.studentsystem.repository.dts1.User_roleRepository;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class User_roleService
{

    final User_roleRepository user_roleRepository;
    
    @Autowired
	private ModelMapper mapper;

    public User_roleService(User_roleRepository user_roleRepository, ModelMapper mapper) {
        this.user_roleRepository = user_roleRepository;
        this.mapper = mapper;
        this.mapper.addConverter(myConverter);
    }




    public List<User_role> listAll() {

        //@Query("SELECT distinct a FROM Activity a ")
        return user_roleRepository.findAll();

    }



    public User_role saveUser_role(User_role usrrole){

        return user_roleRepository.save(usrrole);
    }



    public User_role mapDTOtoEntity(User_roleDTO userroleDTO){

        User_role user_role = mapper.map(userroleDTO, User_role.class);//new Customers();

        return user_role;

    }

    /*public Customers mapEntityToDTO(Customers cu){

        //create mapper2
        //Customers customer = mapper.map(cuDTO, Customers.class);//new Customers();

        //return customer;

    }*/




    //DTO definitions
    Converter<User_roleDTO, User_role> myConverter = new Converter<User_roleDTO, User_role>()
    {
        
        @Override        
        public User_role convert(MappingContext<User_roleDTO, User_role> context)
        {
                                                                       
            User_roleDTO s = context.getSource(); //origem
            User_role d = new User_role(); //destinbo //*context.getDestination() bug Null                        
                        
            //Format dates and numbers
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate dt = LocalDate.parse(s.getDt_cadastro(), formatter);
            String dtStr = dt.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            long dtLong = Long.valueOf(dtStr);

                        
            d.setRoleid(s.getRoleid());
            d.setRolename(s.getRolename());
            d.setRoledesc(s.getRoledesc());
            d.setDtcad(dtLong);
                        
            return d;

        }
    };


    //SimpleDateFormat formatterS = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH); //dd-MMM-yyyy
    //Date dt = formatterS.parse(usrDTO.getDt_cadastro());        
    //DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");                                   
    //String dtStr2 = dt2.getYear()+StringUtils.leftPad(dt2.getMonthValue()+"",2,"0")+StringUtils.leftPad(dt2.getDayOfMonth()+"", 2, "0");    

}
