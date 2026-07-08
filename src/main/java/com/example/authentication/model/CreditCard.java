package com.example.authentication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_creditcard")
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstname", length = 100, nullable = false)
    private String firstname;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "phone", length = 20, nullable = false)
    private String phone;

    @Column(name = "last_4digit", length = 4, nullable = false)
    private String last4digit;

    @Column(name = "date", length = 30, nullable = false)
    private String date;

    public CreditCard() {}

    public CreditCard(String firstname, String email, String phone, String last4digit, String date) {
        this.firstname = firstname;
        this.email = email;
        this.phone = phone;
        this.last4digit = last4digit;
        this.date = date;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getLast4digit() { return last4digit; }
    public void setLast4digit(String last4digit) { this.last4digit = last4digit; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}