/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tramites;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.una.tramites.services.UsuarioServiceImplementation;

/**
 *
 * @author andre
 */
@Configuration
@EnableWebSecurity
 
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 @Autowired
 private UsuarioServiceImplementation userService;
 @Autowired
 private BCryptPasswordEncoder bCrypt;

 @Bean
 public BCryptPasswordEncoder passwordEncoder() {
 BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
 return bCryptPasswordEncoder;
 }
 @Override
 protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder)
throws Exception {
authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(bCrypt);
 }
 @Override
 protected void configure(HttpSecurity http) throws Exception {
 http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
 }
}

