package com.SafetyNetAlerts.model;

import lombok.Data;

@Data
public class Person {

    public String firstName;
    public String lastName;
//    public Date birthdate;
    public String address;
    public String city;
    public String zip;
    public String phone;
    public String email;

    public Person() {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
 //       this.birthdate = birthdate;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(){
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

  //  public Date getBirthdate() {return birthdate;}

  //  public void setBirthdate(Date birthdate) {this.birthdate = birthdate;}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}