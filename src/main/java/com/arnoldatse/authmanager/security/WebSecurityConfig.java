package com.arnoldatse.authmanager.security;

import com.arnoldatse.authmanager.admin.security.AdminAuthenticationProvider;
import com.arnoldatse.authmanager.customers.security.CustomerAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    AdminAuthenticationProvider adminAuthenticationProvider;
    @Autowired
    CustomerAuthenticationProvider customerAuthenticationProvider;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.authenticationProvider(adminAuthenticationProvider);
        authenticationManagerBuilder.authenticationProvider(customerAuthenticationProvider);
        System.out.println(
                "\n\n\n----------------------------------------------\n\n\n"
                +"AuthenticationManagerBuilder: "+authenticationManagerBuilder.toString()
                +"\n\n\n----------------------------------------------\n\n\n"
        );
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(authorization->authorization
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/orders/**").hasRole("CUSTOMER")
                .anyRequest().permitAll()
        )
        .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}