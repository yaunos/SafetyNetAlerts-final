package com.SafetyNetAlerts.DTO;

import lombok.Data;

import java.util.List;

@Data
public class PersonsByStationNbAdultsNbChildrenDTO {

    private List<PersonNameAddressPhoneDTO> persons;

    private int numberChildren;

    private int numberAdults;
}
