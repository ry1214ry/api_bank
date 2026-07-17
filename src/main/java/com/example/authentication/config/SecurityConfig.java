package com.example.authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthFilter, AuthenticationProvider authenticationProvider) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/error").permitAll()

                        // 1. PUBLIC AUTH PATHS
                        .requestMatchers(
                                "/api/v1/auth", "/api/v1/auth/**",
                                "/authentication-0.0.1-SNAPSHOT/api/v1/auth", "/authentication-0.0.1-SNAPSHOT/api/v1/auth/**"
                        ).permitAll()

                        // 2. STATIC ASSETS & IMAGES
                        .requestMatchers(
                                "/images/**",
                                "/authentication-0.0.1-SNAPSHOT/images/**"
                        ).permitAll()

                        // 3. SECURE MUTATION ROUTES FOR CAREER (Requires Token)
                        .requestMatchers(HttpMethod.POST, "/api/v1/career/**", "/authentication-0.0.1-SNAPSHOT/api/v1/career/**").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/api/v1/career/**", "/authentication-0.0.1-SNAPSHOT/api/v1/career/**").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/career/**", "/authentication-0.0.1-SNAPSHOT/api/v1/career/**").authenticated()

                        // 4. SECURE MUTATION ROUTES FOR CAREER CV (Requires Token)
                        .requestMatchers(HttpMethod.GET, "/api/v1/careerCV", "/api/v1/careerCV/**", "/authentication-0.0.1-SNAPSHOT/api/v1/careerCV", "/authentication-0.0.1-SNAPSHOT/api/v1/careerCV/**").authenticated()
                        .requestMatchers(HttpMethod.PUT, "/api/v1/careerCV", "/api/v1/careerCV/**", "/authentication-0.0.1-SNAPSHOT/api/v1/careerCV", "/authentication-0.0.1-SNAPSHOT/api/v1/careerCV/**").authenticated()
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/careerCV/**", "/authentication-0.0.1-SNAPSHOT/api/v1/careerCV/**").authenticated()

                        // 5. PUBLIC GET & PUBLIC APPLICATION SUBMISSIONS (No Token Required)
                        .requestMatchers(HttpMethod.GET, "/api/v1/career", "/api/v1/career/**", "/authentication-0.0.1-SNAPSHOT/api/v1/career", "/authentication-0.0.1-SNAPSHOT/api/v1/career/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/v1/careerCV", "/api/v1/careerCV/**", "/authentication-0.0.1-SNAPSHOT/api/v1/careerCV", "/authentication-0.0.1-SNAPSHOT/api/v1/careerCV/**").permitAll()

                        // 6. ALL REMAINING CORE PUBLIC ENDPOINTS (Includes both base paths and wildcards)
                        .requestMatchers(
                                "/api/v1/products", "/api/v1/products/**",
                                "/api/v1/menus", "/api/v1/menus/**",
                                "/api/v1/creditcards", "/api/v1/creditcards/**",
                                "/api/v1/chooseposts", "/api/v1/chooseposts/**",
                                "/api/v1/intranet-folders", "/api/v1/intranet-folders/**",
                                "/api/v1/newsletter", "/api/v1/newsletter/**",
                                "/api/v1/contact-us", "/api/v1/contact-us/**",
                                "/authentication-0.0.1-SNAPSHOT/api/v1/products", "/authentication-0.0.1-SNAPSHOT/api/v1/products/**",
                                "/authentication-0.0.1-SNAPSHOT/api/v1/menus", "/authentication-0.0.1-SNAPSHOT/api/v1/menus/**",
                                "/authentication-0.0.1-SNAPSHOT/api/v1/creditcards", "/authentication-0.0.1-SNAPSHOT/api/v1/creditcards/**",
                                "/authentication-0.0.1-SNAPSHOT/api/v1/chooseposts", "/authentication-0.0.1-SNAPSHOT/api/v1/chooseposts/**",
                                "/authentication-0.0.1-SNAPSHOT/api/v1/intranet-folders", "/authentication-0.0.1-SNAPSHOT/api/v1/intranet-folders/**",
                                "/authentication-0.0.1-SNAPSHOT/api/v1/newsletter", "/authentication-0.0.1-SNAPSHOT/api/v1/newsletter/**",
                                "/authentication-0.0.1-SNAPSHOT/api/v1/contact-us", "/authentication-0.0.1-SNAPSHOT/api/v1/contact-us/**"
                        ).permitAll()

                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}