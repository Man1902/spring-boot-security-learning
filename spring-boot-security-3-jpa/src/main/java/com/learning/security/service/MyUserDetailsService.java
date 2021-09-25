package com.learning.security.service;

import com.learning.security.entity.User;
import com.learning.security.model.MyUserDetails;
import com.learning.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional = userRepository.findByUserName(username);
        userOptional.orElseThrow(() -> new UsernameNotFoundException("User not found for userName : " + username));
        return new MyUserDetails(userOptional.get());
    }
}
