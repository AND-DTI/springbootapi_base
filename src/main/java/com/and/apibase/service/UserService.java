package com.and.apibase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.and.apibase.model.dts1.User;
import com.and.apibase.repository.dts1.UserRepository;



@Service
public class UserService
{

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }





    public List<User> listarTodos() {
        
        //@Query("SELECT distinct a FROM Activity a ")
        return userRepository.findAll();
        
    }


    /*public List<User> findAll() {
		
		return findAll();
		
	}*/
		
	
	public List<User> listByUsername(String username) {
				
		return userRepository.findDistinctByUsername(username.toUpperCase());        
							
	}


    


    public Optional<User> getByUsernameOptional(String username) {
				
		//return (User) userRepository.findDistinctByUsername(username.toUpperCase());
        return userRepository.findByUsername(username.toUpperCase());
							
	}

    
    public User getByUsername(String username) {
				
		return (User) userRepository.findDistinctByUsername(username.toUpperCase());        
							
	}


    public User saveUser(User user){

		return userRepository.save(user);

	}


}


//return urRepository.findDistinctBy();
//return urRepository.findAllById(Iterable<String> ids);
//return urRepository.findDistinctByID();
