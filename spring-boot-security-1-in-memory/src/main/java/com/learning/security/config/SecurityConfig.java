package com.learning.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // 1) Configure Authentication Manager
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Approach1: inMemoryAuthentication provider OR
        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
                //.withUser("user").password("{noop}password").roles("USER")    // If password encoder bean is not configured
                .and()
                .withUser("admin").password("$2a$10$CrCNsBq/yD3.165JMlYcsuH1Oppmt8k.Tnq22KrHD2Wdhs7QP9Jcy").roles("ADMIN", "USER");

        // Approach2: DAO Authentication provider using UserDetailsService Impl OR
        //auth.userDetailsService(userDetailsService);

        // Approach3: JDBC Authentication provider
        /*auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username,password,enabled from users where username = ? ")
                .authoritiesByUsernameQuery("select username,authority from authorities where username = ? "); */
    }

    // 2) Configure Authorization
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")                     // Note : Most restrictive urls should be first
                .antMatchers("/user").hasAnyRole("USER", "ADMIN")
                .antMatchers("/", "/authenticate").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
