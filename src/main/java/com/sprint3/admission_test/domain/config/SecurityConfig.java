package com.sprint3.admission_test.domain.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {

     @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         log.info(" ENTRA A [SecurityConfig][SecurityFilterChain]]");
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/Pharmacist").hasRole("PHARMACIST")
                .requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .httpBasic(withDefaults())
            .csrf(csrf -> csrf.disable());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder){
        log.info(" ENTRA A [SecurityConfig][UserDetailsService]]");
        UserDetails user = User.builder()
        .username("Pharmacist")
        .password(encoder.encode("1234"))
        .roles("PHARMACIST")  
        .build();

        UserDetails admin = User.builder()
        .username("admin")
        .password(encoder.encode("admin"))
        .roles("ADMIN")  
        .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
