package com.arjuncodes.studentsystem.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.arjuncodes.studentsystem.model.dts1.User;
import com.arjuncodes.studentsystem.repository.dts1.UserRepository;



@Service
public class AuthenticationService implements UserDetailsService{


    @Autowired 
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        //return userService.getByUsername(username);
        return userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    }


    
    
    
    
    
    /*final UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       
        User userModel = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        return new User(
                    userModel.getUsername(), userModel.getPassword(), true, true, true,true, userModel.getAuthorities() 
                   );

    }*/

    
}
