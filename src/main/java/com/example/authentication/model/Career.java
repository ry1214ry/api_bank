package com.example.authentication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_career")
public class Career {

    @Id
    @Column(name = "career_id", length = 50, nullable = false)
    private String careerId;

    @Column(name = "career_title_kh", length = 255)
    private String careerTitleKh;

    @Column(name = "career_title_en", length = 255)
    private String careerTitleEn;

    @Column(name = "career_title_ch", length = 255)
    private String careerTitleCh;

    @Column(name = "career_kh", columnDefinition = "TEXT")
    private String careerKh;

    @Column(name = "career_en", columnDefinition = "TEXT")
    private String careerEn;

    @Column(name = "career_ch", columnDefinition = "TEXT")
    private String careerCh;

    @Column(name = "detail_kh", columnDefinition = "TEXT")
    private String detailKh;

    @Column(name = "detail_en", columnDefinition = "TEXT")
    private String detailEn;

    @Column(name = "detail_ch", columnDefinition = "TEXT")
    private String detailCh;

    @Column(name = "link_kh", length = 500)
    private String linkKh;

    @Column(name = "link_en", length = 500)
    private String linkEn;

    @Column(name = "link_ch", length = 500)
    private String linkCh;

    @Column(name = "post_date", length = 100)
    private String postDate;

    @Column(name = "close_date", length = 100)
    private String closeDate;

    @Column(name = "status", length = 20)
    private String status;

    @Column(name = "image", length = 500)
    private String image;

    @Column(name = "short_id")
    private Integer shortId;

    @Column(name = "reorder")
    private Integer reorder;

    public Career() {}

    // Getters and Setters
    public String getCareerId() { return careerId; }
    public void setCareerId(String careerId) { this.careerId = careerId; }

    public String getCareerTitleKh() { return careerTitleKh; }
    public void setCareerTitleKh(String careerTitleKh) { this.careerTitleKh = careerTitleKh; }

    public String getCareerTitleEn() { return careerTitleEn; }
    public void setCareerTitleEn(String careerTitleEn) { this.careerTitleEn = careerTitleEn; }

    public String getCareerTitleCh() { return careerTitleCh; }
    public void setCareerTitleCh(String careerTitleCh) { this.careerTitleCh = careerTitleCh; }

    public String getCareerKh() { return careerKh; }
    public void setCareerKh(String careerKh) { this.careerKh = careerKh; }

    public String getCareerEn() { return careerEn; }
    public void setCareerEn(String careerEn) { this.careerEn = careerEn; }

    public String getCareerCh() { return careerCh; }
    public void setCareerCh(String careerCh) { this.careerCh = careerCh; }

    public String getDetailKh() { return detailKh; }
    public void setDetailKh(String detailKh) { this.detailKh = detailKh; }

    public String getDetailEn() { return detailEn; }
    public void setDetailEn(String detailEn) { this.detailEn = detailEn; }

    public String getDetailCh() { return detailCh; }
    public void setDetailCh(String detailCh) { this.detailCh = detailCh; }

    public String getLinkKh() { return linkKh; }
    public void setLinkKh(String linkKh) { this.linkKh = linkKh; }

    public String getLinkEn() { return linkEn; }
    public void setLinkEn(String linkEn) { this.linkEn = linkEn; }

    public String getLinkCh() { return linkCh; }
    public void setLinkCh(String linkCh) { this.linkCh = linkCh; }

    public String getPostDate() { return postDate; }
    public void setPostDate(String postDate) { this.postDate = postDate; }

    public String getCloseDate() { return closeDate; }
    public void setCloseDate(String closeDate) { this.closeDate = closeDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public Integer getShortId() { return shortId; }
    public void setShortId(Integer shortId) { this.shortId = shortId; }

    public Integer getReorder() { return reorder; }
    public void setReorder(Integer reorder) { this.reorder = reorder; }
}