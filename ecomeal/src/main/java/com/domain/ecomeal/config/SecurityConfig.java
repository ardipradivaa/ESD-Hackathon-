package com.domain.ecomeal.config;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    public UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
        .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(registry->{
                registry.requestMatchers("/register/**").permitAll();
                // registry.requestMatchers("/home/**").hasRole("USER");
                // registry.anyRequest().authenticated();
                registry.anyRequest().permitAll();

        })
        .formLogin(httpSecurityFormLoginConfigurer -> {
            httpSecurityFormLoginConfigurer
                    // .loginPage("/login")
                    .successHandler(new AuthenticationSuccessHandler())
                    .permitAll();
        })
        .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return userDetailsService;
    }
    
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
