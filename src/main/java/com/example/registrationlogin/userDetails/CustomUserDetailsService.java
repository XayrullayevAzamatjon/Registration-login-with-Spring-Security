package com.example.registrationlogin.userDetails;

import com.example.registrationlogin.UserRepository;
import com.example.registrationlogin.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       User user =repository.findByEmail(email);
       if (user==null){
           throw new UsernameNotFoundException("User not found");
       }
        return new CustomUserDetails(user);
    }
}
