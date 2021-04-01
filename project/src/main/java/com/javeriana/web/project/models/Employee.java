package com.javeriana.web.project.models;

public class Employee {
    private Long id;
    private String firstName;
    private String LastName;
    private String email;
    private String password;
    private boolean administrator;

    public Employee(Long id, String firstName, String lastName, String email, String password, boolean administrator) {
        this.id = id;
        this.firstName = firstName;
        LastName = lastName;
        this.email = email;
        this.password = password;
        this.administrator = administrator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }
}
