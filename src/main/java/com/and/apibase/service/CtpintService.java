package com.and.apibase.service;
//import org.apache.commons.lang3.StringUtils;
//import com.arjuncodes.studentsystem.utils.Auxiliar;
//import org.modelmapper.Converter;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.spi.MappingContext;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
//import org.springframework.data.domain.Sort;

import com.and.apibase.configs.security.Auditoria;
import com.and.apibase.model.dts1.Ctpint;
import com.and.apibase.repository.dts1.CtpintRepository;






@Service
public class CtpintService
{

    
    final CtpintRepository ctpintRepository;
    
    @Value("${app.name}")
    String appname;
    @Value("${app.host}")
    String apphost;
    @Value("${app.interfaces.user}")
    String appsysuser;
                        
    //@Autowired
	//private ModelMapper mapper;



    public CtpintService(CtpintRepository ctpintRepository/*, ModelMapper mapper*/) {
        
        this.ctpintRepository = ctpintRepository;    
        //this.mapper = mapper;
        //this.mapper.addConverter(converterDTOtoENT);
                                               
    }


    /*public List<Ctpattach> findAll() {	

		return ctpattachRepository.findAll(Sort.by(Sort.Direction.ASC, "atachid"));	

	}*/



	public Ctpint saveCtpint(Ctpint ctpint){

        Auditoria audit = new Auditoria();
                    
        //Set system audit *system auto insert 
        ctpint.setItaudsys(appname); 
        ctpint.setItaudusr(appsysuser); 
        ctpint.setItaudhst(apphost); 
        ctpint.setItauddt(audit.getData_audit());
        ctpint.setItaudhr(audit.getHora_audit()); 
        
        return ctpintRepository.save(ctpint);
        
	}


 



	

}