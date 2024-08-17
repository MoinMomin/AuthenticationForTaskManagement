package com.novalabs.authservice.service;

import com.novalabs.authservice.UserRepository;
import com.novalabs.authservice.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userServiceImpl implements UserService{
@Autowired
    UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public Users signUp(Users users) {
        Optional<Users> userDbOpt=userRepository.findByEmail(users.getEmail());
        if(!userDbOpt.isEmpty()){
return  null;
        }
        users.setPassword(passwordEncoder.encode(users.getPassword()));

        return userRepository.save(users);
    }
}
