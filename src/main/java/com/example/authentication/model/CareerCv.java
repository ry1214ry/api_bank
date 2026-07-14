package com.example.authentication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_career_cv")
public class CareerCv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstname", length = 100, nullable = false)
    private String firstname;

    @Column(name = "lastname", length = 100, nullable = false)
    private String lastname;

    @Column(name = "position", length = 100, nullable = false)
    private String position;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "phonenumber", length = 14, nullable = false)
    private String phonenumber;

    @Column(name = "date", length = 100, nullable = false)
    private String date;

    @Column(name = "cv", length = 5000, nullable = true)
    private String cv;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    public CareerCv() {}

    public CareerCv(String firstname, String lastname, String position, String email, String phonenumber, String date, String cv, String status) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.position = position;
        this.email = email;
        this.phonenumber = phonenumber;
        this.date = date;
        this.cv = cv;
        this.status = status;
    }


    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhonenumber() { return phonenumber; }
    public void setPhonenumber(String phonenumber) { this.phonenumber = phonenumber; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getCv() { return cv; }
    public void setCv(String cv) { this.cv = cv; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}