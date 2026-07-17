package com.example.authentication.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.authentication.model.Role;
import com.example.authentication.repository.RoleRepository;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initializeRoles(RoleRepository roleRepository) {
        return args -> {

            // 1. Seed standard USER role if not present under any common variation
            if (roleRepository.findByName("ROLE_USER").isEmpty() && roleRepository.findByName("user").isEmpty()) {
                Role userRole = new Role();
                userRole.setName("ROLE_USER");
                userRole.setRole("user");
                userRole.setCategories("0"); // Matching the category structure in your image

                roleRepository.save(userRole);
                System.out.println(">> Seeded default missing role: ROLE_USER");
            }

            // 2. Seed standard ADMIN role if not present under any common variation
            if (roleRepository.findByName("ROLE_ADMIN").isEmpty() && roleRepository.findByName("administrator").isEmpty()) {
                Role adminRole = new Role();
                adminRole.setName("ROLE_ADMIN");
                adminRole.setRole("administrator");
                adminRole.setCategories("0");

                roleRepository.save(adminRole);
                System.out.println(">> Seeded default missing role: ROLE_ADMIN");
            }
        };
    }
}