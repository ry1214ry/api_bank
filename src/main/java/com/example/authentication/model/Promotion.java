package com.example.authentication.model;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_promotions")
public class Promotion {

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

    @Column(name = "image_bg", length = 100, nullable = false)
    private String imageBg;

    @Column(name = "period_date", length = 300, nullable = false)
    private String periodDate;

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

    @Column(name = "image_m", length = 100, nullable = false)
    private String imageM;

    @Column(name = "image_d", length = 100, nullable = false)
    private String imageD;

    @Column(name = "image_hover", length = 100, nullable = false)
    private String imageHover;

    @Column(name = "valid", length = 200, nullable = false)
    private String valid;

    @Column(name = "expire", length = 100, nullable = false)
    private String expire;

    // Default Constructor
    public Promotion() {}

    // Parameterized Constructor
    public Promotion(String proKh, String proEn, String proCh, String imageBg, String periodDate,
                     String detailKh, String detailEn, String detailCh, String status,
                     String imageM, String imageD, String imageHover, String valid, String expire) {
        this.proKh = proKh;
        this.proEn = proEn;
        this.proCh = proCh;
        this.imageBg = imageBg;
        this.periodDate = periodDate;
        this.detailKh = detailKh;
        this.detailEn = detailEn;
        this.detailCh = detailCh;
        this.status = status;
        this.imageM = imageM;
        this.imageD = imageD;
        this.imageHover = imageHover;
        this.valid = valid;
        this.expire = expire;
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

    public String getImageBg() { return imageBg; }
    public void setImageBg(String imageBg) { this.imageBg = imageBg; }

    public String getPeriodDate() { return periodDate; }
    public void setPeriodDate(String periodDate) { this.periodDate = periodDate; }

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

    public String getImageHover() { return imageHover; }
    public void setImageHover(String imageHover) { this.imageHover = imageHover; }

    public String getValid() { return valid; }
    public void setValid(String valid) { this.valid = valid; }

    public String getExpire() { return expire; }
    public void setExpire(String expire) { this.expire = expire; }
}