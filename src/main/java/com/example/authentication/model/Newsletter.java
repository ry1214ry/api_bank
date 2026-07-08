package com.example.authentication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_newsletter")
public class Newsletter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email", length = 200, nullable = false)
    private String email;

    @Column(name = "phone", nullable = false)
    private Integer phone;

    @Column(name = "register_date", length = 200, nullable = false)
    private String registerDate;

    // Default constructor matching the pattern
    public Newsletter() {}

    // Parameterized constructor excluding ID
    public Newsletter(String email, Integer phone, String registerDate) {
        this.email = email;
        this.phone = phone;
        this.registerDate = registerDate;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getPhone() { return phone; }
    public void setPhone(Integer phone) { this.phone = phone; }

    public String getRegisterDate() { return registerDate; }
    public void setRegisterDate(String registerDate) { this.registerDate = registerDate; }
}