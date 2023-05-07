package com.arjuncodes.studentsystem.service;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import com.arjuncodes.studentsystem.configs.security.Auditoria;
import com.arjuncodes.studentsystem.model.dts1.Ctpcomp;
import com.arjuncodes.studentsystem.model.dts1.dto.CtpcompCAD;
import com.arjuncodes.studentsystem.model.dts1.dto.CtpcompDTOpost;
import com.arjuncodes.studentsystem.model.dts1.dto.CtpcompDTOput;
import com.arjuncodes.studentsystem.repository.dts1.CtpcompRepository;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
//import antlr.StringUtils;
import org.apache.commons.lang3.StringUtils;
import com.arjuncodes.studentsystem.utils.Auxiliar;
//import com.arjuncodes.studentsystem.utils.Auxiliar.*;



@Service
public class CtpcompService
{

    final CtpcompRepository ctpcompRepository;            
    final String fileServer = "c:/DEV/FileServer"; //getFieServer from UDC        
    LocalDateTime agora;
    String agoraStr, data_audit, hora_audit;// DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());


    @Autowired
	private ModelMapper mapper;

    public CtpcompService(CtpcompRepository ctpcompRepository, ModelMapper mapper) {
        this.ctpcompRepository = ctpcompRepository;        
        this.mapper = mapper;
        this.mapper.addConverter(converterDTOputToENT);
        this.mapper.addConverter(converterDTOpostToENT);
        
        //this.mapper.addConverter(converterDTOtoENT);
        //this.mapper.addConverter(converterENTtoCAD);

        
        /*this.agora = LocalDateTime.now();        
        this.agoraStr = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(agora);
        this.data_audit = agora.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        this.hora_audit = agora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));*/
                                
        
    }


    
    public List<CtpcompCAD> findAllCAD() {	

		List<Ctpcomp> componentes = ctpcompRepository.findAll(Sort.by(Sort.Direction.ASC, "compid"));	
		List<CtpcompCAD> cadastros = Arrays.asList(mapper.map(componentes, CtpcompCAD[].class));
		
		return cadastros;

	}



    public List<Ctpcomp> listAll() {

        //@Query("SELECT distinct a FROM Activity a ")
        return ctpcompRepository.findAll();

    }


    public List<Ctpcomp> findAll() {	

		return ctpcompRepository.findAll(Sort.by(Sort.Direction.ASC, "compid"));	

	}


	public List<Object[]> findAll2() {	

		return ctpcompRepository.findAll2();	

	}


    public List<CtpcompCAD> findByCode(String nroit){

		List<Ctpcomp> componentes = ctpcompRepository.findByNroit(nroit); //update filed name on AS400 from nro_it to nroit		
		List<CtpcompCAD> cadastros = Arrays.asList(mapper.map(componentes, CtpcompCAD[].class));
	
		return cadastros;
		
		
		//https://www.baeldung.com/spring-data-derived-queries
		//Optional<Ctpcomp> componente = ctpcompRepository

		//return urRepository.findAllById(Iterable<String> ids);
		//return urRepository.findAllById(Iterable<String> ids);

        //return urRepository.findDistinctByID();
		
	}


	public Ctpcomp saveCtpcomp(Ctpcomp componente){		

		return ctpcompRepository.save(componente);

	}



    public CtpcompCAD save(CtpcompDTOput compInsert){		

		Ctpcomp componente = mapDTOputToEntity(compInsert);
		Ctpcomp compNew = ctpcompRepository.save(componente);
		CtpcompCAD cadastroNovo = mapEntityToCAD(compNew);

		return cadastroNovo;
	}	


	public CtpcompCAD update(CtpcompDTOpost compAlt){		

		Ctpcomp componente = mapDTOpostToEntity(compAlt);
		Ctpcomp compNew = ctpcompRepository.save(componente);
		CtpcompCAD cadastroAtualizado = mapEntityToCAD(compNew);

		return cadastroAtualizado;
	}




    public Ctpcomp mapDTOputToEntity(CtpcompDTOput compDTO){

        Ctpcomp componente = mapper.map(compDTO, Ctpcomp.class);//new Customers();

        return componente;

    }


    public Ctpcomp mapDTOpostToEntity(CtpcompDTOpost compDTO){

        Ctpcomp componente = mapper.map(compDTO, Ctpcomp.class);

        return componente;

    }	    


    public CtpcompCAD mapEntityToCAD(Ctpcomp comp){

        CtpcompCAD cad = mapper.map(comp, CtpcompCAD.class); //default mapper;

        return cad;

    }    

    /*public Customers mapEntityToDTO(Customers cu){

        //create mapper2
        //Customers customer = mapper.map(cuDTO, Customers.class);//new Customers();

        //return customer;

    }*/




    //DTO definitions
    Converter<CtpcompDTOput, Ctpcomp> converterDTOputToENT = new Converter<CtpcompDTOput, Ctpcomp>()
    {
        
        @Override        
        public Ctpcomp convert(MappingContext<CtpcompDTOput, Ctpcomp> context) 
        {
                                                                       
            CtpcompDTOput s = context.getSource(); //origem
            Ctpcomp d = new Ctpcomp(); //destinbo //*context.getDestination() bug Null                        
            Auditoria audit = new Auditoria();
            

            //Format dates and numbers            
            LocalDate dt = LocalDate.parse(s.getDtacadS(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String dtStr = dt.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            //long dtLong = Long.valueOf(dtStr);
            
            String fileName = s.getNroit().trim();//StringUtils.leftPad(s.getNro_it().trim(), 5, "0");
            String outputPDF = fileName+".PDF";
            String outputB64 = fileName+"_Base64.TXT";
            String decodeResult;
            String pathPDF = fileServer+"\\"+outputPDF;
                        
            decodeResult = Auxiliar.decodeBase64(s.getFileBase64(), outputPDF, outputB64, fileServer);            
            if( !StringUtils.equals(decodeResult, "OK") ){
                pathPDF = ("conversion error: "+decodeResult).substring(0, 199);
            }
            

            //Set values
            d.setNroit(s.getNroit());
            d.setNom_it(s.getNom_it());
            d.setPdffil(pathPDF);
            d.setDtacad(dtStr);
            d.setUsrcad(s.getUsrcad());
            d.setObs(s.getObs());
            //Set system audit
            d.setItaudsys("sysrequest");
            d.setItaudusr("usrlogged");
            d.setItaudhst("hostrequest"); //get from login
            d.setItauddt(audit.getData_audit());
            d.setItaudhr(audit.getHora_audit());
                        
            return d;

        }
    };




    Converter<CtpcompDTOpost, Ctpcomp> converterDTOpostToENT = new Converter<CtpcompDTOpost, Ctpcomp>()
    {
        
        @Override        
        public Ctpcomp convert(MappingContext<CtpcompDTOpost, Ctpcomp> context) 
        {
                                                                       
            CtpcompDTOpost s = context.getSource(); //origem
            Ctpcomp d = new Ctpcomp(); 				//destinbo 
            Auditoria audit = new Auditoria();
            

            //Format dates and numbers            
            LocalDate dt = LocalDate.parse(s.getDtacadS(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String dtStr = dt.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
            
            
            String fileName = s.getNroit().trim();
            String outputPDF = fileName+".PDF";
            String outputB64 = fileName+"_Base64.TXT";             
            String pathPDF = fileServer+"\\"+outputPDF;
                        
            String decodeResult = Auxiliar.decodeBase64(s.getFileBase64(), outputPDF, outputB64, fileServer);            
            if( !StringUtils.equals(decodeResult, "OK") ){
                pathPDF = ("conversion error: "+decodeResult).substring(0, 199);
            }
            

            //Set values
			d.setCompid(s.getCompid());
            d.setNroit(s.getNroit());
            d.setNom_it(s.getNom_it());
            d.setPdffil(pathPDF);
            d.setDtacad(dtStr);
            d.setUsrcad(s.getUsrcad());
            d.setObs(s.getObs());
            //Set system audit
            d.setItaudsys("sysrequest");
            d.setItaudusr("usrlogged");
            d.setItaudhst("hostrequest"); //get from login
            d.setItauddt(audit.getData_audit());
            d.setItaudhr(audit.getHora_audit());
                        
            return d;

        }
    };


    /*Converter<Ctpcomp, CtpcompCAD> converterENTtoCAD = new Converter<Ctpcomp, CtpcompCAD>()
    {
        
        @Override        
        public CtpcompCAD convert(MappingContext<Ctpcomp, CtpcompCAD> context)
        {
                                                                       
            Ctpcomp s = context.getSource(); //origem
            CtpcompCAD d = new CtpcompCAD(); //destinbo //*context.getDestination() bug Null                        
              
            //Set values
            d.setCompid(s.getCompid());
            d.setNro_it(s.getNro_it());
            d.setNom_it(s.getNom_it());
            d.setPdffil(s.getPdffil());
            d.setDtacad(s.getDtacad());
            d.setUsrcad(s.getUsrcad());
            d.setObs(s.getObs());


            return d;

        }
    };    
*/

}
