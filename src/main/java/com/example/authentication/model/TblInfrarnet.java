package com.example.authentication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_infrarnet")
public class TblInfrarnet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "infrar_name", nullable = false, length = 200)
    private String infrarName;

    @Column(name = "infrar_file", nullable = false, length = 100)
    private String infrarFile;

    @Column(name = "infrar_category", nullable = false, length = 200)
    private String infrarCategory;

    @Column(name = "folder_name", nullable = false, length = 200)
    private String folderName;

    @Column(name = "infrar_status", nullable = false, length = 50)
    private String infrarStatus;

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getInfrarName() { return infrarName; }
    public void setInfrarName(String infrarName) { this.infrarName = infrarName; }

    public String getInfrarFile() { return infrarFile; }
    public void setInfrarFile(String infrarFile) { this.infrarFile = infrarFile; }

    public String getInfrarCategory() { return infrarCategory; }
    public void setInfrarCategory(String infrarCategory) { this.infrarCategory = infrarCategory; }

    public String getFolderName() { return folderName; }
    public void setFolderName(String folderName) { this.folderName = folderName; }

    public String getInfrarStatus() { return infrarStatus; }
    public void setInfrarStatus(String infrarStatus) { this.infrarStatus = infrarStatus; }
}