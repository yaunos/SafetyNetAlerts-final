package com.SafetyNetAlerts.DTO;

import lombok.Data;

import java.util.List;

@Data
public class PersonChildrenAdultsByAddressDTO {

    private List<PersonNameAgeDTO> listChildren;
    private List<PersonNameDTO> listAdults;
}
