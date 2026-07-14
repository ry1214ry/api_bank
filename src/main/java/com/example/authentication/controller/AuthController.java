package com.example.authentication.controller;

import com.example.authentication.dto.AuthResponse;
import com.example.authentication.dto.LoginRequest;
import com.example.authentication.dto.RegisterRequest;
import com.example.authentication.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(service.login(request));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            service.logout(authHeader);
            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "Token invalidated. Logged out successfully."
            ));
        }
        return ResponseEntity.badRequest().body(Map.of(
                "success", false,
                "message", "No authorization token found in headers."
        ));
    }
}