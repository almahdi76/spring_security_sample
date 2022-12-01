package com.authentication.authentication.securite;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collections;

@EnableWebSecurity
@Configuration
public class SecurutyConfig {
    private PasswordEncoder passwordEncoder;

    public SecurutyConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .authorizeHttpRequests()
                .requestMatchers("/admin","/users").authenticated()
                .requestMatchers("/").permitAll()
                .and()
                .formLogin()
                .and()
                .build();
    }
   @Bean
    UserDetailsService userDetailsService(){
        return new InMemoryUserDetailsManager(
                new User("user1",passwordEncoder.encode("111"), Collections.emptyList()),
                new User("admin",passwordEncoder.encode("111"), Collections.emptyList())
        );
    }


}
