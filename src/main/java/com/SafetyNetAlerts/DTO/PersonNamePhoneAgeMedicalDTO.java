package com.SafetyNetAlerts.DTO;

import lombok.Data;

import java.util.List;
@Data

public class PersonNamePhoneAgeMedicalDTO {

    private String firstName;

    private String lastName;

    private String phone;

    private int age;

    private List<String> medications;

    private List<String> allergies;
}
