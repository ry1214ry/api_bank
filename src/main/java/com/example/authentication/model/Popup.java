package com.example.authentication.model;
import jakarta.persistence.*;
@Entity
@Table(name = "tb_popup")
public class Popup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "status", length = 100, nullable = false)
    private String status;

    @Column(name = "snow", length = 20, nullable = false)
    private String snow;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    @Column(name = "image_m", length = 100, nullable = false)
    private String imageM;

    @Column(name = "image_d", length = 100, nullable = false)
    private String imageD;

    @Column(name = "link", length = 200, nullable = false)
    private String link;

    @Column(name = "set_time", nullable = false)
    private Integer setTime;


    public Popup() {}

    public Popup(String status, String snow, String name, String imageM, String imageD, String link, Integer setTime) {
        this.status = status;
        this.snow = snow;
        this.name = name;
        this.imageM = imageM;
        this.imageD = imageD;
        this.link = link;
        this.setTime = setTime;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getSnow() { return snow; }
    public void setSnow(String snow) { this.snow = snow; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getImageM() { return imageM; }
    public void setImageM(String imageM) { this.imageM = imageM; }

    public String getImageD() { return imageD; }
    public void setImageD(String imageD) { this.imageD = imageD; }

    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }

    public Integer getSetTime() { return setTime; }
    public void setSetTime(Integer setTime) { this.setTime = setTime; }

}