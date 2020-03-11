package com.learning.security.service;

import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService, Serializable {
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserDetails userDetails = new UserDetails() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                return grantedAuthorities;
            }

            @Override
            public String getPassword() {
                return "$2a$10$CrCNsBq/yD3.165JMlYcsuH1Oppmt8k.Tnq22KrHD2Wdhs7QP9Jcy"; //password
            }

            @Override
            public String getUsername() {
                return "admin";
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }
        };
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;
    }
}