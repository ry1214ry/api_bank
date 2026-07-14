package com.example.authentication.model;
import jakarta.persistence.*;
@Entity
@Table(name = "tbl_contact_list")
public class ContactList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Lob
    @Column(name = "file_name", nullable = false, columnDefinition = "TEXT")
    private String fileName;

    @Lob
    @Column(name = "file_upload", nullable = false, columnDefinition = "TEXT")
    private String fileUpload;

    @Column(name = "status", length = 30, nullable = false)
    private String status;

    public ContactList() {}
    public ContactList(String fileName, String fileUpload, String status) {
        this.fileName = fileName;
        this.fileUpload = fileUpload;
        this.status = status;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getFileName() { return fileName; }
    public void setFileName(String fileName) { this.fileName = fileName; }

    public String getFileUpload() { return fileUpload; }
    public void setFileUpload(String fileUpload) { this.fileUpload = fileUpload; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}