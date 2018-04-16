package com.sainz.example.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Person {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long id;

    //@NotEmpty for Strings
    //@NotNull for integers
    //@Size (min, max)
    //@Range (min, max)
    
    @NotEmpty
    @Size(max=20)
    private String firstName;

    @NotEmpty
    @Size(max=20)
    private String lastName;


    @NotEmpty
    private String phoneNumber;

    @Email
    @NotEmpty
    private String emailAddress;

    public Person(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
