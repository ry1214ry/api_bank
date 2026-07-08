package com.example.authentication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_pro_title")
public class ProductTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_title_id")
    private Integer proTitleId;

    @Column(name = "pro_title_kh", length = 100, nullable = false)
    private String proTitleKh;

    @Column(name = "pro_title_en", length = 100, nullable = false)
    private String proTitleEn;

    @Column(name = "pro_title_ch", length = 100, nullable = false)
    private String proTitleCh;

    // Default Constructor
    public ProductTitle() {}


    public ProductTitle(String proTitleKh, String proTitleEn, String proTitleCh) {
        this.proTitleKh = proTitleKh;
        this.proTitleEn = proTitleEn;
        this.proTitleCh = proTitleCh;
    }

    public Integer getProTitleId() { return proTitleId; }
    public void setProTitleId(Integer proTitleId) { this.proTitleId = proTitleId; }

    public String getProTitleKh() { return proTitleKh; }
    public void setProTitleKh(String proTitleKh) { this.proTitleKh = proTitleKh; }

    public String getProTitleEn() { return proTitleEn; }
    public void setProTitleEn(String proTitleEn) { this.proTitleEn = proTitleEn; }

    public String getProTitleCh() { return proTitleCh; }
    public void setProTitleCh(String proTitleCh) { this.proTitleCh = proTitleCh; }
}