package com.csproj.CornerStore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class securityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                // Everyone can see these pages
                .requestMatchers("/navbar", "/","/index", "/products", "/cart", "/wishlist", "/images/**", "/main.css", "/navbar.css","/css/**", "/products.js","/api/**","/setAdminSession", "/clearAdminSession").permitAll()
                // Admin pages: let controller decide based on session flag
                .requestMatchers("/admin/**").permitAll()
            )
            .csrf(csrf -> csrf.disable()) 
            // Disable Spring Security’s default login form
            .formLogin(form -> form.disable())
            // Allow logout if you want to clear session
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .permitAll()
            );

        return http.build();
    }
}

