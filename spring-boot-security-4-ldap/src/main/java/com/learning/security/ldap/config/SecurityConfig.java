package com.learning.security.ldap.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    // 1) Configure Authentication Manager
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Approach1: inMemoryAuthentication provider OR
        /*auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
                //.withUser("user").password("{noop}password").roles("USER")    // If password encoder bean is not configured
                .and()
                .withUser("admin").password("$2a$10$CrCNsBq/yD3.165JMlYcsuH1Oppmt8k.Tnq22KrHD2Wdhs7QP9Jcy").roles("ADMIN", "USER");*/

        // Approach2: DAO Authentication provider using UserDetailsService Impl OR
       // auth.userDetailsService(userDetailsService);

        // Approach3: JDBC Authentication provider
        /*auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username,password,enabled from users where username = ? ")
                .authoritiesByUsernameQuery("select username,authority from authorities where username = ? "); */

        // Approach4 : LDAP Authentication provider
        auth.ldapAuthentication()
                .userDnPatterns("uid={0},ou=people")
                .groupSearchBase("ou=groups")
                .contextSource()
                .url("ldap://localhost:8389/dc=springframework,dc=org")
                .and()
                .passwordCompare()
                .passwordEncoder(passwordEncoder())
                .passwordAttribute("userPassword");

    }

    // 2) Configure Authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
