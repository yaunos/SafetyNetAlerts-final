package com.SafetyNetAlerts.repository;

import java.util.List;

public interface CustomDataRepository {

    List<String> getPersonsMedicalInformation(String firstName, String lastName);
    public List<String> getEmailsByCity(String city);


   // List<Firestation> getAddressesByStation(int stationNumber);
}
