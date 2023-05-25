package com.arjuncodes.studentsystem.repository.dts1;
import java.util.List;
//import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import com.arjuncodes.studentsystem.model.dts1.Ctpattach;





//public interface CtpattachRepository extends JpaRepository<Ctpattach, String>{
public interface CtpattachRepository extends JpaRepository<Ctpattach, Long>{
		

    //@Query(value="select COMPID, trim(NROIT) NROIT, trim(NOMIT) NOMIT, trim(PDFFIL) PDFFIL "+
    //             "from PTDHD.CTPCOMP2 a", nativeQuery=true)       
    //List<Object[]> findAll2(); 


    List<Ctpattach> findByAtachtb(String atachtb);

        
    //List<Ctpattach> findByRegidList(Sort sort, long regid);

    List<Ctpattach> findByIdreg(long idreg);
    

    
    
}