package com.SafetyNetAlerts.DTO;

import lombok.Data;

import java.util.List;

@Data
public class PersonsByStationNumberNbAdultsNbChildrenDTO {

    private List<PersonNameAddressPhoneDTO> persons;

    private int numberChildren;

    private int numberAdults;
}
