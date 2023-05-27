package com.and.apibase.service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.and.apibase.configs.security.Auditoria;
import com.and.apibase.model.dts1.Ctpattach;
import com.and.apibase.model.dts1.Ctpcomp;
import com.and.apibase.model.dts1.dto.CtpcompAttach_post;
import com.and.apibase.model.dts1.dto.CtpcompCAD;
import com.and.apibase.model.dts1.dto.CtpcompDTOpost;
import com.and.apibase.model.dts1.dto.CtpcompDTOput;
import com.and.apibase.repository.dts1.CtpattachRepository;
import com.and.apibase.repository.dts1.CtpcompRepository;
import com.and.apibase.utils.Auxiliar;

import org.springframework.data.domain.Sort;
//import org.apache.commons.lang3.StringUtils;
//import antlr.StringUtils;






@Service
public class CtpcompService
{

    final CtpcompRepository ctpcompRepository;  
    final CtpattachRepository ctpattachRepository;
    final String fileServer = "c:/DEV/FileServer"; //getFieServer from UDC
    final String fileServerCTP = "c:/DEV/FileServerCTP"; //getFieServer from UDC
    LocalDateTime agora;
    String agoraStr, data_audit, hora_audit;// DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());


    @Autowired
	private ModelMapper mapper;
    


    public CtpcompService(CtpcompRepository ctpcompRepository, CtpattachRepository ctpattachRepository, ModelMapper mapper) {

        this.ctpcompRepository = ctpcompRepository;
        this.ctpattachRepository = ctpattachRepository;
        this.mapper = mapper;
        this.mapper.addConverter(converterDTOputToENT);
        this.mapper.addConverter(converterDTOpostToENT);

        /*this.agora = LocalDateTime.now();        
        this.agoraStr = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(agora);
        this.data_audit = agora.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        this.hora_audit = agora.format(DateTimeFormatter.ofPattern("HH:mm:ss"));*/                                        
    }



	public List<CtpcompCAD> findAllCAD() {	

		List<Ctpcomp> componentes = ctpcompRepository.findAll(Sort.by(Sort.Direction.ASC, "compid"));	
		List<CtpcompCAD> cadastros = Arrays.asList(mapper.map(componentes, CtpcompCAD[].class));

        
        for(CtpcompCAD cad : cadastros){
            
            //get first attach
            List<Ctpattach> attachs = ctpattachRepository.findByIdreg(cad.getCompid());
            CtpcompAttach_post atachCAD = new CtpcompAttach_post(
                attachs.get(0).getAtachid(), 
                attachs.get(0).getAtachname(), 
                attachs.get(0).getAtachtp(),
                attachs.get(0).getB64file() //just attach file name not the full data base64
            );
            cad.getAttachs().add(atachCAD);
        };
        
        
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



    public CtpcompCAD getByID(long id) {

        //@Query("SELECT distinct a FROM Activity a ")
        //Optional<Ctpcomp> componente = ctpcompRepository.findById(String.valueOf(id)); //using string gets error
        //Optional<Ctpcomp> componente = ctpcompRepository.findById(id);  OK

        Ctpcomp componente = ctpcompRepository.findById(id).get(); 

        
        //Get first component attach
        //List<Ctpattach> attach = ctpattachRepository.findByRegidList( (Sort.by(Sort.Direction.ASC, "atachid")), id); **erro: No property 'list' found for type 'long' 
        //Obs replace by custom query (atachtb='CTPCOMP' and regid=compid) when attach table used by others registers beyond CTPCOMP
        List<Ctpattach> attachs = ctpattachRepository.findByIdreg(id);        
        Ctpattach singleAttach = attachs.get(0);

        String fileBase64 = singleAttach.getAtachpath()+"/"+singleAttach.getB64file();
        String base64Data = Auxiliar.readFile(fileBase64);
        
        CtpcompAttach_post atachCAD = new CtpcompAttach_post(
            singleAttach.getAtachid(),             
            singleAttach.getAtachname(), 
            singleAttach.getAtachtp(),
            base64Data //replace by blob from table (atachdata)
        );
                
        CtpcompCAD cadastro = mapEntityToCAD(componente);
        cadastro.getAttachs().add(atachCAD);

        return cadastro;

    }    

	public List<CtpcompCAD> findByCode(String nroit){

		List<Ctpcomp> componentes = ctpcompRepository.findByNroit(nroit);		
		List<CtpcompCAD> cadastros = Arrays.asList(mapper.map(componentes, CtpcompCAD[].class));
		        
        for(CtpcompCAD cad : cadastros){
            
            //get first attach
            List<Ctpattach> attachs = ctpattachRepository.findByIdreg(cad.getCompid());
            CtpcompAttach_post atachCAD = new CtpcompAttach_post(
                attachs.get(0).getAtachid(), 
                attachs.get(0).getAtachtp(),
                attachs.get(0).getAtachname(), 
                attachs.get(0).getB64file() //just attach file name not the full data base64
            );
            cad.getAttachs().add(atachCAD);
        };        
        
        
        
        return cadastros;
				
		//https://www.baeldung.com/spring-data-derived-queries
		//Optional<Ctpcomp> componente = ctpcompRepository
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

        Ctpcomp componente = mapper.map(compDTO, Ctpcomp.class); 
        return componente;

    }


    public Ctpcomp mapDTOpostToEntity(CtpcompDTOpost compDTO){

        Ctpcomp componente = mapper.map(compDTO, Ctpcomp.class);
        return componente;

    }	


    public CtpcompCAD mapEntityToCAD(Ctpcomp comp){

        CtpcompCAD cad = mapper.map(comp, CtpcompCAD.class);//default mapper;
        return cad;

    }    

 

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
            long epoch = dt.toEpochSecond(LocalTime.parse("00:00:00"), ZoneOffset.UTC);
            //String fileName = StringUtils.leftPad(s.getNroit().trim(), 5, "0");
            //String outputPDF = fileName+".PDF";
            //**removido String outputPDF = s.getAttachs().get(0).getAtachname();
            //**removido String pathPDF = fileServerCTP+"/"+outputPDF; //for user PDFFILL
                        
          
            //Set values
            d.setNroit(s.getNroit());
            d.setNomit(s.getNomit());
            d.setObsit(s.getObsit());
            d.setDtacad(epoch);//unix
            d.setDtacads(dtStr);
            //d.setUsrcad(s.getUsrcad());
            d.setUsrcads(s.getUsrcads());
            d.setCategory(s.getCategory());                        
            //Set system audit                        
            d.setItaudsys(s.getItaudsys()); //sysrequest - frontend
            d.setItaudusr(s.getItaudusr()); //loged user on frontend
            d.setItaudhst(s.getItaudhst()); //host user who call frontend
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
            long epoch = dt.toEpochSecond(LocalTime.parse("20:12:32"), ZoneOffset.UTC);
            
            //String fileName = s.getNroit().trim();
            //String outputPDF = fileName+".PDF";  
            //**removido String outputPDF = s.getAttachs().get(0).getAtachname();
            //**removido String pathPDF = fileServerCTP+"/"+outputPDF; //for user PDFFILL
                        
          
            //Set values
			d.setCompid(s.getCompid());
            d.setNroit(s.getNroit());
            d.setNomit(s.getNomit());
            d.setObsit(s.getObsit());
            d.setDtacad(epoch);//unix
            d.setDtacads(dtStr);
            //d.setUsrcad(s.getUsrcad());
            d.setUsrcads(s.getUsrcads());
            d.setCategory(s.getCategory());  
            //Set system audit
            d.setItaudsys(s.getItaudsys()); //sysrequest - frontend
            d.setItaudusr(s.getItaudusr()); //loged user on frontend
            d.setItaudhst(s.getItaudhst()); //host user who call frontend
            d.setItauddt(audit.getData_audit());
            d.setItaudhr(audit.getHora_audit());
                        
            return d;

        }
    };



}






		//Single object
        //List<Ctpcomp> planos = myRepository.findAll(Sort.by(Sort.Direction.ASC, "plnseq"));
		//final var planosDTO = modelMapper.map(planos, FlwPlanDTO.class);


		//List object
		//List<FlwPlan> plans = new ArrayList<>();		
		/*plans.add(			
			new FlwPlan(
					"05001", 900000123, "X1", null, null, "P", 0, 
					"20221111", "JP", "MA", "CP_0", 1, "Create PO", 
					0, 0, 0, 0, 0, "", "", "", "", ""
				)
		);
		plans.add...*/
		//List<FlwPlanDTO> deptDTO = mapper.map(plans, new TypeToken<List<FlwPlanDTO>>(){}.getType());
        //List<PostDTO> postDtoList = Arrays.asList(modelMapper.map(postEntityList, PostDTO[].class));
		//List<FlwPlanDTO> planosDTO = Arrays.asList(modelMapper.map(planos, FlwPlanDTO[].class));


	