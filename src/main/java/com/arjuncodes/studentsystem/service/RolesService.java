package com.arjuncodes.studentsystem.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import com.arjuncodes.studentsystem.model.dts1.Roles;
import com.arjuncodes.studentsystem.model.dts1.dto.RolesDTO;
import com.arjuncodes.studentsystem.repository.dts1.RolesRepository;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class RolesService
{

    final RolesRepository rolesRepository;
    
    @Autowired
	private ModelMapper mapper;

    public RolesService(RolesRepository rolesRepository, ModelMapper mapper) {
        this.rolesRepository = rolesRepository;
        this.mapper = mapper;
        this.mapper.addConverter(myConverter);
    }




    public List<Roles> listAll() {

        //@Query("SELECT distinct a FROM Activity a ")
        return rolesRepository.findAll();

    }



    public Roles saveUser_role(Roles usrrole){

        return rolesRepository.save(usrrole);
    }



    public Roles mapDTOtoEntity(RolesDTO userroleDTO){

        Roles user_role = mapper.map(userroleDTO, Roles.class);//new Customers();

        return user_role;

    }

    /*public Customers mapEntityToDTO(Customers cu){

        //create mapper2
        //Customers customer = mapper.map(cuDTO, Customers.class);//new Customers();

        //return customer;

    }*/




    //DTO definitions
    Converter<RolesDTO, Roles> myConverter = new Converter<RolesDTO, Roles>()
    {
        
        @Override        
        public Roles convert(MappingContext<RolesDTO, Roles> context)
        {
                                                                       
            RolesDTO s = context.getSource(); //origem
            Roles d = new Roles(); //destinbo //*context.getDestination() bug Null                        
                        
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
