package com.arjuncodes.studentsystem.repository.dts1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.arjuncodes.studentsystem.model.dts1.Ctpcomp;

public interface CtpcompRepository extends JpaRepository<Ctpcomp, String>{
		

    @Query(value="select COMPID, trim(NRO_IT) NRO_IT, trim(NOM_IT) NOM_IT, trim(PDFFIL) PDFFIL "+
                 "from PTDHD.CTPCOMP2 a", nativeQuery=true)   
    //@Query("select new FlwPlan(a.codcia, a.ponum) from FlwPlan a")
    List<Object[]> findAll2(); 


}
