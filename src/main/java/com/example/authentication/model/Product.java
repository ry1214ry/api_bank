package com.example.authentication.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "pro_kh", length = 200, nullable = false)
    private String proKh;

    @Column(name = "pro_en", length = 200, nullable = false)
    private String proEn;

    @Column(name = "pro_ch", length = 200, nullable = false)
    private String proCh;

    @Column(name = "link_kh", length = 191)
    private String linkKh;

    @Column(name = "link_en", length = 191)
    private String linkEn;

    @Column(name = "link_ch", length = 191)
    private String linkCh;

    @Column(name = "image", length = 200, nullable = false)
    private String image;

    @Column(name = "box_detail_kh", length = 300, nullable = false)
    private String boxDetailKh;

    @Column(name = "box_detail_en", length = 300, nullable = false)
    private String boxDetailEn;

    @Column(name = "box_detail_ch", length = 300, nullable = false)
    private String boxDetailCh;

    @Lob
    @Column(name = "detail_kh", nullable = false, columnDefinition = "TEXT")
    private String detailKh;

    @Lob
    @Column(name = "detail_en", nullable = false, columnDefinition = "TEXT")
    private String detailEn;

    @Lob
    @Column(name = "detail_ch", nullable = false, columnDefinition = "TEXT")
    private String detailCh;

    @Column(name = "status", length = 20, nullable = false)
    private String status;

    @Lob
    @Column(name = "image_m", nullable = false, columnDefinition = "TEXT")
    private String imageM;

    @Lob
    @Column(name = "image_d", nullable = false, columnDefinition = "TEXT")
    private String imageD;

    @Column(name = "visible", length = 20, nullable = false)
    private String visible;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Default Constructor
    public Product() {}

    // Parameterized Constructor (Excluding ID, CreatedAt, UpdatedAt)
    public Product(String proKh, String proEn, String proCh, String linkKh, String linkEn, String linkCh,
                   String image, String boxDetailKh, String boxDetailEn, String boxDetailCh,
                   String detailKh, String detailEn, String detailCh, String status,
                   String imageM, String imageD, String visible) {
        this.proKh = proKh;
        this.proEn = proEn;
        this.proCh = proCh;
        this.linkKh = linkKh;
        this.linkEn = linkEn;
        this.linkCh = linkCh;
        this.image = image;
        this.boxDetailKh = boxDetailKh;
        this.boxDetailEn = boxDetailEn;
        this.boxDetailCh = boxDetailCh;
        this.detailKh = detailKh;
        this.detailEn = detailEn;
        this.detailCh = detailCh;
        this.status = status;
        this.imageM = imageM;
        this.imageD = imageD;
        this.visible = visible;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // Getters and Setters
    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }

    public String getProKh() { return proKh; }
    public void setProKh(String proKh) { this.proKh = proKh; }

    public String getProEn() { return proEn; }
    public void setProEn(String proEn) { this.proEn = proEn; }

    public String getProCh() { return proCh; }
    public void setProCh(String proCh) { this.proCh = proCh; }

    public String getLinkKh() { return linkKh; }
    public void setLinkKh(String linkKh) { this.linkKh = linkKh; }

    public String getLinkEn() { return linkEn; }
    public void setLinkEn(String linkEn) { this.linkEn = linkEn; }

    public String getLinkCh() { return linkCh; }
    public void setLinkCh(String linkCh) { this.linkCh = linkCh; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getBoxDetailKh() { return boxDetailKh; }
    public void setBoxDetailKh(String boxDetailKh) { this.boxDetailKh = boxDetailKh; }

    public String getBoxDetailEn() { return boxDetailEn; }
    public void setBoxDetailEn(String boxDetailEn) { this.boxDetailEn = boxDetailEn; }

    public String getBoxDetailCh() { return boxDetailCh; }
    public void setBoxDetailCh(String boxDetailCh) { this.boxDetailCh = boxDetailCh; }

    public String getDetailKh() { return detailKh; }
    public void setDetailKh(String detailKh) { this.detailKh = detailKh; }

    public String getDetailEn() { return detailEn; }
    public void setDetailEn(String detailEn) { this.detailEn = detailEn; }

    public String getDetailCh() { return detailCh; }
    public void setDetailCh(String detailCh) { this.detailCh = detailCh; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getImageM() { return imageM; }
    public void setImageM(String imageM) { this.imageM = imageM; }

    public String getImageD() { return imageD; }
    public void setImageD(String imageD) { this.imageD = imageD; }

    public String getVisible() { return visible; }
    public void setVisible(String visible) { this.visible = visible; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}