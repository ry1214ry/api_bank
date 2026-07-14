package com.example.authentication.service;

import com.example.authentication.config.JwtService;
import com.example.authentication.dto.AuthResponse;
import com.example.authentication.dto.LoginRequest;
import com.example.authentication.dto.RegisterRequest;
import com.example.authentication.model.Role;
import com.example.authentication.model.User;
import com.example.authentication.repository.RoleRepository;
import com.example.authentication.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository repository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse register(RegisterRequest request) {
        if (repository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email address is already in use.");
        }

        String targetRoleName = "ROLE_USER";
        if (request.getRole() != null && !request.getRole().isBlank()) {
            String rawRole = request.getRole().trim().toUpperCase();


            if (rawRole.startsWith("ROLE_")) {
                targetRoleName = rawRole;
            } else {
                targetRoleName = "ROLE_" + rawRole;
            }
        }

        // 2. Validate that it's only allowed to be ROLE_ADMIN or ROLE_USER
        if (!targetRoleName.equals("ROLE_ADMIN") && !targetRoleName.equals("ROLE_USER")) {
            throw new RuntimeException("Invalid role registration requested. Must be ADMIN or USER.");
        }

        // 3. Fetch the actual Role entity from your database table
        final String finalRoleSearch = targetRoleName;
        Role userRole = roleRepository.findByName(finalRoleSearch)
                .orElseGet(() -> roleRepository.findByName("ROLE_USER")
                        .orElseThrow(() -> new RuntimeException("Default 'ROLE_USER' role could not be found in the database. Please insert it first.")));

        User user = new User(
                request.getFirstname(),
                request.getLastname(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                userRole
        );

        User savedUser = repository.save(user);
        String jwtToken = jwtService.generateToken(savedUser);

        return new AuthResponse(
                jwtToken,
                savedUser.getId(),
                savedUser.getFirstname(),
                savedUser.getLastname(),
                savedUser.getEmail(),
                savedUser.getRole() != null ? savedUser.getRole().getName() : "ROLE_USER"
        );
    }

    public AuthResponse login(LoginRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new RuntimeException("Invalid email or password combination.");
        }

        User user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + request.getEmail()));

        String jwtToken = jwtService.generateToken(user);

        return new AuthResponse(
                jwtToken,
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getEmail(),
                user.getRole() != null ? user.getRole().getName() : "ROLE_USER"
        );
    }
}