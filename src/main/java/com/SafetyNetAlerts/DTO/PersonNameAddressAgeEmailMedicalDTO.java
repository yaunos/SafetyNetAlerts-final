package com.SafetyNetAlerts.DTO;

import lombok.Data;

import java.util.List;

@Data
public class PersonNameAddressAgeEmailMedicalDTO {

    private String firstName;
    private String lastName;
    private String address;
    private int age;
    private String email;
    private List<String> medication;
    private List<String> allergies;

}
