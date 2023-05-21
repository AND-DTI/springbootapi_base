package com.arjuncodes.studentsystem.repository.dts1;
import java.util.List;
//import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import com.arjuncodes.studentsystem.model.dts1.Ctpint;






    public interface CtpintRepository extends JpaRepository<Ctpint, Long>{
		

    

        List<Ctpint> findByTablefrom(String tablefrom);
            

        List<Ctpint> findByIdreg(long idreg); //alter to Regid
    

    
    
}