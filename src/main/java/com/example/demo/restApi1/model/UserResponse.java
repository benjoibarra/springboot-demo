package com.example.demo.restApi1.model;

public class UserResponse {
    private String fName;
    private String lName;
    private long id;

    public UserResponse(String fName, String lName, long id) {
        this.fName = fName;
        this.lName = lName;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
