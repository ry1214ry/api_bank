package com.example.authentication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_intranet_folder")
public class IntranetFolder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "folder_name", length = 100, nullable = false)
    private String folderName;

    @Column(name = "folder_category", length = 100, nullable = false)
    private String folderCategory;

    @Column(name = "folder_status", length = 100, nullable = false)
    private String folderStatus;

    // Default constructor
    public IntranetFolder() {}

    // Parameterized constructor excluding ID
    public IntranetFolder(String folderName, String folderCategory, String folderStatus) {
        this.folderName = folderName;
        this.folderCategory = folderCategory;
        this.folderStatus = folderStatus;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getFolderName() { return folderName; }
    public void setFolderName(String folderName) { this.folderName = folderName; }

    public String getFolderCategory() { return folderCategory; }
    public void setFolderCategory(String folderCategory) { this.folderCategory = folderCategory; }

    public String getFolderStatus() { return folderStatus; }
    public void setFolderStatus(String folderStatus) { this.folderStatus = folderStatus; }
}