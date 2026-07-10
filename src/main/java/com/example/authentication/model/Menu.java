package com.example.authentication.model;
import jakarta.persistence.*;
@Entity
@Table(name = "tbl_menu")
public class Menu {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "kh", length = 100, nullable = false)
    private String kh;
    @Column(name = "en", length = 100, nullable = false)
    private String en;
    @Column(name = "ch", length = 100, nullable = false)
    private String ch;
    @Column(name = "kh_link", length = 100, nullable = false)
    private String khLink;
    @Column(name = "en_link", length = 100, nullable = false)
    private String enLink;
    @Column(name = "ch_link", length = 100, nullable = false)
    private String chLink;
    @Column(name = "status", nullable = false)
    private Integer status;
    @Column(name = "activ", length = 100, nullable = false)
    private String activ;
    public Menu() {}


    public Menu(String kh, String en, String ch, String khLink, String enLink, String chLink, Integer status, String activ) {
        this.kh = kh;
        this.en = en;
        this.ch = ch;
        this.khLink = khLink;
        this.enLink = enLink;
        this.chLink = chLink;
        this.status = status;
        this.activ = activ;
    }


    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getKh() { return kh; }
    public void setKh(String kh) { this.kh = kh; }
    public String getEn() { return en; }
    public void setEn(String en) { this.en = en; }
    public String getCh() { return ch; }
    public void setCh(String ch) { this.ch = ch; }
    public String getKhLink() { return khLink; }
    public void setKhLink(String khLink) { this.khLink = khLink; }
    public String getEnLink() { return enLink; }
    public void setEnLink(String enLink) { this.enLink = enLink; }
    public String getChLink() { return chLink; }
    public void setChLink(String chLink) { this.chLink = chLink; }
    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }
    public String getActiv() { return activ; }
    public void setActiv(String activ) { this.activ = activ; }


}