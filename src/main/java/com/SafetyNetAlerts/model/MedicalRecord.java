package com.SafetyNetAlerts.model;

import lombok.Data;

import java.lang.reflect.Array;
import java.util.Date;

@Data
public class MedicalRecord {

    public String firstName;
    public String lastName;
    public Date birthdate;
    public Array medication;
    public Array allergie;

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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Array getMedication() {
        return medication;
    }

    public void setMedication(Array medication) {
        this.medication = medication;
    }

    public Array getAllergie() {
        return allergie;
    }

    public void setAllergie(Array allergie) {
        this.allergie = allergie;
    }

}
