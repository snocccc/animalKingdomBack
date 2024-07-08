package com.pinoypliks.co.animalkingdom.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity

public class SecurityConfig {
    private UserDetailsService userDetailService;

    public SecurityConfig(UserDetailsService userDetailService){
        this.userDetailService = userDetailService;
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
    throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(
            (authorize) -> authorize.requestMatchers(HttpMethod.GET, "/api/v1/**").permitAll()
            .anyRequest().authenticated()


        );
        return http.build();
    }

}
