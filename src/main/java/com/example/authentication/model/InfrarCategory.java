// Defines the package location for this model class
package com.example.authentication.model;

// Imports the Jakarta Persistence annotations for database mapping
import jakarta.persistence.*;

@Entity // Marks this class as a database entity (creates a database table)
@Table(name = "tbl_infrar_category") // Maps this entity to the specific table named 'tbl_infrar_category'
public class InfrarCategory {

    @Id // Specifies the primary key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Enables auto-increment for the ID column
    private Integer id;

    // privat : access modifire
    // integer : data type
    // status : varriable

    // Maps to column 'infrar_category', cannot be null, max length 200 characters
    @Column(name = "infrar_category", nullable = false, length = 200)
    private String infrarCategory;


    // Maps to column 'status', cannot be null, max length 50 characters
    @Column(name = "status", nullable = false, length = 50)
    private String status;


    // --- Getter and Setter Methods (Used to read and modify private fields) ---

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getInfrarCategory() { return infrarCategory; }
    public void setInfrarCategory(String infrarCategory) { this.infrarCategory = infrarCategory; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }


}
