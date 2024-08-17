package com.novalabs.authservice.configuration;

import com.novalabs.authservice.UserRepository;
import com.novalabs.authservice.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserDetailsImplement implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Optional<Users> optionalUser= userRepository.findByName(username);
       if(optionalUser.isEmpty()){
           throw new UsernameNotFoundException("Could not find user");
       }
        return new UserDetailsDAO(optionalUser.get());
    }
}
