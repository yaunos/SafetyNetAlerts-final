package com.SafetyNetAlerts.DTO;

import lombok.Data;

import java.util.List;

@Data

public class PersonsByAddressByStationDTO {
    private String address;

    private List<PersonNamePhoneAgeMedicalDTO> residents;
}
