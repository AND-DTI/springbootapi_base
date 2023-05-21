package com.arjuncodes.studentsystem.service;
import com.arjuncodes.studentsystem.configs.security.Auditoria;
import com.arjuncodes.studentsystem.model.dts1.Ctpattach;
import com.arjuncodes.studentsystem.model.dts1.dto.CtpattachDTO;
import com.arjuncodes.studentsystem.model.dts1.dto.CtpcompAttach_post;
import com.arjuncodes.studentsystem.repository.dts1.CtpattachRepository;
import com.arjuncodes.studentsystem.utils.Auxiliar;
import java.time.LocalDateTime;
import java.util.List;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.apache.commons.lang3.StringUtils;





@Service
public class CtpattachService
{

    
    final CtpattachRepository ctpattachRepository;           
    final String fileServer = "c:/DEV/FileServer"; //getFieServer from UDC
    final String fileServerCTP = "c:/DEV/FileServerCTP";//"//hda0158/Ferramentaria_HTA/PCCP/FILESERVER/2D"; //getFieServer from UDC
    LocalDateTime agora;
    String agoraStr, data_audit, hora_audit; 


    @Autowired
	private ModelMapper mapper;

    public CtpattachService(CtpattachRepository ctpattachRepository, ModelMapper mapper) {
        
        this.ctpattachRepository = ctpattachRepository;    
        this.mapper = mapper;
        this.mapper.addConverter(converterDTOtoENT);
                                               
    }



	/*public List<CtpcompCAD> findAllCAD() {	

		List<Ctpcomp> componentes = ctpattachRepository.findAll(Sort.by(Sort.Direction.ASC, "compid"));	
		List<CtpcompCAD> cadastros = Arrays.asList(mapper.map(componentes, CtpcompCAD[].class));
		
		return cadastros;

	}


    public List<Ctpcomp> listAll() {

        //@Query("SELECT distinct a FROM Activity a ")
        return ctpcompRepository.findAll();

    }*/


    public List<Ctpattach> findAll() {	

		return ctpattachRepository.findAll(Sort.by(Sort.Direction.ASC, "atachid"));	

	}


	/*public List<CtpcompCAD> findByCode(String nroit){

		List<Ctpcomp> componentes = ctpcompRepository.findByNroit(nroit);		
		List<CtpcompCAD> cadastros = Arrays.asList(mapper.map(componentes, CtpcompCAD[].class));

		return cadastros;
		
	}*/


	public Ctpattach saveCtpattach(Ctpattach attach){		

		return ctpattachRepository.save(attach);

	}


	public CtpcompAttach_post save(CtpattachDTO attachDTO){		


        Ctpattach attach = mapDTOToEntity(attachDTO);
		
        Ctpattach attachNew = ctpattachRepository.save(attach);
		
        CtpcompAttach_post atachCAD = new CtpcompAttach_post(
            attachNew.getAtachid(), attachNew.getAtachname(), attachNew.getB64file()
        );


		return atachCAD;
        
	}


	/*public CtpcompCAD update(CtpcompDTOpost compAlt){		

		Ctpcomp componente = mapDTOpostToEntity(compAlt);
		Ctpcomp compNew = ctpcompRepository.save(componente);
		CtpcompCAD cadastroAtualizado = mapEntityToCAD(compNew);

		return cadastroAtualizado;
	}*/




    public Ctpattach mapDTOToEntity(CtpattachDTO attachDTO){ //default mapper

        Ctpattach attach = mapper.map(attachDTO, Ctpattach.class); 

        return attach;

    }


 



    //DTO definitions
    Converter<CtpattachDTO, Ctpattach> converterDTOtoENT = new Converter<CtpattachDTO, Ctpattach>()
    {
        
        @Override        
        public Ctpattach convert(MappingContext<CtpattachDTO, Ctpattach> context) 
        {
                                                                       
            CtpattachDTO s = context.getSource(); //origem
            Ctpattach d = new Ctpattach(); //destinbo 
            Auditoria audit = new Auditoria();
            

            //String fileName = s.getNroit().trim(); //StringUtils.leftPad(s.getNroit().trim(), 5, "0");
            //String outputPDF = fileName+".PDF";
            String outputB64 = s.getAtachname().replace(".PDF", "")+"_Base64.TXT";
            String decodeResult;
            String obs = "";
                        
            decodeResult = Auxiliar.decodeBase64(s.getFileBase64(), s.getAtachname(), outputB64, fileServer, fileServerCTP);            
            if( !StringUtils.equals(decodeResult, "OK") ){
                obs = ("conversion error: "+decodeResult).substring(0, 199);
            }
            

            //Set values
            d.setAtachid(s.getAtachid()); //if 0: insert else update
            d.setAtachtb("CTPCOMP");
            d.setRegid(s.getCompid());
            d.setAtachname(s.getAtachname());
            d.setAtachpath(fileServer);
            d.setB64file(outputB64);
            d.setPubpath(fileServerCTP);
            d.setAtachobs(obs);
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