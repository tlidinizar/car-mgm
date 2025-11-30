package com.mgm.car.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mgm.car.entity.UserEntity;

import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {

    private final PasswordEncoder encoder;

    public UserInfoService(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    // Method to load user details by username (email)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Fetch user from the database by email (username)
        Optional<UserEntity> userOptional = null;
        
        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
        
        // Convert UserInfo to UserDetails (UserInfoDetails)
        UserEntity user = userOptional.get();
        return new User(user.getEmail(), user.getPassword(), user.getRoles());
    }


}