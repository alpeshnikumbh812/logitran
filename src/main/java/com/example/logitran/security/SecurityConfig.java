package com.example.logitran.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Profiles;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    private WebSecurity web;
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        System.out.println("Globe config");
        auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().authorizeRequests()
                .antMatchers("/company/save").permitAll()
                .antMatchers("/customer/save").permitAll()
                .antMatchers("/customer/**").hasAuthority("CUSTOMER")
                .antMatchers("/company/**").hasAuthority("LOGISTIC COMPANY")
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated().and()
                .httpBasic();
        ;
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        System.out.println("WebSecurity");
//        web.ignoring().antMatchers("/company/save");
//    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception
//    {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("{noop}test123")
//                .roles("USER");
//    }
}
