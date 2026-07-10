package com.example.authentication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Safeguard for schemas without explicit auto_increment config
    @Column(name = "id")
    private Integer id;

    @Column(name = "position", length = 200, nullable = false)
    private String position;

    @Column(name = "link", length = 200, nullable = false)
    private String link;

    @Column(name = "pos_id", nullable = false)
    private Integer posId;

    @Column(name = "status", length = 100, nullable = false)
    private String status;

    // Default Constructor
    public Position() {}

    // Parameterized Constructor
    public Position(String position, String link, Integer posId, String status) {
        this.position = position;
        this.link = link;
        this.posId = posId;
        this.status = status;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }

    public Integer getPosId() { return posId; }
    public void setPosId(Integer posId) { this.posId = posId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}