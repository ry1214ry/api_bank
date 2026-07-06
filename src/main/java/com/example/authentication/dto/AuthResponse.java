package com.example.authentication.dto;

public class AuthResponse {
    private String token;
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String role;

    // This constructor fixes the "Expected 1 argument but found 6" error!
    public AuthResponse(String token, Long id, String firstname, String lastname, String email, String role) {
        this.token = token;
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.role = role;
    }

    // Getters and Setters
    public String getToken() { return token; }
    public void setToken(String token) { this.token = token; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}