package com.arjuncodes.studentsystem.repository.dts1;

import java.util.List;
import java.util.Optional;
//import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arjuncodes.studentsystem.model.dts1.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {




    List<User> findAll(); 
		

	Optional<User> findByUsername(String username);
    

	List<User> findDistinctByUsername (String username);
    
    
    /*@Override
    default <S extends User> Optional<S> findOne(Example<S> example) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }*/

    //List<User> findDistinctByUsername(String username);

    //public List<User> findAll();
        
    //List<User> findDistinctBy();

    //List<UserRoles>

    //List<UserRoles> find


}