package com.example.authentication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_choosepost")
public class Choosepost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pos_id", nullable = false)
    private Integer posId;

    @Column(name = "position", length = 200, nullable = false)
    private String position;

    @Column(name = "status", length = 100, nullable = false)
    private String status;

    @Column(name = "link", length = 200, nullable = false)
    private String link;

    // Default constructor matching the pattern
    public Choosepost() {}

    // Parameterized constructor excluding ID matching the pattern
    public Choosepost(Integer posId, String position, String status, String link) {
        this.posId = posId;
        this.position = position;
        this.status = status;
        this.link = link;
    }

    // Getters and Setters matching the pattern
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getPosId() { return posId; }
    public void setPosId(Integer posId) { this.posId = posId; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }
}