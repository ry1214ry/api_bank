package com.example.authentication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_contact_us")
public class ContactUs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Matches your primary key column name 'id'
    private Integer id;

    @Column(name = "location", length = 100, nullable = false)
    private String location;

    @Column(name = "tproduct", length = 100, nullable = false)
    private String tproduct;

    @Column(name = "firstname", length = 100, nullable = false)
    private String firstname;

    @Column(name = "lastname", length = 100, nullable = false)
    private String lastname;

    @Column(name = "phone", nullable = false)
    private Integer phone;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "ccustomer", length = 20, nullable = false)
    private String ccustomer;

    @Column(name = "feedback", length = 1000, nullable = false)
    private String feedback;

    @Column(name = "tfeedback", length = 100, nullable = false)
    private String tfeedback;

    @Column(name = "image", length = 300, nullable = false)
    private String image;

    @Column(name = "date", length = 50, nullable = false)
    private String date;

    public ContactUs() {}

    public ContactUs(String location, String tproduct, String firstname, String lastname,
                     Integer phone, String email, String ccustomer, String feedback,
                     String tfeedback, String image, String date) {
        this.location = location;
        this.tproduct = tproduct;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.ccustomer = ccustomer;
        this.feedback = feedback;
        this.tfeedback = tfeedback;
        this.image = image;
        this.date = date;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getTproduct() { return tproduct; }
    public void setTproduct(String tproduct) { this.tproduct = tproduct; }

    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    public Integer getPhone() { return phone; }
    public void setPhone(Integer phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCcustomer() { return ccustomer; }
    public void setCcustomer(String ccustomer) { this.ccustomer = ccustomer; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }

    public String getTfeedback() { return tfeedback; }
    public void setTfeedback(String tfeedback) { this.tfeedback = tfeedback; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}