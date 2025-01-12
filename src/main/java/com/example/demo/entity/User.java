package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // Map this entity to the "users" table in the database
public class User {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false) // Map to the "firstName" column
    private String fName;

    @Column(name = "last_name", nullable = false) // Map to the "lastName" column
    private String lName;

    public User() {
    }

    public User(Long id, String fName, String lName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }


}
