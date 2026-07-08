package com.example.authentication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_infrar_client")
public class InfrarClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // increasement
    private Integer id;

    @Column(name = "username", nullable = false, length = 100)   // can be  not null
    private String username;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "department", nullable = false, length = 200)
    private String department;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "date_register", nullable = false, length = 100)
    private String dateRegister;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDateRegister() { return dateRegister; }
    public void setDateRegister(String dateRegister) { this.dateRegister = dateRegister; }
}

